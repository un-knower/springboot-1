package com.telit.springboot.baseCommon;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.*;

public class BaseServiceImpl<T , ID extends Serializable> implements BaseService<T, ID>{

    /** 基类 **/
    private BaseDao<T, ID> baseDao;

    /** 注入 **/
    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    /***** 自定义方法 *******/
    public Long count() {
        return this.baseDao.count();
    }

    public long count(Specification<T> sf) {
        return this.baseDao.count(sf);
    }

    public long count(Filter... filters) {
        return this.baseDao.count(getSpecification(new ArrayList<Filter>(Arrays.asList(filters))));
    }

    public long count(List<Filter> filters) {
        return this.baseDao.count(getSpecification(filters));
    }

    public List<T> findAll() {
        return this.baseDao.findAll();
    }

    public List<T> findAll(Sort sort) {
        return this.baseDao.findAll(sort);
    }


    public List<T> findAll(Specification<T> sf) {
        return baseDao.findAll(sf);
    }

    public List<T> findAll(Specification<T> sf, Sort sort) {
        return baseDao.findAll(sf, sort);
    }

    public T findOne(ID id) {
        return this.baseDao.findOne(id);
    }


    public T findOne(Specification<T> sf) {
        return this.baseDao.findOne(sf);
    }


    public T find(Filter ... filters){
        return this.baseDao.findOne(getSpecification(new ArrayList<Filter>(Arrays.asList(filters))));
    }


    public T find(List<Filter> filters) {
        return this.baseDao.findOne(getSpecification(filters));
    }


    public List<T> findList(Filter ... filters){
        return this.baseDao.findAll(getSpecification(new ArrayList<Filter>(Arrays.asList(filters))));
    }

    public List<T> findList(Filter filter, Sort sort){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(filter);
        return baseDao.findAll(getSpecification(filters), sort);
    }

    public List<T> findList(Sort sort, Filter ... filters){
        return baseDao.findAll(getSpecification(new ArrayList<Filter>(Arrays.asList(filters))), sort);
    }

    public List<T> findList(List<Filter> filters) {
        return baseDao.findAll(getSpecification(filters));
    }


    public List<T> findList(List<Filter> filters, Sort sort) {
        return baseDao.findAll(getSpecification(filters), sort);
    }

    public T save(T entity) {
        return this.baseDao.save(entity);
    }

    @Transactional
    public void save(List<T> list) {
        this.baseDao.save(list);
    }

    public void save(Iterable<T> iters) {
        this.baseDao.save(iters);
    }

    public T saveAndFlush(T entity) {
        return this.baseDao.saveAndFlush(entity);
    }

    public T update(T t) {
        return this.baseDao.save(t);
    }

    public T updateAndFlush(T t) {
        return this.baseDao.saveAndFlush(t);
    }

    public void delete(ID id) {
        this.baseDao.delete(id);
    }

    public void delete(T entity) {
        this.baseDao.delete(entity);
    }

    public void delete(Iterable<T> iters) {
        this.baseDao.delete(iters);
    }

    public void delete(List<T> list) {
        this.baseDao.delete(list);
    }

    public void deleteAll() {
        this.baseDao.deleteAll();
    }

    public void deleteAllInBatch() {
        this.baseDao.deleteAllInBatch();
    }

    public void deleteInBatch(Iterable<T> iters) {
        this.baseDao.deleteInBatch(iters);
    }

    public Boolean exists(ID ID) {
        return this.baseDao.exists(ID);
    }

    public void flush() {
        this.baseDao.flush();
    }

    public Specification<T> getSpecification(final List<Filter> filters){
        Specification<T> spc = new Specification<T>() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                Predicate predicate = null;
                Filter filter = null;
                Object valType;
                Path<?> path;
                List<Predicate> list = new ArrayList<Predicate>();
                for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext();) {
                    filter = iterator.next();
                    if (filter == null || filter.isEmpty()) {
                        continue;
                    }
                    valType = getValueType(filter.getValue());
                    //path = root.get(filter.getProperty());
                    String property = filter.getProperty();
                    if(property.contains(".")){
                        String[] ss = property.split("[.]");
                        if (ss.length==3){
                            path = root.join(ss[0], JoinType.LEFT).join(ss[1], JoinType.LEFT).get(ss[2]);
                        }else {
                            path = root.join(ss[0], JoinType.LEFT).get(ss[1]);
                        }
                    }else {
                        path = root.get(property);
                    }
                    switch (filter.getOperator()) {
                        case eq: {
                            predicate  = cb.equal(path.as(valType.getClass()), filter.getValue());
                            break;
                        }
                        case ne: {
                            predicate  = cb.notEqual(path.as(valType.getClass()), filter.getValue());
                            break;
                        }
                        case gt: {
                            predicate  = cb.greaterThan((Expression<Comparable>) path.as(valType.getClass()), (Comparable) filter.getValue());
                            break;
                        }
                        case lt: {
                            predicate  = cb.lessThan((Expression<Comparable>) path.as(valType.getClass()), (Comparable) filter.getValue());
                            break;
                        }
                        case ge: {
                            predicate  = cb.greaterThanOrEqualTo((Expression<Comparable>) path.as(valType.getClass()), (Comparable) filter.getValue());
                            break;
                        }
                        case le: {
                            predicate  = cb.lessThanOrEqualTo((Expression<Comparable>) path.as(valType.getClass()), (Comparable) filter.getValue());
                            break;
                        }
                        case like: {
                            predicate  = cb.like(path.as(String.class), "%" + filter.getValue() + "%");
                            break;
                        }
                        case isNull: {
                            predicate  = cb.isNull(path.as(String.class));
                            break;
                        }
                        case isNotNull: {
                            predicate  = cb.isNotNull(path.as(String.class));
                            break;
                        }
                        case in: {
                            Object filterValue = filter.getValue();
                            //List<String> ids = new ArrayList<String>();;
                            if(BeanUtil.isEmpty(filterValue)){
                                predicate = cb.isNull(path.as(String.class));
                            }else{
                                if(filterValue instanceof String){ //拼接的字符串
                                    filterValue = Arrays.asList(filterValue.toString().split(","));
                                }//否则限制只能传入collection 子类
                                predicate = path.as(String.class).in(filterValue);
                            }
                            break;
                        }
                        default:
                            predicate = null;
                            break;
                    }

                    if (predicate != null) {
                        list.add(predicate);
                    }
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return spc;
    }

    /**
     * 获取Filter参数的数据类型
     * @return
     */
    private Object getValueType(Object value) {
        if (value instanceof String) {
            return "";
        }else if (value instanceof Long) {
            return 1l;
        }else if (value instanceof Integer) {
            return 1;
        }else if (value instanceof Float) {
            return 1f;
        }else if (value instanceof Double) {
            return 1.0d;
        }else if (value instanceof Boolean) {
            return true;
        }else if (value instanceof Date) {
            return new Date();
        }
        return value;
    }

    public com.telit.springboot.filter.Page<T> findAll(Pageable pageable) {
        return toPage(baseDao.findAll(pageable));
    }

    public com.telit.springboot.filter.Page<T> findAll(Specification<T> sf, Pageable pageable) {
        return toPage(baseDao.findAll(sf, pageable));
    }

    public  com.telit.springboot.filter.Page<T> findList(Filter filter, Pageable pageable) {
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(filter);
        return findList(filters, pageable);
    }

    public  com.telit.springboot.filter.Page<T> findList(Pageable pageable, Filter... filters) {
        return toPage(baseDao.findAll(getSpecification(new ArrayList<Filter>(Arrays.asList(filters))), pageable));
    }

    public  com.telit.springboot.filter.Page<T> findList(List<Filter> filters, Pageable pageable) {
        return toPage(baseDao.findAll(getSpecification(filters), pageable));
    }

    public  com.telit.springboot.filter.Page<T> toPage(Page<T> page){
        return new  com.telit.springboot.filter.Page<T>(page.getNumber(), page.getSize(),
                page.getTotalPages(), page.getTotalElements(), page.getContent());
    }
}
