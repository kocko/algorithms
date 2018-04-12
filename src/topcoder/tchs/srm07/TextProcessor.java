package topcoder.tchs.srm07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {

    public String collectLetters(String text) {
        List<Character> list = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                list.add(Character.toLowerCase(c));
            }
        }
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

}
