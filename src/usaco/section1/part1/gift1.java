package usaco.section1.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
ID: <your-id-here>
LANG: JAVA
TASK: gift1
*/

public class gift1 implements Closeable {

    private InputReader in = new InputReader();
    private PrintWriter out;

    public gift1() {
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve() {
        int n = in.ni();
        String[] order = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            order[i] = in.next();
            map.put(order[i], 0);
        }
        while (true) {
            String from = in.next();
            if (from == null) break;
            int amount = in.ni(), count = in.ni();
            if (count > 0) {
                int perPerson = amount / count;
                map.put(from, map.get(from) - amount);
                for (int i = 0; i < count; i++) {
                    String to = in.next();
                    map.put(to, map.get(to) + perPerson);
                }
                map.put(from, map.get(from) + (amount % count));
            } else if (count == 0) {
                map.put(from, map.get(from) + amount);
            }
        }
        for (String key : order) {
            out.println(key + " " + map.get(key));
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

        public InputReader() {
            try {
                reader = new BufferedReader(new FileReader("gift1.in"), 32768);
                tokenizer = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    return null;
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

    public static void main(String[] args) {
        new gift1().solve();
    }
}
