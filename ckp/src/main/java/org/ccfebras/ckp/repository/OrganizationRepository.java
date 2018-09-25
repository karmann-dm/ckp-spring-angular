package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Department;
import org.ccfebras.ckp.model.Organization;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends CommonRepository<Organization> {
    List<Organization> findAllByDepartment(Department department);
}
