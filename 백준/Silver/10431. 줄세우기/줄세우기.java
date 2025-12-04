import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Student {
        int height;

        public Student(int height) {
            this.height = height;
        }

       public boolean isTallerThan(Student newStudent) {
            return this.height > newStudent.height;
        }
    }
       
    public static class Line {
        
        private final List<Student> students = new ArrayList<>();

        public int stand(Student newStudent) {
            int stepBackCnt = (int) students.stream()
                                    .filter(student -> student.isTallerThan(newStudent))
                                    .count();
            int idx = 0;
            for (Student student : students) {
                if (student.isTallerThan(newStudent)) {
                    break;
                }
                idx++;
            }
        
            students.add(idx, newStudent);

            return stepBackCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int totalSteps = 0;
            Line line = new Line();
            for (int j = 0; j < 20; j++) {
                Student student = new Student(Integer.parseInt(st.nextToken()));
                totalSteps += line.stand(student);
            }

            sb.append(t).append(' ').append(totalSteps).append('\n');
        }

        System.out.print(sb);
    }
}
