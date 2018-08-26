package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] splittedStringArr = text.split(" ");
        wordsArray = new String[splittedStringArr.length];
        System.arraycopy(splittedStringArr, 0, wordsArray, 0, splittedStringArr.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        for (int i = 0; i<wordsArray.length; i++) {
            if(wordsArray[i] == wordToBeRemoved)
                //System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
                System.arraycopy(wordsArray, i+1, wordsArray, i,wordsArray.length-1-i);
        }
    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int i = 0; i <= wordsArray.length-1; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        String[] arrPartToCompare = new String[fromWords.length];
        for (int arrIdx = 0; arrIdx <= wordsArray.length - fromWords.length; arrIdx++) {
            System.arraycopy(wordsArray, arrIdx, arrPartToCompare, 0, fromWords.length);
            // Check equality of part of source array and array of words to be replaced
            if(Arrays.equals(fromWords, arrPartToCompare)) {
                //copy end of the Array
                String[] arrEnd = new String[wordsArray.length-arrIdx+1+fromWords.length ];
                System.arraycopy(wordsArray, arrIdx+1+fromWords.length, arrEnd, 0, arrEnd.length);
                }
                //System.out.println(Arrays.toString(wordsArray));for (int replaceIdx = 0; replaceIdx <= fromWords.length-1; replaceIdx++) {
                //wordsArray[replaceIdx+arrIdx] = toWords[replaceIdx];
        }
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
