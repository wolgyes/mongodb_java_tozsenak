package Mongo;

import com.mongodb.client.*;
import org.bson.Document;

import org.json.*;


public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

}

class App{
    Database db;


    public App(){
        try{
            this.db = new Database("Project");

        }
        catch (Exception e){
            System.out.println("Hiba:"+ e.getMessage());
        }
    }
    void get_collection(){
        MongoCollection<Document> collection = this.db.database.getCollection("Products");
        Document doc = collection.find().first();
        JSONObject data = new JSONObject(doc);
        for (Object varos: data.getJSONArray("Hungary")) {
            System.out.println(varos);
            break;
        }
        System.out.println(data.getJSONArray("Hungary").get(0));

        System.out.println();

        MongoCollection<Document> collection2 = this.db.database.getCollection("cica");
        Document doc2 = collection2.find().first();
        JSONObject data2 = new JSONObject(doc2);
        for (Object item: data2.getJSONObject("menu").getJSONArray("items")){
            if (!item.equals(null)){
                JSONObject item_json = new JSONObject(item.toString());
                System.out.println(item_json.get("id"));
            }
        }



        // sor => { key:value, key:value,
    }
    void run(){
        this.get_collection();
    }
}