package topcoder.contests401_500.srm483;

public class DigitHoles {

    public int numHoles(int number) {
        String s = String.valueOf(number);
        int result = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '0' :
                case '4':
                case '6':
                case '9': result++; break;
                case '8': result += 2; break;
            }
        }
        return result;
    }
}
