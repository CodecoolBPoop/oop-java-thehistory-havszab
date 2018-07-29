package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        for (int i = 0; i<wordsArray.length; i++) {
            if(wordsArray[i] == wordToBeRemoved)
                wordsArray[i] = null;
        }
    }

    @Override
    public int size() {
        int arrSize = wordsArray.length;
        return arrSize;
    }

    @Override
    public void clear() {

    }

    @Override
    public void replaceOneWord(String from, String to) {
        for(String word : wordsArray)
            if (word == from)
                word = to;
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
