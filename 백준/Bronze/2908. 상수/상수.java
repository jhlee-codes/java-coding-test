import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        char[] charA = Integer.toString(a).toCharArray();
        char[] charB = Integer.toString(b).toCharArray();

        char[] newA = new char[charA.length];
        char[] newB = new char[charB.length];

        for (int i=0;i<charA.length;i++) {
            newA[i] = charA[3-1-i];
        }

        for (int i=0;i<charB.length;i++) {
            newB[i] = charB[3-1-i];
        }

        int newAInt = Integer.parseInt(String.valueOf(newA));
        int newBInt = Integer.parseInt(String.valueOf(newB));

        if (newAInt > newBInt) {
            System.out.println(newAInt);
        } else {
            System.out.println(newBInt);
        }
        
        s.close();
    }
}