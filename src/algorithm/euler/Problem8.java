package algorithm.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @FileName : Problem8.java
 * @Project : test_project
 * @Date : 2013. 5. 21.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Problem8 {

	public static void main(String[] args) throws Exception {
		new Problem8().process();
	}

	/**
	 * <pre>
	 * process
	 *
	 * <pre>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void process() throws FileNotFoundException, IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File(getResourcePath())));

		String line = null;
		int resultNumber = 0;
		Map<Integer, String> spliteMap = new HashMap<Integer, String>();

		while ((line = bf.readLine()) != null) {
			int checkCnt = 0;
			int multiFive = 1;
			StringBuilder buf = new StringBuilder();

			for (int i = 0; i < line.length(); i++) {
				checkCnt++;
				int num = Integer.parseInt(String.valueOf(line.charAt(i)));
				multiFive = multiFive * num;
				buf.append(num);

				if (checkCnt == 5) {

					spliteMap.put(multiFive, buf.toString());

					if (resultNumber < multiFive) {
						resultNumber = multiFive;
					}
					checkCnt = 0;
					buf.setLength(0);
				}
			}
		}

		System.out.println(spliteMap.get(resultNumber));
	}

	/**
	 * <pre>
	 * getResourcePath
	 *
	 * <pre>
	 * @return
	 */
	private String getResourcePath() {
		URL url = getClass().getResource("number.txt");
		return url.getFile();
	}
}
