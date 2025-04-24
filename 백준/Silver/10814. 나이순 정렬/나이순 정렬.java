import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();

        String[][] userInfo = new String[num][2];

        for (int i=0;i<num;i++) {
            userInfo[i][0] = s.next();
            userInfo[i][1] = s.nextLine();
        }

        s.close();

        // 안정소트
        Arrays.sort(userInfo, Comparator.comparing(o->Integer.parseInt(o[0])));

        for (String[] info : userInfo) {
            System.out.println(info[0]+info[1]);
        }
    }
}