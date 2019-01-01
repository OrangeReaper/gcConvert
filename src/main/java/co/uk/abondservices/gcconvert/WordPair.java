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

/**
 * Wordpair is simply a pair of integers
 *   eg 
 * header       9000  4500
 * one           550  1675
 * zero          550   550
 * 
 * @author andy
 */
public class WordPair {
    //Constructors
    public WordPair(){
        
    }
    public WordPair(int word1, int word2){
        this.word1=word1;
        this.word2=word2;
    }
    
    private int word1=0;
    public int getWord1() {return word1;}
    public void setWord1(int word) { this.word1=word;}
    
    private int word2=0;
    public int getWord2() {return word2;}
    public void setWord2(int word) { this.word2=word;}
    
    public boolean isValue(WordPair wordPair, int tolerance){
        return (UTIL.isWithinTolerance(word1, wordPair.getWord1(), tolerance) &&
                UTIL.isWithinTolerance(word2, wordPair.getWord2(), tolerance));
    }
}
