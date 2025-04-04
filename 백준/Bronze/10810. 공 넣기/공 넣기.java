import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] ballArr = new int[n];
        for (int i : ballArr) {
            i = 0;
        }
        for (int i=0;i<m;i++) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            int num3 = s.nextInt();
            int length = num2-num1;
            for (int j=0;j<length+1;j++) {
                ballArr[num1+j-1] = num3;
            }
        }
        s.close();
        for (int i : ballArr) {
            System.out.print(i+" ");
        }
    }
}