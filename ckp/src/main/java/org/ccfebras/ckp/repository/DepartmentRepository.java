package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
