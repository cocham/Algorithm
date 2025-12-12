import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Cogwheel> cogwheelsList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            Cogwheel cogwheel = new Cogwheel(line);
            cogwheelsList.add(cogwheel);
        }
        Cogwheels cogwheels = new Cogwheels(cogwheelsList);

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            cogwheels.move(wheelNum, direction);
        }

        System.out.println(cogwheels.calcScores());
    }

    static class Cogwheels {
        private final List<Cogwheel> cogwheelList;

        Cogwheels(List<Cogwheel> cogwheelList) {
            this.cogwheelList = List.copyOf(cogwheelList);
        }

        public void move(int wheelIndex, int direction) {
            int idx = wheelIndex - 1;
            int[] rotateDirections = new int[4];
            rotateDirections[idx] = direction;

            // 왼쪽으로 전파
            for (int i = idx; i > 0; i--) {
                if (cogwheelList.get(i).getLeftWheel() != cogwheelList.get(i - 1).getRightWheel()) {
                    rotateDirections[i - 1] = -rotateDirections[i];
                } else {
                    break;
                }
            }

            // 오른쪽으로 전파
            for (int i = idx; i < 3; i++) {
                if (cogwheelList.get(i).getRightWheel() != cogwheelList.get(i + 1).getLeftWheel()) {
                    rotateDirections[i + 1] = -rotateDirections[i];
                } else {
                    break;
                }
            }

            // 실제 회전
            for (int i = 0; i < 4; i++) {
                if (rotateDirections[i] != 0) {
                    cogwheelList.get(i).rotate(rotateDirections[i]);
                }
            }
        }

        public int calcScores() {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if (cogwheelList.get(i).getFirstWheel() == 1) {
                    sum += (1 << i); // 2^i
                }
            }
            return sum;
        }
    }

    static class Cogwheel {
        private final LinkedList<Integer> wheels;

        Cogwheel(String line) {
            this.wheels = Arrays.stream(line.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        public int getRightWheel() {
            return wheels.get(2);
        }

        public int getLeftWheel() {
            return wheels.get(6);
        }

        public void rotate(int rotateDirection) {
            if (rotateDirection == -1) {
                moveLeft();
            } else if (rotateDirection == 1) {
                moveRight();
            }
        }

        private void moveLeft() {
            wheels.addLast(wheels.poll());
        }

        private void moveRight() {
            wheels.addFirst(wheels.pollLast());
        }

        public int getFirstWheel() {
            return wheels.getFirst();
        }
    }
}
