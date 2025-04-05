import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            System.out.println(num1+num2);
        }
        s.close();
    }
}