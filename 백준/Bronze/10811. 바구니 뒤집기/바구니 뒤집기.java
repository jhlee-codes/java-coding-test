import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] numArr = new int[n];
        int[] targetArr = new int[n];
        for (int i = 0; i < n; i++) {
            targetArr[i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            // .clone()을 이용해서 깊은복사!!
            // 깊은복사 : 배열 targetArr을 그대로 가져와 새로운 배열을 만드는것으로, numArr를 수정해도 targetArr에는 영향 X!!
            numArr = targetArr.clone();
            for (int j = 0; j < b-a+1; j++) {
                targetArr[a - 1 + j] = numArr[b - 1 - j];
            }
        }
        s.close();
        for (int target : targetArr) {
            System.out.print(target + " ");
        }
    }
}