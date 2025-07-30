import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()),
            m = Integer.parseInt(st.nextToken()), 
            rcnt = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        
        int layers = Math.min(n, m) / 2;
        for (int i = 0; i < rcnt; i++){
            for (int lay = 0; lay < layers; lay++){
                int temp = arr[lay][lay];
                for(int c = lay + 1; c < m - lay; c++){
                    arr[lay][c - 1] = arr[lay][c];
                } //위
                for(int r = lay + 1; r < n - lay; r++){
                    arr[r - 1][m - 1 - lay] = arr[r][m - 1 - lay];
                } //오
                for(int c = m - 2 - lay; c >= lay; c--){
                    arr[n - 1 - lay][c + 1] = arr[n - 1 - lay][c];
                }//우
                for(int r = n - 2 - lay; r >= lay; r--){
                    arr[r + 1][lay] = arr[r][lay];
                }//좌
                
                arr[lay + 1][lay] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
               System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}