import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Node[] tree = new Node[26];
    static StringBuilder sb = new StringBuilder();
    
    static class Node {
        char left, right;
        
        Node (char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            tree[root - 'A'] = new Node(left, right);
        }
        
        preOrder('A');
        sb.append('\n');
        inOrder('A');
        sb.append('\n');
        postOrder('A');
        
        System.out.print(sb);
    }
    
    static void preOrder(char cur) {
        if (cur == '.') {
            return;
        }
        
        sb.append(cur);
        
        preOrder(tree[cur - 'A'].left);
        preOrder(tree[cur - 'A'].right);
    }
    
    static void inOrder(char cur) {
        if (cur == '.') {
            return;
        }
                
        inOrder(tree[cur - 'A'].left);
        sb.append(cur);
        inOrder(tree[cur - 'A'].right);
    }
    
    static void postOrder(char cur) {
        if (cur == '.') {
            return;
        }
                
        postOrder(tree[cur - 'A'].left);
        postOrder(tree[cur - 'A'].right);
        sb.append(cur);
    }
}
