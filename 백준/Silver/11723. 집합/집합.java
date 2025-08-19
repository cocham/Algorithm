import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int bitmask = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long cnt = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++){
            String[] line = br.readLine().split(" ");
            
            String op = line[0];
            
            switch(op){
                case "add":
                    add(Integer.parseInt(line[1]));
                    break;
                case "remove":
                    remove(Integer.parseInt(line[1]));
                    break;
                case "check":
                    sb.append(check(Integer.parseInt(line[1]))).append("\n");
                    break;
                case "toggle":
                    toggle(Integer.parseInt(line[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        
        System.out.print(sb);
    }     

    static void add(int x)    { bitmask |= (1 << (x - 1)); }
    static void remove(int x) { bitmask &= ~(1 << (x - 1)); }
    static int check(int x)   { return (bitmask & (1 << (x - 1))) != 0 ? 1 : 0;}
    static void toggle(int x) { bitmask ^= (1 << (x - 1)); }
    static void all()         { bitmask = (1 << 20) - 1; }
    static void empty()       { bitmask = 0; }
}
