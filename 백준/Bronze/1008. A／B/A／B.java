import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double firstNum = s.nextDouble();
        double secondNum = s.nextDouble();
        s.close();
        
        System.out.println(firstNum/secondNum);
        
    }
}