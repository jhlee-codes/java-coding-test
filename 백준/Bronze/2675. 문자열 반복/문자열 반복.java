import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] repeat = new int[num];
        String[] str = new String[num];
        for (int i = 0; i < num; i++) {
            repeat[i] = s.nextInt();
            str[i] = s.next();
        }
        s.close();
        for (int i = 0; i < num; i++) {
            char[] ch = str[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                for (int k = 0; k < repeat[i]; k++) {
                    System.out.print(ch[j]);
                }
            }
            System.out.println();
        }
    }
}