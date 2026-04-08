import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Solution
{
    static int N, M;
    static int max = 0;
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            max = 0;
            int[][] arr = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
                	check(i, j, arr);
                }
            }
            
            sb.append("#").append(t).append(" " + max).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void check(int r, int c, int[][] arr) {
        int sum = 0;
        
    	for (int i = r; i < r + M; i++) {
        	for (int j = c; j < c + M; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) return;
				sum += arr[i][j];
            }
        }
        
        max = Math.max(sum, max);
       
    }
}