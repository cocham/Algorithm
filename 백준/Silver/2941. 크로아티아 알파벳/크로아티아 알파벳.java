import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        String sep = s.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "0");
        
        System.out.print(sep.length());   
    }
}