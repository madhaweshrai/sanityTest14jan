//package dbMongo;
//package com.DB.Mongo;
//
//import java.net.UnknownHostException;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.Mongo;
//import com.mongodb.MongoException;
//
//public class MongoConnection2 {
//	public static void main(String[] args) {
//
//	    try {
//
//		Mongo mongo = new Mongo("localhost", 27017);
//		DB db = mongo.getDB("testdb");
//
//		boolean auth = db.authenticate("qatest1", "qatest@123".toCharArray());
//		if (auth) {
//
//			DBCollection table = db.getCollection("user");
//
//			BasicDBObject document = new BasicDBObject();
//			document.put("name", "mkyong");
//			table.insert(document);
//
//			System.out.println("Login is successful!");
//		} else {
//			System.out.println("Login is failed!");
//		}
//		System.out.println("Done");
//
//	    } catch (UnknownHostException e) {
//		e.printStackTrace();
//	    } catch (MongoException e) {
//		e.printStackTrace();
//	    }
//	  }
//}
