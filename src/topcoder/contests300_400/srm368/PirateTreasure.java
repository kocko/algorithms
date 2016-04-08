package topcoder.contests300_400.srm368;

import java.util.HashMap;
import java.util.Map;

public class PirateTreasure {

    private Map<String, Integer> DIRECTIONS = new HashMap<String, Integer>() {{
        put("NORTH", 1);
        put("SOUTH", 2);
        put("EAST", 3);
        put("WEST", 4);
        put("NORTHEAST", 5);
        put("SOUTHEAST", 6);
        put("NORTHWEST", 7);
        put("SOUTHWEST", 8);
    }};

    public double getDistance(int[] steps, String[] directions) {
        int n = steps.length;
        int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        double x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            int a = dx[DIRECTIONS.get(directions[i]) - 1];
            int b = dy[DIRECTIONS.get(directions[i]) - 1];
            if (a != 0 && b != 0) {
                x += (a * steps[i] * Math.sqrt(2) / 2);
                y += (b * steps[i] * Math.sqrt(2) / 2);
            } else {
                x += a * steps[i];
                y += b * steps[i];
            }
        }
        return Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        System.out.println(new PirateTreasure().getDistance(new int[]{2}, new String[]{"NORTHWEST"}));
    }

}
