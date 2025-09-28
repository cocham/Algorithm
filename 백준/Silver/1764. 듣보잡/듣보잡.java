import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> unKnowns = new HashMap<>();
        ArrayList<String> resultList = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int noListenNums = Integer.parseInt(st.nextToken());
        int noSeenNums = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < noListenNums; i++) {
            String person = br.readLine();
            unKnowns.put(person, 1);
        }
        
        for (int i = 0; i < noSeenNums; i++) {
            String person = br.readLine();
            
            if (unKnowns.containsKey(person)) {
                resultList.add(person);
            }
        }
        
        Collections.sort(resultList);    
        System.out.println(resultList.size());
        for (String p : resultList) {
            System.out.println(p);
        }
    }
}