package uva.volume117;

import java.io.*;
import java.util.StringTokenizer;

public class CreditCheck implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                String next = in.next();
                int value = 2 * (next.charAt(0) - '0');
                a.append(value);
                b.append(next.charAt(1));
                value = 2 * (next.charAt(2) - '0');
                a.append(value);
                b.append(next.charAt(3));
            }
            int total = 0;
            for (char c : a.toString().toCharArray()) {
                total += (c - '0');
            }
            for (char c : b.toString().toCharArray()) {
                total += (c - '0');
            }

            out.println(total % 10 == 0 ? "Valid" : "Invalid");
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
        try (CreditCheck instance = new CreditCheck()) {
            instance.solve();
        }
    }

}
