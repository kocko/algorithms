package topcoder.contests701_800.srm753;

public class KerimJavati {

  public int howLong(String text) {
    int result = text.length();
    for (char c : text.toCharArray()) {
      result += (c - 'a') * 2;
    }
    return result;
  }
  
}
