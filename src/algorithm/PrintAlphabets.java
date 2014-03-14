package algorithm;

/**
 * @FileName : PrintAlphabets.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class PrintAlphabets {

	public static void main(String[] args) {
		printAlphabets();
		printAlphabetsUpperCase();
	}

	public static void printAlphabets() {
		System.out.println("List of alphabets in lowercase : ");
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.format("%s ", ch);
		}
	}

	public static void printAlphabetsUpperCase() {
		System.out.println("\nList of alphabets in uppercase : ");
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.format("%s ", ch);
		}
	}
}
