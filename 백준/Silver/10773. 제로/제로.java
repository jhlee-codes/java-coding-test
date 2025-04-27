import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int sum = 0;
        List<Integer> numList = new ArrayList<>();

        for (int i=0;i<num;i++) {
            int target = s.nextInt();

            if (target == 0) {
                numList.remove(numList.size()-1);
            } else {
                numList.add(target);
            }
        }

        for (int n : numList) {
            sum += n;
        }
        s.close();

        System.out.println(sum);
    }
}