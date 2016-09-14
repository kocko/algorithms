package codeforces.contests701_800.problemset714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MeetingOfOldFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long l1 = in.nl(), r1 = in.nl(), l2 = in.nl(), r2 = in.nl(), k = in.nl();
        if (r1 < l2 || l1 > r2) {
            out.println(0);
        } else {
            long left = Math.max(l1, l2);
            long right = Math.min(r1, r2);
            if (k < left || k > right) {
                out.println(right - left + 1);
            } else {
                out.println(right - left);
            }
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
        try (MeetingOfOldFriends instance = new MeetingOfOldFriends()) {
            instance.solve();
        }
    }
}
