package com.localcode.vesty.store.product.service;

import com.localcode.vesty.shared.utility.GenericAssembler;
import com.localcode.vesty.store.product.ProductEntity;
import com.localcode.vesty.store.product.ProductRepository;
import com.localcode.vesty.store.product.dto.ProductDTO;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final GenericAssembler assembler;
    private final ProductRepository repository;

    @Override
    public List<ProductDTO> findAll(ProductFilterDTO filter) {
        Specification<ProductEntity> specification = ProductSpecs.mountPredicates(filter);
        List<ProductEntity> entities = repository.findAll(specification);
        return assembler.toCollectionModel(entities, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> findPageable(ProductFilterDTO filter) {
        Specification<ProductEntity> specification = ProductSpecs.mountPredicates(filter);
        Page<ProductEntity> page = repository.findAll(specification, filter.getPageable());
        return assembler.toPageModel(page, ProductDTO.class);
    }

    @Override
    public ProductDTO findModelById(Long id) {
        return assembler.toModel(findEntityById(id), ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        ProductEntity entity = assembler.toModel(product, ProductEntity.class);
        return assembler.toModel(repository.save(entity), ProductDTO.class);
    }

    @Override
    public ProductDTO edit(Long id, ProductDTO product) {
        findEntityById(id);
        ProductEntity entity = assembler.toModel(product, ProductEntity.class);
        return assembler.toModel(repository.save(entity), ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        findEntityById(id);
    }

    private ProductEntity findEntityById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
