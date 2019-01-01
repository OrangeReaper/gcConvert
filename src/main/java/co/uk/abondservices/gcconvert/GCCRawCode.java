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
public class GCCRawCode {
    //Constructors
    public GCCRawCode(){
        
    }
    public void init(String function, String code){
        lircKey.setFunction(function);
        irSeq.clear();
        String[] codeParts = code.split(",");
        
        String connectorAddress=codeParts[1].trim();
        lircKey.setConnectorAddress(connectorAddress);
        
        String id=codeParts[2].trim();
        lircKey.setId(id);
        
        String strFreq=codeParts[3].trim();
        int frequency=Integer.parseInt(strFreq);
        lircKey.setFrequency(frequency);
        
        String strRepeat=codeParts[4].trim();
        int repeat=Integer.parseInt(strRepeat);
        lircKey.setRepeat(repeat);
        
        String strOffset=codeParts[5].trim();
        int offset=Integer.parseInt(strOffset);
        lircKey.setOffset(offset);
        
        for (int i = 6; i < codeParts.length; i++){         
            irSeq.add(Integer.parseInt(codeParts[i].trim()));
            } 
        
        analyseIRSeq();
    }
    
    
    
    private LIRCKey lircKey=new LIRCKey();
    public LIRCKey getLircKey() { return lircKey; }
    public void setLircKey(LIRCKey lircKey) { this.lircKey = lircKey; }  
    
    //KeyEditor Values...
    //GCC Name is @ lircKey.getFunction()
    private int andyMoteIndex=0;
    private String userDefinedKeyName="";
    private boolean selected=false;

    public boolean isSelected() {
        return selected;
    }

    public int getAndyMoteIndex() {
        return andyMoteIndex;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getUserDefinedKeyName() {
        return userDefinedKeyName;
    }

    public void setAndyMoteIndex(int andyMoteIndex) {
        this.andyMoteIndex = andyMoteIndex;
    }

    public void setUserDefinedKeyName(String userDefinedKeyName) {
        this.userDefinedKeyName = userDefinedKeyName;
    }
    
    
    private List<Integer> irSeq=new ArrayList<>();
    public List<Integer> getIRSeq() {return irSeq;}
    public void setIRSeq(List<Integer> irSeq) {this.irSeq=irSeq;}
    
    private void analyseIRSeq(){

        // build histogram;
        Histogram histogram=new Histogram();
        int onOffPeriods=irSeq.size();
        if (lircKey.getOffset()!=1 ) onOffPeriods=lircKey.getOffset()-1;
        
        for (int i = 0; i < onOffPeriods; i++){
            histogram.add(new WordPair(irSeq.get(i), irSeq.get(i+1)));
            i++;
        }
        //        get largest count in histogram;
        WordPair largestCount=histogram.getLargestCount();
        //        get next largest count in histogram;
        WordPair nextLargestCount=histogram.getNextLargestCount(largestCount);
        
        //        'one' is the largest value of these two;
        lircKey.setOne(getPairAddingUpTo(Math.max(largestCount.getWord1(),nextLargestCount.getWord1())));
        //        'zero' is the smaller value;
        lircKey.setZero(getPairAddingUpTo(Math.min(largestCount.getWord1(),nextLargestCount.getWord1())));
        
        //if irSeq 1st pair is not 'one' or 'zero' then we have a 'header';
        WordPair testHeader=new WordPair(irSeq.get(0),irSeq.get(1));
        if (!pairIsOneOrZero(testHeader)){
          lircKey.setHeader(testHeader);
        }
        
        //if irseq last pair is not 'one' or 'zero' then we have a 'gap';
        if (!pairIsOneOrZero(new WordPair(irSeq.get(onOffPeriods-2),irSeq.get(onOffPeriods-1)))){
            lircKey.setPtrail(irSeq.get(irSeq.size()-2));
            lircKey.setGap(irSeq.get(irSeq.size()-1));
        }
        
        // how many words do we have? is the same as how many times the header appears in the seq
        int wordCount=histogram.getEntry(testHeader).getWord2();
        lircKey.setBits(getBits(wordCount, onOffPeriods));
        
        setHexCodes(wordCount);
        
        
    }
    private WordPair getPairAddingUpTo(int value){
        WordPair result=new WordPair(0,0);
        for (int i = 0; i < irSeq.size(); i++){
            if (UTIL.isWithinTolerance(irSeq.get(i) + irSeq.get(i+1),value,Tolerances.rawCodeTolerance)) {
                return new WordPair(irSeq.get(i),irSeq.get(i+1));
            }
            i++;
        }
        return result;
    }
    private boolean pairIsOneOrZero(WordPair wordPair){
        if (wordPair.isValue(lircKey.getOne(), Tolerances.oneOrZeroTolerance)) return true;
        if (wordPair.isValue(lircKey.getZero(),Tolerances.oneOrZeroTolerance)) return true;
        return false;
    }
    private int getBits(int wordCount, int onOffPeriods){
        int result=onOffPeriods/2;
        if (lircKey.hasHeader()) result=result-wordCount;
        if (lircKey.hasGap()) result=result-wordCount;
        return result/wordCount;
    }
    private void setHexCodes(int wordCount){
        String binaryStr="";
        int ptr=0;
        List<String> hexResult=new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {// For Each Word
                if (lircKey.hasHeader()) ptr=ptr+2; //skip header if there is one
                String binWord="";
                for (int j = 0; j < lircKey.getBits(); j++) {// For Each Bit
                    WordPair nextBit=new WordPair(irSeq.get(ptr),irSeq.get(ptr+1));
                    ptr=ptr+2;
                    if ((lircKey.isZero(nextBit))){
                        binWord=binWord+"0";
                    } else {
                        binWord=binWord+"1";
                    }
                }
                // end of word
                if (lircKey.hasGap()) ptr=ptr+2;
                hexResult.add(BinToHex.convert(binWord));
        }
        
        lircKey.setHexCodes(hexResult);              
    }

}
