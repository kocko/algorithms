package uva.volume118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Alaska implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            Set<Integer> set = new TreeSet<>();
            set.add(0);
            for (int i = 0; i < n; i++) {
                set.add(in.ni());
            }
            List<Integer> diff = new ArrayList<>();
            Iterator<Integer> iterator = set.iterator();
            int previous = 0;
            while (iterator.hasNext()) {
                int current = iterator.next();
                diff.add(current - previous);
                previous = current;
            }
            diff.add(1422 - previous);
            boolean ok = true;
            for (int i = 1; i < diff.size(); i++) {
                ok &= diff.get(i) <= 200;
            }
            ok &= diff.get(diff.size() - 1) <= 100; 
            out.println(ok ? "POSSIBLE" : "IMPOSSIBLE");
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
        try (Alaska instance = new Alaska()) {
            instance.solve();
        }
    }
}
