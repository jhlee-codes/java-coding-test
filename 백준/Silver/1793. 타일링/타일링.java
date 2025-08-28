import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 문제 : 2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수 구하기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 큰 수 연산 -> BigInteger 활용
        // 런타임 에러 (ArrayIndexOutOfBounds) 발생 -> ArrayList로 변경
        List<BigInteger> tileCnt = new ArrayList<>();
        tileCnt.add(BigInteger.ONE);   // tileCnt[0]
        tileCnt.add(BigInteger.ONE);   // tileCnt[1]

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);

            // 2xn 직사각형의 맨 오른쪽부분을 2x1(가로/세로), 2x2 타일로 채운다고 가정
            // -> 남는 부분 n-1, n-2, n-2
            for (int i = tileCnt.size(); i <= n; i++) {
                tileCnt.add(tileCnt.get(i - 1).add(tileCnt.get(i - 2).shiftLeft(1)));
            }

            System.out.println(tileCnt.get(n));
        }
    }
}
