package com.telit.springboot.baseCommon;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.filter.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable> {
    public Long count();

    public long count(Specification<T> sf);

    public long count(Filter... filters);

    public long count(List<Filter> filters);

    public List<T> findAll();

    public List<T> findAll(Sort sort);

    public List<T> findAll(Specification<T> sf);

    public List<T> findAll(Specification<T> sf, Sort sort);

    public Page<T> findAll(Pageable pageable);

    public T findOne(ID ID);

    public T findOne(Specification<T> sf);

    public Page<T> findAll(Specification<T> sf, Pageable pageable);

    public T find(Filter... filters);

    public T find(List<Filter> filters);

    public List<T> findList(Filter... filters);

    public List<T> findList(Filter filter, Sort sort);

    public List<T> findList(Sort sort, Filter... filters);

    public List<T> findList(List<Filter> filters);

    public List<T> findList(List<Filter> filters, Sort sort);

    public Page<T> findList(Filter filter, Pageable pageable);

    public Page<T> findList(Pageable pageable, Filter... filters);

    public Page<T> findList(List<Filter> filters, Pageable pageable);

    public T save(T entity);

    public void save(List<T> list);

    public void save(Iterable<T> iters);

    public T saveAndFlush(T entity);

    public T update(T t);

    public T updateAndFlush(T t);

    public void delete(T entity);

    public void delete(ID id);

    public void delete(Iterable<T> iters);

    public void delete(List<T> list);

    public void deleteAll();

    public void deleteAllInBatch();

    public void deleteInBatch(Iterable<T> iters);

    public Boolean exists(ID ID);

    public void flush();
}
