import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cardNum = s.nextInt();
        int maxNum = s.nextInt();
        int[] card = new int[cardNum];
        int result =0;
        int maxResult = 0;
        s.nextLine();
        for (int i=0;i<cardNum;i++) {
            card[i] = s.nextInt();
        }
        // 완전탐색, 숫자 3개씩 더하는 모든 경우의 수
        for (int i=0;i<cardNum-2;i++) {
            for (int j=i+1;j<cardNum-1;j++) {
                for (int k=j+1;k<cardNum;k++) {
                    result = card[i] + card[j] + card[k];
                    if (result <= maxNum) {
                        if (result > maxResult) {
                            maxResult = result;
                        }
                    }
                }
            }
        }
        System.out.println(maxResult);
    }
}