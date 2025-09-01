import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++){
            int cpy = Integer.parseInt(br.readLine());
            sb.append(cpy).append(" ").append(cpy).append('\n');
        }
        System.out.println(sb);
    }
}