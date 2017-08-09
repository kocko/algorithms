package codeforces.contests001_100.problemset063;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SinkingShip implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Passenger> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.next(), type = in.next();
            int t;
            if ("rat".equals(type)) t = 0;
            else if ("woman".equals(type) || "child".equals(type)) t = 1;
            else if ("man".equals(type)) t = 2;
            else t = 3;
            list.add(new Passenger(name, t, i));
        }
        Collections.sort(list);
        for (Passenger passenger : list) {
            out.println(passenger.name);
        }
    }
    
    private class Passenger implements Comparable<Passenger> {
        private String name;
        private int type, idx;

        private Passenger(String name, int type, int idx) {
            this.name = name;
            this.type = type;
            this.idx = idx;
        }

        @Override
        public int compareTo(Passenger o) {
            int x = Integer.compare(this.type, o.type);
            return x == 0 ? Integer.compare(this.idx, o.idx) : x;
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
        try (SinkingShip instance = new SinkingShip()) {
            instance.solve();
        }
    }
}
