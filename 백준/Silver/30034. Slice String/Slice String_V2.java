import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet; 
import java.util.Set; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> separatorSet = new HashSet<>();
        StringTokenizer st;
        
        int sepN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sepN; i++) {
            separatorSet.add(st.nextToken().charAt(0));
        } 
        
        int numSepN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSepN; i++) {
            separatorSet.add(st.nextToken().charAt(0));
        }
        
        int mergerN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mergerN; i++) {
            separatorSet.remove(st.nextToken().charAt(0));
        }
        
        StringBuilder sb = new StringBuilder();
        
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] chars = str.toCharArray();
        
        for (char c : chars) {
            if (!separatorSet.contains(c) && c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '\n') {
                    sb.append('\n');
                }
            }
        }
        
        System.out.print(sb);
    }
}
