package hackerearth.codemonk.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CityAndCampers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    static class DisjointSet {
        int arr[];
        int size[];
        int max = 1, min = 1;  

        DisjointSet(int n) {
            arr = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
            }
            for (int i = 1; i <= n; i++) {
                size[i] = 1;
            }
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
                if (size[x] > size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                arr[x] = y;
                size[y] += size[x];
                size[x] = 1;
                max = Math.max(max, size[y]);
                if (max == arr.length - 1) {
                    min = arr.length - 1;
                }
            }
        }

        private void calculateMin() {
            for (int i = 1; i < size.length; i++) {
                if (size[i] < min && size[i] != 1) {
                    min = size[i];
                }
            }
        }

    }

    public void solve() {
        int n = in.ni(), k = in.ni();
        DisjointSet ds = new DisjointSet(n);
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < k; i++) {
            int x = in.ni(), y = in.ni();
            if (!visited[x]) {
                visited[x] = true;
                count++;
            }
            if (!visited[y]) {
                visited[y] = true;
                count++;
            }
            ds.union(x, y);
            if (count == n) {
                ds.calculateMin();
            }
            out.println(ds.max - ds.min);
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
        new CityAndCampers().solve();
    }
}