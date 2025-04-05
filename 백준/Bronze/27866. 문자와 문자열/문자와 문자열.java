import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int targetIdx = s.nextInt();
        s.close();
        System.out.println(str.charAt(targetIdx-1));
    }
}