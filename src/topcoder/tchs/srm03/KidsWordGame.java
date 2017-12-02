package topcoder.tchs.srm03;

import java.util.ArrayList;
import java.util.List;

public class KidsWordGame {

    public int getCheater(String[] first, String[] second, String[] third) {
        List<String> log = new ArrayList<>();
        String[][] temp = new String[][]{first, second, third};
        int row = 0, col = 0;
        while (true) {
            if (col < temp[row].length) {
                log.add(temp[row][col]);
                row++;
            } else break;
            if (row == 3) {
                row = 0;
                col++;
            }
        }
        int result = -1;
        for (int i = 1; i < log.size(); i++) {
            String current = log.get(i), previous = log.get(i - 1);
            if (current.length() != previous.length() + 1) {
                result = i - 1;
                break;
            }
            if (!previous.equals(current.substring(0, current.length() - 1)) && !previous.equals(current.substring(1))) {
                result = i - 1;
                break;
            }
        }
        if (result == -1) return -1;
        result %= 3;
        return result + 1;
    }
    
}
