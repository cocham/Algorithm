import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] rooms = new int[N];
        for (int i = 0; i < N; i++) {
            rooms[i] = i;
        }
        
        int totalCnt = 0;
        int curMaxSequence = 0;
        int maxSequence = 0;
        int hongId = 0;
        int joeId = A;
        
        for (int m = 0; m < M; m++) {
            int hongLoc = -1;
            int joeLoc = -1;
            for (int i = 0; i < N; i++) {
                if (rooms[i] == hongId) {
                    hongLoc = i;
                } else if (rooms[i] == joeId) {
                    joeLoc = i;
                }
            }
            
            if (Math.abs(hongLoc - joeLoc) <= B) {
                totalCnt++;
                curMaxSequence++;
                maxSequence = Math.max(curMaxSequence, maxSequence);
            } else {
                curMaxSequence = 0;
            }
            
            if (m == M - 1) {
                break;
            }
            
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            
            int[] curScores = new int[N];
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                curScores[i] = a - b;
            }
            
            for (int r = 0; r < N - 1; r++) {
                boolean swap = false;

                int person1 = rooms[r];
                int person2 = rooms[r + 1];
                int p1Score = curScores[person1];
                int p2Score = curScores[person2];
                
                if (p1Score >= 0 && p2Score >= 0 && p2Score >= p1Score + 2) {
                    swap = true;
                } else if (p2Score >= 0 && p1Score < 0) {
                    swap = true;
                } else if (p1Score < 0 && p2Score < 0 && p2Score >= p1Score + 4) {
                    swap = true;
                }
                
                if (swap) {
                    rooms[r + 1] = person1;
                    rooms[r] = person2;
                    curScores[person2] -= 2;
                    curScores[person1] += 2;
                }
            }
        }
        
        System.out.print(totalCnt + " " + maxSequence);
        
    }
}