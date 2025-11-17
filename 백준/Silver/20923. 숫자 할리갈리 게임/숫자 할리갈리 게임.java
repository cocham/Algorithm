import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dodo = new ArrayDeque<>();
        Deque<Integer> su = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dodo.addFirst(Integer.parseInt(st.nextToken()));
            su.addFirst(Integer.parseInt(st.nextToken()));
        }
        
        Deque<Integer> doTurn = new ArrayDeque<>();
        Deque<Integer> suTurn = new ArrayDeque<>();
        String winner = "";
        while (m > 0) {

            if (dodo.isEmpty()) {
                winner = "su";
                break;
            }
            doTurn.addFirst(dodo.poll());
            if (dodo.isEmpty()) {
                winner = "su";
                break;
            }

            if (!doTurn.isEmpty() && doTurn.peek() == 5 
                || !suTurn.isEmpty() && suTurn.peek() == 5) {
                while(!suTurn.isEmpty()) {
                    dodo.addLast(suTurn.pollLast());
                }
                while(!doTurn.isEmpty()) {
                    dodo.addLast(doTurn.pollLast());
                } 
            } else if (!doTurn.isEmpty() && !suTurn.isEmpty() 
                && doTurn.peek() + suTurn.peek() == 5) {
                while(!doTurn.isEmpty()) {
                    su.addLast(doTurn.pollLast());
                } 
                while(!suTurn.isEmpty()) {
                    su.addLast(suTurn.pollLast());
                }
            }
            m--;

            if (m == 0) {
                break;
            }

            if (su.isEmpty()) {
                winner = "do";
                break;
            }
            suTurn.addFirst(su.poll());
            if (su.isEmpty()) {
                winner = "do";
                break;
            }

            if (!doTurn.isEmpty() && doTurn.peek() == 5 
                || !suTurn.isEmpty() && suTurn.peek() == 5) {
                while(!suTurn.isEmpty()) {
                    dodo.addLast(suTurn.pollLast());
                }
                while(!doTurn.isEmpty()) {
                    dodo.addLast(doTurn.pollLast());
                } 
            } else if (!doTurn.isEmpty() && !suTurn.isEmpty() 
                && doTurn.peek() + suTurn.peek() == 5) {
                while(!doTurn.isEmpty()) {
                    su.addLast(doTurn.pollLast());
                } 
                while(!suTurn.isEmpty()) {
                    su.addLast(suTurn.pollLast());
                }
            }
            m--;
            
            if (m == 0) {
                break;
            }
        }

        if (dodo.size() < su.size()) {
            winner = "su";
        } else if (dodo.size() > su.size()) {
            winner = "do";
        } else if (dodo.size() == su.size()) {
            winner = "dosu";
        }

        System.out.println(winner);
    }
}