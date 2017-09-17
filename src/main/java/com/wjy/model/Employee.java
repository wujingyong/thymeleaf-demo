package com.wjy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}