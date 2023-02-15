package templates;

public class MatrixPower {

  private final long MOD = (long) 1e9 + 7;

  private int[][] power(int[][] m, int p) {
    int n = m.length;
    int[][] result = new int[n][n];
    for (int i = 0; i < n; i++) result[i][i] = 1;
    while (p > 0) {
      if (p % 2 == 1) {
        result = multiply(result, m);
      }
      m = multiply(m, m);
      p >>= 1;
    }
    return result;
  }

  private int[][] multiply(int[][] a, int[][] b) {
    int[][] result = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < a[0].length; k++) {
          result[i][j] += a[i][k] * b[k][j];
          result[i][j] %= MOD;
        }
      }
    }
    return result;
  }

}
