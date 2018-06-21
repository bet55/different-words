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
        SplittedText splittedText = new SplittedText(text);

        //task 1
        System.out.println("всего слов - " + splittedText.getAllWords().length);
        System.out.println("уникальных слов - " + splittedText.getUniqueWords().length);
        //task 1

        //task 2
        for (String s:splittedText.getSortedUniqueWords()) {
            System.out.println(s);
        }
        //task 2

        //task 3
        HashMap<String, Integer> wordsWithCount = splittedText.getWordsWithCount();
        for (String s: splittedText.getUniqueWords()) {
            System.out.println(s + " - " + wordsWithCount.get(s));
        }
        //task 3

        //task 4
        for (int i = splittedText.getAllLines().length; i > 0; i--) {
            System.out.println(splittedText.getAllLines()[i-1]);
        }
        //task 4

        //task 5

        //task 5

        //task 6
        while (true){
            Scanner scanner = new Scanner(System.in);
            int userChoise = scanner.nextInt();
            System.out.println(splittedText.getLine(userChoise));
        }
        //task 6

    }
}
//java -cp target/col-ex-jar-with-dependencies.jar ru.sbt.collections.Counter1DifferentWords