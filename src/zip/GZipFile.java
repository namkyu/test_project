package zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @FileName : GZipFile.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class GZipFile {

	private static final String INPUT_GZIP_FILE = "E:\\test\\zip\\gate_info.20150130_15.gz";
	private static final String OUTPUT_FILE = "E:\\test\\zip\\gate_info.20150130_15.txt";

	public static void main(String[] args) {
		GZipFile gZip = new GZipFile();
		gZip.gunzipIt();
	}

	/**
	 * GunZip it
	 */
	public void gunzipIt() {

		byte[] buffer = new byte[1024];

		try {
			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(INPUT_GZIP_FILE));
			FileOutputStream out = new FileOutputStream(OUTPUT_FILE);

			int len;
			while ((len = gzis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}

			gzis.close();
			out.close();

			System.out.println("Done");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
