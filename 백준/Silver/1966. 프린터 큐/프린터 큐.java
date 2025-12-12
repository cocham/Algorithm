import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Docs docs = new Docs();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                Doc doc = new Doc(j, Integer.parseInt(st.nextToken()));
                docs.addDocs(doc);
            }
            sb.append(docs.doPrint(m)).append('\n');
        }
        System.out.print(sb);
    }
    
    static class Docs {
    private LinkedList<Doc> queue;

    public Docs() {
        this.queue = new LinkedList<>();
    }

    public void addDocs(Doc doc) {
        queue.add(doc);
    }

    public int doPrint(int m) {
        int printOrder = 0;
        while (!queue.isEmpty()) {
            Doc current = queue.poll();

            boolean hasHigherPriority = queue.stream()
                       .anyMatch(doc -> doc.getPriority() > current.getPriority());

            if (hasHigherPriority) {
               queue.addLast(current);
            } else {
                printOrder++;
                if (current.getId() == m) {
                    break;
                }
           }
       }

       return printOrder;
    }
}
    
    static class Doc {
    private int id;
    private int priority;

    public Doc(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}
}
