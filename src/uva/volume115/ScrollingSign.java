package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ScrollingSign implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), w = in.ni();
      StringBuilder text = new StringBuilder(in.next());
      for (int i = 1; i < w; i++) {
        String word = in.next();
        char[] temp = (word + "#" + text).toCharArray();
        int[] prefix = prefix(temp);
        for (int j = prefix[prefix.length - 1]; j < word.length(); j++) {
          text.append(word.charAt(j));
        }
      }
      out.println(text.length());
    }
  }
  
  private int[] prefix(char[] x) {
    int[] result = new int[x.length];
    int k = 0;
    for (int i = 1; i < x.length; i++) {
      while (k > 0 && x[i] != x[k]) {
        k = result[k - 1];
      }
      if (x[i] == x[k]) {
        k++;
      }
      result[i] = k;
    }
    return result;
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
    try (ScrollingSign instance = new ScrollingSign()) {
      instance.solve();
    }
  }
}
