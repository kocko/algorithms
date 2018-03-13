package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;

public class AssistanceRequired implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        init();
        int n;
        while ((n = in.ni()) != 0) {
            out.println(lucky.get(n - 1));
        }
    }

    private List<Integer> lucky = new ArrayList<>();

    private void init() {
        int n = 35000;
        boolean[] free = new boolean[n + 1];
        fill(free, true);
        for (int i = 2; i <= n; i++) {
            if (free[i]) {
                lucky.add(i);
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (free[j]) {
                        count++;
                        if (count % i == 0) {
                            free[j] = false;
                        }
                    }
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
        try (AssistanceRequired instance = new AssistanceRequired()) {
            instance.solve();
        }
    }
}
