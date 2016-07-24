package topcoder.contests201_300.srm209;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MedalTable {
	
    class Country implements Comparable<Country> {
        String name;
        int gold;
        int silver;
        int bronze;
        
        Country(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Country o) {
            int res = Integer.compare(o.gold, this.gold);
            if (res == 0) {
                res = Integer.compare(o.silver, this.silver);
            }
            if (res == 0) {
                res = Integer.compare(o.bronze, this.bronze);
            }
            if (res == 0) {
                res = this.name.compareTo(o.name);
            }
            return res;
        }

        @Override
        public String toString() {
            return name + " " + gold + " " + silver + " " + bronze;
        }
    }
	public String[] generate(String[] results) {
        Map<String, Country> map = new HashMap<String, Country>();
        for (String res : results) {
            Scanner sc = new Scanner(res);
            String name = sc.next();
            Country c = map.get(name);
            if (c != null) {
                c.gold++;
            } else {
                c = new Country(name);
                c.gold = 1;
                map.put(name, c);
            }
            name = sc.next();
            c = map.get(name);
            if (c != null) {
                c.silver++;
            } else {
                c = new Country(name);
                c.silver = 1;
                map.put(name, c);
            }
            name = sc.next();
            c = map.get(name);
            if (c != null) {
                c.bronze++;
            } else {
                c = new Country(name);
                c.bronze = 1;
                map.put(name, c);
            }
        }
        Country[] result = new Country[map.size()];
        int i = 0;
        for (Map.Entry<String, Country> e : map.entrySet()) {
            result[i++] = e.getValue();
        }
        Arrays.sort(result);
        i = 0;
        String[] ret = new String[result.length];
        for (Country c : result) {
            ret[i++] = c.toString();
        }
		return ret;
	}
}
