package codeforces.contests600_699.problemset669;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LittleArtemAndMatrix implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    interface Query {
        int getType();
    }

    static class Shift implements Query {
        int type;
        int element;

        Shift(int type, int element) {
            this.type = type;
            this.element = element;
        }

        @Override
        public int getType() {
            return type;
        }
    }

    class Ask implements Query {
        int r;
        int c;
        int value;

        Ask(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public int getType() {
            return 3;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni(), q = in.ni();
        int[][] matrix = new int[n][m];
        List<Query> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int type = in.ni();
            Query query;
            if (type == 1) {
                query = new Shift(1, in.ni() - 1);
            } else if (type == 2) {
                query = new Shift(2, in.ni() - 1);
            } else {
                query = new Ask(in.ni() - 1, in.ni() - 1, in.ni());
            }
            list.add(query);
        }

        for (int i = 0; i < q; i++) {
            Query query = list.get(q - i - 1);
            if (query.getType() == 1) {
                Shift shift = (Shift) query;
                int[] copy = new int[m];
                System.arraycopy(matrix[shift.element], 0, copy, 0, m);
                int last = copy[copy.length - 1];
                System.arraycopy(copy, 0, matrix[shift.element], 1, copy.length - 1);
                matrix[shift.element][0] = last;
            } else if (query.getType() == 2) {
                Shift shift = (Shift) query;
                int[] copy = new int[n];
                for (int k = 0; k < n; k++) copy[k] = matrix[k][shift.element];
                int last = copy[n - 1];
                for (int j = 1; j < n; j++) {
                    matrix[j][shift.element] = copy[j - 1];
                }
                matrix[0][shift.element] = last;
            } else if (query.getType() == 3) {
                Ask ask = (Ask) query;
                matrix[ask.r][ask.c] = ask.value;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(matrix[i][j] + " ");
            }
            out.println();
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
        new LittleArtemAndMatrix().solve();
    }
}
