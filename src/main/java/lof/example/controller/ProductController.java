package lof.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lof.example.modal.Category;
import lof.example.modal.Product;
import lof.example.repository.CategoryRepository;
import lof.example.repository.ProductRepository;
import lof.example.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired private ProductService productService;
	
	@Autowired ProductRepository productRepository;
	
	@Autowired CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Product> find(@RequestParam(name = "search")String search) {
		return productService.findBySpecification(search);
	}
	
	@PostConstruct
	private void insert() {
		Category mobileCategory = categoryRepository.save(new Category(10L, "Mobile"));
		Category categoryClothes = categoryRepository.save(new Category(20L, "Clothes"));
		
		Product shitProduct = new Product(2020L, "SHIT", Boolean.TRUE, categoryClothes);
		Product tShitProduct = new Product(2021L, "T-SHIT", Boolean.TRUE, categoryClothes);
		
		Product galaxyProduct = new Product(1021L, "Galaxy S3", Boolean.TRUE, mobileCategory);
		Product motorolaG1Product = new Product(1022L, "Moto G1", Boolean.TRUE, mobileCategory);
		Product motorolaG3Product = new Product(1023L, "Moto G2", Boolean.TRUE, mobileCategory);
		
		
		productRepository.save(shitProduct);
		productRepository.save(tShitProduct);
		productRepository.save(motorolaG1Product);
		productRepository.save(galaxyProduct);
		productRepository.save(motorolaG3Product);
		
	}
}
