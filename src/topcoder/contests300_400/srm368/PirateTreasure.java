package topcoder.contests300_400.srm368;

import java.util.HashMap;
import java.util.Map;

public class PirateTreasure {

    private Map<String, Integer> DIRECTIONS = new HashMap<String, Integer>() {{
        put("NORTH", 0);
        put("NORTHEAST", 1);
        put("EAST", 2);
        put("SOUTHEAST", 3);
        put("SOUTH", 4);
        put("SOUTHWEST", 5);
        put("WEST", 6);
        put("NORTHWEST", 7);
    }};

    public double getDistance(int[] steps, String[] directions) {
        int n = steps.length;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        double x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            int d = DIRECTIONS.get(directions[i]);
            if (dx[d] == 0) {
                y += dy[d] * steps[i];
            } else if (dy[d] == 0) {
                x += dx[d] * steps[i];
            } else {
                x += dx[d] / Math.sqrt(2) * steps[i];
                y += dy[d] / Math.sqrt(2) * steps[i];
            }
        }
        return Math.sqrt(x * x + y * y);
    }

}
