package codeforces.contests701_800.problemset727;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.StringTokenizer;

public class BillTotalValue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        String current = "";
        BigDecimal total = BigDecimal.ZERO;
        for (char c : x) {
            if (isLetter(c) && !"".equals(current)) {
                total = addNewExpense(current, total);
                current = "";
            } else if (!isLetter(c)){
                current += c;
            }
        }
        if (current.length() > 0) {
            total = addNewExpense(current, total);
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat format = new DecimalFormat("#,##0.##", decimalFormatSymbols);
        format.setGroupingUsed(true);           
        out.println(format.format(total.doubleValue()));
    }

    private BigDecimal addNewExpense(String current, BigDecimal total) {
        String newValue = "";
        int n = current.length();
        for (int i = 0; i < n; i++) { 
            if (i == n - 3) {
                newValue += current.charAt(i);
            } else if (current.charAt(i) != '.' && i != n - 3) {
                newValue += current.charAt(i);
            }
        }
        return total.add(new BigDecimal(newValue));
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
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
        try (BillTotalValue instance = new BillTotalValue()) {
            instance.solve();
        }
    }
}
