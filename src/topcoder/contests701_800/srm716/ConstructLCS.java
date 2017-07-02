package topcoder.contests701_800.srm716;

import java.util.Arrays;

public class ConstructLCS {
    
    public String construct(int ab, int bc, int ca) {
        int[] values = {ab, bc, ca};
        Arrays.sort(values);
        StringBuilder[] result = new StringBuilder[3];
        for (int i = 0; i < 3; i++) result[i] = new StringBuilder();
        StringBuilder left, mid, right;
        int rightIdx;
        if (values[1] == ab) {
            if (ca == values[2]) {
                left = result[2]; 
                mid = result[1];
                rightIdx = 0;
            } else {
                left = result[2];
                mid = result[0];
                rightIdx = 1;
            }
        } else if (values[1] == ca) {
            if (bc == values[2]) {
                left = result[1];
                mid = result[0];
                rightIdx = 2;
            } else {
                left = result[1];
                mid = result[2];
                rightIdx = 0;
            }
        } else {
            if (ca == values[2]) {
                left = result[0];
                mid = result[1];
                rightIdx = 2;
            } else {
                left = result[0];
                mid = result[2];
                rightIdx = 1;
            }
        }
        right = result[rightIdx];
        for (int i = 0; i < values[2]; i++) {
            left.append('1');
            right.append('1');
        }
        for (int i = 0; i < 50; i++) {
            mid.append('0');
        }
        for (int i = 0; i < values[0]; i++) {
            left.append('0');
        }
        for (int i = 0; i < values[1]; i++) {
            right.append('0');
        }
        result[rightIdx] = right.reverse();
        return result[0] + " " + result[1] + " " + result[2];
    }

}