import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] cube = new int[101];
        for (int i = 0; i <= 100; i++) {
            cube[i] = i * i * i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int a = 2; a <= 100; a++) {
            int aCube = cube[a];
            for (int b = 2; b <= 100; b++) {
                int bCube = cube[b];
                for (int c = b; c <= 100; c++){
                    int cCube = cube[c];
                    for (int d = c; d <= 100; d++) {
                        int dCube = cube[d];
                        if (aCube == bCube + cCube + dCube) {
                           sb.append("Cube = ")
                             .append(a)
                             .append(", Triple = (")
                             .append(b).append(",")
                             .append(c).append(",")
                             .append(d).append(")")
                             .append('\n');
                        }
                    }
                }
            }
        }
        
        System.out.print(sb);
    }
}