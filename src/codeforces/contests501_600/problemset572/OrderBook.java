package codeforces.contests501_600.problemset572;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class OrderBook implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Order {
        int volume;
        int price;

        Order(int volume, int price) {
            this.volume = volume;
            this.price = price;
        }

        public int getVolume() {
            return volume;
        }

        public int getPrice() {
            return price;
        }
    }

    public void solve() {
        int n = in.ni(), s = in.ni();
        TreeMap<Integer, Integer> buy = new TreeMap<>(), sell = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String type = in.next();
            int p = in.ni(), q = in.ni();
            TreeMap<Integer, Integer> map = "S".equals(type) ? sell : buy;
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + q);
            } else {
                map.put(p, q);
            }
            if (map.size() > s) {
                if ("S".equals(type)) map.remove(map.lastKey());
                else map.remove(map.firstKey());
            }
        }
        print(sell, "S");
        print(buy, "B");
    }

    private void print(TreeMap<Integer, Integer> map, String key) {
        while (!map.isEmpty()) {
            out.println(key + " " + map.lastKey() + " " + map.get(map.lastKey()));
            map.remove(map.lastKey());
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

    public static void main(String[] args) {
        new OrderBook().solve();
    }
}
