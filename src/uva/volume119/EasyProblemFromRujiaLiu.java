package uva.volume119;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.stream.Collectors.toList;

public class EasyProblemFromRujiaLiu implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split("\\s+");
            int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= 1000000; i++) {
                list.add(new ArrayList<>());
            }
            split = in.readLine().split("\\s+");
            for (int idx = 0; idx < n; idx++) {
                int value = Integer.parseInt(split[idx]);
                list.get(value).add(idx + 1);
            }
            while (m-- > 0) {
                split = in.readLine().split("\\s+");
                int idx = Integer.parseInt(split[0]), value = Integer.parseInt(split[1]);
                if (list.get(value).size() < idx) {
                    out.println(0);
                } else {
                    out.println(list.get(value).get(idx - 1));
                }
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
        try (EasyProblemFromRujiaLiu instance = new EasyProblemFromRujiaLiu()) {
            instance.solve();
        }
    }
}
