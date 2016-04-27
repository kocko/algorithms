package topcoder.tco.tco2015.round1;

public class EllysTimeMachine {

    public String getTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[1]) / 5;
        if (hour == 0) hour = 12;
        int min = Integer.parseInt(split[0]) * 5;
        if (min == 60) min = 0;
        return String.format("%02d:%02d", hour, min);
    }

}
