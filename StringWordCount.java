/**
 * This class has a static method used to count the number of words in a String.
 * 
 * @author Michael Yaworski of http://mikeyaworski.com
 * @version January 22, 2014
 */
public class StringWordCount {

    public static int countWords(String s) {

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
        
            // if the char is a letter, it's a word.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            
            // if char isn't a letter and there have been letters before, wordCount goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                
                // if not an apostrophe, count the word
                if (s.charAt(i) != '\'') {
                    wordCount++;
                    word = false;
                    
                // else if (an apostrophe) AND the letter before was an apostrophe, count the word
                } else if (s.charAt(i-1) == '\'') {
                    wordCount++;
                    word = false;
                }
                
            // last word of String; if it doesn't end with a non letter, it wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}