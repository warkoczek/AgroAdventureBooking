package com.warkoczewski.AgroAdventureBooking.interview;

public class Palindrome {
    public static void main(String[] args) {
        String text= "ok y o";
        String cleanText = text.replaceAll("\\s+", "");
        System.out.println(cleanText);
        System.out.println(isPalindromeStringBuilder(text));
        System.out.println(isPalindromeWhileLoop(text));
    }

    private static boolean isPalindromeWhileLoop(String text) {
        String cleanString = getCleanString(text);
        int length = cleanString.length();
        int forward = 0;
        int backward = length-1;
        while(backward > forward){
            char forwardChar = cleanString.charAt(forward++);
            char backwardChar = cleanString.charAt(backward--);
            if(forwardChar != backwardChar){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeStringBuilder(String text){
        return getReversedString(text).equals(getCleanString(text));

    }

    private static String getReversedString(String text) {
        char[] cleanTextChars = getCleanString(text).toCharArray();
        StringBuilder reversedText = new StringBuilder();
        for(int i=cleanTextChars.length-1; i>=0; i--){
            reversedText.append(cleanTextChars[i]);
        }
        return reversedText.toString();
    }

    private static String getCleanString(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }


}
