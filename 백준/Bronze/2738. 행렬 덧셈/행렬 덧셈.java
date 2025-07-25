import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fstLine = br.readLine().split(" ");
        
        int N = Integer.parseInt(fstLine[0]);
        int M = Integer.parseInt(fstLine[1]);
        
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
  
        for (int i = 0; i < N; i++){
            A[i] = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();
        }
        
        for (int i = 0; i < N; i++){
            B[i] = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();
        }
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                int sum = A[i][j] + B[i][j];
                bw.write(Integer.toString(sum));
                if (j < M - 1) bw.write(' ');
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}