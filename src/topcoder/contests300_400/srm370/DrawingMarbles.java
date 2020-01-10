package topcoder.contests300_400.srm370;

public class DrawingMarbles {

  public double sameColor(int[] colors, int n) {
    double result = 0;
    int total = 0;
    for (int color : colors) {
      total += color;
    }
    for (int color : colors) {
      if (color >= n) {
        double probability = 1;
        int marbles = color;
        for (double j = 0; j < n; j++, marbles--) {
          probability *= marbles / (total - j);
        }
        result += probability;
      }
    }
    return result;
  }

}
