import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < 5; i++){
            ans ^= Integer.parseInt(br.readLine());
        }
        System.out.println(ans);
                                             
    }
}