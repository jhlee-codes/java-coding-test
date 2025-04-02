import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int firstNum = s.nextInt();
        int secondNum = s.nextInt();
        s.close();
        
        if (firstNum > secondNum) {
            System.out.println(">");
        } else if (firstNum < secondNum) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}
