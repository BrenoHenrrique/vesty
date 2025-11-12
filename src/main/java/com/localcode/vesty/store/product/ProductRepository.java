package com.localcode.vesty.store.product;

import com.localcode.vesty.shared.utils.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Long> {
}
