package com.example.week5evaluation.controller;

import com.example.week5evaluation.entity.Staff;
import com.example.week5evaluation.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    // answer for quest- 1
    @GetMapping("/all")
    public List<Staff> getAll() {
        return service.getAllStaff();
    }

    // answer for quest- 2
    @GetMapping("/{id}")
    public Staff getById(@PathVariable int id) {
        return service.getStaffById(id);
    }

    // answer for quest- 3
    @PostMapping("/add")
    public int add(@RequestBody Staff staff) {
        return service.insertStaff(staff);
    }

    // answer for quest-4
    @GetMapping("/salary/{sal}")
    public List<Staff> salaryGreater(@PathVariable double sal) {
        return service.getStaffSalaryGreaterThan(sal);
    }

    // answer for quest- 5
    @GetMapping("/exp/{min}/{max}")
    public List<Staff> expBetween(@PathVariable int min,
                                  @PathVariable int max) {
        return service.getStaffExperienceBetween(min, max);
    }

    // answer for quest- 6
    @GetMapping("/maxsalary")
    public Staff maxSalary() {
        return service.getMaxSalaryStaff();
    }

    // answer for quest- 7
    @PutMapping("/update/{id}/{salary}")
    public int updateSalary(@PathVariable int id,
                            @PathVariable double salary) {
        return service.updateSalary(id, salary);
    }

    // answer for quest- 8
    @GetMapping("/minexpname")
    public String minExpName() {
        return service.getMinExperienceStaffName();
    }

    // answer for quest- 9
    @GetMapping("/trainer")
    public List<Staff> trainerList() {
        return service.getTrainerStaff();
    }

    // answer for quest-10
    @GetMapping("/nontrainer")
    public List<Staff> nonTrainerList() {
        return service.getNonTrainerStaff();
    }
}