import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        quadTree(0, 0, N);
        System.out.print(sb);
    }
    
    static void quadTree(int r, int c, int size) {
        if (isSameColor(r, c, size)) {
            sb.append(arr[r][c]);
            return;
        }
        
        int newSize = size / 2;
        sb.append("(");
        
        quadTree(r, c, newSize);
        quadTree(r, c + newSize, newSize);
        quadTree(r + newSize, c, newSize);
        quadTree(r + newSize, c + newSize, newSize);
        
        sb.append(")");
    }
    
    static boolean isSameColor(int r, int c, int size) {
        int start = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != start) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
