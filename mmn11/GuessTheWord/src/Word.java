/**
 * This class represents the word that was chosen for particular game round
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 04/11/2021
 */

public class Word
{
    // instance variables
    private char[] _word;
    private char[] _wordBlank;             //the word with open letters which user was guessing right
    private boolean[] _wordLetters;        //array of ABC, true if the word contains the letter ('a'=0, 'z'=25)
    private boolean _gameFinished = false; //true when word guessed

    //constructors
    /**
     * Constructs a random word from the vocabulary
     */
    public Word()
    {
        String temp = Vocabulary.getRandomWord();
        _word = new char[temp.length()];
        _wordBlank = new char[temp.length()];
        _wordLetters = new boolean[Vocabulary.ABC];

        //filling the instance variables according chosen word
        for(int i=0; i<temp.length(); i++)
        {
            this._word[i] = temp.charAt(i);
            this._wordBlank[i] = '_';
            this._wordLetters[_word[i]-'a'] = true;
        }
    } //end of empty constructor

    /**
     * Returns the hidden word including the guessed letters
     * @return the hidden word including the guessed letters
     */
    public String getWordBlank(){
        return new String(_wordBlank);
    }

    /**
     * Returns a status of the game (true if the word was guessed, otherwise - false)
     * @return true when the word was guessed, otherwise - false
     */
    public boolean isGameFinished() {
        return _gameFinished;
    } //end of method isGameFinished

    /**
     * Checks if user guess was right. If guess is right, than fill the word blank and return true.
     * @param guess - the character received from the user
     * @return true if the word contains the given character, otherwise false
     */
    public boolean isWordLetter(char guess) {
        boolean res = false;
        if(_wordLetters[guess-'a']) {     //checks if the word contains the given letter
                res = true;
                fillWordBlank(guess);
        }
        return res;
    } //end of method isWordLetter

    //Puts the guessed letter into the hidden word
    private void fillWordBlank(char letter) {
        boolean isUnderscore = false;
        for(int i = 0; i< _word.length; i++){   //looking for a place of the letter in the word
            if(_word[i] == letter){
                _wordBlank[i] = letter;
            }
            if(_wordBlank[i] == '_'){   //checks if there are still unguessed letters
                isUnderscore = true;
            }
        }

        if(!isUnderscore){      //checks if the word was guessed
            this._gameFinished = true;
        }
    } //end of method fillWordBlank
} //end of class Word
