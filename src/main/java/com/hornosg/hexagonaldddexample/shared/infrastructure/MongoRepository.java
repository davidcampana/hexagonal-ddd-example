package com.hornosg.hexagonaldddexample.shared.infrastructure;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoRepository {
    private static final String uri = "mongodb+srv://<<user>>:<<password>>@clusterX.xxxxxx.mongodb.net/?retryWrites=true&w=majority";

    protected MongoClient getClient()
    {
        return MongoClients.create(uri);
    }

    protected MongoCollection<Document> getCollection(
            MongoClient mongoClient,
            String databaseName,
            String collectionName
    ) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);

        return database.getCollection(collectionName);
    }
}
