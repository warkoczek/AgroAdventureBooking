package com.warkoczewski.AgroAdventureBooking.interview;

//Task: Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1;
public class UniqueCharacter {

    public static void main(String[] args){

        System.out.println(getCharacter("georatele"));

    }

    public static int getCharacter(String text){

            int[] characters = new int[26];

            if(text == null || text.isEmpty()){
                return -1;
            }

            for(int i=0; i < text.length(); i++){
                characters[text.charAt(i) - 'a']++;
            }

            for(int i=0; i < text.length(); i++){
                if(characters[text.charAt(i) - 'a'] == 1){
                    return i;
                }
            }


        return -1;
    }

    
}
