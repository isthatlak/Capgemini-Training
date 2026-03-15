package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @Column(name="department_id")
    int departmentid;
    @Column(name="department_name")
    String depname;
    @Column(name="manager_id")
    Integer managerid;
    @Override
    public String toString() {
        return "Department [departmentId=" + departmentid +
                ", depName=" + depname +
                ", managerId=" + managerid + "]";
    }

    public int getDepartmentid() {
        return departmentid;
    }
    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    public String getDepname() {
        return depname;
    }
    public void setDepname(String depname) {
        this.depname = depname;
    }
    public Integer getManagerid() {
        return managerid;
    }
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }
}
