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
import javafx.util.Pair;

/**
 * @author andy
 */
public class BinToHex {
    private static final List<Pair<String, String>> binToHexTable = new ArrayList<Pair<String, String>>() {{
        add(new Pair <> ("0000", "0"));
        add(new Pair <> ("0001", "1"));
        add(new Pair <> ("0010", "2"));
        add(new Pair <> ("0011", "3"));
        add(new Pair <> ("0100", "4"));
        add(new Pair <> ("0101", "5"));
        add(new Pair <> ("0110", "6"));
        add(new Pair <> ("0111", "7"));
        add(new Pair <> ("1000", "8"));
        add(new Pair <> ("1001", "9"));
        add(new Pair <> ("1010", "A"));
        add(new Pair <> ("1011", "B"));
        add(new Pair <> ("1100", "C"));
        add(new Pair <> ("1101", "D"));
        add(new Pair <> ("1110", "E"));
        add(new Pair <> ("1111", "F"));
    }};
    
    public static String convert(String binStr){
        String result="";
        while ((binStr.length() % 4)!= 0){
            binStr="0"+binStr;
        }
        int wordLength=binStr.length()/4; 
        for (int i = 0; i < wordLength; i++) {// For Each Nibble
            String nibble = binStr.substring(i*4, (i*4)+4);
            result=result+getNibble(nibble);
            
        }
        return "0x" + result;
    }
    private static String getNibble(String nibble){
        String result="";
        for (Pair<String,String> pair : binToHexTable){
            if (pair.getKey().equals(nibble)) return pair.getValue();
        }
        return result;
    }
    
    
}
