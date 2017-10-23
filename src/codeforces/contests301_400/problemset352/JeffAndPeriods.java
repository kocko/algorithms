package codeforces.contests301_400.problemset352;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JeffAndPeriods implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        final int MAX = 100001;
        boolean[] ignore = new boolean[MAX];
        int[] lastSeen = new int[MAX], diff = new int[MAX];
        for (int i = 0; i < 100001; i++) lastSeen[i] = diff[i] = -1;
        for (int i = 0; i < n; i++) {
            int value = in.ni();
            if (!ignore[value]) {
                if (lastSeen[value] == -1) {
                    lastSeen[value] = i;
                } else {
                    int p = i - lastSeen[value];
                    if (diff[value] == -1) {
                        diff[value] = p;
                        lastSeen[value] = i;
                    }
                    else if (diff[value] == p) {
                        lastSeen[value] = i;
                    } else {
                        ignore[value] = true;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 1; i < MAX; i++) {
            if (!ignore[i] && lastSeen[i] != -1) {
                if (diff[i] == -1) diff[i] = 0;
                result.append(i).append(" ").append(diff[i]).append("\n");
                count++;
            }
        }
        out.println(count);
        out.print(result);
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
        try (JeffAndPeriods instance = new JeffAndPeriods()) {
            instance.solve();
        }
    }
}
