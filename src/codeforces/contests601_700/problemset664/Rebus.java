package codeforces.contests601_700.problemset664;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Rebus implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] line = in.nextLine().split("\\s+");
        int size = line.length;
        int n = Integer.parseInt(line[size - 1]);
        int unknown = (size - 2) / 2 + 1;
        int[] values = new int[unknown];
        int[] signs = new int[unknown];
        signs[0] = 1;
        int idx = 1;
        int minLeft = 1, maxLeft = n, minRight = n, maxRight = n;
        for (int i = 1; i < size - 2; i += 2) {
            signs[idx] = "+".equals(line[i]) ? 1 : -1;
            if (signs[idx] == 1) {
                minLeft++;
                maxLeft += n;
            } else {
                minRight++;
                maxRight += n;
            }
            idx++;
        }
        if (maxLeft < minRight || maxRight < minLeft) {
            out.println("Impossible");
            return;
        }
        int[] temp = {minLeft, maxLeft, minRight, maxRight};
        Arrays.sort(temp);
        out.println("Possible");
        for (int i = temp[1]; i <= temp[2]; i++) {
            fillValues(i, values, signs, (v) -> v > 0);
            fillValues(i - n, values, signs, (v) -> v < 0);
            if (ok(values, n)) {
                for (int j = 0; j < values.length; j++) {
                    if (j > 0) {
                        out.print(signs[j] == 1 ? '+' : '-');
                        out.print(' ');
                    }
                    out.print(values[j]);
                    out.print(' ');
                }
                out.print("= ");
                out.println(n);
                return;
            }
        }
    }
    
    private void fillValues(int sum, int[] values, int[] signs, Predicate<Integer> predicate) {
        int cnt = 0;
        for (int i = 0; i < values.length; i++) {
            if (predicate.test(signs[i])) {
                cnt++;
            }
        }
        if (cnt > 0) {
            int init = sum / cnt, rem = sum % cnt;
            for (int i = 0; i < values.length; i++) {
                if (predicate.test(signs[i])) {
                    values[i] = init;
                    if (rem > 0) {
                        values[i]++;
                        rem--;
                    }
                }
            }
        }
    }
    
    private boolean ok(int[] values, int n) {
        for (int value : values) {
            if (value > n) return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }
    
    public static void main(String[] args) throws IOException {
        try (Rebus instance = new Rebus()) {
            instance.solve();
        }
    }
}
