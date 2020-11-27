package com.example.demo.service;

import com.example.demo.Dao.plansDao;
import com.example.demo.vo.Plans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class plansService {

    @Autowired
    private plansDao plansDao;

    public void savePlan(Plans plans){
        plansDao.addPlan(plans);
    }
    public Plans getPlansById(int planId){
        return plansDao.getPlanById(planId);
    }
}
