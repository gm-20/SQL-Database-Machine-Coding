package model;

import java.util.HashMap;

public class Database {

    String name;
    HashMap<String,Table> tableMap;

    public Database(String name) {
        this.name = name;
        this.tableMap = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String,Table> getTableMap() {
        return tableMap;
    }

    public void setTableMap(HashMap<String,Table> tableMap) {
        this.tableMap = tableMap;
    }
}
