package hackerrank.contests.weekofcode22;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MakingPolygons implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> x = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            x.add(next);
            sum += next;
        }
        if (n == 1) {
            out.println(2);
        } else if (n == 2) {
            if (x.get(0).equals(x.get(1))) {
                out.println(2);
            } else {
                out.println(1);
            }
        } else {
            int cuts = 0;
            while (true) {
                Collections.sort(x);
                int last = x.get(x.size() - 1);
                if (sum - last > last) {
                    break;
                }
                x.remove(x.size() - 1);
                x.add(last / 2);
                if (last % 2 == 1) {
                    x.add((last / 2) + 1);
                } else {
                    x.add(last / 2);    
                }
                cuts++;
            }
            out.println(cuts);
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
        try (MakingPolygons instance = new MakingPolygons()) {
            instance.solve();
        }
    }
}
