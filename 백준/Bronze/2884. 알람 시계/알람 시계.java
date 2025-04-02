import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hour = s.nextInt();
        int minute = s.nextInt();
        s.close();
        int realTime;

        if (hour>=0 && hour<24 && minute<60 && minute>=0) {
            realTime = hour * 60 + minute - 45;
            
            if (realTime<0) {
                realTime += 24 * 60;
            }
            
        } else {
            System.out.println("시간을 잘못 입력하였습니다.");
            return ;
        }
        System.out.printf("%d %d", realTime/60, realTime%60);

    }
}