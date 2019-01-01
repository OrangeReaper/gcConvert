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
import com.opencsv.bean.CsvBindByName;

/**
 * function, code1, hexcode1, code2, hexcode2
 * @author andy
 */
public class GCCItem {
    // Constructors
    public GCCItem(){
        
    }
    
    @CsvBindByName(column = "function", required = true)
    private String function;
    public String getFunction() {return function;}
    public void setFunction(String function) {this.function=function;}

    @CsvBindByName(column = "code1", required = true)
    private String code1;
    public String getCode1() {return code1;}
    public void setCode1(String code1) {this.code1=code1;}

    @CsvBindByName(column = "hexcode1")
    private String hexcode1;
    public String getHexcode1() {return hexcode1;}
    public void setHexcode1(String hexcode1) {this.hexcode1=hexcode1;}

    @CsvBindByName(column = "code2")
    private String code2;
    public String getCode2() {return code2;}
    public void setCode2(String code2) {this.code2=code2;}
    
    @CsvBindByName(column = "hexcode2")
    private String hexcode2;
    public String getHexcode2() {return hexcode2;}
    public void setHexcode2(String hexcode2) {this.hexcode2=hexcode2;}
    
}
