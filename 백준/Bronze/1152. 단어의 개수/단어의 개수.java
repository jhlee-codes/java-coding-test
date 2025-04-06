import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        String[] strArr = str.split(" ");
        int cnt = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("")) {
                cnt--;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}