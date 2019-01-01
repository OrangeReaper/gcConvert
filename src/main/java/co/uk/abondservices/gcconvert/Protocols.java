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
 *
 * @author andy
 */
    public class Protocols {
        public enum protocol {
        UNKNOWN, NEC, LG, KASIEKYO, RC6
    }
    
    private static final List<Protocol> protocolTable = new ArrayList<Protocol>() {{
       add(new Protocol(protocol.NEC, new WordPair(9000,4500), false));
       add(new Protocol(protocol.KASIEKYO, new WordPair(3456,1728), false));
        add(new Protocol(protocol.LG, new WordPair(4420,4420), false)); 
        add(new Protocol(protocol.RC6, new WordPair(2667,889), true)); 
    }};
    
    public static Protocol getProtocol(WordPair wordPair, int frequency){
        Protocol result=Protocol.getUNKNOWN();
        WordPair wp=new WordPair(UTIL.getPeriod(wordPair.getWord1(), frequency),
                                 UTIL.getPeriod(wordPair.getWord2(), frequency));
        
        for (Protocol protocol : protocolTable){
            WordPair value=(WordPair) protocol.getLeader();
            if (value.isValue(wp, Tolerances.protocolTolerance)) {
                return protocol;
            }
        }
        return result;
    }    
}
