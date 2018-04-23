package topcoder.tco.tco2018.round1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.String.valueOf;
import static java.lang.Math.abs;

public class Deadfish {

    public int shortestCode(int n) {
        final int MAX = (int) 2e6;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] min = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            min[i] = -1;
        }
        min[getIndex(0)] = 0;
        queue.addLast(0);
        int stop = getIndex(n);
        while (!queue.isEmpty()) {
            int top = queue.pollFirst(), idx;
            int prev = min[getIndex(top)];
            
            if (top == stop) break;
            
            int add = top + 1;
            idx = getIndex(add);
            if (idx < MAX && min[idx] == -1) {
                min[idx] = prev + 1;
                queue.add(add);
            }
            int decrement = top - 1;
            idx = getIndex(decrement);
            if (idx >= 0 && idx < MAX && min[idx] == -1) {
                min[idx] = prev + 1;
                queue.add(decrement);
            }
            if (abs(top) <= 448) {
                int square = top * top;
                idx = getIndex(square);
                if (idx < MAX && min[idx] == -1) {
                    min[idx] = prev + 1;
                    queue.add(square);  
                }
            }
            int sort = sort(top);
            idx = getIndex(sort);
            
            if (idx >= 0 && idx < MAX && min[idx] == -1) {
                min[idx] = prev + 1;
                queue.add(sort);
            }
        }
        int idx = getIndex(n);
        return min[idx];
    }
    
    private int getIndex(int value) {
        return value + 99991;
    }
    
    private int sort(int value) {
        int sign = value < 0 ? -1 : 1;
        return sign * Integer.valueOf(sort(valueOf(abs(value))));
    }
    
    private String sort(String value) {
        Character[] digits = new Character[value.length()];
        int idx = 0;
        for (char c : value.toCharArray()) {
            digits[idx++] = c;
        }
        Arrays.sort(digits, Comparator.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (Character c : digits) result.append(c);
        return result.toString();
    }
    
}
