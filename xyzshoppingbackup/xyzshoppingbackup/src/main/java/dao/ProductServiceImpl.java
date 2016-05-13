package dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.ProductDaoImpl;
import model.Product;
import model.reg;

	@Service
	public class ProductServiceImpl 
	{
			@Autowired
			ProductDaoImpl personService;
			reg r;

				


		 @Transactional
		 public void AddProductDetails(Product p) 
		 {
			 
			 personService.AddProductDetails(p);
		 }
		 
		 @Transactional
		 public void Adduser(reg r) 
		 {
			 
			 personService.Adduser(r);
		 }


		 @Transactional
		 public void   UpdateProductDetails(Product p) 
		 {
			 
			 personService.UpdateProductDetails(p);
		 }	
		 
			
         


		 @Transactional
		 public List<Product> ListProductDetails()
		 {
			 return personService.ListProductDetails(); 
		 }
		 
		 public List<Product> ListProductDetails1()
		 {
			 return personService.ListProductDetails1(); 
		 }




		 @Transactional
		 public void RemoveProductDetails(int id) 
		{
    		personService.RemoveProductDetails(id);
		}

	}