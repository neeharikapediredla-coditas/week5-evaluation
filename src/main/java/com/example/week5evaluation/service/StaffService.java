package com.example.week5evaluation.service;

import com.example.week5evaluation.entity.Staff;
import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff();
    Staff getStaffById(int id);
    int insertStaff(Staff staff);
    List<Staff> getStaffSalaryGreaterThan(double salary);
    List<Staff> getStaffExperienceBetween(int min, int max);
    Staff getMaxSalaryStaff();
    int updateSalary(int id, double salary);
    String getMinExperienceStaffName();
    List<Staff> getTrainerStaff();
    List<Staff> getNonTrainerStaff();
}