package ru.sbt.collections;

import java.util.*;

/**
 * Created by ag on 22.06.2018.
 */
public class SplittedText {
    private String[] allWords;
    private String[] allLines;

    public SplittedText(String text){
        allLines = text.split("\n");
        String textAfterReplace = text.replaceAll("[^a-zA-Zа-яА-Яё]", " ");
        allWords = textAfterReplace.split("\\s+");
    }

    public String[] getAllWords(){
        return allWords;
    }

    public String[] getAllLines(){
        return allLines;
    }

    public String[] getUniqueWords(){
        Set<String> set = new HashSet<>(Arrays.asList(allWords));
        String[] uniqueWords = set.toArray(new String[set.size()]);
        return uniqueWords;
    }

    public String[] getSortedUniqueWords(){
        String[] sortedUniqueWords = this.getUniqueWords();
        Comparator<String> stringComparatorByLength = new SortStringByLength();
        Arrays.sort(sortedUniqueWords, stringComparatorByLength);
        return sortedUniqueWords;
    }

    public HashMap<String, Integer> getWordsWithCount(){
        String[] uniqueWords = this.getUniqueWords();
        int[] counts = new int[uniqueWords.length];

        for (int i = 0; i < uniqueWords.length; i++) {
            for (String s2: allWords) {
                if (uniqueWords[i].equals(s2)){
                    counts[i]++;
                }
            }
        }

        HashMap<String, Integer> uniqueWordsWithCount = new HashMap<>();
        for (int i = 0; i < uniqueWords.length; i++) {
            uniqueWordsWithCount.put(uniqueWords[i], counts[i]);
        }

        return uniqueWordsWithCount;
    }

    public String getLine(int index){
        if (index > 0 && index <= this.getAllLines().length){
            return getAllLines()[index - 1];
        }else {
            return "in this text only " + this.getAllLines().length + "lines";
        }
    }


}
