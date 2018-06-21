package ru.sbt.collections;

import java.util.Comparator;

/**
 * Created by ag on 21.06.2018.
 */
class SortStringByLength implements Comparator<String> {
    @Override
    public int compare(String string1, String string2) {
        if(string1.length() > string2.length()){
            return 1;
        }else{
            if(string1.length() < string2.length()){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
