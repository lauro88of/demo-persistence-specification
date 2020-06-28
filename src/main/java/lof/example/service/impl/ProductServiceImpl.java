package lof.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import lof.example.modal.Product;
import lof.example.repository.ProductRepository;
import lof.example.service.ProductService;
import lof.specification.OperationsCriteria;
import lof.specification.SpecificationService;
import lof.specification.SpecificationsBuilder;

@Service
public class ProductServiceImpl extends SpecificationService<Product> implements ProductService {

	@Autowired ProductRepository productRepository;

	@Override
	public JpaSpecificationExecutor<Product> getJpaSpecificationExecutor() {
		return productRepository;
	}
	
	
	public Product findOneExample() {
		SpecificationsBuilder<Product> builder = new SpecificationsBuilder<>();
		builder.with("code", OperationsCriteria.EQ, 2020L);
		return findOneBySpecification(builder.build()).orElse(null);
	}
	public List<Product> findListExample() {
		SpecificationsBuilder<Product> builder = new SpecificationsBuilder<>();
		builder.with("category.name", OperationsCriteria.IN, new String[] {"Mobile", "Clouthes"});
		return findBySpecification(builder.build());
	}
}
