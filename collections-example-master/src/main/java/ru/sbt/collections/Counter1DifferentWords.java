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
        SplittedTextIntoWords splittedTextIntoWords = new SplittedTextIntoWords(text);
        SplittedTextIntoLines splittedTextIntoLines = new SplittedTextIntoLines(text);

        //task 1
        System.out.println("всего слов - " + splittedTextIntoWords.getAllWords().length);
        System.out.println("уникальных слов - " + splittedTextIntoWords.getUniqueWords().length);
        //task 1

        //task 2
        for (String s:splittedTextIntoWords.getSortedUniqueWords()) {
            System.out.println(s);
        }
        //task 2

        //task 3
        HashMap<String, Integer> wordsWithCount = splittedTextIntoWords.getWordsWithCount();
        for (String s: splittedTextIntoWords.getUniqueWords()) {
            System.out.println(s + " - " + wordsWithCount.get(s));
        }
        //task 3

        //task 4
        Iterator iteratorForLines = splittedTextIntoLines.iterator();
        while (iteratorForLines.hasNext()){
            System.out.println(iteratorForLines.next());
        }
        //task 4

        //task 5
        //в классе SplittedTextIntoWords итератор для обхода в прямом порядке, в классе SplittedTextIntoLines - в обратном
        //task 5

        //task 6
        while (true){
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            System.out.println(splittedTextIntoLines.getLine(userChoice));
        }
        //task 6

    }
}
//java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.Counter1DifferentWords