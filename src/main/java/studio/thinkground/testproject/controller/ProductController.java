package studio.thinkground.testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.service.ProductService;
import studio.thinkground.testproject.data.dto.ProductDTO;

@RestController
@RequestMapping("api/v1/product-api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productid}")
    public ProductDTO getProduct(@PathVariable String productid){
        return productService.getProduct(productid);
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }
}
