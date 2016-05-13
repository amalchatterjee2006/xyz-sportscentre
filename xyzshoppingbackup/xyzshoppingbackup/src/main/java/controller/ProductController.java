package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import model.Product;
import model.reg;
import dao.ProductDaoImpl;
import dao.ProductServiceImpl;

	@Controller
	public class ProductController 
	{
		@Autowired
		private ProductServiceImpl productService1;



				@RequestMapping("/")
				public String indexpage() 
				{
					return "index";
				}
				
				//for opening the details page about the product
		         @RequestMapping("/pdetails")
		          public String productdetails() 
		         {
		        	 return "pdetails";
		         }
		
		         @RequestMapping("/back")
		         public String bactphome() 
		         {
		        	 return "index";
		         }

                  //for spring security		
	             @RequestMapping("/login")
		          public String showHome1()
		          {
			         return "login";
		          }
		
		           @RequestMapping("/error")
		            public String showHome2()
		            {
			           return "error";
		            }


                   //for registration page
		            @RequestMapping("/regis")
	              	public String registrationpage() 
		           {
			            return "registration";
		           }

		            @RequestMapping("/product")
		            public String productdetalspage() 
		            {
		            	return "ProductDetails";
		            }


		            @RequestMapping(value = "/persons", method = RequestMethod.GET)
		            public String ListProductDetails(Model model) 
		            {
			        model.addAttribute("person", new Product());
			        model.addAttribute("listProduct", this.productService1.ListProductDetails());
			        return "ProductAdd";
		            }
		
		            @RequestMapping("/pr")		
		            public String ListProductDetails1(Model model) 
		            {
		            	model.addAttribute("person", new Product());
		            	model.addAttribute("listProduct", this.productService1.ListProductDetails());
		            	return "ProductDetails";
		            }
 
                     //For add and update person both
		            @RequestMapping(value= "/person/add", method = RequestMethod.POST)
		            public String AddProductDetails(@ModelAttribute("person") Product p)
		            {
     
		            	if(p.getId() == 0)
		            	{
       
		            		this.productService1.AddProductDetails(p);
		            	}
		            	else
		            	{
        				this.productService1.UpdateProductDetails(p);
		            	}
     
		            	return "redirect:/persons";
     
		            }
 
		            @RequestMapping("/remove/{id}")
		            public String removePerson(@PathVariable("id") int id)
		            {
     
		            	this.productService1.RemoveProductDetails(id);
		            	return "redirect:/persons";
		            }

		            //@RequestMapping("/edit/{id}")
		            /*  public String editPerson(@PathVariable("id") int id, Model model){
    				model.addAttribute("person", this.personService.getPersonById(id));
    				model.addAttribute("listPersons", this.personService.listPersons());
    				return "person";
					}*/

		           //for display of productdetails  added

		            /*		@RequestMapping("productdetails")
					public ModelAndView showProducts()
					{
					ModelAndView mv=new ModelAndView("productdetails");
					List<Product> employeeList=new ArrayList<Product>();
					employeeList=productService1.ListProductDetails();
					mv.addObject("listfromtab",employeeList);
					return mv;
					}*/
		
		
		            //FOR UPLOADING IMAGE
		
		            /*	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	    			public @ResponseBody
					String uploadFileHandler(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) 
	    			{
	 
	            	if (!file.isEmpty()) 
	            	{
	                	try 
	                		{
	                			byte[] bytes = file.getBytes();
	 
	                // Creating the directory to store file
	                				String rootPath = "D://DT-TTT/Amal/TTTworkspace/xyzshoppingbackup/xyzshoppingbackup/src/main/webapp/resources/images";
	                				File dir = new File(rootPath + File.separator);
	                				if (!dir.exists())
	                				dir.mkdirs();
	 
	                // Create the file on server
	                				File serverFile = new File(dir.getAbsolutePath()
	                                + File.separator + name+".jpg");
	                				BufferedOutputStream stream = new BufferedOutputStream(
	                				new FileOutputStream(serverFile));
	                				stream.write(bytes);
	                				stream.close();
	 
	                       //logger.info("Server File Location="
	                        //+ serverFile.getAbsolutePath());
	 
	                				return "You successfully uploaded file=" + name;
	                } 
	                	catch (Exception e) 
	                	{
	                		return "You failed to upload " + name + " => " + e.getMessage();
	                	}
	            	} 
	            		else 
	            		{
	            			return "You failed to upload " + name
	            					+ " because the file was empty.";
	            		}
	    			}*/

		            //for new  user
		
		            @RequestMapping("/regnew")
		            public String showRegisterPage(Model m)
		            {
		            	m.addAttribute("user",new reg());
		            	return "regnew";
		            }
		
		            @RequestMapping(value= "/adduser", method = RequestMethod.POST)
		            public String Adduser(@ModelAttribute("regist") reg p,HttpRequest request)
		            {
     
			
		            	productService1.Adduser(p);
		            	return "index";
		            }

		

	}