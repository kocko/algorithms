package topcoder.tchs.srm30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HowManyBirthdays {

    public String[] getList(String[] friends, String today) {
        List<String> result = new ArrayList<>();
        Scanner sc = new Scanner(today);
        int day = sc.nextInt(), month = sc.nextInt();
        sc.close();
        for (String f : friends) {
            sc = new Scanner(f);
            String name = sc.next();
            int d = sc.nextInt(), m = sc.nextInt();
            if (d == day && m == month) result.add(name);
            sc.close();
        }
        Collections.sort(result);
        String[] ans = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

}
