package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.ProductWCharsDAO;
import com.winterShop.repository.model.product.ProductWChars;
import com.winterShop.service.contracts.product.ProductWCharsService;
import com.winterShop.service.model.product.ProductWCharsDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductWCharsServiceImpl implements ProductWCharsService {

    @Autowired
    ProductWCharsDAO productWCharsDAO;

    private ModelMapper modelMapper;

    public ProductWCharsServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ProductWCharsDTO> getAll() {
        List<ProductWChars> productWCharsList = productWCharsDAO.findAll();

        List<ProductWCharsDTO> productWCharsDTOList = new ArrayList<>();

        for(ProductWChars p: productWCharsList) {
            productWCharsDTOList.add(modelMapper.map(p, ProductWCharsDTO.class));
        }

        return productWCharsDTOList;
    }

    @Override
    public List<ProductWCharsDTO> getAll(String category) {
        List<ProductWChars> productWCharsList = productWCharsDAO.findAll();

        List<ProductWCharsDTO> productWCharsDTOList = new ArrayList<>();

        for(ProductWChars p: productWCharsList) {
            System.out.println(p.getProduct().getCategory().getCategory());
            if(p.getProduct().getCategory().getCategory().equals(category))
                productWCharsDTOList.add(modelMapper.map(p, ProductWCharsDTO.class));
        }

        return productWCharsDTOList;
    }


    @Override
    public ProductWCharsDTO getById(Long aLong) {

        ProductWChars productWChars = productWCharsDAO.findById(aLong).get();
        ProductWCharsDTO productWCharsDTO = modelMapper.map(productWChars, ProductWCharsDTO.class);
        return productWCharsDTO;
    }

    @Override
    public ProductWCharsDTO save(ProductWCharsDTO entity) {

        ProductWChars productWChars = new ProductWChars();

        modelMapper.map(entity, productWChars);

        if(entity.getProductDTO().getCategoryDTO().getCategory().equals("snowboard")) {
            productWChars.setSnowboardBootsCharacteristics(null);
        }
        if(entity.getProductDTO().getCategoryDTO().getCategory().equals("snowboardBoots")) {
            productWChars.setSnowboardCharacteristics(null);
        }


        productWChars = productWCharsDAO.save(productWChars);

        return modelMapper.map(productWChars, ProductWCharsDTO.class);
    }

    @Override
    public ProductWCharsDTO update(ProductWCharsDTO entity) {
        return modelMapper.map(productWCharsDAO.save(modelMapper.map(entity, ProductWChars.class)), ProductWCharsDTO.class);
    }

    @Override
    public ProductWCharsDTO updateImgAndStock(Long id, ProductWCharsDTO entity) {

        //we only want to update the stock and the image, the rest will stay the same
        ProductWCharsDTO productWCharsDTO = getById(id);
        System.out.println(productWCharsDTO);

        productWCharsDTO.setImage(entity.getImage());
        productWCharsDTO.setStock(entity.getStock());

        ProductWChars productWChars = new ProductWChars();
        modelMapper.map(productWCharsDTO, productWChars);
        //null fields get instantiated by the model mapper.. set them back to null
        if(productWCharsDTO.getProductDTO().getCategoryDTO().getCategory().equals("snowboard")) {
            productWChars.setSnowboardBootsCharacteristics(null);
        }
        if(productWCharsDTO.getProductDTO().getCategoryDTO().getCategory().equals("snowboardBoots")) {
            productWChars.setSnowboardCharacteristics(null);
        }

        return modelMapper.map(productWCharsDAO.save(productWChars), ProductWCharsDTO.class);
    }

    @Override
    public List<ProductWCharsDTO> findByProduct_productId(Long productId) {
        List<ProductWChars> productWCharsList = productWCharsDAO.findByProduct_productId(productId);

        List<ProductWCharsDTO> productWCharsDTOList = new ArrayList<>();

        for(ProductWChars p: productWCharsList) {
            productWCharsDTOList.add(modelMapper.map(p, ProductWCharsDTO.class));
        }

        return productWCharsDTOList;
    }

    @Override
    public void delete(Long aLong) {

        productWCharsDAO.deleteById(aLong);

    }
}
