import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        char[] chArr = str.toCharArray();
        Integer[] numArr = new Integer[str.length()];    // 컬렉션-> 참조형 변수 필요

        for (int i=0;i<str.length();i++) {
                numArr[i] = chArr[i]-'0';   //문자-> 숫자 변환
        }

        Arrays.sort(numArr, Collections.reverseOrder());

        for (int n:numArr) {
            System.out.print(n);
        }

    }
}