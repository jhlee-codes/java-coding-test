import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문제 : 숫자의 총 합이 100을 가깝게 만들기 (입력: 10개의 정수)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int target = sum + num;
            if (target > 100) {
                if (target - 100 > 100 - sum) {
                    break;
                }
            }
            sum += num;
        }

        System.out.println(sum);
    }
}