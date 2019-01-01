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
public class Settings extends Json {
    public Settings(){
        
    }
    
    private List<GCCItem> gccItems=new ArrayList<>();
    private List<GCCRawCode> gccRawCodes=new ArrayList<>();
    private String name="";
    private String path="";
    private String aeps="100";
    private String eps="30";
    private String flags="SPACE_ENC";
    private String toggle="0";
    
    private String bits="32";
    private String gap="1234";
    private String header1="1234";
    private String header2="1234";
    private String one1="1234";
    private String one2="1234";
    private String zero1="1234";
    private String zero2="1234";
    private String ptrail="1234";
    private String frequency="1234";
    
    Protocol protocol=Protocol.getUNKNOWN();

    public Protocol getProtocol() {
        return protocol;
    }

    public String getBits() {
        return bits;
    }

    public String getGap() {
        return gap;
    }

    public String getHeader1() {
        return header1;
    }

    public String getHeader2() {
        return header2;
    }

    public String getOne1() {
        return one1;
    }

    public String getOne2() {
        return one2;
    }

    public String getZero1() {
        return zero1;
    }

    public String getZero2() {
        return zero2;
    }

    public String getPtrail() {
        return ptrail;
    }

    public String getFrequency() {
        return frequency;
    }
    
    
    public String getAeps() {
        return aeps;
    }

    public String getEps() {
        return eps;
    }

    public String getFlags() {
        return flags;
    }

    public String getToggle() {
        return toggle;
    }
    
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
    
    public List<GCCItem> getGccItems() {
        return gccItems;
    }

    public List<GCCRawCode> getGccRawCodes() {
        return gccRawCodes;
    }

    public void setGccItems(List<GCCItem> gccItems) {
        this.gccItems = gccItems;
    }

    public void setGccRawCodes(List<GCCRawCode> gccRawCodes) {
        this.gccRawCodes = gccRawCodes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAeps(String aeps) {
        this.aeps = aeps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public void setToggle(String toggle) {
        this.toggle = toggle;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public void setOne1(String one1) {
        this.one1 = one1;
    }

    public void setOne2(String one2) {
        this.one2 = one2;
    }

    public void setZero1(String zero1) {
        this.zero1 = zero1;
    }

    public void setZero2(String zero2) {
        this.zero2 = zero2;
    }

    public void setPtrail(String ptrail) {
        this.ptrail = ptrail;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
    
    
}
