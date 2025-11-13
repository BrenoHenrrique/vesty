package com.localcode.vesty.shared.builders;

import jakarta.persistence.criteria.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class SpecificationBuilder<T> {
    private final Root<T> root;
    private final CriteriaBuilder builder;
    private final List<Predicate> predicates = new ArrayList<>();

    private Path<?> getPath(String field) {
        String[] part = field.split("\\.");
        Path<?> path = root.get(part[0]);
        for (int i = 1; i < part.length; i++) {
            path = path.get(part[i]);
        }
        return path;
    }

    public SpecificationBuilder<T> addEqual(String field, Object valor) {
        if (valor != null) {
            Path<?> path = field.contains(".") ? getPath(field) : root.get(field);
            predicates.add(builder.equal(path, valor));
        }

        return this;
    }

    public SpecificationBuilder<T> addLike(String field, String valor) {
        if (valor != null) {
            Path<String> path = field.contains(".") ? (Path<String>) getPath(field) : root.get(field);
            predicates.add(builder.like(builder.upper(path), "%" + valor.toUpperCase() + "%"));
        }
        return this;
    }

    public SpecificationBuilder<T> addIn(String field, List<?> valores) {
        if (valores != null && !valores.isEmpty()) {
            Path<?> path = field.contains(".") ? getPath(field) : root.get(field);
            predicates.add(path.in(valores));
        }
        return this;
    }

    public SpecificationBuilder<T> addIsTrue(Expression<Boolean> expressao) {
        if (Objects.isNull(expressao)) {
            return this;
        }
        predicates.add(builder.isTrue(expressao));
        return this;
    }

    public Predicate[] build() {
        return predicates.toArray(new Predicate[0]);
    }

    public Predicate buildWithAnd() {
        return builder.and(this.build());
    }

    public Predicate buildWithOr() {
        return builder.or(this.build());
    }

    public Predicate buildEmpty() {
        return builder.conjunction();
    }
}
