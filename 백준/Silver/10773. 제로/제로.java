import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> moneys = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                moneys.pop();
            }
            else {
                moneys.add(n); 
            }
        }
        
        long sum = 0;
        for (Integer n : moneys) {
            sum += n;
        }
        
        System.out.print(sum);
    }
}