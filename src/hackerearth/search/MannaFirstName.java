package hackerearth.search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MannaFirstName implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        while (n-- > 0) {
            char[] next = in.next().toCharArray();
            int a = 0, b = 0;
            int currentSize = 0;
            for (int i = 0; i < next.length; i++) {
                char c = next[i];
                if (matches(c, currentSize)) {
                    currentSize++;
                    if (currentSize == 7) {
                        b++;
                        currentSize = 0;
                    }
                } else {
                    if (currentSize >= 4) {
                        a++;
                        currentSize = 0;
                    }
                    if (matches(c, currentSize)) {
                        currentSize++;
                    }
                }
            }
            if (currentSize >= 4) {
                a++;
            }
            out.println("SUVO = " + a + ", SUVOJIT = " + b);
        }
    }
    
    private boolean matches(char c, int currentSize) {
        switch(currentSize) {
            case 0: return c == 'S';
            case 1: return c == 'U';
            case 2: return c == 'V';
            case 3: return c == 'O';
            case 4: return c == 'J';
            case 5: return c == 'I';
            case 6: return c == 'T';
        }
        return false;
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
        try (MannaFirstName instance = new MannaFirstName()) {
            instance.solve();
        }
    }
}
