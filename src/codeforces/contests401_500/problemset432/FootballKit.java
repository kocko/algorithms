package codeforces.contests401_500.problemset432;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FootballKit implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Team {
        int home;
        int away;
        
        private Team(int home, int away) {
            this.home = home;
            this.away = away;
        }
    }
    
    public void solve() {
        int n = in.ni();
        Team[] x = new Team[n];
        int[] home = new int[100001];
        int[] away = new int[100001];
        for (int i = 0; i < n; i++) {
            int a = in.ni(), b = in.ni();
            x[i] = new Team(a, b);
            home[a]++;
            away[b]++;
        }
        int t = (n - 1) << 1;
        for (int i = 0; i < n; i++) {
            int a = n - home[x[i].away] - 1;
            out.println((t - a) + " " + a);
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
        try (FootballKit instance = new FootballKit()) {
            instance.solve();
        }
    }
}
