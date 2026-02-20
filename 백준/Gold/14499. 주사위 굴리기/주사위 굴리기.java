import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int R, C;
    static int[][] arr;
    static int K;
    static int[] dr = {0,0,0,-1,1};
    static int[] dc = {0,1,-1,0,0};
    static int[] dice = new int[7]; //위 뒤 우 좌 앞 밑
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int move = Integer.parseInt(st.nextToken());
            
            int nr = R + dr[move];
            int nc = C + dc[move];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            R = nr;
            C = nc;
            roll(move);
            if (arr[R][C] == 0) {
                arr[R][C] = dice[6];
            } else {
                dice[6] = arr[R][C];
                arr[R][C] = 0;
            }
            
            sb.append(dice[1]).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void roll(int move) {
        int[] temp = dice.clone();
        
        if (move == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (move == 2) {
            dice[4] = temp[1];
            dice[6] = temp[4];
            dice[1] = temp[3];
            dice[3] = temp[6];
        } else if (move == 3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else if (move == 4) {
            dice[5] = temp[1];
            dice[6] = temp[5];
            dice[2] = temp[6];
            dice[1] = temp[2];
        } 
    }
}