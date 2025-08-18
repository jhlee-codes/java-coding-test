import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        List<String> serialNums = new ArrayList<>();

        for (int i = 1; i <= total; i++) {
            serialNums.add(br.readLine());
        }

        // 1. 길이순 -> 2. 숫자의 합 -> 3. 사전순 정렬
        serialNums.sort(
            Comparator.comparingInt(String::length)
                .thenComparingInt(Main::sum)
                .thenComparing(Comparator.naturalOrder())
        );

        for (String str : serialNums) {
            System.out.println(str);
        }
    }

    public static int sum(String str) {
        int sum = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(str.charAt(i) + "");
            }
        }

        return sum;
    }
}