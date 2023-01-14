package studio.thinkground.testproject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.testproject.data.entity.ProductEntity;

// JpaRepository<ProductRepository, String>
// => jPa repo가 사용할 < 엔티티, 왼쪽 엔티티에서 사용할 primary id값 >
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
