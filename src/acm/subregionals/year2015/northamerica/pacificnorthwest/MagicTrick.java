package acm.subregionals.year2015.northamerica.pacificnorthwest;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicTrick implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    private class Operation {
        String command;
        int value;
        
        Operation(String command, int value) {
            this.command = command;
            this.value = value;
        }
    }
    
    public void solve() {
        int n = in.ni();
        Operation[] operations = new Operation[n];
        for (int i = 0; i < n; i++) {
            operations[i] = new Operation(in.next(), in.ni());
        }
        int result = 0;
        for (long i = 1; i <= 100; i++) {
            long current = i;
            boolean bad = false;
            in: for (Operation op : operations) {
                int value = op.value;
                switch (op.command) {
                    case "ADD" : {
                        current += value;
                        break;
                    }
                    case "SUBTRACT": {
                        current -= value;
                        if (current < 0) {
                            bad = true;
                            break in;
                        }
                        break;
                    }
                    case "MULTIPLY" : {
                        current *= value;
                        break;
                    }
                    case "DIVIDE": {
                        if (current % value == 0) {
                            current /= value;
                        } else {
                            bad = true;
                            break in;
                        }
                    }
                }
            }
            bad |= (current < 0);
            if (bad) {
                result++;
            }
        }
        out.println(result);
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
        new MagicTrick().solve();
    }
}
