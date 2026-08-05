import java.util.*;

public class WaterJugProblem {
    // State representation using an inner class
    static class State {
        int jug1; // 5L Jug
        int jug2; // 2L Jug
        List<String> path;

        public State(int jug1, int jug2, List<String> path) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.path = new ArrayList<>(path);
        }
    }

    public static void solve(int cap1, int cap2, int target) {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        List<String> initialPath = new ArrayList<>();
        initialPath.add("(0, 0)");
        queue.add(new State(0, 0, initialPath));
        visited.add("0,0");

        boolean found = false;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int j1 = current.jug1;
            int j2 = current.jug2;

            
            if (j1 == target) {
                System.out.println("Goal Achieved! Sequence of states:");
                for (String p : current.path) {
                    System.out.println(p);
                }
                found = true;
                break;
            }

            
            List<State> nextStates = new ArrayList<>();

            // 1. Fill Jug 1 (5L)
            nextStates.add(new State(cap1, j2, appendPath(current.path, cap1, j2)));
            // 2. Fill Jug 2 (3L)
            nextStates.add(new State(j1, cap2, appendPath(current.path, j1, cap2)));
            // 3. Empty Jug 1 (5L)
            nextStates.add(new State(0, j2, appendPath(current.path, 0, j2)));
            // 4. Empty Jug 2 (3L)
            nextStates.add(new State(j1, 0, appendPath(current.path, j1, 0)));
            // 5. Pour Jug 1 -> Jug 2
            int pour1to2 = Math.min(j1, cap2 - j2);
            nextStates.add(new State(j1 - pour1to2, j2 + pour1to2, appendPath(current.path, j1 - pour1to2, j2 + pour1to2)));
            // 6. Pour Jug 2 -> Jug 1
            int pour2to1 = Math.min(j2, cap1 - j1);
            nextStates.add(new State(j1 + pour2to1, j2 - pour2to1, appendPath(current.path, j1 + pour2to1, j2 - pour2to1)));

            // Process unvisited states
            for (State next : nextStates) {
                String stateKey = next.jug1 + "," + next.jug2;
                if (!visited.contains(stateKey)) {
                    visited.add(stateKey);
                    queue.add(next);
                }
            }
        }

        if (!found) {
            System.out.println("No solution possible for the given target.");
        }
    }

    private static List<String> appendPath(List<String> oldPath, int j1, int j2) {
        List<String> newPath = new ArrayList<>(oldPath);
        newPath.add("(" + j1 + ", " + j2 + ")");
        return newPath;
    }

    public static void main(String[] args) {
        int jug1Capacity = 5;
        int jug2Capacity = 3;
        int targetAmount = 4;
        solve(jug1Capacity, jug2Capacity, targetAmount);
    }
}