package demo.repository;

import org.springframework.data.repository.CrudRepository;
import demo.domain.Shop;

public interface ShopRepository extends CrudRepository<Shop, Long> {


}
