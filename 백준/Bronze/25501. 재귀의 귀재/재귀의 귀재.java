import java.util.Scanner;

public class Main {
    public static int cnt = 0;

    public static int recursion(char[] chars, int l, int r){
        cnt +=1;
        if(l >= r) return 1;
        else if(chars[l] != chars[r]) return 0;
        else return recursion(chars, l+1, r-1);
    }

    public static int isPalindrome(char[] chars){
        return recursion(chars, 0, chars.length-1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i=0;i<n;i++) {
            cnt = 0;
            char[] charArr = s.next().toCharArray();
            System.out.println(isPalindrome(charArr)+" " + cnt);
        }
        s.close();

    }
}
