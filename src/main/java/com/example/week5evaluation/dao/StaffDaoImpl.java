package com.example.week5evaluation.dao;

import com.example.week5evaluation.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl implements StaffDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1. Get all staff
    @Override
    public List<Staff> getAllStaff() {
        String sql = "SELECT * FROM staff";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Staff.class));
    }

    // 2. Get staff by id
    @Override
    public Staff getStaffById(int id) {
        String sql = "SELECT * FROM staff WHERE staffid = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Staff.class), id);
    }

    // 3. Insert staff
    @Override
    public int insertStaff(Staff staff) {
        String sql = "INSERT INTO staff VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                staff.getStaffid(),
                staff.getName(),
                staff.getProfile(),
                staff.getSalary(),
                staff.getExperience());
    }

    // 4. Salary > given amount
    @Override
    public List<Staff> getStaffSalaryGreaterThan(double salary) {
        String sql = "SELECT * FROM staff WHERE salary > ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Staff.class), salary);
    }

    // 5. Experience between
    @Override
    public List<Staff> getStaffExperienceBetween(int min, int max) {
        String sql = "SELECT * FROM staff WHERE experience BETWEEN ? AND ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Staff.class), min, max);
    }

    // 6. Max salary staff
    @Override
    public Staff getMaxSalaryStaff() {
        String sql = "SELECT * FROM staff ORDER BY salary DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Staff.class));
    }

    // 7. Update salary by id
    @Override
    public int updateSalary(int id, double salary) {
        String sql = "UPDATE staff SET salary = ? WHERE staffid = ?";
        return jdbcTemplate.update(sql, salary, id);
    }

    // 8. Name of min experience staff
    @Override
    public String getMinExperienceStaffName() {
        String sql = "SELECT name FROM staff ORDER BY experience ASC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    // 9. Profile = Trainer
    @Override
    public List<Staff> getTrainerStaff() {
        String sql = "SELECT * FROM staff WHERE profile = 'Trainer'";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Staff.class));
    }

    // 10. Profile != Trainer
    @Override
    public List<Staff> getNonTrainerStaff() {
        String sql = "SELECT * FROM staff WHERE profile != 'Trainer'";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Staff.class));
    }
}