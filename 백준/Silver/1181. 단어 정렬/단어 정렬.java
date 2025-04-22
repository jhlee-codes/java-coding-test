import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        String[] strArr = new String[num];

        for (int i=0;i<num;i++) {
                strArr[i] = s.nextLine();
        }
        s.close();

        // 중복제거
        HashSet<String> setStrArr = new HashSet<>(Arrays.asList(strArr));
        // 다시 배열로 변환
        strArr = setStrArr.toArray(new String[0]);
        // 정렬
        Arrays.sort(strArr, (s1,s2) -> (s1.length() == s2.length()) ? s1.compareTo(s2) : s1.length()-s2.length());

        for (String str: strArr) {
            System.out.println(str);
        }
    }
}