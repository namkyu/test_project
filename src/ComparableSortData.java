import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @FileName : SortMapTest.java
 * @Project : test_project
 * @Date : 2012. 6. 1.
 * @작성자 : 이남규
 * @프로그램설명 : List안에 존재하는 객체의 속성 값 정렬
 */
public class ComparableSortData {

	public static void main(String[] args) {
		List<DataVO> listData = new ArrayList<DataVO>();

		DataVO dataVO1 = new DataVO();
		dataVO1.setTitle("장");
		DataVO dataVO2 = new DataVO();
		dataVO2.setTitle("이");
		DataVO dataVO3 = new DataVO();
		dataVO3.setTitle("김");

		listData.add(dataVO1);
		listData.add(dataVO2);
		listData.add(dataVO3);

		System.out.println(listData);
		Collections.sort(listData);
		System.out.println(listData);

	}

}

class DataVO implements Comparable<DataVO> {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "DataVO [title=" + title + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DataVO dataVO) {
		return title.compareTo(dataVO.getTitle()); // 데이터를 비교해 준다.
	}
}
