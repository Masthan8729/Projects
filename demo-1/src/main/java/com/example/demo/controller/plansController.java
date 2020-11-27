package com.example.demo.controller;

import com.example.demo.vo.Plans;
import com.example.demo.service.plansService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class plansController {
    final static Logger log = LogManager.getLogger(plansController.class);
    @Autowired
    private plansService service;
   /* @Autowired
    private plansRepo plansRepo;*/

    @PostMapping("/addPlan")
    @CrossOrigin("https://web.postman.co/build/")
    public void savePlan(@RequestBody Plans plans){
        log.info("Saving Plan");
       service.savePlan(plans);
    }

    @GetMapping("/getPlansById/{planId}")
    @CrossOrigin("https://web.postman.co/build/")
    public Plans getPlanById(@PathVariable int planId){
        log.info("Getting plan by plan Id");
        return service.getPlansById(planId);
    }

  /*  @PutMapping("/Plan/{planId}")
    public Plans replacePlan(@RequestBody Plans newPlan, @PathVariable int planId) {
        return plansRepo.findById(planId)
                .map(Plan -> {
                    Plan.setMonthly(newPlan.getMonthly());
                    Plan.setThreeMonths(newPlan.getThreeMonths());
                    Plan.setSixMonths(newPlan.getSixMonths());
                    Plan.setOneYear(newPlan.getOneYear());
                    return plansRepo.save(Plan);
                })
                .orElseGet(() -> {
                    newPlan.setPlanId(planId);
                    return plansRepo.save(newPlan);
                });
    }*/

}
