package model;

import java.util.HashMap;

public class TableSchema {

    HashMap<String,String> hashMap;

    public TableSchema(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }
}
