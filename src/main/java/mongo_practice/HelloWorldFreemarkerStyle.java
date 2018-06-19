package mongo_practice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreemarkerStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
		try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter stringWriter = new StringWriter();
			Map<String, String> hashMap = new HashMap<>();
			hashMap .put("name", "java");
			helloTemplate.process(hashMap, stringWriter);
			System.out.println(stringWriter);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
