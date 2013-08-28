package htmltoimage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import gui.ava.html.image.generator.HtmlImageGenerator;

import java.io.File;

import org.junit.Test;

/**
 * @FileName : HtmlToImageTest.java
 * @Project : test_project
 * @Date : 2013. 8. 27.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class HtmlToImageTest {

	/**
	 * <pre>
	 * htmlToImageTest
	 *
	 * <pre>
	 */
	@Test
	public void htmlToImageTest() {
		String path = "E:\\test\\htmlToImage\\";
		String imageName = "htmlToImage.png";
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		imageGenerator.loadHtml("<img src='http://cfile9.uf.tistory.com/image/1267333350C6D94F2ED802' width='50' height='50' /> <b>Hello World!</b> Please goto <a title=\"Goto Google\" href=\"http://www.google.com\">Google</a>.");
		imageGenerator.saveAsImage(path + imageName);
		imageGenerator.saveAsHtmlWithMap(path + "hello-world.html", path + imageName);

		assertThat(true, is(new File(path, imageName).isFile()));
	}
}
