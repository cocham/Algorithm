import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        
        int maxWidth = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int w = 0;
                while (j + w < M && i + w < N) {
                        int vertex1 = arr[i][j];
                        int vertex2 = arr[i][j + w];
                        int vertex3 = arr[i + w][j];
                        int vertex4 = arr[i + w][j + w];

                        if (vertex1 == vertex2 && vertex2 == vertex3 && vertex3 == vertex4) {
                            maxWidth = Math.max(maxWidth, (w+1) * (w+1));
                        }
                    
                    w++;
                }
            }
        }
        
        System.out.println(maxWidth);
    }
}