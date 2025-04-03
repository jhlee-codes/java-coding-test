import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        for (int i=0;i<total;i++) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            
            System.out.println(num1+num2);
        }
        s.close();
    }
}