package studio.thinkground.testproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.service.ProductService;
import studio.thinkground.testproject.data.dto.ProductDTO;

@RestController
@RequestMapping("api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productid}")
    public ProductDTO getProduct(@PathVariable String productid){
        long startTime = System.currentTimeMillis();
        LOGGER.info("[productController] perform {} of testproject API", "getProduct");

        ProductDTO productDTO = productService.getProduct(productid);

        LOGGER.info("[productController] Response : : productID = {}, productName = {}," +
                "productPrice = {}, productStock = {}, ResponseTime = {}ms",productDTO.getProductId(),productDTO.getProductName()
        ,productDTO.getProductPrice(), productDTO.getProductStock(), (System.currentTimeMillis()-startTime));

        LOGGER.info("[ProductController] Response : : productId = " + productDTO.getProductId()+" ,");
        return productDTO;
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
