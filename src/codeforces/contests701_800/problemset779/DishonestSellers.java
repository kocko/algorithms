package codeforces.contests701_800.problemset779;

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

public class DishonestSellers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Item implements Comparable<Item> {
        private int idx, now, then;
        
        private Item(int idx, int now, int then) {
            this.idx = idx;
            this.now = now;
            this.then = then;
        }
        
        private int loss() {
            return then - now;
        }

        @Override
        public int compareTo(Item o) {
            int x = this.then - this.now;
            int y = o.then - o.now;
            return -Integer.compare(x, y);
        }
    }
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] now = new int[n];
        for (int i = 0; i < n; i++) {
            now[i] = in.ni();
        }
        int[] then = new int[n];
        for (int i = 0; i < n; i++) {
            then[i] = in.ni();
        }
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(i, now[i], then[i]));    
        }
        Collections.sort(list);
        long result = 0L;
        int i;
        for (i = 0; i < k; i++) {
            result += list.get(i).now;
        }
        for (; i < n; i++) {
            if (list.get(i).loss() < 0) break;
            else result += list.get(i).now;
        }
        while (i < n) {
            result += list.get(i).then;
            i++;
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
        try (DishonestSellers instance = new DishonestSellers()) {
            instance.solve();
        }
    }
}
