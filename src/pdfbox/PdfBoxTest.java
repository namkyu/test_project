package pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.Test;

/**
 * @FileName : PdfBoxTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class PdfBoxTest {

	@Test
	public void test() {
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File("E:\\test\\pdfbox\\hackers.pdf");
		try {
			PDFParser parser = new PDFParser(new FileInputStream(file));
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			pdfStripper.setStartPage(28);
			pdfStripper.setEndPage(28);
			String parsedText = pdfStripper.getText(pdDoc);
			System.out.println(parsedText);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
