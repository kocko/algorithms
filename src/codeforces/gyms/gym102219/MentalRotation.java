package codeforces.gyms.gym102219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MentalRotation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] instructions = in.next().toCharArray();
    char[][] grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    
    int rotations = 0;
    for (char c : instructions) {
      if (c == 'L') {
        if (--rotations < 0) {
          rotations = 3;
        }
      } else {
        if(++rotations > 3) {
          rotations = 0;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < rotations; k++) {
          grid[i][j] = right(grid[i][j]);
        }
      }
    }
    char[][] result = new char[n][n];
    if (rotations == 0) {
      result = grid;
    } else if (rotations == 1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          result[j][n - i - 1] = grid[i][j];
        }
      }
    } else if (rotations == 2) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          result[n - i - 1][n - j - 1] = grid[i][j];
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          result[n - j - 1][i] = grid[i][j];
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(result[i][j]);
      }
      out.println();
    }
  }
  
  private char right(char x) {
    switch (x) {
      case '^' : return '>';
      case '>' : return 'v';
      case 'v' : return '<';
      case '<' : return '^';
      default: return '.';
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
    try (MentalRotation instance = new MentalRotation()) {
      instance.solve();
    }
  }
}
