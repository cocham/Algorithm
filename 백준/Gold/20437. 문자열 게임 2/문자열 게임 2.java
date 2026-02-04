import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            List<Integer>[] alphas = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alphas[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                int idx = c - 'a';
                alphas[idx].add(i);
            }
            
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
                
            for (int i = 0; i < alphas.length; i++) {
                if (alphas[i].size() >= K) {
                    for (int j = 0; j <= alphas[i].size() - K; j++) {
                        minLength = Math.min(alphas[i].get(j + K - 1) -  alphas[i].get(j) + 1, minLength);
                        maxLength = Math.max(alphas[i].get(j + K - 1) -  alphas[i].get(j) + 1, maxLength);
                    }
                }
            }
            
            if (minLength == Integer.MAX_VALUE || maxLength == Integer.MIN_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(minLength).append(" ").append(maxLength).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}