import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] chess = {1,1,2,2,2,8};
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            int a = Integer.parseInt(input[i]);
            System.out.print(chess[i] - a+" ");
        }
    }
}