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
 *
 * @author andy
 */
public class UTIL {
    static public int getPeriod(int value, int frequency){
        int periodInUsecs=1000000/frequency;
        return value*periodInUsecs;
    }
    
    static public boolean isWithinTolerance(int value, int compareWith, int tolerance){
        int maxValue=((compareWith*100)+(compareWith*tolerance))/100;
        int minValue=((compareWith*100)-(compareWith*tolerance))/100;
        if (value<minValue) return false;
        if (value>maxValue) return false;
        return true;
    }
}
