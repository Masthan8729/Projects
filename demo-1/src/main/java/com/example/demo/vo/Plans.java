package com.example.demo.vo;

import javax.persistence.*;

@Entity
@Table(name = "subcription_plans_tbl")
public class Plans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;
    private int monthly;
    private int threeMonths;
    private int sixMonths;
    private int oneYear;

    public Plans() {
    }

    public Plans(int planId, int monthly, int threeMonths, int sixMonths, int oneYear) {
        this.planId = planId;
        this.monthly = monthly;
        this.threeMonths = threeMonths;
        this.sixMonths = sixMonths;
        this.oneYear = oneYear;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getMonthly() {
        return monthly;
    }

    public void setMonthly(int monthly) {
        this.monthly = monthly;
    }

    public int getThreeMonths() {
        return threeMonths;
    }

    public void setThreeMonths(int threeMonths) {
        this.threeMonths = threeMonths;
    }

    public int getSixMonths() {
        return sixMonths;
    }

    public void setSixMonths(int sixMonths) {
        this.sixMonths = sixMonths;
    }

    public int getOneYear() {
        return oneYear;
    }

    public void setOneYear(int oneYear) {
        this.oneYear = oneYear;
    }
}
