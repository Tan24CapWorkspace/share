package com.cg.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cg.dao.ProductRepo;
import com.cg.entities.Product;
import com.cg.exceptions.ApplicationException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo dao;
	
	/*
	 * addProduct()	: To add product 
	 * Input : Product object
	 * Output : boolean
	 * Exception : ApplicationException (is Product is already present)
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addProduct(Product product) {
		Optional<Product> temp = dao.findById(product.getId());
		if(!temp.isPresent()) {
			dao.saveAndFlush(product);
			return true;
		}else
			throw new ApplicationException("The Product with ID : "+product.getId()+" already present");
	}


	/*
	 * deleteProduct()	: To delete product 
	 * Input : String id
	 * Output : boolean
	 * Exception : ApplicationException (is Product is not present)
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteProduct(String id) {
		Optional<Product> temp = dao.findById(id);
		if(temp.isPresent()) {
			dao.deleteById(id);
			return true;
		}else
			throw new ApplicationException("The Product with ID : "+id+" not present in database");
	}

	
	/*
	 * getAllProducts()	: To get all product 
	 * Input : void
	 * Output : List<Product>
	 * Exception : ApplicationException (if no Products are present)
	 * */
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		List<Product> list = dao.findAll();
		if(!list.isEmpty()) {
			return list;
		}else
			throw new ApplicationException("No Products present in database");
	}

	/*
	 * findProduct() : To find the product based on its ID 
	 * Input : String id
	 * Output : Product
	 * Exception : ApplicationException (if Products not present)
	 * */
	@Transactional(readOnly=true)
	public Product findProduct(String id) {
		Optional<Product> temp = dao.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}else
			throw new ApplicationException("The Product with ID : "+id+" not present id database");
	}

	
	/*
	 * updateProduct() : To update the product
	 * Input : Product product, String id(i.e product id)
	 * Output : boolean
	 * Exception : ApplicationException
	 * */
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean updateProduct(Product product, String id) {
		if(!id.equals(product.getId())) {
			/*
			 * When given product id mismatch with Product object id.
			 * */
			throw new ApplicationException("Given ID : "+id+" and Product ID : "+product.getId()+" mismatch.");
		}
		Optional<Product> temp = dao.findById(product.getId());
		if(temp.isPresent()) {
			Product pro = temp.get();
			pro.setName(product.getName());
			pro.setModel(product.getModel());
			pro.setPrice(product.getPrice());
			dao.saveAndFlush(pro);
			return true;
		}else
			/*
			 * When given product is not present in database
			 * */
			throw new ApplicationException("The Product with ID : "+product.getId()+" not present id database");
	}
}
