package codeforces.contests401_500.problemset437;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TheChildAndHomework implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        int[] size = new int[4];
        int ans = 3;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            String line = in.readLine().substring(2);
            size[i] = line.length();
        }
        for (int i = 0; i < 4; i++) {
            boolean big = true;
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    big &= (size[i] > size[j] && size[i] >= 2 * size[j]);
                }
            }
            boolean small = true;
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    small &= (size[i] < size[j] && 2 * size[i] <= size[j]);
                }
            }
            if (big || small) {
                count++;
                ans = i;
            }
        }
        if (count == 1) {
            out.println((char) ('A' + ans));
        } else {
            out.println('C');
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TheChildAndHomework instance = new TheChildAndHomework()) {
            instance.solve();
        }
    }
}
