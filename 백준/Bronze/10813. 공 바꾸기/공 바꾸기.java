import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] numArr = new int[n];
        int[] targetArr = new int[n];
        for (int i=0;i<n;i++) {
            targetArr[i] = i+1;
        }
        for (int i=0;i<m;i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            // 깊은 복사 (numArr는 변하지 않는 배열!)
            numArr = targetArr.clone();
            // 값 바꾸기
            targetArr[a-1] = numArr[b-1];
            targetArr[b-1] = numArr[a-1];
        }
        s.close();
        for (int num : targetArr) {
            System.out.print(num+" ");
        }
    }
}