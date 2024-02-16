package service;

import model.Table;
import model.TableSchema;

import java.util.ArrayList;

public interface DatabaseOps {

    void createDB(String name);

    void createTable(String dbName, String tableName, Table table);

    void removeTable(String dbName, String tableName);

    void createEntry(String dbName, String tableName, TableSchema data);

    void getEntry(String dbName, String tableName, Integer key);

    ArrayList<TableSchema> fetchAllEntries(String dbName,String tableName);

    TableSchema searchEntry(String dbName, String tableName, String column, String searchValue);

}
