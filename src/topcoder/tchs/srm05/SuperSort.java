package topcoder.tchs.srm05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperSort {

    public String wordSort(String sentence) {
        List<String> order = new ArrayList<>(), words = new ArrayList<>(), others = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                current.append(c);
            } else {
                String s = current.toString();
                if (s.length() > 0) {
                    order.add("w");
                    words.add(s);
                }
                order.add("o");
                others.add(String.valueOf(c));
                current = new StringBuilder();
            }
        }
        String s = current.toString();
        if (s.length() > 0) {
            order.add("w");
            words.add(s);
        }
        Collections.sort(words);
        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        for (String o : order) {
            if ("w".equals(o)) {
                result.append(words.get(i++));
            } else {
                result.append(others.get(j++));
            }
        }
        return result.toString();
    }

}
