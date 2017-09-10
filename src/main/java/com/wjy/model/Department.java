package com.wjy.model;

import javax.persistence.*;

@Table(name = "tbl_dept")
public class Department {
    @Id
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    private String ghj;

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return ghj
     */
    public String getGhj() {
        return ghj;
    }

    /**
     * @param ghj
     */
    public void setGhj(String ghj) {
        this.ghj = ghj;
    }
}