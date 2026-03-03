package com.example.week5evaluation.service;

import com.example.week5evaluation.dao.StaffDao;
import com.example.week5evaluation.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Staff getStaffById(int id) {
        return staffDao.getStaffById(id);
    }

    @Override
    public int insertStaff(Staff staff) {
        return staffDao.insertStaff(staff);
    }

    @Override
    public List<Staff> getStaffSalaryGreaterThan(double salary) {
        return staffDao.getStaffSalaryGreaterThan(salary);
    }

    @Override
    public List<Staff> getStaffExperienceBetween(int min, int max) {
        return staffDao.getStaffExperienceBetween(min, max);
    }

    @Override
    public Staff getMaxSalaryStaff() {
        return staffDao.getMaxSalaryStaff();
    }

    @Override
    public int updateSalary(int id, double salary) {
        return staffDao.updateSalary(id, salary);
    }

    @Override
    public String getMinExperienceStaffName() {
        return staffDao.getMinExperienceStaffName();
    }

    @Override
    public List<Staff> getTrainerStaff() {
        return staffDao.getTrainerStaff();
    }

    @Override
    public List<Staff> getNonTrainerStaff() {
        return staffDao.getNonTrainerStaff();
    }
}