package org.ccfebras.ckp.service.base;

import org.ccfebras.ckp.exception.NotFoundException;
import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.repository.base.CommonRepository;

import java.util.Collection;


public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> implements CommonService<E, R> {
    @Override
    public E save(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public E getById(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new NotFoundException(
                this.getClass().getName(),
                "id",
                id
        ));
    }

    @Override
    public E update(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public Collection<E> getList() {
        return getRepository().findAll();
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }
}
