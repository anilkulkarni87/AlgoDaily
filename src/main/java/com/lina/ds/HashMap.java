package com.lina.ds;

import java.util.ArrayList;

public class HashMap {
    static class Entry{
        public final String key;
        public Object val;

        Entry(String key, Object val) {
            this.key = key;
            this.val = val;
        }
    }

    private ArrayList<Entry>[] storage;

    public HashMap(){
        this.storage = new ArrayList[16];
    }

    private int hashStr(String str){
        int finalHash = 0;
        for(int i=0;i<str.length(); i++){
            final int charCode = str.charAt(i);
            finalHash += charCode;
        }
        return finalHash;
    }

    public void set(String key, Object val){
        int idx = hashStr(key)%16;
        if(this.storage[idx] == null){
            this.storage[idx] = new ArrayList<Entry>();
        }
        this.storage[idx].add(new Entry(key, val));
    }

    public Object get(String key){
        int idx = hashStr(key)%16;

        if(this.storage[idx] != null){
            for(Entry entry : this.storage[idx]){
                if(entry.key == key){
                    return entry.val;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        System.out.println(map.get("Anil"));
        map.set("Anil","NAME");
        map.set("linA","NAME");
        map.set("Second Entry","SECOND");
        System.out.println(map.get("Second Entry"));

    }
}
