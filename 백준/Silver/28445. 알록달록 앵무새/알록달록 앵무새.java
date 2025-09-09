import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        Set<String> uniqueColors = new TreeSet<>();
     
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        uniqueColors.add(st1.nextToken());
        uniqueColors.add(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        uniqueColors.add(st2.nextToken());
        uniqueColors.add(st2.nextToken());

        for (String bodyColor : uniqueColors) {
            for (String tailColor : uniqueColors) {
                System.out.println(bodyColor + " " + tailColor);
            }
        }
    }
}