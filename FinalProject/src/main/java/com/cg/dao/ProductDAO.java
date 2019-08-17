package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.bean.Product;

/**
 * @author Tanmay Pathak
 * */
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where category = ?1 and subcategory = ?2")
	public List<Product> getProductsFiltered(String category, String subcategory);
	
	// For getting products in a given range of price
	@Query("from Product  WHERE  category=:category AND price>=:min AND  price<:max")
	public List<Product> getProductsInRange(@Param("category")String category,@Param("min")int min,@Param("max")int max);

	// Sorting by products price in ascending order
	@Query("from Product WHERE  category=:category order by price")
	public List<Product> findByProductCategoryOrderByProductPrice(@Param("category")String category);

	// Sorting by products price in descending order
	@Query("from Product WHERE  category=:category order by price desc")
	public List<Product> findByProductCategoryOrderByProductPriceDesc(@Param("category")String category);

/*	// For getting the most viewed product
	@Query(" from Product WHERE category=:category order by views desc")
	public List<Product> findByproductCategoryOrderByProductViewDesc(@Param("category")String category);
*/
	// For getting the best-seller product
	@Query("from Product WHERE category=:category order by soldQuantities desc")
	public List<Product> findByproductCategoryOrderByProductsSoldDesc(@Param("category")String category);
	
}
