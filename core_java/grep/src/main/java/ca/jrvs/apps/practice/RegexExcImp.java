package ca.jrvs.apps.practice;

import java.util.regex.*;

public class RegexExcImp implements RegexExc {

    public static void main(String[] arg ){ };

    public boolean matchJpeg(String filename) {
        String regex = ".*\\.jpeg$";
        return Pattern.matches(regex, filename);
    };

    public boolean matchIp(String ip) {
        String regex = "([0-9]{1,3}\\.){3}([0-9]{1,3})";
        return Pattern.matches(regex, ip);
    };

    public boolean isEmptyLine(String line) {
        String regex = "^\\s*$";
        return Pattern.matches(regex, line);
    };

}
