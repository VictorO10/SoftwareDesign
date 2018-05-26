package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.ProductDAO;
import com.winterShop.repository.model.product.Product;
import com.winterShop.service.contracts.product.ProductService;
import com.winterShop.service.model.product.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    private ModelMapper modelMapper;

    public ProductServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = productDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<ProductDTO>>() {}.getType();

        List<ProductDTO> productDTOList = modelMapper.map(productList, targetListType);

        return productDTOList;
    }

    @Override
    public ProductDTO getById(Long aLong) {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO entity) {
        Product product = new Product();

        modelMapper.map(entity, product);

        product = productDAO.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO entity) {
        return modelMapper.map(productDAO.save(modelMapper.map(entity, Product.class)), ProductDTO.class);
    }

    @Override
    public void delete(Long aLong) {
        productDAO.deleteById(aLong);
    }
}
