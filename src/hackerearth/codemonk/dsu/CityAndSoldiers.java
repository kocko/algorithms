package hackerearth.codemonk.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CityAndSoldiers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    static class DisjointSet {
        int[] arr;  
        
        public DisjointSet(int n) {
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) arr[i] = i;
        }
        
        public int root(int n) {
            while (n != arr[n]) n = arr[n];
            return n;
        }
        
        public void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                arr[x] = y;
            }
        }
        
        public void changeLeader(int a) {
            int root = root(a);
            if (a != root) {
                arr[a] = a;
                arr[root] = a;
            }
        }
        
    }

    public void solve() {
        int n = in.ni(), q = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        while (q-- > 0) {
            int type = in.ni();
            if (type == 1) {
                int a = in.ni(), b = in.ni();
                dsu.union(a, b);
            } else if (type == 2) {
                int a = in.ni();
                dsu.changeLeader(a);
            } else if (type == 3) {
                out.println(dsu.root(in.ni()));
            }
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
        new CityAndSoldiers().solve();
    }
}
