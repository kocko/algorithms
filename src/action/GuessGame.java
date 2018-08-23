package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GuessGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] guesses = new int[n][2];
        for (int i = 0; i < n; i++) {
            guesses[i][0] = in.ni();
            guesses[i][1] = in.ni();
        }
        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int possible : new int[]{guesses[i][0] - guesses[i][1], guesses[i][0] + guesses[i][1]}) {
                if (possible >= 1 && possible <= (int) 1e9) {
                    boolean ok = true;
                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            ok &= (possible == guesses[j][0] - guesses[j][1] || possible == guesses[j][0] + guesses[j][1]);
                        }
                    }
                    if (ok) result.add(possible);
                }
            }
        }
        if (result.size() == 0) out.println(-2);
        else if (result.size() > 1) out.println(-1);
        else out.println(result.iterator().next());
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
        try (GuessGame instance = new GuessGame()) {
            instance.solve();
        }
    }
}
