package filesAndStreamsExercise;

import java.io.*;

public class P04CountCharactersType {
    public static void main(String[] args) {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try(FileReader fr = new FileReader("src/filesAndStreamsExercise/resources/input.txt");
            PrintWriter pw = new PrintWriter(new FileWriter("src/filesAndStreamsExercise/resources/output.txt")))
         {
             int oneSymbol = fr.read();
             while(oneSymbol >= 0) {
                 char symbolAsChar = (char) oneSymbol;

                 if(isVowel(symbolAsChar)) {
                     vowels++;
                 } else if (isPunctuation(symbolAsChar)) {
                     punctuation++;
                 } else if(!Character.isWhitespace(symbolAsChar)){
                     consonants++;
                 }

                 oneSymbol = fr.read();
             }
             pw.printf("Vowels: %d%nOther symbols: %d%nPunctuation: %d", vowels, consonants, punctuation);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isVowel(char character) {
        return character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i';
    }
    public static boolean isPunctuation(char character) {
        return character == '!' || character == ',' || character == '.' || character == '?';
    }
}
