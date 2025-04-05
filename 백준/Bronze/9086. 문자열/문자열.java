import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i=0;i<num;i++) {
            String str = s.next();
            // 중간에 +""+ 없으면 숫자로 출력됨
            System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
        }
        s.close();
    }
}