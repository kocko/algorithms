package codeforces.contests601_700.problemset664;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InternationalOlympiad implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            String s = in.next().substring(4);
            int value = Integer.parseInt(s);
            switch (s.length()) {
                case 1: s = (s.equals("9") ? "1989" : "199" + s); break;
                case 2: s = s.equals("99") ? "1999" : "20" + s; break;
                case 3: s = value >= 99 ? "2" + s : "3" + s; break;
                case 4: s = value >= 3099 ? s : "1" + s; break;
                case 5: s = value >= 13099 ? s : "1" + s; break;
                case 6: s = value >= 113099 ? s : "1" + s; break;
                case 7: s = value >= 1113099 ? s : "1" + s; break;
                case 8: s = value >= 11113099 ? s : "1" + s; break;
                case 9: s = value >= 111113099 ? s : "1" + s; break;
            }
            out.println(s);
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
        try (InternationalOlympiad instance = new InternationalOlympiad()) {
            instance.solve();
        }
    }
}
