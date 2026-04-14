import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dodo = new ArrayDeque<>();
        Deque<Integer> su = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dodo.addFirst(Integer.parseInt(st.nextToken()));
            su.addFirst(Integer.parseInt(st.nextToken()));
        }
        
        Deque<Integer> donq = new LinkedList<>();
        Deque<Integer> suq = new LinkedList<>();
        
        
        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                donq.add(dodo.poll());
                if (dodo.size() == 0) break;
            } else {
                suq.add(su.poll());
                if (su.size() == 0) break;
            }
            
            int sutop = suq.isEmpty() ? 0 : suq.peekLast();
            int dotop = donq.isEmpty() ? 0 : donq.peekLast();

            if (dotop == 5 || sutop == 5) {
                while (!suq.isEmpty()) {
                    dodo.addLast(suq.poll());
                }
                while (!donq.isEmpty()) {
                    dodo.addLast(donq.poll());
                }
            } 
            if (!donq.isEmpty() && !suq.isEmpty() && sutop + dotop == 5) {
                while (!donq.isEmpty()) {
                    su.addLast(donq.poll());
                }
                while (!suq.isEmpty()) {
                    su.addLast(suq.poll());
                }
            }
        }

        if (dodo.size() > su.size()) {
            System.out.print("do");
        } else if (su.size() > dodo.size()) {
            System.out.print("su");
        } else {
            System.out.print("dosu");
        }
    }
}
