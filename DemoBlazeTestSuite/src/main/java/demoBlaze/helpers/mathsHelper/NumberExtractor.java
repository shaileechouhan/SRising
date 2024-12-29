package demoBlaze.helpers.mathsHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {
    public static int extractInt(String inputText){
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        String number = "";
        while (matcher.find()){
            number = matcher.group();
        }
        return Integer.parseInt(number);
    }
    public static long extractLong(String inputText){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(inputText);
        String number = "";
        while (matcher.find()){
            number = matcher.group();
        }
        return Long.parseLong(number);
    }
}
