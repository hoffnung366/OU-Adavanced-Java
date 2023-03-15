/**
 * This class represents the vocabulary used for the game "Guess the word"
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 04/11/2021
 */

import java.util.Random;

public final class Vocabulary {
    //class variables
    public static final int ABC = 26;               //number of letters in the alphabet
    private static final String[] _words = {        // nouns in lowercase letters
        "pneumonoultramicroscopicsilicovolcanoconiosis",
        "hippopotomonstrosesquippedaliophobia",
        "supercalifragilisticexpialidocious",
        "pseudopseudohypoparathyroidism",
        "floccinaucinihilipilification",
        "antidisestablishmentarianism",
        "honorificabilitudinitatibus",
        "thyroparathyroidectomized",
        "dichlorodifluoromethane",
        "incomprehensibilities",
        "business",
        "company",
        "country",
        "government",
        "mother",
        "people",
        "place",
        "point",
        "problem",
        "program",
        "question",
        "right",
        "room",
        "school",
        "state",
        "story",
        "student",
        "study",
        "system",
        "thing",
        "time",
        "water",
        "way",
        "week",
        "woman",
        "word",
        "world",
        "year"
    }; // end of variable _words

    /**
     * Returns the random word from the vocabulary
     * @return the random word from the vocabulary
     */
    public static String getRandomWord() {
        Random gen = new Random();
        return _words[gen.nextInt(_words.length)];
    } //end of method getRandomWord
} //end of class Vocabulary
