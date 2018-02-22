package usaco.section1.part1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class friday implements Closeable {

    private InputReader in;
    private PrintWriter out;
    
    public friday() throws IOException {
        in = new InputReader(new FileInputStream(new File("friday.in")));
        out = new PrintWriter(new FileOutputStream(new File("friday.out")));
    }

    public void solve() {
        int n = in.ni();
        int[] result = new int[7];
        int[] normal = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leap   = {-1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayOfWeek = -1;
        for (int i = 0; i < n; i++) {
            int year = 1900 + i;
            int[] days;
            if (isLeap(year)) {
                days = leap;
            } else {
                days = normal;
            }
            for (int m : days) {
                for (int j = 1; j <= m; j++) {
                    dayOfWeek++;
                    dayOfWeek %= 7;
                    if (j == 13) {
                        result[dayOfWeek]++;
                    }
                }
            }
        }
        for (int i = 5; i <= 6; i++) {
            out.print(result[i]);
            out.print(' ');
        }
        for (int i = 0; i < 5; i++) {
            out.print(result[i]);
            if (i <= 3) out.print(' ');
        }
        out.println();
    }
    
    private boolean isLeap(int n) {
        if (n % 100 == 0) {
            return n % 400 == 0;
        }
        return n % 4 == 0;
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
        try (friday instance = new friday()) {
            instance.solve();
        }
    }
}
