package topcoder.contests300_400.srm354;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class DateFormat {

    public String fromEuropeanToUs(String[] dateList) {
        StringJoiner result = new StringJoiner(" ");
        String last = null;
        StringBuilder join = new StringBuilder();
        for (String s : dateList) join.append(s);
        String[] list = join.toString().split(" ");
        for (String date : list) {
            String[] split = date.split("/");
            String reverse = split[1] + "/" + split[0];
            List<String> temp = new ArrayList<>();
            if (isUs(date)) temp.add(date);
            if (isUs(reverse)) temp.add(reverse);
            if (last == null) {
                Collections.sort(temp);
                result.add(temp.get(0));
                last = temp.get(0);
            } else {
                temp.add(last);
                Collections.sort(temp);
                if (temp.get(temp.size() - 1).equals(last)) return "";
                else {
                    for (int i = 0; i < temp.size() - 1; i++) {
                        if (temp.get(i + 1).compareTo(last) > 0) {
                            result.add(temp.get(i + 1));
                            last = temp.get(i + 1);
                            break;
                        }
                    }
                }
            }
        }
        return result.toString();
    }

    private boolean isUs(String date) {
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] temp = date.split("/");
        int f = Integer.parseInt(temp[0]), s = Integer.parseInt(temp[1]);
        return f >= 1 && f <= 12 && s >= 1 && s <= days[f - 1];
    }
	
}
