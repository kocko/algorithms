package uva.volume116;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class BallotEvaluation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        Map<String, BigDecimal> map = new HashMap<>();
        while (n-- > 0) {
            map.put(in.next(), BigDecimal.valueOf(Double.parseDouble(in.next())));
        }
        for (int testCase = 1; testCase <= m; testCase++) {
            BigDecimal total = BigDecimal.ZERO;
            BigDecimal value;
            boolean foundOperator = false;
            String operator = null;
            while (true) {
                String next = in.next();
                if ("+".equals(next)) continue;
                if (comparison(next) != null) {
                    operator = comparison(next);
                    foundOperator = true;
                } else {
                    if (foundOperator) {
                        value = BigDecimal.valueOf(Double.parseDouble(next));
                        String output = evaluate(total, operator, value) ? "correct" : "incorrect";
                        out.printf("Guess #%d was %s.\n", testCase, output);
                        break;
                    } else {
                        total = total.add(map.get(next));
                    }
                }
            }
        }
    }

    private final BiFunction<BigDecimal, BigDecimal, Boolean> gr = (a, b) -> a.compareTo(b) > 0;
    private final BiFunction<BigDecimal, BigDecimal, Boolean> ge = (a, b) -> a.compareTo(b) >= 0;
    private final BiFunction<BigDecimal, BigDecimal, Boolean> le = (a, b) -> a.compareTo(b) <= 0;
    private final BiFunction<BigDecimal, BigDecimal, Boolean> eq = (a, b) -> a.compareTo(b) == 0;
    private final BiFunction<BigDecimal, BigDecimal, Boolean> lt = (a, b) -> a.compareTo(b) < 0;

    private final List<String> operators = Arrays.asList(">", "<", "=", ">=", "<=");

    private String comparison(String value) {
        for (String op : operators) {
            if (value.equals(op)) return value;
        }
        return null;
    }

    private boolean evaluate(BigDecimal total, String operator, BigDecimal value) {
        switch (operator) {
            case ">": return gr.apply(total, value);
            case "<": return lt.apply(total, value);
            case ">=": return ge.apply(total, value);
            case "<=": return le.apply(total, value);
            case "=": return eq.apply(total, value);
        }
        return false;
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
        try (BallotEvaluation instance = new BallotEvaluation()) {
            instance.solve();
        }
    }
}
