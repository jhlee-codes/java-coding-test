import java.util.Scanner;
public class Main {                    
    public static void main(String[] args) {   
        Scanner s = new Scanner(System.in);    
        int[] numArr = new int[10];            
        int totalCnt = 0;                      
        for (int i=0;i<10;i++) {               
            int num = s.nextInt();             
            numArr[i] = num%42;                
        }                                      
        for (int i=0;i<10;i++) {               
            int cnt =0;                        
            for (int j=i+1;j<10;j++) {         
                if (numArr[i] != numArr[j]) {  
                    cnt++;                     
                }                              
            }                                  
            if (cnt == 10-i-1) {               
                totalCnt++;                    
            }                                  
        }                                      
        s.close();                             
        System.out.println(totalCnt);          
    }                                          
}                                              