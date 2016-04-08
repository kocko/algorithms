package topcoder.contests601_700.srm662;

public class Hexspeak {

    public String decode(long cipher) {
        String s = Long.toHexString(cipher).replaceAll("0", "O").replaceAll("1", "I").toUpperCase();
        for (char c : s.toCharArray()) {
            if (c >= '2' && c <= '9') return "Error!";
        }
        return s;
    }

}
