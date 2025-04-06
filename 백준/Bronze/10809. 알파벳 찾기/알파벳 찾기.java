import java.util.Scanner;

public class Main{
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] charArr = s.next().toCharArray();
        s.close();
        int[] alphabet = new int[26];
        for (int i=0; i<alphabet.length; i++) {
            alphabet[i] = -1;
        }
        for(int i=0;i<charArr.length;i++){
            int num = (int) charArr[i];
            // 알파벳 소문자 ASCII 코드 : 97 ~ 122
            for (int j = 0; j < alphabet.length; j++) {
                if (num == 97+j) {
                    alphabet[j] = alphabet[j] == -1 ? i : alphabet[j];
                }
            }
        }
        for (int a : alphabet) {
            System.out.print(a+" ");
        }
    }
}