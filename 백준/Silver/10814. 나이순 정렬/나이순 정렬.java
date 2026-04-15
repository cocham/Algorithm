import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Person {
        int age;
        String name;
        
        Person (int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        Person[] p = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[i] = new Person(age, name);
        }
        
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Person ps : p) {
            sb.append(ps.age).append(" " + ps.name).append("\n");
        }
        
        System.out.print(sb);
    }
}