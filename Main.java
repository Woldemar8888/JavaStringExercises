package by.epamtc.aladzyin.string;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "Some example of string";
        String palindrome = "AbccbA";

//        showEvenOddSymbol( str );
//        showUppercaseLowercaseRatio( str );
//        System.out.println( deleteSameSymbols(str) );
//        System.out.println( getMatchesCount('e', str) );
//        System.out.println( getReversedString(str) );
//        System.out.println( insertSubString(str, 0, "INSERTED") );
//        System.out.println( deleteSubString(str, 1) );
//        System.out.println( deleteSubString(str, 1, 288) );
//        System.out.println( copySubString(str, 1, 5) );
//        System.out.println( getLength(str) );
//        System.out.println( getCountSubstrings(str, "e ") );
//        showReversedString( str );
//        System.out.println( changeSpaces(str) );
//        System.out.println( changeSymbols(str) );
//        System.out.println( getShortestWordLength(str) );
//        System.out.println( getWordsCount(str) );
//        System.out.println( deleteLastWord(str) );
//        System.out.println( addSpaces(str) );
//        System.out.println( isPalindrome(palindrome) );
//        System.out.println( replaceSubstring(str, "string", "char") );
        System.out.println( removeWords(str, 7) );
//        System.out.println( removeExtraSpaces(str) );
    }

    public static void showEvenOddSymbol( String str ) {
        StringBuilder EvenCharsLine = new StringBuilder();
        StringBuilder OddCharsLine = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (i % 2 == 0) {
                EvenCharsLine.append(str.charAt(i));
            } else {
                OddCharsLine.append(str.charAt(i));
            }
        }

        System.out.println(EvenCharsLine.toString() + '\n' + OddCharsLine.toString());
    }

    public static void showUppercaseLowercaseRatio( String str ) {
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        int length = str.length();
        double lowerCaseRatio;
        double upperCaseRatio;

        for (int i = 0; i < length; i++) {

            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCaseCount++;
            }

            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCaseCount++;
            }
        }

        lowerCaseRatio = (double) lowerCaseCount / length * 100;
        upperCaseRatio = (double) upperCaseCount / length * 100;


        System.out.println("lowerCaseRatio is " + lowerCaseRatio + " %");
        System.out.println("upperCaseRatio is " + upperCaseRatio + " %");
    }

    public static String deleteSameSymbols( String str ) {

        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        for (char ch : set) {
            result.append(ch);
        }

        return result.toString();
    }

    public static int getMatchesCount( char symbol, String str ) {

        int matchesCount = 0;
        char[] charsArray = str.toCharArray();

        for (char ch : charsArray) {
            if (ch == symbol) {
                matchesCount++;
            }
        }

        return matchesCount;
    }

    public static String getReversedString( String str ) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    public static String insertSubString( String str, int offset, String substring ) {
        StringBuilder stringBuilder = new StringBuilder(str);

        if (offset > str.length()) offset = str.length();
        if (offset < 0) offset = 0;

        return stringBuilder.insert(offset, substring).toString();
    }

    public static String deleteSubString( String str, int offset ) {

        if (offset > str.length()) offset = str.length();
        if (offset < 0) offset = 0;

        return str.substring(0, offset);
    }

    public static String deleteSubString( String str, int offset, int count ) {

        if (offset > str.length()) offset = str.length();
        if (count > str.length()) count = str.length() - offset;
        if (offset < 0) offset = 0;
        if (count < 0) count = 0;


        return str.substring(0, offset) + str.substring(offset + count);
    }

    public static String copySubString( String str, int offset, int count ) {

        if (offset > str.length()) offset = str.length();
        if (count > str.length()) count = str.length() - offset;
        if (offset < 0) offset = 0;
        if (count < 0) count = 0;

        return str.substring(offset, count);
    }

    public static int getLength( String str ) {

        return (str != null) ? str.length() : 0;
    }

    public static int getCountSubstrings( String str, String substring ) {

        int count = 0;

        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void showReversedString( String str ) {

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);

        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            list.add(str.substring(matcher.start(), matcher.end()));
        }


        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i) + " ");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    public static String changeSpaces( String str ){
        return str.replaceAll( "\\s+", "*");
    }

    public static String changeSymbols( String str ){

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);

        int position = 0;
        int maxLength = 0;

        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            list.add(str.substring(matcher.start(), matcher.end()));
        }

        for(int i = 0; i < list.size(); i++){

            int length =list.get(i).length();

            if( length > maxLength ) {
                maxLength = length;
                position = i;
            }
        }

        list.set(position, list.get(position).replaceAll("a", "b"));

        for(String s : list){
            stringBuilder.append(s + " " );
        }

        return stringBuilder.toString().trim();
    }

    public static int getShortestWordLength( String str ){

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);

        List<Integer> list = new ArrayList<>();

        while (matcher.find()) {
            list.add( (str.substring(matcher.start(), matcher.end())).length() );
        }

        Collections.sort(list);

        return list.get(0);
    }

    public static int getWordsCount( String str ){

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);

        List<Integer> list = new ArrayList<>();

        while (matcher.find()) {
            list.add( (str.substring(matcher.start(), matcher.end())).length() );
        }

        return list.size();
    }

    public static String deleteLastWord( String str ){

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add( str.substring(matcher.start(), matcher.end()) );
        }

        list.remove( list.size() -1);

        for (String s : list){
            stringBuilder.append(s + " ");
        }

        return stringBuilder.toString().trim();
    }

    public static String addSpaces( String str ){
        return str.replaceAll("\\s", "  ");
    }

    public static Boolean isPalindrome( String str ){

        StringBuilder stringBuilder = new StringBuilder(str);
        String reversed = stringBuilder.reverse().toString();
        return str.equals(reversed);
    }

    public static String replaceSubstring( String str, String instead, String insert ){
        return str.replaceAll( instead, insert);
    }

    public static String removeWords( String str, int wordLength ){

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<>();

        while (matcher.find()) {

            String s = str.substring(matcher.start(), matcher.end());

            if( s.length() != wordLength ) list.add(s);
        }

        for (String s : list){
            stringBuilder.append(s + " ");
        }

        return stringBuilder.toString().trim();
    }

    public static String removeExtraSpaces( String str ){
        return str.replaceAll("\\s+", " ");
    }

}