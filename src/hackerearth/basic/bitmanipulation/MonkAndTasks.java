package hackerearth.basic.bitmanipulation;

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

public class MonkAndTasks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.ni());
            }
            Collections.sort(list, (a, b) -> Integer.compare(popCount(a), popCount(b)));
            for (Integer i : list) {
                out.print(i + " ");
            }
            out.println();
        }
    }
    
    private int popCount(int a) {
        int result = 0;
        while (a > 0) {
            a &= (a - 1);
            result++;
        }
        return result;
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
        try (MonkAndTasks instance = new MonkAndTasks()) {
            instance.solve();
        }
    }
}
