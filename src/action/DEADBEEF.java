package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DEADBEEF implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    while (n-- > 0) {
      String hex = hex(in.next());
      if (hex != null) {
        out.println(hex);
      }
    }
  }

  private String hex(String var) {
    var = "0x" + var;
    var = var.replaceAll("O", "0");
    var = var.replaceAll("I", "1");
    var = var.replaceAll("Z", "2");
    var = var.replaceAll("S", "5");
    var = var.replaceAll("T", "7");
    return (valid(var)) ? var : null;
  }
  
  private boolean valid(String var) {
    boolean hex = true;
    int firstNonHex = -1;
    for (int i = 2; i < var.length(); i++) {
      char ch = var.charAt(i);
      if (ch == 'U' || ch == 'L') {
        if (firstNonHex == -1) {
          firstNonHex = i;
        }
      } else if (!(ch >= '0' && ch <= '9') && !(ch >= 'A' && ch <= 'F')) {
        hex = false;
      }
    }
    if (hex && firstNonHex > 2) {
      String suffix = var.substring(firstNonHex);
      return ("ULL".equals(suffix) || "L".equals(suffix) || "LL".equals(suffix) || "UL".equals(suffix) || "U".equals(suffix));
    } else if (firstNonHex == -1) {
      return hex;
    } else {
      return false;
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
    try (DEADBEEF instance = new DEADBEEF()) {
      instance.solve();
    }
  }
}
