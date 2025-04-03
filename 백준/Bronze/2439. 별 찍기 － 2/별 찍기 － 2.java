import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.close();

        for (int i=0;i<num;i++){
            for (int j=1;j<num-i;j++) {
                System.out.print(" ");
            }
            for (int j=0;j<i+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}