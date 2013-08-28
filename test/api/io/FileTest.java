package api.io;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : FileTest.java
 * @Project : test_project
 * @Date : 2012. 11. 14.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FileTest {

	private File testFile;

	@Before
	public void test파일생성() throws IOException {
		testFile = new File("C:\\file.txt");
		testFile.createNewFile();
	}

	@After
	public void test파일삭제() {
		testFile.delete();
	}

	@Test
	public void separator테스트() {
		String pathSeparator = File.pathSeparator;
		assertThat(pathSeparator, is(";"));

		char pathSeparatorChar = File.pathSeparatorChar;
		assertThat(pathSeparatorChar, is(';'));

		String separator = File.separator;
		assertThat(separator, is("\\"));

		char separatorChar = File.separatorChar;
		assertThat(separatorChar, is('\\'));
	}

	@Test
	public void 생성자테스트() throws IOException {
		File file = new File("C:\\", "file1.txt");
		assertThat(file.createNewFile(), is(true));

		URI fileUri = file.getAbsoluteFile().toURI();
		assertThat(fileUri.toString(), is("file:/C:/file1.txt"));

		file.delete();
	}

	@Test
	public void permissionTest() {
		assertThat(testFile.canExecute(), is(true));
		assertThat(testFile.canRead(), is(true));
		assertThat(testFile.canWrite(), is(true));
	}

	@Test
	public void compareToTest() throws IOException {
		File compareFile1 = new File("c:\\campareFile1.txt");
		File compareFile2 = new File("c:\\campareFile2.txt");
		File compareFile3 = new File("c:\\campareFile1.txt");

		// pathname의 문자열을 비교하여 같으면 0을 return하고, 틀리면 -1을 return한다.
		assertThat(compareFile1.compareTo(compareFile2), is(-1));
		assertThat(compareFile1.compareTo(compareFile3), is(0));
		assertThat(compareFile1.compareTo(compareFile1), is(0));
	}

	@Test
	public void createNewFileTest() throws IOException {
		File test = new File("c:\\createFile.txt");

		assertThat(test.createNewFile(), is(true));
		assertThat(test.createNewFile(), is(false));

		test.delete();
	}

	@Test
	public void createTempFileTest() throws IOException {
		File tempFile = File.createTempFile("~TMP_", ".tmp", new File("c:\\"));

		assertThat(tempFile.isFile(), is(true));

		tempFile.delete();
	}

	@Test
	public void deleteTest() throws IOException {

		// 파일 삭제 테스트
		File test1 = new File("c:\\test1.txt");
		File test2 = new File("c:\\test2.txt");

		test1.createNewFile();
		test2.createNewFile();

		assertThat(test1.delete(), is(true));
		assertThat(test2.delete(), is(true));

		// 폴더 삭제 테스트
		File folder = new File("c:\\testFolder");
		folder.mkdir();
		assertThat(folder.delete(), is(true));

		// 폴더 안에 파일 있는 경우 테스트
		File folder1 = new File("c:\\testFolder");
		folder1.mkdir();
		for (int i = 0; i < 100; i++) {
			File fileInForder = new File(folder1.getPath(), i + "test.txt");
			fileInForder.createNewFile();
		}

		File[] listFile = folder1.listFiles();
		for (File file : listFile) {
			if (file.isFile()) {
				file.delete();
			}
		}
		assertThat(folder1.delete(), is(true));

	}

	@Test
	public void equalsTest() {
		File test1 = new File("c:\\test1.txt");
		File test2 = new File("c:\\test2.txt");
		File test3 = new File("c:\\test1.txt");

		assertThat(test1.equals(test2), is(false));
		assertThat(test1.equals(test3), is(true));
	}

	@Test
	public void existsTest() throws IOException {
		File test = new File("c:\\existsTest.txt");
		assertThat(test.exists(), is(false));

		test.createNewFile();
		assertThat(test.exists(), is(true));

		File folder = new File("c:\\existsTestFolder");
		assertThat(folder.exists(), is(false));

		folder.mkdir();
		assertThat(folder.exists(), is(true));

		test.delete();
		folder.delete();
	}

	@Test
	public void absoluteFileTest() {
		String fileName = "c:\\absoluteFile.txt";
		File test = new File(fileName);

		assertThat(test.getAbsoluteFile().getPath(), is(fileName));
	}

	@Test
	public void canonicalFileTest() throws IOException {
		String fileName = "c:\\canon.txt";
		File test = new File(fileName);

		assertThat(test.getCanonicalFile().getPath(), is(not(fileName)));
	}

	@Test
	public void getFreeSizeTest() throws IOException {
		File test = new File("c:\\freeTest.txt");
		test.createNewFile();
		long unallocatedSize = test.getFreeSpace();

		assertThat(unallocatedSize, is(test.getFreeSpace()));
		test.delete();
	}

	@Test
	public void getNameTest() {
		String fileName = "test.txt";
		File test = new File("c:\\", fileName);
		assertThat(test.getName(), is(fileName));

		File test1 = new File("c:\\");
		assertThat(test1.getName(), is(""));
	}

	@Test
	public void getParentTest() {
		File test = new File("c:\\test.txt");
		File parentFile = test.getParentFile();
		assertThat(parentFile.getPath(), is("c:\\"));
	}

	@Test
	public void spaceTest() throws IOException {
		File test = new File("c:\\test.txt");
		test.createNewFile();
		long totalSpace = test.getTotalSpace(); // 파티션 전체 사이즈
		long usableSpace = test.getUsableSpace(); // 사용 가능한 공간 사이즈

		assertThat(totalSpace > 0, is(usableSpace > 0));
	}

	@Test
	@SuppressWarnings("unused")
	public void hashTest() {
		File test = new File("c:\\test.txt");
	}

	@Test
	public void isAbsoluteTest() {
		File test = new File("c:\\test.txt");
		assertThat(test.isAbsolute(), is(true));

		File test1 = new File("test.txt");
		assertThat(test1.isAbsolute(), is(false));
	}

	@Test
	public void isDirectoryAndIsFileTest() throws IOException {
		File test = new File("c:\\test.txt");
		test.createNewFile();
		assertThat(test.isDirectory(), is(false));
		assertThat(test.isFile(), is(true));

		File test1 = new File("c:\\");
		assertThat(test1.isDirectory(), is(true));
		assertThat(test1.isFile(), is(false));

		test.delete();
	}

	@Test
	public void isHiddenTest() {
		File test = new File("c:\\test.txt");
		assertThat(test.isHidden(), is(false));
	}

	@Test
	@SuppressWarnings("unused")
	public void lastModified() {
		File test = new File("c:\\test.txt");
		long modify = test.lastModified();
	}

	@Test
	public void lengthTest() throws IOException {
		File test = new File("c:\\test.txt");
		test.createNewFile();

		assertThat(test.length(), is(0L));
		test.delete();
	}

	@Test
	@SuppressWarnings("unused")
	public void listTest() {
		File test = new File("c:\\", "");
		String[] listFile = test.list(); // 파일, 폴더 name 모두 추출
	}

	@Test
	public void listFilterTest() {
		File test = new File("c:\\");

		String[] list = test.list(new FilterTest());
		for (String fileStr : list) {
			assertThat(fileStr.endsWith(".xls"), is(true));
		}
	}

	@Test
	public void listRootTest() {
		File[] listFile = File.listRoots();
		for (File file : listFile) {
			System.out.println(file);
		}
	}

	@Test
	public void mkdirsTest() {
		File test = new File("c:\\test\\test1\\test2\\test3");
		assertThat(test.mkdirs(), is(true));

		deleteDir(new File("c:\\test"));
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

	@Test
	public void renameToTest() throws IOException {
		File test = new File("c:\\rename1.txt");
		test.createNewFile();

		File test2 = new File("c:\\rename2.txt");
		boolean changed = test.renameTo(test2);
		assertThat(changed, is(true));

		test2.delete();
	}

	@Test
	public void permissionTest2() throws IOException {
		File test = new File("c:\\per.txt");
		test.createNewFile();

		assertThat(test.setExecutable(true, false), is(true));
		assertThat(test.setReadable(true, false), is(true));
		assertThat(test.setWritable(true, false), is(true));

		test.delete();
	}

	@Test
	public void readOnlyTest() throws IOException {
		File test = new File("c:\\readOnly.txt");
		test.createNewFile();
		assertThat(test.setReadOnly(), is(true));

		test.delete();
	}

}

class FilterTest implements FilenameFilter {

	@Override
	public boolean accept(File dir, String fileName) {
		return fileName.toLowerCase().endsWith(".xls");
	}

}
