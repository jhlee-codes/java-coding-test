import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] numArr = new int[5];
        int sum = 0;
        for (int i=0;i<5;i++) {
            numArr[i] = s.nextInt();
            sum += numArr[i];
            s.nextLine();
        }
        s.close();
        Arrays.sort(numArr);

        System.out.println(sum/5);  // 평균
        System.out.println(numArr[2]);   //중앙값
    }
}