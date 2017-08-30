package codeforces.contests801_900.problemset845;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class DrivingTest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Stack<Integer> speedLimits = new Stack<>();
        speedLimits.add(305);
        int overtakeAllowed = 0;
        int currentSpeed = 0, result = 0;
        for (int i = 0; i < n; i++) {
            int type = in.ni();
            switch (type) {
                case 1: {
                    currentSpeed = in.ni();
                    break;
                }
                case 2: {
                    result += overtakeAllowed;
                    overtakeAllowed = 0;
                    break;
                }
                case 3: {
                    speedLimits.add(in.ni());
                    break;
                }
                case 4: {
                    overtakeAllowed = 0;
                    break;
                }
                case 5: {
                    speedLimits.clear();
                    speedLimits.add(305);
                    break;
                }
                case 6: {
                    overtakeAllowed++;
                    break;
                }
            }
            while (currentSpeed > speedLimits.peek()) {
                speedLimits.pop();
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

    public static void main(String[] args) throws IOException {
        try (DrivingTest instance = new DrivingTest()) {
            instance.solve();
        }
    }
}
