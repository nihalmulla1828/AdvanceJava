package com.demo.SpringBootRestWebservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootRestWebservice.beans.Product;
import com.demo.SpringBootRestWebservice.dao.ProductDao;
import com.demo.SpringBootRestWebservice.dto.ProductDto;
import com.demo.SpringBootRestWebservice.mapper.ProductDTOMapper;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductDao pdao;

@Override
public List<ProductDto> getAllProducts() {
	List<Product> plst=pdao.findAll();
	plst.forEach(System.out::println);
	List<ProductDto> plist=plst.stream()
	.map(prod->ProductDTOMapper.mapToProductDto(prod))
	.collect(Collectors.toList());
	return plist;
}

@Override
public boolean addNewProduct(ProductDto pdto) {
	Product p=ProductDTOMapper.mapToProduct(pdto);
	Product p1= pdao.save(p);
	return p1!=null;
}

@Override
public ProductDto getById(int pid) {
	
	Optional<Product> op=pdao.findById(pid);
	if(op.isPresent()) {
		return ProductDTOMapper.mapToProductDto(op.get());
	}else {
		return null;
	}
	
}

@Override
public boolean updateProduct(ProductDto p) {
	Optional<Product> op=pdao.findById(p.getPid());
	if(op.isPresent()) {
		Product p2=op.get();
		p2.setPname(p.getPname());
		p2.setQty(p.getQty());
		p2.setPrice(p.getPrice());
		p2.setExpdate(LocalDate.parse(p.getLdtstr(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		pdao.save(p2);
		return true;
	}
	return false;
}

@Override
public boolean deleteById(int pid) {
	Optional<Product> op=pdao.findById(pid);
	if(op.isPresent()) {
	   pdao.delete(op.get());
	   return true;
	}
	return false;
}

@Override
public List<ProductDto> findByCategory(int cid) {
	List<Product> plst =pdao.getProductsByCid(cid);
	List<ProductDto> plist=plst.stream()
			.map(prod->ProductDTOMapper.mapToProductDto(prod))
			.collect(Collectors.toList());
			return plist;
}
}
