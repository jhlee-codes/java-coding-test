import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while(true) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();

            if (num1==0 && num2==0) {
                break;
            }
            
            System.out.println(num1+num2);
        }
        s.close();
    }
}