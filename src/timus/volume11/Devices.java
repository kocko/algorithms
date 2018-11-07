package timus.volume11;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Devices implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        Map<String, Integer> devicesCount = new HashMap<>();
        Map<String, Integer> lowestPrice = new HashMap<>();
        int mostPopular = 0;
        for (int i = 0; i < 6; i++) {
            String friend = in.next(), device = in.next();
            int price = in.ni();
            devicesCount.put(device, devicesCount.getOrDefault(device, 0) + 1);
            mostPopular = max(mostPopular, devicesCount.get(device));
            lowestPrice.put(device, min(price, lowestPrice.getOrDefault(device, (int) 1e7)));
        }
        int cheapest = (int) 1e7;
        String result = "";
        for (Map.Entry<String, Integer> entry : devicesCount.entrySet()) {
            if (entry.getValue() == mostPopular) {
                int price = lowestPrice.get(entry.getKey());
                if (price < cheapest) {
                    cheapest = price;
                    result = entry.getKey();
                }
            }
        }
        out.println(result);
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
        try (Devices instance = new Devices()) {
            instance.solve();
        }
    }
}
