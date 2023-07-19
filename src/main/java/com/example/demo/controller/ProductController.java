package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;

@RestController
public class ProductController {
	private List<Product> data = new ArrayList<Product>();
	@GetMapping("product")
	public List<Product> getProducts(){
		return data;
	}
	@PostMapping("/product")
	public Product aadProduct(@RequestBody Product body) {
		for (int i =0; i <data.size();i++) {
			if(data.get(i).getProductID()==body.getProductID()) {
				return null;
			}
		}
		data.add(body);
		return body;
	}	
	
	@GetMapping("/product/{ProductID}")
	public Product getProductDetail(@PathVariable Integer ProductID) {
		for (int i =0; i <data.size();i++) {
			if(ProductID == data.get(i).getProductID()){
				return data.get(i);		
	}
	}
		return null;
}
	@PutMapping("/product/{ProductID}")
	public Product updatProduct (@PathVariable Integer ProductID,@RequestBody Product body) {
		for (int i =0; i <data.size();i++) {
			if(ProductID == data.get(i).getProductID()){
				data.get(i).setProductID(body.getProductID());
				data.get(i).setProductName(body.getProductName());
				data.get(i).setProductPrice(body.getProductPrice());
				data.get(i).setProductDetail(body.getProductDetail());
				data.get(i).setProductAmount(body.getProductAmount());
				
				return data.get(i);
			}
		
	}
		return null;
	}

	@DeleteMapping("/product/{ProductID}")
	public String deleteProduct(@PathVariable Integer ProductID) {
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getProductID().equals(ProductID)) {
				data.remove(i);
				return null;
			}
		}
		return "delete unsuccessfully";

}
}
