package studio.thinkground.testproject.data.dao;

import studio.thinkground.testproject.data.entity.ProductEntity;

import java.util.Optional;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);

}
