package topcoder.contests201_300.srm227;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientsList {

    class Name implements Comparable<Name> {
        String first;
        String last;

        @Override
        public int compareTo(Name o) {
            int cmp = last.compareTo(o.last);
            if (cmp == 0) {
                return first.compareTo(o.first);
            }
            return cmp;
        }

        @Override
        public String toString() {
            return first + " " + last;
        }
    }

    public String[] dataCleanup(String[] names) {
        List<Name> list = new ArrayList<Name>();
        for (int i = 0; i < names.length; i++) {
            Name name = new Name();
            if (names[i].contains(",")) {
                String[] split = names[i].split(", ");
                name.first = split[1];
                name.last = split[0];
            } else {
                String[] split = names[i].split(" ");
                name.first = split[0];
                name.last = split[1];
            }
            list.add(name);
        }
        Collections.sort(list);
        String[] result = new String[names.length];
        int next = 0;
        for (Name n : list) {
            result[next++] = n.toString();
        }
        return result;
    }
    
}
