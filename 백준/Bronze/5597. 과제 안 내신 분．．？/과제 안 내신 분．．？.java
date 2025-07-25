import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] submitted = new boolean[31];
        
        for (int i = 0; i < 28; i++){
            int X = Integer.parseInt(br.readLine());
            submitted[X] = true;
        }
  
        for (int i = 1; i <= 30; i++){
            if (!submitted[i]){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}