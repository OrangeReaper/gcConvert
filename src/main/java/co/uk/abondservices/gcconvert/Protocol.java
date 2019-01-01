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
public class Protocol {
    
    public Protocol(Protocols.protocol protocol, WordPair leader, boolean raw){
        this.protocol=protocol;
        this.leader=leader;
        this.raw=raw;
    }
    
    Protocols.protocol protocol;
    WordPair leader;
    boolean raw;

    public static Protocol getUNKNOWN() { return new Protocol(Protocols.protocol.UNKNOWN, new WordPair(0,0), true); }
    
    public Protocols.protocol getProtocol() {
        return protocol;
    }

    public WordPair getLeader() {
        return leader;
    }

    public boolean isRaw() {
        return raw;
    }

    public void setProtocol(Protocols.protocol protocol) {
        this.protocol = protocol;
    }

    public void setLeader(WordPair leader) {
        this.leader = leader;
    }

    public void setRaw(boolean raw) {
        this.raw = raw;
    }
    
    
    
}
