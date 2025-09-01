import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 (A+B)%C, 
        // 둘째 줄에 ((A%C) + (B%C))%C
        // 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        long arr[] = Arrays.stream(br.readLine().trim().split(" "))
                           .mapToLong(Long::parseLong)
                           .toArray();
        long a = arr[0], b = arr[1], c = arr[2];
        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b % c)) % c);
    }
}