package hackerrank.contests.weekofcode35;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyPurchase implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int best = (int) 1e9 + 5;
        String name = null;
        while (n-- > 0) {
            String next = in.next();
            int price = in.ni();
            if (isLucky(price) && price < best) {
                best = price;
                name = next;
            }
        }
        out.println(name != null ? name : -1);
    }
    
    private boolean isLucky(int n) {
        String value = String.valueOf(n);
        int fours = 0, sevens = 0;
        for (char c : value.toCharArray()) {
            if (c == '4') fours++;
            else if (c == '7') sevens++;
            else return false;
        }
        return fours == sevens;
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
        try (LuckyPurchase instance = new LuckyPurchase()) {
            instance.solve();
        }
    }
}
