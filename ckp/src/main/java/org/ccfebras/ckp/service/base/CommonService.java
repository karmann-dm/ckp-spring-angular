package org.ccfebras.ckp.service.base;

import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.repository.base.CommonRepository;

import java.util.Collection;

public interface CommonService<E extends AbstractEntity, R extends CommonRepository<E>> {
    R getRepository();

    E save(E entity);
    E update(E entity);
    E getById(Long id);
    Collection<E> getList();
    void deleteById(Long id);
}
