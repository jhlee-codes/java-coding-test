import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    // 숫자 범위를 나타내는 N
    // 출력한 숫자 개수 M
    // 현재 출력한 숫자 위치 current
    //현재 숫자 위치에 해당하는 숫자 출력*
    // N: 4, M: 3
    // 1 2 3
    // index (0, 1, 2) <3>
    // 1 [2]
    public void recursive(int N, int M, List<Integer> selected, int current) {
        // 기저 사례
        if (current == M) {
            for (int i = 0; i < selected.size(); i++) {
                System.out.print(selected.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (selected.contains(i)) {
                continue;
            }
            if (selected.size() != 0 && i<selected.get(selected.size()-1)) {
                continue;
            }
            selected.add(i);
            recursive(N, M, selected, current + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N, M, new ArrayList<>(), 0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}