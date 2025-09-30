import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> employee = new HashMap<>();
        int overTime = 0;
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String inOrOut = st.nextToken();
            
            if (inOrOut.equals("+")) {
                employee.put(name, employee.getOrDefault(name, 0) + 1);
            } else if (inOrOut.equals("-")) {
                int c = employee.getOrDefault(name, 0);
                if (c > 0) {
                    employee.put(name, c - 1);
                } else {
                    overTime++;
                }
            }
        }
        
        for (int c : employee.values()) {
            if (c > 0) {
                overTime += c;
            }
        }
        
        System.out.println(overTime);
    }
}