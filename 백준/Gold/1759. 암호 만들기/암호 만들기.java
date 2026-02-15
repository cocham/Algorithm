import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        
        dfs(0,"");
        System.out.print(sb);
    }
    
    static void dfs(int idx, String s) {
        if (s.length() == L) {
            if (check(s)) {
                sb.append(s).append('\n');
            }
        }
        
        for (int i = idx; i < C; i++) {
            dfs(i + 1, s + arr[i]);
        }
    }
    
    static boolean check(String s) {
        boolean option1 = false;
        int cnt = 0;
        
        if (s.length() < 3) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                option1 = true;
            } else {
                cnt++;
            }
        }
        
        if (option1 && cnt >= 2) {
            return true;
        }
        
        return false;
    }
}