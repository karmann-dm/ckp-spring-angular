package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.*;

import java.util.List;

public interface DictionaryService {
    Organization findOrganizationById(Long id);
    Organization saveOrganization(Organization organization);
    Organization updateOrganization(Long id, Organization organization);
    List<Organization> findOrganizations();
    List<Organization> findOrganizationsByDepartmentId(Long departmentId);
    void deleteOrganization(Long id);

    Position findPositionById(Long id);

    Degree findDegreeById(Long id);

    Rank findRankById(Long id);

    Department findDepartmentById(Long id);
    Department saveDepartment(Department department);
    Department updateDepartment(Long id, Department department);
    List<Department> findDepartments();
    void deleteDepartment(Long id);
}
