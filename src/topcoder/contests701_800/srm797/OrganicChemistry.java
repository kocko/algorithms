package topcoder.contests701_800.srm797;

public class OrganicChemistry {

  public int countHydrogens(String atoms, int[] u, int[] v) {
    char[] x = atoms.toCharArray();
    int n = x.length;
    int[] degree = new int[n];
    for (int i = 0; i < n; i++) {
      if (x[i] == 'C') {
        degree[i] = 4;
      } else if (x[i] == 'N') {
        degree[i] = 3;
      } else if (x[i] == 'O') {
        degree[i] = 2;
      }
    }
    for (int i = 0; i < u.length; i++) {
      degree[u[i]]--;
      degree[v[i]]--;
    }
    int result = 0;
    for (int deg : degree) {
      result += deg;
    }
    return result;
  }

}
