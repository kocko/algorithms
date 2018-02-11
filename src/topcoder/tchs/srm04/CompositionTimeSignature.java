package topcoder.tchs.srm04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositionTimeSignature {

    private Map<Character, Integer> time = new HashMap<Character, Integer>() {{
        put('S', 1);
        put('E', 2);
        put('Q', 4);
        put('H', 8);
        put('W', 16);
    }};

    private final int[] signatures = new int[]{6, 8, 12, 16};
    private final String[] k = new String[]{"3/8", "2/4", "3/4", "4/4"};

    public String getTimeSignature(String duration) {
        int total = 0;
        for (char c : duration.toCharArray()) total += time.get(c);
        List<Integer> possible = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (total % signatures[i] == 0) {
                possible.add(i);
            }
        }
        if (possible.size() == 0 || total < 6) {
            return "?/?";
        }
        int min = 100000, idx = -1;
        for (int s : possible) {
            int max = signatures[s];
            int current = 0, notes = 0;
            for (char c : duration.toCharArray()) {
                int step = time.get(c);
                if (current + step > max) {
                    notes++;
                }
                current += step;
                current %= max;
            }
            if (notes < min) {
                min = notes;
                idx = s;
            }
        }
        return k[idx];
    }

}
