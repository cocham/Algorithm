import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        int ncase = Integer.parseInt(br.readLine());
        for (int i = 0; i < ncase; i++){
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int S = Integer.parseInt(line[1]);
            int B = Integer.parseInt(line[2]);
            list.add(new int[] {N, S, B});
        }
        
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                if (j == i) continue;
                for (int k = 1; k <= 9; k++){
                    if (k == i || k == j) continue;
                    
                    String cand = "" + i + j + k;
                    if (numCheck(cand, list)) answer++;
                }
            }
        }
        
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    
    static boolean numCheck(String num, List<int[]> list){
        for (int[] hint : list){
            String guess = Integer.toString(hint[0]);
            int s = 0, b = 0;
            int strike = hint[1];
            int ball = hint[2];
            for (int idx = 0; idx < 3; idx++){
                if(num.charAt(idx) == guess.charAt(idx)){
                    s++;
                } else if(guess.indexOf(num.charAt(idx)) != -1){
                    b++;
                }
            }
            if (s != strike || b != ball) return false;
        }
        return true;
    }
}