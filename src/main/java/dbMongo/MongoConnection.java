//package dbMongo;
//package com.DB.Mongo;
//
//import org.testng.Assert;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.MongoClient;
//
//public class MongoConnection {
//	public static void main(String args[]) {
//
//		// Connecting to the mongoDB instance
//		MongoClient mongoClient = new MongoClient("ds047403-a1.mongolab.com", 47403);
//
//		// Selecting the database
//		DB db = mongoClient.getDB("semusi");
//		// qatest@123
//
//		char[] password = new char[] { 'q', 'a', 't', 'e', 's', 't', '@', '1', '2', '3' };
//		
//		boolean authenticated = db.authenticate("qatest1", password);
//
//		if (authenticated) {
//			System.out.println("Successfully logged in to MongoDB!");
//		} else {
//			System.out.println("Invalid username/password");
//		}
//
//	}
//}
