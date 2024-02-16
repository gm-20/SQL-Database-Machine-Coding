import model.Table;
import model.TableSchema;
import service.DatabaseOps;
import service.DatabaseOpsImpl;

import java.util.HashMap;


public class Driver {


    public static void main(String[] args) {


        DatabaseOps dbOps = new DatabaseOpsImpl();

        dbOps.createDB("gama");

        Table table = new Table("table-1",new TableSchema(
           new HashMap<String,String>() {{
               put("name","string");
               put("age","int");
           }}
        ));

        dbOps.createTable("gama",table.getName(),table);

        HashMap<String,String> data = new HashMap<>();
        data.put("name","Gaurav");
        data.put("age","22");
        dbOps.createEntry("gama","table-1",new TableSchema(data));

        HashMap<String,String> data2 = new HashMap<>();
        data2.put("name","Saurabh");
        data2.put("age","22");
        dbOps.createEntry("gama","table-1",new TableSchema(data2));

        //dbOps.getEntry("gama","table-1",1);

        //ArrayList<TableSchema> response = dbOps.fetchAllEntries("gama","table-1");

//        for (TableSchema row : response) {
//            row.getHashMap().forEach((k,value) -> {
//                System.out.print(k);
//                System.out.print(" ");
//                System.out.println(value);
//            });
//        }

        dbOps.searchEntry("gama","table-1","name","Gaurav");


    }

}
