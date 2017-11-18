package topcoder.contests701_800.srm723;

public class BuffaloBuffalo {

    public String check(String s) {
        String[] split = s.split(" ");
        boolean ok = s.charAt(0) == ' ';
        if (s.length() > 1) {
            ok &= s.charAt(s.length() - 1) != ' ';
        }
        for (String x : split) {
            if (!"buffalo".equals(x)) {
                ok = false;
                break;
            }
        }
        return ok ? "Good" : "Not good";
    }
}
