import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        Map<String, Integer> salesBook = new HashMap<>();

        for (int i = 1; i <= total; i++) {
            String title = br.readLine();

            if (salesBook.containsKey(title)) {
                salesBook.put(title, salesBook.get(title) + 1);
            } else {
                salesBook.put(title, 0);
            }
        }

        // 사전순 정렬
        salesBook = new TreeMap<>(salesBook);

        // 최대카운트수(value) 구하고, 해당 카운트수인 제목(key) 출력 
        Integer maxCnt = Collections.max(salesBook.values());
        for (String title : salesBook.keySet()) {
            if (salesBook.get(title).equals(maxCnt)) {
                System.out.println(title);
                break;
            }
        }
    }
}