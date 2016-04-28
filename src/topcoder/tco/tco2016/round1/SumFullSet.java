package topcoder.tco.tco2016.round1;

import java.util.HashSet;
import java.util.Set;

public class SumFullSet {

    public String isSumFullSet(int[] elements) {
        if (elements.length <= 1) return "closed";
        Set<Integer> hash = new HashSet<Integer>();
        for (int i : elements) {
            hash.add(i);
        }
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hash.contains(elements[i] + elements[j])) {
                    return "not closed";
                }
            }
        }
        return "closed";
    }

    public static void main(String[] args) {
        SumFullSet temp = new SumFullSet();
        System.out.println(temp.isSumFullSet(int[] elements));
    }

}
