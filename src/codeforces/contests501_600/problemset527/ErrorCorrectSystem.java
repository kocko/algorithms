package codeforces.contests501_600.problemset527;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ErrorCorrectSystem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), distance = 0;
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if (x[i] != y[i]) {
                distance++;
                graph[x[i] - 'a'][y[i] - 'a'] = true;
            }
        }
        char[] best = bestSwap();
        if (best != null) {
            int[] result = new int[2];
            result[0] = result[1] = -1;
            for (int i = 0; i < n; i++) {
                if (result[0] != -1 && result[1] != -1) break;
                if (x[i] != y[i]) {
                    if (x[i] == best[0] && y[i] == best[1]) {
                        result[0] = i + 1;
                    }
                    if (x[i] == best[1] && y[i] == best[0]) {
                        result[1] = i + 1;
                    }
                }
            }
            out.println(distance - 2);
            out.println(result[0] + " " + result[1]);
            return;
        }
        char[] secondBest = secondBestSwap();
        if (secondBest != null) {
            int[] result = new int[2];
            result[0] = result[1] = -1;
            for (int i = 0; i < n; i++) {
                if (result[0] != -1 && result[1] != -1) break;
                if (x[i] != y[i]) {
                    if (x[i] == secondBest[0] && y[i] == secondBest[1]) {
                        result[0] = i + 1;
                    }
                    if (x[i] == secondBest[1] && y[i] == secondBest[2]) {
                        result[1] = i + 1;
                    }
                }
            }
            out.println(distance - 1);
            out.println(result[0] + " " + result[1]);
            return;
        }
        out.println(distance);
        out.println("-1 -1");
    }

    private boolean[][] graph = new boolean[26][26];

    private char[] bestSwap() {
        char a, b;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (graph[i][j] && graph[j][i]) {
                    a = (char) ('a' + i);
                    b = (char) ('a' + j);
                    return new char[]{a, b};
                }
            }
        }
        return null;
    }

    private char[] secondBestSwap() {
        char a, b, c;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (graph[i][j]) {
                    for (int k = 0; k < 26; k++) {
                        if (graph[j][k]) {
                            a = (char) ('a' + i);
                            b = (char) ('a' + j);
                            c = (char) ('a' + k);
                            return new char[]{a, b, c};
                        }
                    }
                }
            }
        }
        return null;
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
        try (ErrorCorrectSystem instance = new ErrorCorrectSystem()) {
            instance.solve();
        }
    }
}
