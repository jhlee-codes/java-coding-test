import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int target = s.nextInt();
        int[] numArr = new int[total];
        for (int i=0;i<total;i++) {
            numArr[i] = s.nextInt();
        }

        for (int a : numArr){
            if (target>a) {
                System.out.print(a+" ");
            }
        }
    }
}