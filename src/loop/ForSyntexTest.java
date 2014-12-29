package loop;


/**
 * @FileName : ForSyntexTest.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ForSyntexTest {


	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// for문 앞에 붙어 있는 label1은 syntax가 아니다. 그냥 표시일 뿐이다.
		label1 : for (int i = 0; i < 10; i++) {
			System.out.println("label1 : " + i);

			label2 : for (int j = 0; j < 10; j++) {
				System.out.println("label2 : " + j);
				if (j == 5) {
					break label1;
				}
			}
		}
	}
}
