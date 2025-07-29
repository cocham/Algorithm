import java.io.*;
import java.util.*;

public class Main{
    static class Info{
        int s, b;
        String num;
        public Info(String num, int s, int b){
            this.num = num;
            this.s = s;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int answer = 0;
        ArrayList<Info> game = new ArrayList<>();
        int ncase = Integer.parseInt(br.readLine());
        for (int i = 0; i < ncase; i++){
            String[] line = br.readLine().split(" ");
            String N = line[0];
            int S = Integer.parseInt(line[1]);
            int B = Integer.parseInt(line[2]);
            game.add(new Info(N,S,B));
        }
        
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                if (j == i) continue;
                for (int k = 1; k <= 9; k++){
                    if (k == i || k == j) continue;
                    
                    String cand = "" + i + j + k;
                    if (numCheck(cand, game)) answer++;
                }
            }
        }
        
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    
    static boolean numCheck(String num, List<Info> game){
        for (Info hint : game){
            String guess = hint.num;
            int strike = hint.s;
            int ball = hint.b;
            int s = 0, b = 0;

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