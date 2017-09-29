package codeforces.contests301_400.problemset342;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class XeniaAndDivisors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        List<Integer> first = new ArrayList<>(), second = new ArrayList<>(), third = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] == 5 || x[i] == 7) {
                out.println(-1);
                return;
            }
            if (x[i] == 1) {
                first.add(x[i]);
            } else if (x[i] == 2 || x[i] == 3) {
                second.add(x[i]);
            } else {
                third.add(x[i]);
            }
        }
        Collections.sort(first);
        Collections.sort(second);
        Collections.sort(third);
        if (first.size() == second.size() && second.size() == third.size()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < first.size(); i++) {
                if (second.get(i) % first.get(i) == 0 && third.get(i) % second.get(i) == 0) {
                    result.append(first.get(i)).append(" ").append(second.get(i)).append(" ").append(third.get(i)).append("\n");
                } else {
                    out.println(-1);
                    return;
                }
            }
            out.print(result);
        } else {
            out.println(-1);
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
        try (XeniaAndDivisors instance = new XeniaAndDivisors()) {
            instance.solve();
        }
    }
}
