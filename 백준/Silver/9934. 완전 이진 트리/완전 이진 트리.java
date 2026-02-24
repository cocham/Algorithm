import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Main {
    static int K;
    static ArrayList<Integer>[] tree;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        tree = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            tree[i] = new ArrayList<>();
        }
        arr = new int[(int) Math.pow(2, K) - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (int) Math.pow(2, K) - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        buildTree(0, arr.length - 1, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < tree[i].size(); j++) {
                sb.append(tree[i].get(j)).append(" ");
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void buildTree(int start, int end, int depth) {
        if (start > end) {
            return;
        }
        
        int mid = (start + end) / 2;
        
        tree[depth].add(arr[mid]);
        
        buildTree(start, mid - 1, depth + 1);
        buildTree(mid + 1, end, depth + 1);
    }
}