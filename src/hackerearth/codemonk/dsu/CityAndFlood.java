package hackerearth.codemonk.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CityAndFlood implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    static class DisjointSet {
        int[] arr;
        
        public DisjointSet(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;
        }
        
        public int root(int x) {
            while (arr[x] != x) {
                x = arr[x];
            }
            return x;
        }
        
        public void union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                arr[x] = y;
            }
        }
    }

    public void solve() {
        int n = in.ni(), k = in.ni();
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < k; i++) {
            int x = in.ni(), y = in.ni();
            ds.union(x - 1, y - 1);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (ds.arr[i] == i) result++;
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

    public static void main(String[] args) {
        new CityAndFlood().solve();
    }
}
