package uva.volume111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class HoaxOrWhat implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            TreeSet<Integer> set = new TreeSet<>();
            int[] count = new int[1000001];
            long result = 0;
            for (int i = 0; i < n; i++) {
                int k = in.ni();
                for (int j = 0; j < k; j++) {
                    int next = in.ni();
                    count[next]++;
                    set.add(next);
                }
                int max = set.last(), min = set.first();
                count[max]--;
                count[min]--;
                if (count[max] == 0) {
                    set.remove(max);
                }
                if (count[min] == 0) {
                    set.remove(min);
                }
                result += ((long) max - min);
            }
            out.println(result);
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
        try (HoaxOrWhat instance = new HoaxOrWhat()) {
            instance.solve();
        }
    }
}
