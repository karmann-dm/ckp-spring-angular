package org.ccfebras.ckp.web.controller.base;

import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.ccfebras.ckp.service.base.CommonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractController<E extends AbstractEntity,
        R extends CommonRepository<E>,
        S extends CommonService<E, R>> implements CommonController<E, R, S> {
    @Override
    public ResponseEntity<E> save(@RequestBody E entity) {
        return new ResponseEntity<>(getService().save(entity), HttpStatus.OK);
    }
}
