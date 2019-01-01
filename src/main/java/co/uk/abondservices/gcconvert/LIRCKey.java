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

import java.util.List;

/**
 *
 * @author andy
 */
public class LIRCKey {
    // Extracted from GlobalCache File
    private int bits;
    private WordPair header=null;
    private WordPair one;
    private WordPair zero;
    private int ptrail;
    private int gap=-1;
    private String function;
    private List<String> hexCodes;
    private int frequency;
    private boolean hasPreData=false;
    private int preDataBits=0;
    private String preData;
    private String connectorAddress;
    private String id;
    private int repeat=1;
    private int offset=1;
           
    
    public boolean hasHeader() {return (header!=null);}
    public boolean hasGap() {return (gap!=-1);}
    public boolean isZero(WordPair wordPair) {
        return (UTIL.isWithinTolerance(UTIL.getPeriod(wordPair.getWord1(), frequency), UTIL.getPeriod(zero.getWord1(), frequency),
                Tolerances.isZeroTolerance) &&
                UTIL.isWithinTolerance(UTIL.getPeriod(wordPair.getWord2(), frequency), UTIL.getPeriod(zero.getWord2(), frequency), 
                Tolerances.isZeroTolerance));
    }

    public String getConnectorAddress() {
        return connectorAddress;
    }

    public String getId() {
        return id;
    }

    public int getRepeat() {
        return repeat;
    }

    public int getOffset() {
        return offset;
    }

    public int getPeriod(int gccRawValue){
        return UTIL.getPeriod(gccRawValue, frequency);
    }

    public boolean isHasPreData() {
        return hasPreData;
    }

    public int getPreDataBits() {
        return preDataBits;
    }

    public String getPreData() {
        return preData;
    }
    
    
    public int getBits() {
        return bits;
    }

    public WordPair getHeader() {
        return header;
    }

    public WordPair getOne() {
        return one;
    }

    public WordPair getZero() {
        return zero;
    }

    public int getPtrail() {
        return ptrail;
    }

    public int getGap() {
        return gap;
    }

    public String getFunction() {
        return function;
    }

    public List<String> getHexCodes() {
        return hexCodes;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setConnectorAddress(String connectorAddress) {
        this.connectorAddress = connectorAddress;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public void setHeader(WordPair header) {
        this.header = header;
    }

    public void setOne(WordPair one) {
        this.one = one;
    }

    public void setZero(WordPair zero) {
        this.zero = zero;
    }

    public void setPtrail(int ptrail) {
        this.ptrail = ptrail;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setHexCodes(List<String> hexCodes) {
        this.hexCodes = hexCodes;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setHasPreData(boolean hasPreData) {
        this.hasPreData = hasPreData;
    }

    public void setPreDataBits(int preDataBits) {
        this.preDataBits = preDataBits;
    }

    public void setPreData(String preData) {
        this.preData = preData;
    }
    
    
    
}
