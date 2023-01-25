package com.hornosg.hexagonaldddexample.customers.infrastructure.persistence;

import com.hornosg.hexagonaldddexample.customers.domain.Customer;
import com.hornosg.hexagonaldddexample.customers.domain.CustomerRepository;
import com.hornosg.hexagonaldddexample.customers.domain.vo.CustomerId;
import com.hornosg.hexagonaldddexample.shared.infrastructure.MongoRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;


public class CustomerMongoRepository extends MongoRepository implements CustomerRepository {
    private static final CustomerMongoSerialization serialization = new CustomerMongoSerialization();

    @Override
    public void save(Customer customer) {
        MongoClient mongoClient = getClient();
        mongoClient.startSession();
        MongoCollection<Document> collection = getCollection(mongoClient, "whitelabel_customers", "customers");

        InsertOneResult result = collection.insertOne(serialization.customerToDocument(customer));
        mongoClient.close();
    }

    @Override
    public Customer find(CustomerId id) {
        MongoClient mongoClient = getClient();
        mongoClient.startSession();
        MongoCollection<Document> collection = getCollection(mongoClient, "db_customers_example", "customers");

        Bson projectionFields = Projections.fields(
            Projections.include("name", "surname", "email", "address", "phone"));
        Document document = collection.find(eq("_id", id.getValue()))
            .projection(projectionFields)
            .first();

        if (document == null) {
            System.out.println("No results found.");
            return null;
        }

        System.out.println(document.toJson());
        mongoClient.close();

        return serialization.documentToCustomer(document);
    }

    @Override
    public void delete(CustomerId id) {
        MongoClient mongoClient = getClient();
        mongoClient.startSession();
        MongoCollection<Document> collection = getCollection(mongoClient, "whitelabel_customers", "customers");

        collection.deleteOne(new Document("_id", id.getValue()));
        mongoClient.close();
    }
}
