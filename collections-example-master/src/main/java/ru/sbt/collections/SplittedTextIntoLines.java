package ru.sbt.collections;

import java.util.Iterator;

/**
 * Created by ag on 22.06.2018.
 */
public class SplittedTextIntoLines implements Iterable {
    private String[] allLines;

    public SplittedTextIntoLines(String text){
        allLines = text.split("\n");
    }

    public String[] getAllLines(){
        return allLines;
    }

    public String getLine(int index){
        if (index > 0 && index <= this.getAllLines().length){
            return getAllLines()[index - 1];
        }else {
            return "in this text only " + this.getAllLines().length + "lines";
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = allLines.length;

            @Override
            public boolean hasNext() {
                return (cursor != 0);
            }

            @Override
            public Object next() {
                return allLines[--cursor];
            }
        };
    }
}
