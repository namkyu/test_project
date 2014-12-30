package jsoup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

/**
 * @FileName : JsoupTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class JsoupTest {

	String writeFileName = "E:\\test\\jsoup\\eslyes.txt";
	String url = "http://www.eslyes.com/";

	@Before
	public void init() {
		File file = new File(writeFileName);
		if (file.isFile()) {
			file.delete();
		}
	}

	@Test
	public void test() throws IOException {
		Document document = Jsoup.connect(url).get();
		Elements elements = document.select("font[face=Times New Roman]");
		Elements elements2 = elements.select("a[href]");

		int idx = 0;
		for (Element element : elements2) {
			String contentUri = element.attr("href");
			String title = element.html();
			Document subPageDocument = Jsoup.connect(url + contentUri).get();
			Elements subElements = subPageDocument.select("p.MsoNormal");

			// title
			writeFile("############################");
			writeFile(++idx + " : " + title);
			writeFile("############################");

			// body
			for (Element subElement : subElements) {
				String engBody = subElement.html().replaceAll("&quot;", "\"");
				writeFile(engBody, 2);
			}
		}
	}

	/**
	 * <pre>
	 * writeFile
	 *
	 * <pre>
	 * @param text
	 */
	private void writeFile(String text) {
		writeFile(text, 1);
	}

	/**
	 * <pre>
	 * writeFile
	 *
	 * <pre>
	 * @param text
	 * @param newLineNum
	 */
	private void writeFile(String text, int newLineNum) {
		try {
			// write
			BufferedWriter out = new BufferedWriter(new FileWriter(writeFileName, true));
			out.write(text);

			// new line 설정
			for (int i = 0; i < newLineNum; i++) {
				out.newLine();
			}

			// close
			out.close();

		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}
	}
}
