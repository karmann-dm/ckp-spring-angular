package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Department;
import org.ccfebras.ckp.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsByShortName(String shortName);
    List<Organization> findAllByDepartment(Department department);
}
