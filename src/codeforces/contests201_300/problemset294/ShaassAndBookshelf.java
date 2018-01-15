package codeforces.contests201_300.problemset294;

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

public class ShaassAndBookshelf implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.ni(), w = in.ni();
            if (t == 1) {
                one.add(w);
            } else {
                two.add(w);
            }
        }
        one.sort(Comparator.reverseOrder());
        two.sort(Comparator.reverseOrder());
        int result = 100000;
        int[] w1 = new int[one.size()];
        if (one.size() > 0) {
            w1[0] = one.get(0);
            for (int i = 1; i < one.size(); i++) {
                w1[i] = w1[i - 1] + one.get(i);
            }
        }
        int[] w2 = new int[two.size()];
        if (two.size() > 0) {
            w2[0] = two.get(0);
            for (int i = 1; i < two.size(); i++) {
                w2[i] = w2[i - 1] + two.get(i);
            }
        }
        int a = 0, b = 0;
        for (int o = 0; o <= one.size(); o++) {
            if (o > 0) a++;
            for (int t = 0; t <= two.size(); t++) {
                if (t > 0) {
                    b = 2 * t;
                }
                int thickness = 0;
                if (one.size() >= 1) {
                    thickness += w1[one.size() - 1];
                }
                if (two.size() >= 1) {
                    thickness += w2[two.size() - 1];
                }
                if (o > 0) thickness -= w1[o - 1];
                if (t > 0) thickness -= w2[t - 1];
                if (thickness <= a + b) {
                    result = Math.min(a + b, result);
                }
            }
            b = 0;
        }
        out.println(result);
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
        try (ShaassAndBookshelf instance = new ShaassAndBookshelf()) {
            instance.solve();
        }
    }
}
