package org.selenium.pom.objects;

import java.io.IOException;

import org.selenium.pom.utils.JacksonUtils;

public class Product {

	// the type and field name[key] must batch in json file and POJO class
	private int id;
	private String name;

	public Product() {

	}

	//constructor to pass productId and fetch the required productName 
	public Product(int id) throws IOException {
		Product[] products = JacksonUtils.deserializeJson("\\resources\\products.json", Product[].class);
		//as the json is array of products , we can iterate thru it and fetch required product
		for (Product product : products) {
			if (product.getId() == id) {
				this.id = id;
				this.name = product.getName();
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
