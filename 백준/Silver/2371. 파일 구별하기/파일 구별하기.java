import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        List<int[]> files = new ArrayList<>(n);
        List<Integer> cur = new ArrayList<>();
        
        while(files.size() < n) {
            int v = sc.nextInt();
            if (v == -1) {
                int[] arr = cur.stream()
                               .mapToInt(Integer::intValue)
                               .toArray();
                files.add(arr);
                cur.clear();
            } else {
                cur.add(v);
            }
        }
        
        StringBuilder[] sig = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            sig[i] = new StringBuilder();
        }
        
        for (int k = 0; ; k++) {
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (k < files.get(i).length) {
                    sig[i].append(files.get(i)[k]).append(',');
                } else {
                    sig[i].append(0).append(',');
                }
                seen.add(sig[i].toString());
            }
            if (seen.size() == n) {
                System.out.println(k + 1);
                break;
            }
        }
            
    } 
}