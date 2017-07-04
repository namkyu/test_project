package algorithm;

import org.junit.Test;

/**
 * @FileName : Example.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class Example {

    @Test
    public void swapNumber() {
        int a = 10;
        int b = 20;

        System.out.printf("Before swap 'a': %d, 'b': %d %n", a, b);
        a = (a + b) - (b = a);
        System.out.printf("After swapping, 'a': %d, 'b': %d %n", a, b);

        System.out.println("Swap two integers without third variable using XOR bitwise Operator");
        int x = 30;
        int y = 60;
        System.out.printf("Before swap 'x': %d, 'y': %d %n", x, y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.printf("After swapping, 'x': %d, 'y': %d %n", x, y);

        System.out.println(1 ^ 2);
        System.out.println(1 ^ 3);
    }

    @Test
    public void swapAlphabet() {
        String test1 = "a";
        String test2 = "b";
        System.out.println("test1=" + test1 + ", test2=" + test2);

        test1 = (test1 + test2).replaceAll((test2 = test1), "");
        System.out.println("test1=" + test1 + ", test2=" + test2);
    }

    @Test
    public void swapAlphabetWithoutFunction() {
        String test1 = "a";
        String test2 = "b";
        System.out.println("test1=" + test1 + ", test2=" + test2);

    }
}
