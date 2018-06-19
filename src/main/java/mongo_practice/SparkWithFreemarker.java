package mongo_practice;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkWithFreemarker {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
		Spark.get("/helloFree", (req, res) -> "Hello World");

		Spark.get("/hi", new Route() {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				StringWriter stringWriter = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					Map<String, String> hashMap = new HashMap<>();
					hashMap .put("name", "java");
					helloTemplate.process(hashMap, stringWriter);
					//System.out.println(stringWriter);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return stringWriter;
			}
		});
	}

}
