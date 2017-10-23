package codeforces.contests801_900.problemset877;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlexAndBrokenContest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] names = {"Danil", "Olya", "Slava", "Ann", "Nikita"};
        String x = in.next();
        int count = 0;
        for (String name : names) {
            for (int i = 0; i <= x.length() - name.length(); i++) {
                boolean ok = true;
                for (int j = 0; j < name.length(); j++) {
                    ok &= (name.charAt(j) == x.charAt(i + j));
                }
                if (ok) count++;
            }
        }
        out.println(count == 1 ? "YES" : "NO");
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
        try (AlexAndBrokenContest instance = new AlexAndBrokenContest()) {
            instance.solve();
        }
    }
}
