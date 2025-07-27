import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] chars = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (char c : chars){
            if (Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}