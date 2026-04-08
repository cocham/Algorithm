import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static int n1, n2, n3, n4;
    static int[] cnt = new int[8001];
    static ArrayList<Integer> mode = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = 4001;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            cnt[n + 4000]++;
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        Arrays.sort(arr);
        
        n1 = (int) Math.round((double) sum / N);
        n2 = arr[N / 2];
        
        int maxCnt = 0;
        for (int i = 0; i <= 8000; i++) {
            maxCnt = Math.max(cnt[i], maxCnt);
        }
        
        boolean fst = false;
        for (int i = 0; i <= 8000; i++) {
            if (cnt[i] == maxCnt) {
                if (!fst) {
                    n3 = i - 4000;
                    fst = true;
                } else {
                    n3 = i - 4000;
                    break;
                }
            }
        }
        
        n4 = max - min;
        System.out.println(n1 + "\n" + n2 + "\n" + n3 + "\n" + n4);
    }
}
