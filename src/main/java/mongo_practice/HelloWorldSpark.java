package mongo_practice;

import spark.Spark;

public class HelloWorldSpark {
	public static void main(String[] args) {
        Spark.get("/", (req, res) -> "Hello World");
    }
}
