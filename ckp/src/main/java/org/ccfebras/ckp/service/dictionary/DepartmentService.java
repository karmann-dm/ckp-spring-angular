package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.Department;
import org.ccfebras.ckp.repository.DepartmentRepository;
import org.ccfebras.ckp.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentService extends AbstractService<Department, DepartmentRepository> {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentRepository getRepository() {
        return departmentRepository;
    }
}
