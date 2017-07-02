package topcoder.contests401_500.srm446;

public class CubeWalking {
    
    public static String finalPosition(String movement) {
        String result = "";
        int x = 1, y = 1;
        int[] dir = {0, -1};
        for (char c : movement.toCharArray()) {
            if (c == 'L') {
                if (dir[0] == 0 && dir[1] == -1) {
                    dir = new int[]{-1, 0};
                } else if (dir[0] == 0 && dir[1] == 1) {
                    dir = new int[]{1, 0};
                } else if (dir[0] == -1 && dir[1] == 0) {
                    dir = new int[]{0, 1};
                } else {
                    dir = new int[]{0, -1};
                }
            }
            if (c == 'R') {
                if (dir[0] == 0 && dir[1] == -1) {
                    dir = new int[]{1, 0};
                } else if (dir[0] == 0 && dir[1] == 1) {
                    dir = new int[]{-1, 0};
                } else if (dir[0] == -1 && dir[1] == 0) {
                    dir = new int[]{0, -1};
                } else {
                    dir = new int[]{0, 1};
                }
            }
            if (c == 'W') {
                x += dir[0];
                y += dir[1];
                if (x > 2) {
                    x %= 3;
                }
                if (y > 2) {
                    y %= 3;
                }
                if (x < 0) {
                    x = 3 + x;
                }
                if (y < 0) {
                    y = 3 + y;
                }
            }
        }
        String[] list = {"RED", "BLUE", "RED", "BLUE", "GREEN", "BLUE", "RED", "BLUE", "RED"};
        result = list[3 * x + y];
        return result;
    }
    
}