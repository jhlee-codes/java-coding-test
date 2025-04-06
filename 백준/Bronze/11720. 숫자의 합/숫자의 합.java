import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        String str = s.next();
        s.close();
        char[] charArr = new char[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            charArr[i] = str.charAt(i);
            sum += Integer.parseInt(String.valueOf(charArr[i]));
        }
        System.out.println(sum);
    }
}