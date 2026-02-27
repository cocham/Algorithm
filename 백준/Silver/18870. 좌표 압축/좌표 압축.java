import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int rank = 0;
        
        HashMap<Integer, Integer> smallCnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int stand = sortedArr[i];
            
            if (!smallCnt.containsKey(stand)) {
                smallCnt.put(stand, rank);
                rank++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int smalls = smallCnt.get(arr[i]);
            sb.append(smalls).append(" ");
        }
        
        System.out.print(sb);
    }
}
