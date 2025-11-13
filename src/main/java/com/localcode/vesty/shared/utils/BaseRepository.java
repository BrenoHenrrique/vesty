package com.localcode.vesty.shared.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, W> extends JpaRepository<T, W>, JpaSpecificationExecutor<T> {
}
