package topcoder.contests501_600.srm522;

public class RowAndCoins {

    public String getWinner(String cells) {
        if (cells.charAt(0) == 'A' || cells.charAt(cells.length() - 1) == 'A') return "Alice";
        return "Bob";
    }

}
