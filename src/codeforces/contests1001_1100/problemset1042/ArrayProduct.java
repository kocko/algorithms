package codeforces.contests1001_1100.problemset1042;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.String.format;

public class ArrayProduct implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni(), maxNegative = Integer.MIN_VALUE, maxNegativeIdx = -1;
        int[] x = new int[k];
        List<Integer> negative = new ArrayList<>(), positive = new ArrayList<>(), zeroes = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            x[i - 1] = in.ni();
            if (x[i - 1] == 0) zeroes.add(i);
            else if (x[i - 1] > 0) positive.add(i);
            else {
                negative.add(i);
                if (x[i - 1] > maxNegative) {
                    maxNegative = x[i - 1];
                    maxNegativeIdx = i;
                }
            }
        }
        int n = negative.size(), z = zeroes.size(), p = positive.size(), cnt = 0;
        //positive
        for (int i = 0; i < p - 1; i++, cnt++) {
            out.println(format("1 %d %d", positive.get(i), positive.get(i + 1)));
        }
        //zeroes
        for (int i = 0; i < z - 1; i++, cnt++) {
            out.println(format("1 %d %d", zeroes.get(i), zeroes.get(i + 1)));
        }
        //negative
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++, cnt++) {
                out.println(format("1 %d %d", negative.get(i), negative.get(i + 1)));
            }
            if (p > 0 && n > 0) {
                cnt++;
                out.println(format("1 %d %d", positive.get(p - 1), negative.get(n - 1)));
            }
            if (z > 0 && cnt < k - 1) {
                out.println(format("2 %d", zeroes.get(z - 1)));
            }
        } else {
            Iterator<Integer> iterator = negative.iterator();
            if (z > 0) {
                out.println(format("1 %d %d", maxNegativeIdx, zeroes.get(z - 1)));
                cnt++;
                while (iterator.hasNext()) {
                    int next = iterator.next();
                    if (next == maxNegativeIdx) {
                        iterator.remove();
                        break;
                    }
                }
                n = negative.size();
                for (int i = 0; i < n - 1; i++, cnt++) {
                    out.println(format("1 %d %d", negative.get(i), negative.get(i + 1)));
                }
                if (cnt < k - 1) {
                    out.println(format("2 %d", zeroes.get(z - 1)));
                    cnt++;
                }
                if (cnt < k - 1) {
                    out.println(format("1 %d %d", negative.get(n - 1), positive.get(p - 1)));
                }
            } else {
                while (iterator.hasNext()) {
                    int next = iterator.next();
                    if (x[next - 1] == maxNegative) {
                        out.println(format("2 %d", next));
                        cnt++;
                        iterator.remove();
                        break;
                    }
                }
                n = negative.size();
                for (int i = 0; i < n - 1; i++, cnt++) {
                    out.println(format("1 %d %d", negative.get(i), negative.get(i + 1)));
                }
                if (cnt < k - 1) {
                    out.println(format("1 %d %d", negative.get(n - 1), positive.get(p - 1)));
                }
            }
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
        try (ArrayProduct instance = new ArrayProduct()) {
            instance.solve();
        }
    }
}
