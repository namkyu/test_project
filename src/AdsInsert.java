import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @FileName : AdsInsert.java
 * @Project : test_project
 * @Date : 2012. 11. 7.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class AdsInsert {


	public static void main(String[] args) throws IOException {
		String filePath = "c:\\adsIdList.txt";

		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		String line = null;
		int cnt = 0;
		StringBuffer buffer = new StringBuffer();
		 while ((line = bf.readLine()) != null) {
			 buffer.append("'");
			 buffer.append(line);
			 buffer.append("'");
			 buffer.append(",");
			 cnt++;
		 }

		 System.out.println(buffer.toString());
		 System.out.println(cnt);
	}
}


