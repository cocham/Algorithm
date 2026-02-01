import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        if (check1(num) && check2(num)) {
            System.out.print(4);
        } else if (check2(num)) {
            System.out.print(2);
        } else if (check1(num)) {
            System.out.print(1);
        } else {
            System.out.print(3);
        }
    }
    
    static boolean check1(String num) {
        int n = Integer.parseInt(num);
        
        if (n == 4 || n >= 6) {
            int sum = 0;
            String[] numArr = num.split("");
            for (int i = 0; i < numArr.length; i++) {
                int value = Integer.parseInt(numArr[i]);
                sum += value;
            }
            
            if (sum % 2 != 0) {
                return true;
            }
        }
        
        return false;
    }
    
    static boolean check2(String num) {
        int n = Integer.parseInt(num);
        if (n == 2 || n == 4) {
            return true;
        } else {
            int cnt = 0;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    cnt++;
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            
            if (n > 1) {
                cnt++;
            }
            
            if (cnt != 0 && cnt % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}