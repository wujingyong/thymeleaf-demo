package com.wjy.model;

import javax.persistence.*;

@Table(name = "tbl_emp")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_name")
    private String empName;

    private String gender;

    private String email;

    @Column(name = "d_id")
    private Integer dId;

    private String abc;

    /**
     * @return emp_id
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * @return emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return d_id
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * @param dId
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /**
     * @return abc
     */
    public String getAbc() {
        return abc;
    }

    /**
     * @param abc
     */
    public void setAbc(String abc) {
        this.abc = abc;
    }
}