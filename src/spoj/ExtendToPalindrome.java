package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtendToPalindrome implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNext()) {
      String next = in.next();
      int n = next.length();
      char[] text = new char[2 * n + 1];
      for (int i = n - 1; i >= 0; i--) {
        text[n - i - 1] = text[text.length - n + i] = next.charAt(i);
      }
      int[] prefix = new int[text.length];
      int k = 0;
      for (int i = 1; i < prefix.length; i++) {
        while (k > 0 && text[i] != text[k]) {
          k = prefix[k - 1];
        }
        if (text[i] == text[k]) {
          k++;
        }
        prefix[i] = k;
      }
      int palindromeSize = prefix[prefix.length - 1];
      int index = next.length() - palindromeSize - 1;
      out.print(next);
      for (int i = index; i >= 0; i--) {
        out.print(next.charAt(i));
      }
      out.println();
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (ExtendToPalindrome instance = new ExtendToPalindrome()) {
      instance.solve();
    }
  }
}
