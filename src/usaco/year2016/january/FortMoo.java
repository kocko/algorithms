package usaco.year2016.january;

  import java.io.BufferedReader;
  import java.io.Closeable;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.PrintWriter;
  import java.util.ArrayDeque;
  import java.util.StringTokenizer;

  import static java.lang.Math.max;

  public class FortMoo implements Closeable {

    private final InputReader in;
    private final PrintWriter out;

    public FortMoo() throws FileNotFoundException {
      in = new InputReader(new FileInputStream("fortmoo.in"));
      out = new PrintWriter(new FileOutputStream("fortmoo.out"));
    }

    public void solve() {
      int n = in.ni(), m = in.ni();
      char[][] grid = new char[n][m];
      for (int i = 0; i < n; i++) {
        grid[i] = in.next().toCharArray();
      }
      int[][] prefix = new int[n][m + 1];
      for (int i = 0; i < n; i++) {
        for (int j = 1; j <= m; j++) {
          prefix[i][j] = prefix[i][j - 1];
          if (grid[i][j - 1] == '.') {
            prefix[i][j]++;
          }
        }
      }
      int result = 0;
      for (int left = 1; left <= m; left++) {
        for (int right = left + 1; right <= m; right++) {
          int h = right - left + 1;
          int first = 0, second = 0;
          ArrayDeque<Integer> emptyRows = new ArrayDeque<>();
          for (int row = 0; row < n; row++) {
            if (grid[row][left - 1] == '.') {
              first++;
            } else {
              first = 0;
            }
            if (grid[row][right - 1] == '.') {
              second++;
            } else {
              second = 0;
            }
            if (prefix[row][right] - prefix[row][left - 1] == h) {
              int v = Math.min(first, second);
              while (emptyRows.size() > 0 && emptyRows.peekFirst() < row - v) {
                emptyRows.pollFirst();
              }
              if (emptyRows.size() > 0) {
                int top = emptyRows.peekFirst();
                v = row - top + 1;
                result = max(result, h * v);
              }
              emptyRows.offerLast(row);
            }
          }
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
      try (FortMoo instance = new FortMoo()) {
        instance.solve();
      }
    }
  }
