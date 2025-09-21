import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(i + 1);
        }
        
        int M = Integer.parseInt(st.nextToken());
        for (int c = 0; c < M; c++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            
            while (i < j) {
                int temp = nums.get(i);
                nums.set(i, nums.get(j));
                nums.set(j, temp);
                i++;
                j--;
            }
        }

        for (int c = 0; c < N; c++) {
            System.out.print(nums.get(c) + " ");
        }
    }
}