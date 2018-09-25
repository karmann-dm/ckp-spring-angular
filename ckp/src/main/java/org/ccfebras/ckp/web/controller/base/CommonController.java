package org.ccfebras.ckp.web.controller.base;

import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.ccfebras.ckp.service.base.CommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommonController<E extends AbstractEntity,
        R extends CommonRepository<E>,
        S extends CommonService<E, R>
        > {
    S getService();

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);
}
