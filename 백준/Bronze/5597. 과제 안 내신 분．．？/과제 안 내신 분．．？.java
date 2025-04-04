import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] student = new int[30];
        for (int i : student) {
            i = 0;
        }
        for (int i=0;i<28;i++){
            int n = s.nextInt();
            student[n-1]++;
        }
        for (int i=0;i<student.length;i++) {
            if (student[i] == 0) {
                System.out.println(i+1);
            }
        }
        
    }
}