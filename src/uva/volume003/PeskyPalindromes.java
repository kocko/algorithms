package uva.volume003;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PeskyPalindromes implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextLine()) {
      String word = in.nextLine();
      int palindromes = palindromes(word);
      out.printf("The string '%s' contains %d palindromes.\n", word, palindromes);
    }
  }

  private int palindromes(String word) {
    int n = word.length();
    Set<String> unique = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        String piece = word.substring(i, j);
        if (isPalindrome(piece)) {
          unique.add(piece);
        }
      }
    }
    return unique.size();
  }

  private boolean isPalindrome(String word) {
    int n = word.length();
    boolean result = true;
    for (int i = 0; i < n / 2; i++) {
      result &= word.charAt(i) == word.charAt(n - i - 1);
    }
    return result;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (PeskyPalindromes instance = new PeskyPalindromes()) {
      instance.solve();
    }
  }
}
