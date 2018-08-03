package org.ccfebras.ckp.web.controller.dictionary;

import org.ccfebras.ckp.model.Department;
import org.ccfebras.ckp.service.dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dictionary/department")
public class DepartmentController {
    @Autowired
    private DictionaryService dictionaryService;

    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(dictionaryService.saveDepartment(department), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        return new ResponseEntity<>(dictionaryService.findDepartments(), HttpStatus.OK);
    }
}
