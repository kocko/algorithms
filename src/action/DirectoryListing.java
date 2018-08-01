package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DirectoryListing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.next();
        }
        while (true) {
            if ((".".equals(data[n - 2]) && "..".equals(data[n - 1])) || ((".".equals(data[n - 1]) && "..".equals(data[n - 2])))) break;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (".".equals(data[i]) || "..".equals(data[i])) {
                    idx = i;
                    break;
                }
            }
            String temp = data[n - 1];
            data[n - 1] = data[idx];
            data[idx] = temp;

            if ((".".equals(data[n - 2]) && "..".equals(data[n - 1])) || ((".".equals(data[n - 1]) && "..".equals(data[n - 2])))) break;
            idx = -1;
            for (int i = 0; i < n; i++) {
                if (".".equals(data[i]) || "..".equals(data[i])) {
                    idx = i;
                    break;
                }
            }
            temp = data[n - 2];
            data[n - 2] = data[idx];
            data[idx] = temp;
        }
        for (String entry : data) out.println(entry);
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
        try (DirectoryListing instance = new DirectoryListing()) {
            instance.solve();
        }
    }
}
