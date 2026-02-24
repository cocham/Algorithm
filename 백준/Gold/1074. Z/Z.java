import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        int size = (int) Math.pow(2, N);
        findZ(0, 0, size);
    }
    
    static void findZ(int r, int c, int size) {
        if (r == R && c == C) {
            System.out.println(cnt);
            System.exit(0);
        }
        
        if (R < r || R >= r + size || C < c || C >= c + size) {
            cnt += size * size;
            return;
        }
        
        int newSize = size / 2;
        findZ(r, c, newSize);
        findZ(r, c + newSize, newSize);
        findZ(r + newSize, c, newSize);
        findZ(r + newSize, c + newSize, newSize);
    }
}
