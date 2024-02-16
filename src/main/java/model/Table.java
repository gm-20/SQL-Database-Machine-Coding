package model;

import java.util.HashMap;

public class Table {

    String name;
    TableSchema schema;
    HashMap<Integer,TableSchema> rows;

    public Table(String name,TableSchema schema) {
        this.name = name;
        this.schema = schema;
        rows = new HashMap<>();
    }

    public HashMap<Integer, TableSchema> getRows() {
        return rows;
    }

    public void setRows(HashMap<Integer, TableSchema> rows) {
        this.rows = rows;
    }

    public TableSchema getSchema() {
        return schema;
    }

    public void setSchema(TableSchema schema) {
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
