package topcoder.contests701_800.srm761;

public class Sunshine {

  public String weatherReport(int total, int rainy) {
    int sunny = total - rainy;
    int groups = rainy + 1;
    int length = sunny / groups;
    int longerGroups = sunny % groups;
    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= groups; i++) {
      for (int j = 1; j <= ((i <= longerGroups) ? length + 1 : length); j++) {
        result.append('S');
      }
      if (i < groups) {
        result.append('R');
      }
    }
    return result.toString();
  }
}
