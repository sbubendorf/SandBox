package ch.rusi.sandbox.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clock {

    private static final String clockControlFileFormat = "<([0-9]{12,20})>";

    private Long clock;

    public Clock(String controlFileClock) {

        Pattern patt = Pattern.compile(clockControlFileFormat);
        Matcher matcher = patt.matcher(controlFileClock);
        if(matcher.find()) {
            // Given clock string matches the pattern
            String stringClock = matcher.group(1);
            clock = Long.parseLong(stringClock);
            System.out.println("Clock is " + clock);
        } else {
            System.out.println("The given clock '" + controlFileClock + "' does not match the required pattern '" + clockControlFileFormat + "'!");
        }
    }

    public Clock(Long numClock) {
        this.clock = numClock;
    }

    public static void main(String[] args) {
        Clock clockNumeric = new Clock(1234L);
        System.out.println("Formatted clock for control file: " + clockNumeric.getControlFileClock());
        Clock clock = new Clock("<000012345678>");

    }

    public String getControlFileClock() {
        return "<" + String.format("%012d", clock) + ">";
    }
}
