package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            if (wordsArray[i] == from) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        List<Integer> indicesWhereReplaceBegins = new ArrayList<>();
        for (int wordsArrIdx = 0; wordsArrIdx < wordsArray.length; wordsArrIdx++)
            if (allEquals(wordsArrIdx, fromWords)) {
                indicesWhereReplaceBegins.add(wordsArrIdx);
                wordsArrIdx += fromWords.length - 1;
            }
        String[] destArr = new String[wordsArray.length + (indicesWhereReplaceBegins.size() * (toWords.length - fromWords.length))];
        int idxArrIdx = 0;
        int wordsArrIdx = 0;
        for (int destArrIdx = 0; destArrIdx < destArr.length ; destArrIdx++) {
            if(!(idxArrIdx > indicesWhereReplaceBegins.size()-1) &&
                 wordsArrIdx == indicesWhereReplaceBegins.get(idxArrIdx)) {
                for (int toWordsIdx = 0; toWordsIdx < toWords.length; toWordsIdx++) {
                    destArr[destArrIdx+toWordsIdx] = toWords[toWordsIdx];
                }
                idxArrIdx++;
                destArrIdx += toWords.length-1;
                wordsArrIdx += fromWords.length;
            } else {
                destArr[destArrIdx] = wordsArray[wordsArrIdx];
                wordsArrIdx++;
            }
        }
        wordsArray = destArr;
    }

    private boolean allEquals(int currentIteration, String[] fromWords) {
        if (isEnoughWordsLeft(currentIteration, fromWords) && wordsArray[currentIteration].equals(fromWords[0])) {
            if(fromWords.length == 1)
                return true;
            for (int i = 1; i < fromWords.length; i++)
                if (!(wordsArray[currentIteration + i].equals(fromWords[i]))) return false;
                else if (wordsArray[currentIteration + i].equals(fromWords[i]) && i == fromWords.length - 1)
                    return true;
        }
        return false;
    }

    private boolean isEnoughWordsLeft(int currentIteration, String[] fromWords) {
        return (currentIteration + fromWords.length <= wordsArray.length);
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
