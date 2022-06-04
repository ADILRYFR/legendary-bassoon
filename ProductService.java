package com.Service;

import java.util.Iterator;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {
	
   ProductDao pd = new ProductDao();
   
   public String addProduct(Product product) {
	   
	   if(product.getPrice()<1000) {
		   return "The price should be greater than 1000";
	   }else if(pd.storeProduct(product)>0) {
		   return "The product details have been added";
	   }else {
		   return "The product was not added";
	   }
	   
   }
   
   public List<Product> getallProductdetails(){
	   List<Product> listofProducts = pd.getAllDetails();
	   Iterator<Product> it = listofProducts.iterator();
	   
	   while(it.hasNext()) {
		   Product p = it.next();
		   p.setPrice(p.getPrice()-200);
		   
	   }
	   return listofProducts;
	   
   }
   
   
	
	

}
