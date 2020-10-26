package ch.rusi.sandbox.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clock {

    private static final String clockControlFileFormat = "<([0-9]{12,12})>";

    private Long clock;

    public Clock(String controlFileClock) {

        Pattern patt = Pattern.compile(clockControlFileFormat);
        Matcher matcher = patt.matcher(controlFileClock);
        if(matcher.find()) {
            // Given clock string matches the pattern
            String stringClock = matcher.group(1);
            clock = Long.parseLong(stringClock);
        } else {
            System.out.println("The given clock '" + controlFileClock + "' does not match the required pattern '" + clockControlFileFormat + "'!");
        }

        System.out.println("Clock is " + clock);

    }

    public Clock(Long numClock) {
        this.clock = numClock;
    }

    public static void main(String[] args) {
        Clock clock = new Clock("<00001x345678>");

    }
}
