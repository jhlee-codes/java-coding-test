import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i=0;i<t;i++) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();

            System.out.printf("Case #%d: %d\n", i+1, num1+num2);
        }
        s.close();
    }
}