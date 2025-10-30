import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<List<Integer>> files = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            List<Integer> file = new ArrayList<>();

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num != -1) {
                    file.add(num);
                } else {
                    break;
                }
            }
            files.add(file);
        }
        
        StringBuilder[] cut = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            cut[i] = new StringBuilder();
        }
        for (int k = 0; ; k++) {
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (k < files.get(i).size()) {
                    int p = files.get(i).get(k);
                    cut[i].append(p).append(',');
                } else {
                    cut[i].append(0).append(',');
                }
                seen.add(cut[i].toString());
            }
            if (seen.size() == n) {
                System.out.println(k + 1);
                break;
            }
        }
    }
}