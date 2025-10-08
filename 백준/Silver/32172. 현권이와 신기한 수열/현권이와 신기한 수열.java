import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Set<Integer> sequence = new HashSet<>();
        int[] nums = new int[n + 1];
        sequence.add(0);
        nums[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int beforeN = nums[i - 1];
            int curN = beforeN - i;
            if (curN < 0 || !sequence.add(curN)) {
                curN = beforeN + i;
            }
            sequence.add(curN);
            nums[i] = curN;
        }
        
        System.out.print(nums[n]);
    }
}