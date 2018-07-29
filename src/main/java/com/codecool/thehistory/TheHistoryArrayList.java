package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();
    private boolean matchAll = false;

    @Override
    public void add(String text) {
        String[]  wordsOfText = text.split(" ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordsOfText));
        ListIterator<String> wordIterator = words.listIterator();
        while (wordIterator.hasNext()) {
            wordsArrayList.add(wordIterator.next());
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        for (int i = 0; i<wordsArrayList.size(); i++) {
            String currentWord = wordsArrayList.get(i);
            if (currentWord.equals(wordToBeRemoved))
                wordsArrayList.remove(currentWord);
        }
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        int i = 0;
        for (String word : wordsArrayList){
            if(word.equals(from))
                wordsArrayList.set(i, to);
            i++;
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int wordsSize = wordsArrayList.size();
        for (int x=0; x<=wordsSize-1; x++) {
            int wordsRemaining = wordsSize - x;
            matchAll = false;
            if (wordsArrayList.get(x).equals(fromWords[0]) && !(wordsRemaining < fromWords.length)) {
                if(fromWords.length == 1) {
                    matchAll = true;
                } else {
                    for (int i = x+1; i <= x+fromWords.length-1; i++) {
                        if (wordsArrayList.get(i).equals(fromWords[i-x])) {
                            matchAll = true;
                        } else {
                            matchAll = false;
                            break;
                        }
                    }
                }
            }
            if (matchAll) {
                for (int i=0; i<=fromWords.length-1; i++) {
                    wordsArrayList.remove(x);
                }
                for (int i=0; i<=toWords.length-1; i++) {
                    wordsArrayList.add(x+i, toWords[i]);
                }
                wordsSize = wordsArrayList.size();
                x += toWords.length-1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
