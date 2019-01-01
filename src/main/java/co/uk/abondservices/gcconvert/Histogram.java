/*
 * Copyright (C) 2018 Andy Bond
 *
 * This file is part of gcConvert
 *
 * gcConvert is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * Version 3.0 as published by the Free Software Foundation
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package co.uk.abondservices.gcconvert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class Histogram {
    private List<WordPair> array = new ArrayList<>();
    
    public void add(WordPair onOffPair){
        int sum=onOffPair.getWord1()+onOffPair.getWord2();
        if (!arrayContains(sum, true)){
            array.add(new WordPair(sum,1));
        }
        
    }
    private boolean arrayContains(int sum, boolean incrementIfYes){
        for (WordPair wordPair : array){
            if (UTIL.isWithinTolerance(wordPair.getWord1(), sum, Tolerances.histogramTolerance)) {
                if (incrementIfYes){
                    int count=wordPair.getWord2();
                    wordPair.setWord2(++count);
                }
                return true;
            }
        }
        return false;
    }
    public WordPair getLargestCount(){
        WordPair result=new WordPair(0,0);
        for (WordPair wordPair : array){
            if (wordPair.getWord2()>=result.getWord2()){
                result=wordPair;
            }
        }        
        return result;
    }
        public WordPair getNextLargestCount(WordPair largestCount){
        WordPair result=new WordPair(0,0);
        for (WordPair wordPair : array){
            if (wordPair!=largestCount){
                if (wordPair.getWord2()>=result.getWord2()){
                    result=wordPair;
                }
            }
        }        
        return result;
    }
    public WordPair getEntry(WordPair wordPair){
        int sum=wordPair.getWord1()+wordPair.getWord2();
        WordPair result=new WordPair(0,0);
        for (WordPair wordPairH : array){
            if (wordPairH.getWord1()==sum){
                return wordPairH;
            }
        }        
        return result;
    }
    
}
