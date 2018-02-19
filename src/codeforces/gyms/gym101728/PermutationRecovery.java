package codeforces.gyms.gym101728;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PermutationRecovery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < 2 * n; i++) {
            int[] data = new int[n]; 
            for (int j = 0; j < n; j++) {
                data[j] = in.ni();
            }
            int key = data[0];
            List<int[]> value = map.getOrDefault(key, new ArrayList<>());
            value.add(data);
            map.put(key, value);
        }
        int start = -1;
        for (int i = 1; i <= n * n; i++) {
            List<int[]> value = map.get(i);
            if (value != null && value.size() == 2) {
                start = i;
                break;
            }
        }
        int[][] result = new int[n][n];
        int[] row = map.get(start).get(0), column = map.get(start).get(1);
        for (int i = 0; i < n; i++) {
            result[0][i] = row[i];            
            result[i][0] = column[i];            
        }
        for (int i = 1; i < n; i++) {
            column = map.get(row[i]).get(0);
            for (int j = 1; j < n; j++) {
                result[j][i] = column[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(result[i][j]);
                out.print(' ');
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

    public static void main(String[] args) throws IOException {
        try (PermutationRecovery instance = new PermutationRecovery()) {
            instance.solve();
        }
    }
}
