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
        
        int strSeparatorN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < strSeparatorN; i++) {
            String separator = st.nextToken();
            separatorSet.add(separator.charAt(0));
        } 
        
        int numSeparatorN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSeparatorN; i++) {
            String numSeparator = st.nextToken();
            separatorSet.add(numSeparator.charAt(0));
        }
        
        int mergerN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mergerN; i++) {
            String merger = st.nextToken();
            separatorSet.remove(merger.charAt(0));
        }
        
        StringBuilder token = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (!separatorSet.contains(c) && c != ' ') {
                token.append(c);
            } else {
                if (token.length() > 0) {
                    sb.append(token).append('\n');
                    token.setLength(0);
                }
            }
        }
        
        if (token.length() > 0) {
            sb.append(token).append('\n');
        }
        
        System.out.print(sb);
    }
}