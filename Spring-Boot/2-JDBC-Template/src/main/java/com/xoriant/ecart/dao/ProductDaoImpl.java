package com.xoriant.ecart.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.dao.utils.DBQueries;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// fetch all products
	public List<Product> findAll() {
		return jdbcTemplate.query(DBQueries.FIND_ALL_PRODUCTS, (ResultSet rs) -> {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);
				productList.add(product);
			}
			return productList;
		});
	}

	// Find a Product by Product ID
	public Product findById(int productId) {
		return jdbcTemplate.query(DBQueries.FIND_PRODUCT_BY_PRODUCTID, (ResultSet rs) -> {

			if (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();
				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);

				return product;
			}
			return null;
		}, productId);
	}

	// ====================

	// Filter Products by Product Name
	public List<Product> findAllByProductName(String productName) {
		return jdbcTemplate.query(DBQueries.FIND_PRODUCT_BY_PRODUCTNAME, (ResultSet rs) -> {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);
				productList.add(product);
			}
			return productList;
		}, productName);
	}

	// ====================

	// Filter Products by Product Price range (min and max)
	public List<Product> findAllproductByPriceRange(double minPrice, double maxPrice) {
		return jdbcTemplate.query(DBQueries.FILTER_PRODUCTS_BY_MIN_MAX, (ResultSet rs) -> {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);
				productList.add(product);
			}
			return productList;
		}, minPrice, maxPrice);
	}

	// Filter Products by Product Max Price
	public List<Product> findAllproductByMaxPrice(double maxPrice) {
		return jdbcTemplate.query(DBQueries.FILTER_PRICE_MAX_RANGE, (ResultSet rs) -> {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);
				productList.add(product);
			}
			return productList;
		}, maxPrice);
	}

	// Filter Products by Brand name
	public List<Product> findAllProductsByBrandName(String brandName) {
		return jdbcTemplate.query(DBQueries.FILTER_PRODUCTS_By_BRANDNAME, (ResultSet rs) -> {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt("cat_id"));
				category.setCategoryTitle(rs.getString("cat_title"));
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));

				product.setProductId(rs.getInt("product_id"));
				product.setDescription(rs.getString("product_desc"));
				product.setImagePath(rs.getString("product_image"));
				product.setKeywords(rs.getString("product_keywords"));
				product.setPrice(rs.getInt("product_price"));
				product.setQuantity(rs.getInt("product_qty"));
				product.setProductName(rs.getString("product_title"));
				product.setCategory(category);
				product.setBrand(brand);
				productList.add(product);
			}
			return productList;
		}, brandName);
	}
	
	
	// Filter Brands by Category Name
		public List<Product> filterBrandsByCategoryName(String categoryName) {
			return jdbcTemplate.query(DBQueries.FILTER_PRODUCTS_BY_CATEGORYNAME, (ResultSet rs) -> {
				List<Product> productList = new ArrayList<Product>();
				while (rs.next()) {
					Product product = new Product();
					Category category = new Category();
					Brand brand = new Brand();

					category.setCategoryId(rs.getInt("cat_id"));
					category.setCategoryTitle(rs.getString("cat_title"));
					brand.setBrandId(rs.getInt("brand_id"));
					brand.setBrandTitle(rs.getString("brand_title"));

					product.setProductId(rs.getInt("product_id"));
					product.setDescription(rs.getString("product_desc"));
					product.setImagePath(rs.getString("product_image"));
					product.setKeywords(rs.getString("product_keywords"));
					product.setPrice(rs.getInt("product_price"));
					product.setQuantity(rs.getInt("product_qty"));
					product.setProductName(rs.getString("product_title"));
					product.setCategory(category);
					product.setBrand(brand);
					productList.add(product);
				}
				return productList;
			}, categoryName);
		}

}
