import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = Arrays.stream(br.readLine().trim().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int a = arr[0], b = arr[1], c = arr[2];
        
        if (a + b == c){
            System.out.println("correct!");
        }else {
            System.out.println("wrong!");
        }
    }
}