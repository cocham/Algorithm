import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[] dwarfs = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            dwarfs[i] = n;
        }
        
        for (int i = 0; i < 9; i++) {
            int fakeDwarf1 = dwarfs[i];
            for (int j = i + 1; j < 9; j++) {
                int fakeDwarf2 = dwarfs[j];
                if (judgeDwarfs(i, j, fakeDwarf1, fakeDwarf2)) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    break;
                }
            }
        }
        
        Arrays.sort(dwarfs);
        for (int i = 0; i < 9; i++) {
            if (dwarfs[i] != 0) {
                System.out.println(dwarfs[i]);
            }
        }
    }
    
    static boolean judgeDwarfs(int i, int j, int fakeDwarf1, int fakeDwarf2) {
        dwarfs[i] = 0;
        dwarfs[j] = 0;
        
        int cnt = 0;
        for (int idx = 0; idx < 9; idx++) {
            cnt += dwarfs[idx];
        }
        
        if (cnt == 100) {
            return true;
        } else {
            dwarfs[i] = fakeDwarf1;
            dwarfs[j] = fakeDwarf2;
            return false;
        }
    }
}