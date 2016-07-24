package topcoder.contests201_300.srm208;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TallPeople {
	
	public int[] getPeople(String[] people) {
        int maxRes = 0;
        int[] col = new int[1001];
        Arrays.fill(col, -1);
        for (String s : people) {
            Scanner sc = new Scanner(s);
            int min = 1001;
            int i = 0;
            while (sc.hasNextInt()) {
                int next = sc.nextInt();
                col[i] = max(col[i], next);
                i++;
                min = min(next, min);
            }
            maxRes = max(maxRes, min);
            sc.close();
        }
        int minRes = col[0];
        for (int i = 1; i < 1001; i++) {
            if (col[i] == -1) break;
            else {
                minRes = Math.min(minRes, col[i]);
            }
        }
        
        return new int[] {maxRes, minRes};
	}
}
