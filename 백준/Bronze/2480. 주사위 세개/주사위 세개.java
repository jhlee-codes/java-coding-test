import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        s.close();
        int money;
        
        if (a==b && b==c) {
            money = 10000 + a * 1000;
        } else if (a==b || b==c || a==c) {
            if (a == b) {
                money = 1000 + a * 100;
            } else {
                money = 1000 + c * 100;
            }
        } else {
            money =  Math.max(a, Math.max(b, c))*100;
        }
        
        System.out.println(money);
    }
}