import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int[] numArr = new int[total];
        s.nextLine();
        for (int i=0;i<total;i++) {
            numArr[i] = s.nextInt();
        }
        s.nextLine();
        int target = s.nextInt();
        int cnt = 0;
        s.close();
        for (int n : numArr) {
            if (n == target) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}