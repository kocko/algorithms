package codeforces.contests201_300.problemset234;

import java.io.*;
import java.util.*;

public class Reading implements Closeable {
    private InputReader in;
    private PrintWriter out;

    private Reading() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }

    public void solve() {
        int n = in.ni(), k = in.ni();
        class Hour {
            int idx, power;

            Hour(int idx, int power) {
                this.idx = idx;
                this.power = -power;
            }
        }
        List<Hour> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(new Hour(i, in.ni()));
        Collections.sort(list, Comparator.comparingInt(a -> a.power));
        out.println(-list.get(k - 1).power);
        for (int i = 0; i < k; i++) {
            out.print(list.get(i).idx);
            out.print(' ');
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
        try (Reading instance = new Reading()) {
            instance.solve();
        }
    }
}
