import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] durabilities = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            durabilities[i] = Integer.parseInt(st.nextToken());
        }

        Belts belts = new Belts(n, durabilities);
        ConveyorSystem conveyorSystem = new ConveyorSystem();
        System.out.println(conveyorSystem.run(k, belts));
    }
    
    static class ConveyorSystem {

        public int run(int k, Belts belts) {
            int step = 0;
            while (belts.brokenSlotCount() < k) {
                step++;
                belts.rotate();
                belts.moveRobot();
                belts.putRobotFirstPlace();
            }
            return step;
        }
    }
        
    static class BeltSlot {
        private int durability;
        private boolean hasRobot;

        public BeltSlot(int durability) {
            this.durability = durability;
            this.hasRobot = false;
        }

        public void putRobot() {
            hasRobot = true;
            durability--;
        }

        public boolean isCanMove() {
            return !hasRobot && durability > 0;
        }

        public void getOff() {
            hasRobot = false;
        }

        public int getDurability() {
            return durability;
        }

        public boolean hasRobot() {
            return hasRobot;
        }
    }
    
    static class Belts {
        private LinkedList<BeltSlot> belts = new LinkedList<>();
        private int n;

        public Belts(int n, int[] durabilities) {
            this.n = n;
            for (int i = 0; i < n * 2; i++) {
                BeltSlot belt = new BeltSlot(durabilities[i]);
                belts.add(belt);
            }
        }

        public void rotate() {
            belts.addFirst(belts.pollLast());
            dropRobot();
        }

        public void moveRobot() {
            for (int i = n - 2; i >= 0; i--) {
                BeltSlot current = belts.get(i);
                BeltSlot next = belts.get(i + 1);

                if (current.hasRobot() && next.isCanMove()) {
                    current.getOff();
                    next.putRobot();
                }
            }

            dropRobot();
        }

        public void putRobotFirstPlace() {
            if (belts.get(0).isCanMove()) {
                belts.get(0).putRobot();
            }
        }

        private void dropRobot() {
            belts.get(n - 1).getOff();
        }

        public int brokenSlotCount() {
            return (int) belts.stream()
                .filter(belt -> belt.getDurability() == 0)
                .count();
        }
    }
}