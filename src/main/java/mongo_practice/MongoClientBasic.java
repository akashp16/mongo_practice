package mongo_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.BsonField;

import mongo_practice.util.Helper;

public class MongoClientBasic {

	public static void main(String args []){
		MongoClientOptions clientOptions = MongoClientOptions.builder().build();
		MongoClient client = new MongoClient(new ServerAddress(),clientOptions);
		MongoCollection<Document> mongoCollection = client.getDatabase("test").getCollection("inventory");
		System.out.println(mongoCollection.count());
		
		//creating document
		Document document = new Document().append("name", "Akash").
										   append("address", "dadar");
		System.out.println(document.get("name"));
		
		Helper.printJson(document);
		
		//inserting document
		//mongoCollection.insertOne(document);
		//mongoCollection.insertMany(Arrays.asList(document,document1));
		Helper.printJson(document);

		//get operation
		//finding one document
		
		Document doc1 = mongoCollection.find().first();
		System.out.println("finding first document");
		Helper.printJson(doc1);
		
		//finding all documents
		System.out.println("finding all documents");
		List<Document> allDocuments = mongoCollection.find().into(new ArrayList<Document>());
		allDocuments.forEach(Helper::printJson);
		
		//iterating doc using cursor
		System.out.println("iterating doc using cursor");
		MongoCursor<Document> cursor = mongoCollection.find().iterator();
		
		try {
			while (cursor.hasNext()) {
				Document cur = cursor.next();
				Helper.printJson(cur);
			}
		} finally {
			cursor.close();
		}
		
		//applying filter on get
		
		Bson filter = new Document("name","Akash").append("address", "dadar");
		//finding all allFilteredDocuments
		System.out.println("finding all allFilteredDocuments");
		List<Document> allFilteredDocuments = mongoCollection.find(filter).into(new ArrayList<Document>());
		allFilteredDocuments.forEach(Helper::printJson);
	}
}
