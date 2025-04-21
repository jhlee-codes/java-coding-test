import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] numArr = new int[num];
        for (int i=0;i<num;i++) {
            numArr[i] = s.nextInt();
            s.nextLine();
        }
        s.close();
        Arrays.sort(numArr);

        for (int n : numArr) {
            System.out.println(n);
        }
    }
}