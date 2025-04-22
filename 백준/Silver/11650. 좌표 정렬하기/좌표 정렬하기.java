import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int[][] coordinate = new int[num][2];
        for (int i=0;i<num;i++) {
            coordinate[i][0] = s.nextInt();
            coordinate[i][1] = s.nextInt();
        }
        s.close();
        
        Arrays.sort(coordinate, (o1,o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        for (int[] arr: coordinate) {
            System.out.println(arr[0]+ " "+ arr[1]);
        }
    }
}
