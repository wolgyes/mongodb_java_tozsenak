package Mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    String database_str;
    ConnectionString connectionString;
    MongoClientSettings settings;
    MongoClient mongoClient;
    MongoDatabase database;
    Logger belog = Logger.getLogger("org.mongodb.driver");

    Database(String database_str) {
        this.database_str = database_str;
        this.connectionString = new ConnectionString("yourmongodblink" + database_str + "?retryWrites=true&w=majority");
        this.settings = MongoClientSettings.builder().applyConnectionString(this.connectionString).serverApi(ServerApi.builder().version(ServerApiVersion.V1).build()).build();
        this.mongoClient = MongoClients.create(this.settings);
        this.database = mongoClient.getDatabase(database_str);
        this.belog.setLevel(Level.SEVERE);
    }
}
