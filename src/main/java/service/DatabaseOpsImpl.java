package service;

import model.Database;
import model.Table;
import model.TableSchema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DatabaseOpsImpl implements DatabaseOps {

    HashMap<String, Database> databaseMap;


    public DatabaseOpsImpl() {
        databaseMap = new HashMap<>();
    }

    @Override
    public void createDB(String name) {

        if (databaseMap.containsKey(name)) {
            throw new RuntimeException("Name already present.");
        } else {
            databaseMap.put(name,new Database(name));
        }



    }

    @Override
    public void createTable(String dbName, String tableName, Table schema) {

        if (databaseMap.get(dbName) == null) {
            throw new RuntimeException("Db not found.");
        } else {
            Database db = databaseMap.get(dbName);

            //Table Name Check
            if (db.getTableMap().containsKey(tableName)) {
                throw new RuntimeException("Table name already present.");
            } else {

                HashMap<String,Table> existingTableMap = db.getTableMap();
                existingTableMap.put(tableName,schema);

            }

        }
    }

    @Override
    public void removeTable(String dbName, String tableName) {

        if (databaseMap.get(dbName) == null) {
            throw new RuntimeException("Db not found.");
        } else {

            Database db = databaseMap.get(dbName);

            if (db.getTableMap().containsKey(tableName)) {

                db.getTableMap().remove(tableName);

                System.out.println("Table Deleted");

            } else {
                throw new RuntimeException("Table name not present.");
            }

        }

    }

    @Override
    public void createEntry(String dbName, String tableName, TableSchema data) {

        Database db = databaseMap.get(dbName);

        Table table = db.getTableMap().get(tableName);

        HashMap<Integer,TableSchema> existingRows = table.getRows();

        //Schema Check
        TableSchema tableSchema = table.getSchema();

        if (!tableSchema.getHashMap().keySet().equals(data.getHashMap().keySet()))
            throw new RuntimeException("Schema donot match");

        existingRows.put(existingRows.size() + 1, data);

    }

    @Override
    public void getEntry(String dbName, String tableName, Integer key) {

        if (databaseMap.get(dbName) == null) {
            throw new RuntimeException("Db not found.");
        } else {

            Database db = databaseMap.get(dbName);

            if (db.getTableMap().containsKey(tableName)) {
                Table table = db.getTableMap().get(tableName);
                TableSchema row = table.getRows().get(key);

                row.getHashMap().forEach((k,value) -> {
                    System.out.print(k);
                    System.out.print(" ");
                    System.out.println(value);
                });

            } else {
                throw new RuntimeException("Table not found.");
            }
        }

    }

    @Override
    public ArrayList<TableSchema> fetchAllEntries(String dbName, String tableName) {

        if (databaseMap.get(dbName) == null) {
            throw new RuntimeException("Db not found.");
        } else {
            Database db = databaseMap.get(dbName);

            if (db.getTableMap().containsKey(tableName)) {

                HashMap<Integer,TableSchema> rows = db.getTableMap().get(tableName).getRows();

                ArrayList<TableSchema> data = new ArrayList<>();

                for (Map.Entry<Integer,TableSchema> s : rows.entrySet()) {
                    data.add(s.getValue());
                }

                return data;

            } else {
                throw new RuntimeException("Table not found.");
            }

        }

    }

    @Override
    public TableSchema searchEntry(String dbName, String tableName, String column, String searchValue) {

        if (databaseMap.get(dbName) == null) {
            throw new RuntimeException("Db not found.");
        } else {
            Database db = databaseMap.get(dbName);

            if (db.getTableMap().containsKey(tableName)) {

                HashMap<Integer,TableSchema> rows = db.getTableMap().get(tableName).getRows();

                for (Map.Entry<Integer,TableSchema> row : rows.entrySet()) {

                    if(row.getValue().getHashMap().containsKey(column)) {

                        if(row.getValue().getHashMap().get(column).equals(searchValue)) {

                            row.getValue().getHashMap().forEach((k,value) -> {
                                System.out.print(k);
                                System.out.print(" ");
                                System.out.println(value);
                            });

                        }

                    }

                }

            }
        }


        return null;
    }
}
