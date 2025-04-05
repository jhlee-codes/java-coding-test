import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] scoreArr = new int[n];
        int maxScore = 0;
        float avgScore = 0;
        for (int i=0;i<n;i++) {
            scoreArr[i] = s.nextInt();
            if (scoreArr[i] > maxScore) {
                maxScore = scoreArr[i];
            }
        }
        for (int i=0;i<n;i++) {
            // 형변환!!
            avgScore += (float) scoreArr[i]/maxScore*100;
        }
        avgScore = avgScore/n;
        System.out.println(avgScore);
    }
}