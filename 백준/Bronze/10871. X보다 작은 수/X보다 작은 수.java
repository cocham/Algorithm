import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] fstLine = br.readLine().split(" ");
        int X = Integer.parseInt(fstLine[1]);
        
        String[] sequence = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (String token : sequence){
            int n = Integer.parseInt(token);
            if (n < X){
                sb.append(n).append(' ');
            }
        }
        
        bw.write(sb.toString().trim());
        bw.newLine();
        
        bw.flush();
        br.close();
        bw.close();
    }
}