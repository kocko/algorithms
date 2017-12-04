package timus.volume09;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongProblemStatement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        h = in.ni(); w = in.ni();
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            if (i > 0 && col > 0) {
                write(1);
            }
            write(in.next().length());
        }
        if (row == 0 && col == 0) {
            pages--;
        }
        out.println(pages);
    }
    
    private int h, w;
    private int row, col, pages = 1;
    
    private void write(int size) {
        if (col + size > w) {
            row++;
            col = size;
            if (row == h) {
                row = 0;
                pages++;
            }
        } else {
            col += size;
        }
        if (col == w) {
            col = 0;
            row++;
        }
        if (row == h) {
            row = 0;
            pages++;
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
        try (LongProblemStatement instance = new LongProblemStatement()) {
            instance.solve();
        }
    }
}
