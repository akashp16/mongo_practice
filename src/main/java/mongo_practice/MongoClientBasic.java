package mongo_practice;

import java.util.Collections;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;

public class MongoClientBasic {

	public static void main(String args []){
		MongoClientOptions clientOptions = MongoClientOptions.builder().build();
		MongoClient client = new MongoClient(new ServerAddress(),clientOptions);
		MongoCollection<Document> mongoCollection = client.getDatabase("test").getCollection("inventory");
		System.out.println(mongoCollection.count());
		
		Document document = new Document().append("name", "Akash").
										   append("address", "dadar");
		
		//mongoCollection.insertOne(document);//
		
		
	}
}
