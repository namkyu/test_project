package jsch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;


/**
 * @FileName : Shell.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class Shell {

	String host = "172.20.53.155";
	String user = "administrator";
	String privateKey = "C:\\Users\\nklee\\.ssh\\id_rsa";

	/**
	 * <pre>
	 * connect
	 *
	 * <pre>
	 * @throws JSchException
	 */
	@Test
	public void connect() throws JSchException {

		JSch jsch = new JSch();

		Session session = jsch.getSession(user, host, 22);
		session.setConfig("PreferredAuthentications", "publickey");
		jsch.addIdentity(privateKey);

		UserInfo ui = new MyUserInfo() {
			@Override
			public boolean promptPassword(String message) {
				return true;
			}
			@Override
			public boolean promptPassphrase(String message) {
				return true;
			}
			@Override
			public boolean promptYesNo(String str) {
				return true;
			}
		};
		session.setUserInfo(ui);
		session.setConfig("StrictHostKeyChecking", "no");

		// connection timeout
		session.connect(30000);

		// channel
		Channel channel = session.openChannel("shell");
		channel.setInputStream(System.in);
		channel.setOutputStream(System.out);
		channel.connect(3 * 1000);
	}

	@Test
	public void 인증없이로그인하기() {


        try {
            JSch jsch = new JSch();

            int port = 22;


            jsch.addIdentity(privateKey);
            System.out.println("identity added ");

            Session session = jsch.getSession(user, host, port);
            System.out.println("session created.");

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            System.out.println("session connected.....");

            Channel channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            System.out.println("shell channel connected....");

            ChannelSftp c = (ChannelSftp) channel;

            String fileName = "E:\\test\\shell\\upload_scp_test.txt";
            c.put(fileName, "./test/");
            c.exit();
            System.out.println("done");

        } catch (Exception e) {
            System.err.println(e);
        }

	}

	/**
	 * <pre>
	 * scpFromServer
	 *
	 * <pre>
	 */
	@Test
	public void scpFromServer() {
		FileOutputStream fos = null;

		try {
			String rfile = "/home/administrator/test/scp_test.tar.gz";
			String lfile = "E:\\test\\shell\\scp_test.tar.gz";

			String prefix = null;
			if (new File(lfile).isDirectory()) {
				prefix = lfile + File.separator;
			}

			JSch jsch = new JSch();
			jsch.addIdentity(privateKey);
			Session session = jsch.getSession(user, host, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();

			// exec 'scp -f rfile' remotely
			String command = "scp -f " + rfile;
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);

			// get I/O streams for remote scp
			OutputStream out = channel.getOutputStream();
			InputStream in = channel.getInputStream();

			channel.connect();

			byte[] buf = new byte[1024];

			// send '\0'
			buf[0] = 0;
			out.write(buf, 0, 1);
			out.flush();

			while (true) {
				int c = checkAck(in);
				if (c != 'C') {
					break;
				}

				// read '0644 '
				in.read(buf, 0, 5);

				long filesize = 0L;
				while (true) {
					if (in.read(buf, 0, 1) < 0) {
						// error
						break;
					}
					if (buf[0] == ' ')
						break;
					filesize = filesize * 10L + (long) (buf[0] - '0');
				}

				String file = null;
				for (int i = 0;; i++) {
					in.read(buf, i, 1);
					if (buf[i] == (byte) 0x0a) {
						file = new String(buf, 0, i);
						break;
					}
				}

				// System.out.println("filesize="+filesize+", file="+file);

				// send '\0'
				buf[0] = 0;
				out.write(buf, 0, 1);
				out.flush();

				// read a content of lfile
				fos = new FileOutputStream(prefix == null ? lfile : prefix + file);
				int foo;
				while (true) {
					if (buf.length < filesize)
						foo = buf.length;
					else
						foo = (int) filesize;
					foo = in.read(buf, 0, foo);
					if (foo < 0) {
						// error
						break;
					}
					fos.write(buf, 0, foo);
					filesize -= foo;
					if (filesize == 0L)
						break;
				}
				fos.close();
				fos = null;

				if (checkAck(in) != 0) {
					System.exit(0);
				}

				// send '\0'
				buf[0] = 0;
				out.write(buf, 0, 1);
				out.flush();
			}

			session.disconnect();

			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ee) {
			}
		}

	}

	private static int checkAck(InputStream in) throws IOException {
		int b = in.read();
		if (b == 0)
			return b;
		if (b == -1)
			return b;

		if (b == 1 || b == 2) {
			StringBuffer sb = new StringBuffer();
			int c;
			do {
				c = in.read();
				sb.append((char) c);
			} while (c != '\n');
			if (b == 1) { // error
				System.out.print(sb.toString());
			}
			if (b == 2) { // fatal error
				System.out.print(sb.toString());
			}
		}
		return b;
	}

}
