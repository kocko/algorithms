package codeforces.gyms.gym101104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DigitalFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            String a = in.next(), b = in.next();
            boolean friends = friends(a, b);
            if (!friends) {
                boolean almost = almost(a, b);
                out.println(almost ? "almost friends" : "nothing");
            } else {
                out.println("friends");
            }
        }
    }
    
    private boolean friends(String a, String b) {
        boolean[] x = new boolean[10], y = new boolean[10];
        for (char c : a.toCharArray()) {
            x[c - '0'] = true;
        }
        for (char c : b.toCharArray()) {
            y[c - '0'] = true;
        }
        boolean result = true;
        for (int i = 0; i < 10; i++) {
            result &= x[i] == y[i];
        }
        return result;
    }
    
    private boolean almost(String a, String b) {
        char[] x = a.toCharArray(), y = b.toCharArray();
        for (int i = 0; i < x.length - 1; i++) {
            if (i == 0 && x[i] == '1') {
                continue;
            }
            if (x[i] >= '1' && x[i + 1] <= '8') {
                x[i]--;
                x[i + 1]++;
                if (friends(new String(x), b)) {
                    return true;
                }
                x[i]++;
                x[i + 1]--;
            }
        }
        for (int i = 0; i < y.length - 1; i++) {
            if (i == 0 && y[i] == '1') {
                continue;
            }
            if (y[i] >= '1' && y[i + 1] <= '8') {
                y[i]--;
                y[i + 1]++;
                if (friends(new String(y), a)) {
                    return true;
                }
                y[i]++;
                y[i + 1]--;
            }
        }

        for (int i = 0; i < x.length - 1; i++) {
            if (i == 0 && x[i] == '9') {
                continue;
            }
            if (x[i] <= '8' && x[i + 1] >= '1') {
                x[i]++;
                x[i + 1]--;
                if (friends(new String(x), b)) {
                    return true;
                }
                x[i]--;
                x[i + 1]++;
            }
        }
        for (int i = 0; i < y.length - 1; i++) {
            if (i == 0 && y[i] == '9') {
                continue;
            }
            if (y[i] <= '8' && y[i + 1] >= '1') {
                y[i]++;
                y[i + 1]--;
                if (friends(new String(y), a)) {
                    return true;
                }
                y[i]--;
                y[i + 1]++;
            }
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
        try (DigitalFriends instance = new DigitalFriends()) {
            instance.solve();
        }
    }
}
