import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    static int[] sevens = new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            sevens[i] = Integer.parseInt(br.readLine());
        }
        
        boolean find = false;
        for (int i = 0; i < 9; i++) {
            if (find) {
                break;
            }
            for(int j = i + 1; j < 9; j++) {               
                if (check(i, j)) {
                    find = true;
                    sevens[i] = 0;
                    sevens[j] = 0;
                } 
            }
        }
        
        Arrays.sort(sevens);
        for (int i = 0; i < 9; i++) {
            if (sevens[i] != 0) {
                System.out.println(sevens[i]);
            }
        }
    }
    
    static boolean check(int idx, int jdx) {
        int checkSum = 0;
        for (int i = 0; i < 9; i++) {
            if (i == idx || i == jdx) {
                continue;
            }
            checkSum += sevens[i];
        }
        if (checkSum == 100) {
            return true;
        }
        return false;
    }
}