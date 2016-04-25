package codeforces.contests600_699.problemset669;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleArtemAndGrasshopper implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        char[] path = in.next().toCharArray();
        int[] j = new int[n];
        for (int i = 0; i < n; i++) j[i] = in.ni();
        boolean[] visited = new boolean[n];
        int current = 0;
        while(true) {
            if (path[current] == '>') current += j[current];
            else current -= j[current];
            if (current < 0 || current >= n) {
                break;
            }
            if (visited[current]) {
                out.println("INFINITE"); return;
            }
            visited[current] = true;
        }
        out.println("FINITE");
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
        new LittleArtemAndGrasshopper().solve();
    }
}
