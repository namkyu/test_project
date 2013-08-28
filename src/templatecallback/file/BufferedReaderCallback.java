package templatecallback.file;


/**
 * @FileName : BufferedReaderCallback.java
 * @Project : test_project
 * @Date : 2013. 8. 1.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface BufferedReaderCallback {

	/**
	 * <pre>
	 * doSomethingWithReader
	 *
	 * <pre>
	 * @param line
	 * @param value
	 * @return
	 */
	Integer doSomethingWithReader(String line, Integer value);
}
