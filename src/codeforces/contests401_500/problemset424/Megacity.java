package codeforces.contests401_500.problemset424;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class Megacity implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class City implements Comparable<City> {

        private int x, y, k;

        private City(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
        
        private double dist() {
            return sqrt(x * x + y * y);
        }

        @Override
        public int compareTo(City o) {
            return Double.compare(dist(), o.dist());
        }
    }
    
    public void solve() {
        int n = in.ni(), s = in.ni();
        List<City> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new City(in.ni(), in.ni(), in.ni()));    
        }
        list.sort(Comparator.naturalOrder());
        double dist = 0d; 
        for (int i = 0; i < n; i++) {
            if (s >= 1000000) {
                out.print(dist);
                return;
            }
            City city = list.get(i);
            s += city.k;
            dist = city.dist();
        }
        if (s >= 1000000) {
            out.print(dist);
            return;
        }
        out.println(-1);
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
        try (Megacity instance = new Megacity()) {
            instance.solve();
        }
    }
}
