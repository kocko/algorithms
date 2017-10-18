package codeforces.contests301_400.problemset381;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SerejaAndStairs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(in.ni());
        list.sort(Comparator.naturalOrder());
        List<Integer> increasing = new ArrayList<>(), decreasing = new ArrayList<>();
        boolean[] used = new boolean[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            int next = list.get(i);
            if (next > last && !used[i]) {
                last = next;
                increasing.add(next);
                used[i] = true;
            }
        }
        last = 5001;
        for (int i = n - 1; i >= 0; i--) {
            int next = list.get(i);
            if (next < last && !used[i]) {
                last = next;
                decreasing.add(next);
                used[i] = true;
            }
        }
        if (decreasing.size() == 0) {
            out.println(increasing.size());
            for (int i = increasing.size() - 1; i >= 0; i--) {
                out.print(increasing.get(i));   
                out.print(' ');   
            }
        } else {
            List<Integer> result = new ArrayList<>();
            last = 0;
            for (int inc : increasing) {
                if (inc > last) {
                    result.add(inc);
                    last = inc;
                }
            }
            for (int dec : decreasing) {
                if (dec < last) {
                    result.add(dec);
                    last = dec;
                }
            }
            out.println(result.size());
            for (int value : result) {
                out.print(value);
                out.print(' ');
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
        try (SerejaAndStairs instance = new SerejaAndStairs()) {
            instance.solve();
        }
    }
}
