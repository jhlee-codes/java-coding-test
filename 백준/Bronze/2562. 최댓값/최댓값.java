import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] numArr = new int[9];
        int max = 0;
        int targetIdx = 0;
        for (int i=0;i<9;i++) {
            numArr[i] = s.nextInt();
            s.nextLine();
            if (numArr[i]>max) {
                max = numArr[i];
                targetIdx = i+1;
            }
        }
        System.out.println(max);
        System.out.println(targetIdx);
    }
}