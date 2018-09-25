package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.Degree;
import org.ccfebras.ckp.repository.DegreeRepository;
import org.ccfebras.ckp.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService extends AbstractService<Degree, DegreeRepository> {
    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public DegreeRepository getRepository() {
        return degreeRepository;
    }
}