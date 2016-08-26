package hackerearth.codemonk.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class CityAndCampers2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    class DisjointSet {
        int[] arr;
        int[] size;
        Map<Integer, Integer> groups = new TreeMap<>();
        int last;
        
        DisjointSet(int n) {
            arr = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
            groups.put(1, n);
        }
        
        int root(int x) {
            return (x == arr[x]) ? x : (arr[x] = root(arr[x]));
        }
        
        int union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                int sizeX = size[x], sizeY = size[y];
                if (sizeX < sizeY) {
                    int d = y;
                    y = x;
                    x = d;
                }
                arr[y] = x;
                size[x] += size[y];
                if (size[x] < 0) {
                    out.println();
                }
                last = update(size[x], sizeX, sizeY);
            }
            return last;
        }
        
        private int update(int a, int b, int c) {
            groups.put(a, groups.getOrDefault(a, 0) + 1);
            groups.put(b, groups.get(b) - 1);
            groups.put(c, groups.get(c) - 1);

            long x = groups.get(b), y = groups.get(c);
            if (x == 0) {
                groups.remove(b);
            }
            if (y == 0) {
                groups.remove(c);
            }
            int min = Integer.MAX_VALUE;
            if (groups.size() == 1) {
                min = 0;
            } else {
                List<Integer> set = new ArrayList<>(groups.keySet());
                for (int i = 1; i < set.size(); i++) {
                    if (groups.get(set.get(i - 1)) > 1) {
                        min = 0;
                        break;
                    }
                    min = min(set.get(i) - set.get(i - 1), min);
                }
            }
           
            return min;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        while (q-- > 0) {
            int x = in.ni(), y = in.ni();
            out.println(dsu.union(x, y));
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
        try (CityAndCampers2 instance = new CityAndCampers2()) {
            instance.solve();
        }
    }
}
