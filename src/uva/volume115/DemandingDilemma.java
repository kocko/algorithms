package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DemandingDilemma implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            int[][] adj = new int[n][n];
            int[][] inc = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    inc[i][j] = in.ni();
                }
            }
            boolean ok = true; 
            for (int j = 0; j < m; j++) {
                List<Integer> edge = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (inc[i][j] == 1) {
                        edge.add(i);        
                    }
                }
                if (edge.size() == 2) {
                    adj[edge.get(0)][edge.get(1)]++;
                    adj[edge.get(1)][edge.get(0)]++;
                } else {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (adj[i][j] > 1) ok = false;
                    }
                }
            }
            out.println(ok ? "Yes" : "No");
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
        try (DemandingDilemma instance = new DemandingDilemma()) {
            instance.solve();
        }
    }
}
