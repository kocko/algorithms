package codeforces.contests401_500.problemset441;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ValeraAndTubes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int m, x = 1, y = 1, step = 1;

    public void solve() {
        int n = in.ni();
        m = in.ni();
        int k = in.ni();
        List<List<int[]>> result = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            int[] a = {x, y};
            step();
            int[] b = new int[]{x, y};
            result.add(Arrays.asList(a, b));
            step();
        }
        List<int[]> last = new ArrayList<>();
        while (last.size() < n * m - 2 * (k - 1)) {
            last.add(new int[]{x, y});
            step();
        }
        result.add(last);
        for (List<int[]> tube : result) {
            out.print(tube.size());
            out.print(' ');
            for (int[] cell : tube) {
                out.print(cell[0]);
                out.print(' ');
                out.print(cell[1]);
                out.print(' ');
            }
            out.println();
        }
    }

    private void step() {
        y += step;
        if (y > m) {
            x++;
            y = m;
            step = -1;
        } else if (y < 1) {
            x++;
            y = 1;
            step = 1;
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
        try (ValeraAndTubes instance = new ValeraAndTubes()) {
            instance.solve();
        }
    }
}
