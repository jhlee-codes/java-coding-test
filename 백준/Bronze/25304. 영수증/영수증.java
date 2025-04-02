import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int totalPrice = s.nextInt();
        int type = s.nextInt();
        int sum = 0;
        
        for (int i=0;i<type;i++) {
            int price = s.nextInt();
            int amount = s.nextInt();
            
            if (amount>0 && amount<11) {
                sum += price*amount;
            } else {
                System.out.println("개수는 1~10개까지만 구매 가능합니다.");
                s.close();
                return ;       
            }       
        }      
        
        s.close();
        
        if (sum == totalPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}