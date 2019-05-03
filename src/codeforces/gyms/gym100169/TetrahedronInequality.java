package codeforces.gyms.gym100169;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class TetrahedronInequality implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      possible = false;
      x = new long[6];
      used = new boolean[6];
      perm = new long[6];
      for (int i = 0; i < 6; i++) {
        x[i] = in.nl();
        if (i == 0) {
          perm[i] = x[i];
          used[i] = true;
        }
      }
      recurse(1);
      out.println(possible ? "YES" : "NO");
    }
  }

  private long[] x;
  private boolean[] used;
  private long[] perm;
  private boolean possible;

  private void recurse(int idx) {
    if (possible) return;
    if (idx == 6) {
      check();
    } else {
      for (int i = 1; i < 6; i++) {
        if (!used[i]) {
          perm[idx] = x[i];
          used[i] = true;
          recurse(idx + 1);
          used[i] = false;
        }
      }
    }
  }

  /*
    A non-degenerate tetrahedron is determined by a tuple (x, y, z, a, b, c) 
    where x, y and z are the lengths of edges that share a same vertex and a, b and c
    are the lengths of the other three edges.
    
    The tetrahedron is non-degenerate when:  
    1) All the tetrahedron walls are valid triangles, i.e. (m + n > p && m + p > n && n + p > m)
    2) D > 0, where D is the determinant of Cayley-Menger:
       |  0  x*x y*y z*z 1 |
       | x*x  0  c*c b*b 1 |
   D = | y*y c*c  0  a*a 1 |
       | z*z b*b a*a  0  1 |
       |  1   1   1   1  0 |
       
    Proof: https://www.ems-ph.org/journals/show_pdf.php?issn=0013-6018&vol=64&iss=4&rank=4 
   */
  private void check() {
    if (allWallsAreTriangles()) {
      BigInteger[][] det = new BigInteger[5][5];
      for (int i = 0; i < 5; i++) {
        det[i][i] = BigInteger.ZERO;
      }
      for (int i = 0; i < 4; i++) {
        det[4][i] = det[i][4] = ONE;
      }
      det[0][1] = det[1][0] = valueOf(perm[0] * perm[0]);
      det[0][2] = det[2][0] = valueOf(perm[1] * perm[1]);
      det[0][3] = det[3][0] = valueOf(perm[2] * perm[2]);

      det[2][3] = det[3][2] = valueOf(perm[3] * perm[3]);
      det[1][3] = det[3][1] = valueOf(perm[4] * perm[4]);
      det[1][2] = det[2][1] = valueOf(perm[5] * perm[5]);

      possible |= determinant(det).compareTo(BigInteger.ZERO) > 0;
    }
  }

  private boolean allWallsAreTriangles() {
    return isTriangle(perm[0], perm[1], perm[5]) && isTriangle(perm[1], perm[2], perm[3])
            && isTriangle(perm[0], perm[2], perm[4]) && isTriangle(perm[3], perm[4], perm[5]);
  }

  private boolean isTriangle(long a, long b, long c) {
    return a + b > c && a + c > b && b + c > a;
  }

  private BigInteger determinant(BigInteger[][] matrix) {
    BigInteger sum = ZERO;
    BigInteger s;
    int n = matrix.length;
    if (n == 1) {
      return (matrix[0][0]);
    }
    for (int i = 0; i < n; i++) {
      BigInteger[][] smaller = new BigInteger[n - 1][n - 1];
      for (int a = 1; a < n; a++) {
        for (int b = 0; b < n; b++) {
          if (b < i) {
            smaller[a - 1][b] = matrix[a][b];
          } else if (b > i) {
            smaller[a - 1][b - 1] = matrix[a][b];
          }
        }
      }
      if (i % 2 == 0) {
        s = ONE;
      } else {
        s = BigInteger.valueOf(-1);
      }
      BigInteger addition = s.multiply(matrix[0][i]).multiply(determinant(smaller));
      sum = sum.add(addition);
    }
    return sum;
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
    try (TetrahedronInequality instance = new TetrahedronInequality()) {
      instance.solve();
    }
  }
}
