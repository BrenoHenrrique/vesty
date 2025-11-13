package com.localcode.vesty.store.product.service;

import com.localcode.vesty.shared.builders.SpecificationBuilder;
import com.localcode.vesty.store.product.ProductEntity;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ProductSpecs {
    private ProductSpecs() {
    }

    public static Specification<ProductEntity> mountPredicates(ProductFilterDTO filter) {
        return (root, query, builder) -> {
            SpecificationBuilder<ProductEntity> specification = new SpecificationBuilder<>(root, builder);
            if (Objects.isNull(filter)) {
                return specification.buildEmpty();
            }

            specification.addLike("name", filter.getName());
            specification.addEqual("category", filter.getCategory());
            specification.addEqual("material", filter.getMaterial());
            specification.addEqual("subCategory", filter.getSubCategory());

            return specification.buildWithAnd();
        };
    }
}
