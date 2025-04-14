import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt(); // 분해합 한 값
        s.close();
        // 생성자 구하기
        for (int i=0;i<num+1;i++) {
            int sum = i;
            int target = i;

            while(target>0) {
                sum += target%10; //10으로 나눈 나머지(자릿수) 합하기
                target = target/10;
            }

            if (sum == num) {
                System.out.println(i);
                return ;
            }
        }
        System.out.println("0");
    }
}