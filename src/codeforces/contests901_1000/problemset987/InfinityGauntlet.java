package codeforces.contests901_1000.problemset987;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class InfinityGauntlet implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("purple", "Power");
            put("green", "Time");
            put("blue", "Space");
            put("orange", "Soul");
            put("red", "Reality");
            put("yellow", "Mind");
        }};
        int n = in.ni();
        while (n-- > 0) {
            String next = in.next();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(next)) {
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        out.println(map.size());
        map.entrySet().stream().map(Map.Entry::getValue).forEach(out::println);
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
        try (InfinityGauntlet instance = new InfinityGauntlet()) {
            instance.solve();
        }
    }
}
