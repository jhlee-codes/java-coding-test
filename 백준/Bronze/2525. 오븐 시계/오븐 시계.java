import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        int hour = s.nextInt();
        int minute = s.nextInt();
        s.nextLine();
        int time = s.nextInt();
        s.close();
        
        int cookEndTime;
        
        if (hour>=0 && hour<24 && minute>=0 && minute<60 ) {
            if (time>=0 && time<=1000){
                cookEndTime = hour * 60 + minute + time;
          
                if (cookEndTime >= 24*60) {
                    cookEndTime -= 24*60;

                }
                
            } else {
                System.out.println("요리 시간을 잘못 입력하였습니다.");
                return ;
            }
        } else {
            System.out.println("현재 시각을 잘못 입력하였습니다.");
            return ;
        }
        
        System.out.printf("%d %d", cookEndTime/60 , cookEndTime%60);
        
        
    }
}