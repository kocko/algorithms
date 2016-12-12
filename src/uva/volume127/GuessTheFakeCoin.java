package uva.volume127;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessTheFakeCoin implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            guess();
        }
    }
    
    private void guess() {
        int left = 1, right = in.ni();
        for (int i = 0; i < 5; i++) {
            int size = right - left + 1, offset = size / 3;
            if (size % 3 == 1) {
                offset = size / 3;
            } else if (size % 3 == 2) {
                offset = size / 3 + 1;
            }
            int mid = left + 2 * offset - 1;
            int response = getQuery(left, mid);
            if (response == 0) {
                left = mid + 1;
            } else if (response == 1) {
                right = left + offset - 1;
            } else if (response == -1) {
                left = mid - offset + 1;
                right = mid;
            }
            if (left == right) {
                out.println("Answer " + left);
                out.flush();
                break;
            }
        }
    }
    
    private int getQuery(int left, int right) {
        StringBuilder sb = new StringBuilder("Test");
        for (int i = left; i <= right; i++) {
            sb.append(" ");
            sb.append(i);
        }
        out.println(sb.toString());
        out.flush();
        return in.ni();
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
        try (GuessTheFakeCoin instance = new GuessTheFakeCoin()) {
            instance.solve();
        }
    }
    
}
