package codeforces.contests901_1000.problemset967;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.*;

public class StairsAndElevators implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), cl = in.ni(), ce = in.ni(), v = in.ni();
        TreeSet<Integer> stairs = new TreeSet<>();
        for (int i = 0; i < cl; i++) {
            stairs.add(in.ni());
        }
        TreeSet<Integer> elevators = new TreeSet<>();
        for (int i = 0; i < ce; i++) {
            elevators.add(in.ni());
        }
        int q = in.ni();
        while (q-- > 0) {
            int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
            if (x1 == x2) {
                out.println(abs(y1 - y2));
                continue;
            }
            int e = Integer.MAX_VALUE;
            int floors = abs(x1 - x2), jump = floors / v + (floors % v != 0 ? 1 : 0);
            Integer leftElevator = elevators.lower(y1), rightElevator = elevators.higher(y1);
            if (leftElevator != null) {
                int e1 = 0;
                e1 += y1 - leftElevator;
                e1 += jump;
                e1 += abs(leftElevator - y2);
                e = min(e, e1);
            }
            if (rightElevator != null) {
                int e2 = 0;
                e2 += rightElevator - y1;
                e2 += jump;
                e2 += abs(rightElevator - y2);
                e = min(e, e2);
            }
            int s = Integer.MAX_VALUE;
            jump = floors;
            Integer leftStairs = stairs.lower(y1), rightStairs = stairs.higher(y1);
            if (leftStairs != null) {
                int s1 = 0;
                s1 += y1 - leftStairs;
                s1 += jump;
                s1 += abs(leftStairs - y2);
                s = min(s, s1);
            }
            if (rightStairs != null) {
                int s2 = 0;
                s2 += rightStairs - y1;
                s2 += jump;
                s2 += abs(rightStairs - y2);
                s = min(s, s2);
            }
            out.println(min(s, e));
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (StairsAndElevators instance = new StairsAndElevators()) {
            instance.solve();
        }
    }
}
