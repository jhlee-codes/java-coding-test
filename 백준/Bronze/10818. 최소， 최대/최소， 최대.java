import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int[] numArr = new int[total];
        int max = 0;
        int min = 0;
        for (int i=0;i<total;i++) {
            numArr[i] = s.nextInt();
            if (i ==0) {
                max = numArr[i];
                min = numArr[i];
            }
            if (numArr[i] > max) {
                max = numArr[i];
            }
            if (numArr[i] < min) {
                min = numArr[i];
            }
        }

        System.out.println(min + " " + max);
    }
}