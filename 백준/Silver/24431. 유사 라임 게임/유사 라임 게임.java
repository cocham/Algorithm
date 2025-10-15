import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int cnt = 0;
            Set<String> surfSet = new HashSet<>();
            String[] words = br.readLine().split(" ");
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                String surffix = word.substring(l - f);

                if (!surfSet.contains(surffix)) {
                    surfSet.add(surffix);
                } else {
                    cnt += 2;
                    surfSet.remove(surffix);
                }
            }
            sb.append(cnt / 2).append('\n');
        }
        
        System.out.print(sb);
    } 
}