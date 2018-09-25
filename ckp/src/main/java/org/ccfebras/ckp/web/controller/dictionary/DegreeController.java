package org.ccfebras.ckp.web.controller.dictionary;

import org.ccfebras.ckp.model.Degree;
import org.ccfebras.ckp.repository.DegreeRepository;
import org.ccfebras.ckp.service.dictionary.DegreeService;
import org.ccfebras.ckp.web.controller.base.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary/degree")
public class DegreeController extends AbstractController<Degree, DegreeRepository, DegreeService> {
    private final DegreeService degreeService;

    @Autowired
    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @Override
    public DegreeService getService() {
        return degreeService;
    }
}
