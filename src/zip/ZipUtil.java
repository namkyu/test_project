package zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class ZipUtil {

	/** 압축률 Default : 9 */
	private static final int COMPRESSION_LEVEL = 8;

	/** Buffer Size */
	private static final int BUFFER_SIZE = 1024 * 2;

	/**
	 * 압축 해제 압축 해제된 파일 목록을 List 반환
	 *
	 * @param zipFilePath
	 * @param targetDir
	 * @return
	 * @throws Exception
	 */
	public List<String> unzipResultFileList(String zipFilePath, String targetDir, boolean isResultFileFullPath) throws Exception {
		return unzipResultFileList(new File(zipFilePath), new File(targetDir), isResultFileFullPath);
	}

	/**
	 * 압축 해제 압축 해제된 파일 목록을 List 반환
	 *
	 * @param zipFile
	 * @param targetDir
	 * @param isResultFileFullPath
	 * @return
	 * @throws Exception
	 */
	public static List<String> unzipResultFileList(File zipFile, File targetDir, boolean isResultFileFullPath) throws Exception {
		return unzipResultFileList(new FileInputStream(zipFile), targetDir, isResultFileFullPath);
	}

	/**
	 * 압축 해제 압축 해제된 파일 목록을 List 반환
	 *
	 * @param inputStream
	 * @param targetDir
	 * @param isResultFileFullPath
	 * @return
	 * @throws Exception
	 */
	public static List<String> unzipResultFileList(InputStream inputStream, String targetDir, boolean isResultFileFullPath) throws Exception {
		return unzipResultFileList(inputStream, new File(targetDir), isResultFileFullPath);
	}

	/**
	 * 압축 해제 압축 해제된 파일 목록을 List 반환
	 *
	 * @param zipFile
	 * @param targetDir
	 * @return
	 * @throws Exception
	 */
	public static List<String> unzipResultFileList(InputStream inputStream, File targetDir, boolean isResultFileFullPath) throws Exception {
		List<String> unzipFileList = new ArrayList<String>();

		ZipArchiveInputStream zi = null;
		ZipArchiveEntry entry = null;
		try {
			zi = new ZipArchiveInputStream(inputStream, null, true);
			while ((entry = zi.getNextZipEntry()) != null) {
				String fileNameToUnzip = new String(entry.getRawName(), Charset.defaultCharset());
				File targetFile = new File(targetDir, fileNameToUnzip);

				if (entry.isDirectory()) {// Directory
					FileUtils.forceMkdir(targetFile.getAbsoluteFile());
				} else { // File
					FileUtils.forceMkdir(targetFile.getParentFile());
					unzipEntry(zi, targetFile);
					if (isResultFileFullPath) {
						unzipFileList.add(targetFile.getAbsolutePath());
					} else {
						unzipFileList.add(targetFile.getName());
					}
				}
			}
		} finally {
			if (zi != null) {
				zi.close();
			}
		}

		return unzipFileList;
	}

	/**
	 * unzip Zip 파일 압축 해제
	 *
	 * @param zipFilePath
	 *            - zip file
	 * @param targetDir
	 *            - 압축 해제 디렉토리
	 * @throws Exception
	 */
	public static void unzip(String zipFilePath, String targetDir) throws Exception {
		unzip(new File(zipFilePath), new File(targetDir));
	}

	/**
	 * unzip Zip 파일 압축 해제
	 *
	 * @param zipFile
	 *            - zip file
	 * @param targetDir
	 *            - 압축 해제 디렉토리
	 * @throws Exception
	 */
	public static void unzip(File zipFile, File targetDir) throws Exception {
		unzip(new FileInputStream(zipFile), targetDir);
	}

	/**
	 * unzip Zip 파일 압축 해제
	 *
	 * @param zipFile
	 *            - zip file
	 * @param targetDir
	 *            - 압축 해제 디렉토리
	 * @throws Exception
	 */
	public static void unzip(InputStream inputStream, File targetDir) throws Exception {
		ZipArchiveInputStream zi = null;
		ZipArchiveEntry entry = null;
		try {
			zi = new ZipArchiveInputStream(inputStream, null, true);
			while ((entry = zi.getNextZipEntry()) != null) {
				String fileNameToUnzip = new String(entry.getRawName(), "UTF-8");
				File targetFile = new File(targetDir, fileNameToUnzip);

				if (entry.isDirectory()) {// Directory
					FileUtils.forceMkdir(targetFile.getAbsoluteFile());
				} else { // File
					FileUtils.forceMkdir(targetFile.getParentFile());
					unzipEntry(zi, targetFile);
				}
			}
		} finally {
			if (zi != null) {
				zi.close();
			}
		}
	}

	/**
	 * unzipEntry
	 *
	 * @param zis
	 * @param targetFile
	 * @return
	 * @throws IOException
	 */
	private static File unzipEntry(ZipArchiveInputStream zis, File targetFile) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(targetFile);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = zis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
		return targetFile;
	}

	/**
	 * sourcePath의 파일 OR 디렉토리를 압축한다.
	 *
	 * @param sourcePath
	 *            - 압축 대상 파일 OR 디렉토리
	 * @param outputFilePath
	 *            - 저장 zip full path
	 * @throws Exception
	 */
	public static void zip(String sourcePath, String outputFilePath) throws Exception {

		// 압축 대상(sourcePath)이 디렉토리 OR 파일 확인
		File sourceFile = new File(sourcePath);
		if (!sourceFile.isFile() && !sourceFile.isDirectory()) {
			throw new FileNotFoundException("Not exist sourcePath.");
		}

		// 확장자가 Zip 여부 확인
		if (!(StringUtils.substringAfterLast(outputFilePath, ".")).equalsIgnoreCase("zip")) {
			throw new Exception("Invalid file suffix.");
		}

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ZipArchiveOutputStream zos = null;

		try {
			fos = new FileOutputStream(outputFilePath);
			bos = new BufferedOutputStream(fos);
			zos = new ZipArchiveOutputStream(bos);
			zos.setLevel(COMPRESSION_LEVEL);
			zipEntry(sourceFile, sourcePath, zos);
			zos.finish();
		} finally {
			try {
				if (zos != null)
					zos.close();
				if (bos != null)
					bos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 파일 압축
	 *
	 * @param sourceFile
	 * @param sourcePath
	 * @param zos
	 * @throws IOException
	 */
	private static void zipEntry(File sourceFile, String sourcePath, ZipArchiveOutputStream zos) throws IOException {
		if (sourceFile.isDirectory()) { // Directory
			if (sourceFile.getName().equalsIgnoreCase(".metadata")) {
				return;
			}
			File[] fileArray = sourceFile.listFiles();
			for (int i = 0; i < fileArray.length; i++) {
				zipEntry(fileArray[i], sourcePath, zos);
			}
		} else { // File
			BufferedInputStream bis = null;
			try {
				String sFilePath = sourceFile.getPath();
				String zipEntryName = sFilePath.substring(sourcePath.length() + 1, sFilePath.length());

				bis = new BufferedInputStream(new FileInputStream(sourceFile));
				ZipArchiveEntry zentry = new ZipArchiveEntry(zipEntryName);
				zentry.setTime(sourceFile.lastModified());
				zos.putArchiveEntry(zentry);

				byte[] buffer = new byte[BUFFER_SIZE];
				int cnt = 0;
				while ((cnt = bis.read(buffer, 0, BUFFER_SIZE)) != -1) {
					zos.write(buffer, 0, cnt);
				}
				zos.closeArchiveEntry();
			} finally {

				if (bis != null) {
					bis.close();
				}
			}
		}
	}
}