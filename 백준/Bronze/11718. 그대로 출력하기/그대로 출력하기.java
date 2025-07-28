import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
         
    }
}