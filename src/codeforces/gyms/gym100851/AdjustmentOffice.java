package codeforces.gyms.gym100851;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AdjustmentOffice implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public AdjustmentOffice() throws IOException {
    in = new InputReader(new FileInputStream("adjustment.in"));
    out = new PrintWriter(new FileOutputStream("adjustment.out"));
  }

  public void solve() {
    int n = in.ni(), q = in.ni();
    long sum = ((long) n * (n + 1)) / 2;
    long[] row = new long[n + 1];
    long[] col = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      row[i] = col[i] = sum + n * i;
    }
    long colSum = 0, rowSum = 0, deletedCols = 0, deletedRows = 0;
    while (q-- > 0) {
      char type = in.next().charAt(0);
      int idx = in.ni();
      if (type == 'R') {
        if (row[idx] != 0) {
          out.println(row[idx] - deletedCols * idx - colSum);
          deletedRows++;
          rowSum += idx;
        } else {
          out.println(0);
        }
        row[idx] = 0;
      } else {
        if (col[idx] != 0) {
          out.println(col[idx] - deletedRows * idx - rowSum);
          deletedCols++;
          colSum += idx;
        } else {
          out.println(0);
        }
        col[idx] = 0;
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
    try (AdjustmentOffice instance = new AdjustmentOffice()) {
      instance.solve();
    }
  }
}
