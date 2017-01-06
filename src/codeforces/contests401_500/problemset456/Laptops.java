package codeforces.contests401_500.problemset456;

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

public class Laptops implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Laptop implements Comparable<Laptop> {
        int price;
        int quality;
        
        private Laptop(int price, int quality) {
            this.price = price;
            this.quality = quality;
        }

        @Override
        public int compareTo(Laptop o) {
            return Integer.compare(this.price, o.price);
        }
    } 
    
    public void solve() {
        int n = in.ni();
        List<Laptop> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Laptop(in.ni(), in.ni()));
        }
        Collections.sort(list);
        boolean happy = false;
        for (int i = 1; i < n; i++) {
            Laptop current = list.get(i);
            Laptop previous = list.get(i - 1);
            if (current.price > previous.price) {
                happy |= current.quality < previous.quality;
            }
        }
        out.println((happy ? "Happy" : "Poor") + " Alex");
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
        try (Laptops instance = new Laptops()) {
            instance.solve();
        }
    }
}
