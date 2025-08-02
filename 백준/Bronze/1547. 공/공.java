import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = Arrays.asList("1", "2", "3");
        
        for (int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            String X = str[0], Y = str[1];
            int xpos = list.indexOf(X), ypos = list.indexOf(Y);
            list.set(ypos, X);
            list.set(xpos, Y);
        }
        
        System.out.println(list.get(0));
    }
}