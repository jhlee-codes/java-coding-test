import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int firstNum = s.nextInt();
        int secondNum = s.nextInt();
        s.close();
        
        System.out.println(firstNum-secondNum);
    }
}