import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int studentCnt = s.nextInt();
        int winner = s.nextInt();
        int[] scoreArr = new int[studentCnt];
        int sum = 0;
        for (int i=0;i<scoreArr.length;i++) {
            scoreArr[i] = s.nextInt();
        }
        s.close();
        Arrays.sort(scoreArr);
        System.out.println(scoreArr[studentCnt-winner]);
    }
}