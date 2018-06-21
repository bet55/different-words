package ru.sbt.collections;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Подсчитайте количество различных слов в файле.
 */
public class Counter1DifferentWords {

    public static void main( String[] args ) throws IOException, URISyntaxException {
        InputStream resourceAsStream = Counter1DifferentWords.class.getResourceAsStream("/ru/sbt/collections/VeryBigText.txt");
        String text = IOUtils.toString( resourceAsStream, "UTF8" );
        String textAfterReplace = text.replaceAll("[^a-zA-Zа-яА-Яё]", " ");
        String[] allWords = textAfterReplace.split("\\s+");
        System.out.println("количество слов в тексте = " + allWords.length);

        //task 1
        Set<String> set = new HashSet<>(Arrays.asList(allWords));
        String[] differentWords = set.toArray(new String[set.size()]);
        System.out.println("количество уникальных слов в тексте = " + differentWords.length);
        //task 1

        //task 2
        Comparator<String> stringComparatorByLength = new SortStringByLength();
        Arrays.sort(differentWords, stringComparatorByLength);
        for (String s: differentWords) {
            System.out.println(s);
        }
        //task 2

        //task 3
        int[] counts = new int[differentWords.length];
        for (int i = 0; i < differentWords.length; i++) {
            for (String s2: allWords) {
                if (differentWords[i].equals(s2)){
                    counts[i]++;
                }
            }
        }
        for (int i = 0; i < differentWords.length; i++) {
            System.out.println(differentWords[i] + " - " + counts[i]);
        }
        //task 3

    }
}
//java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.Counter1DifferentWords