package com.dlt.schedularsvcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dlt.service.SystemSvcs;

@Component
public class SystemSchedular {
	@Autowired
	private SystemSvcs systemService;

	//runs once in a day.
	//@Scheduled(initialDelay = 1000, fixedRate = 2000)
	public void updateOpsHrsDaily() {
		//The ops hours is automatically updated everyday as: (Today Date–Commission Date) X 24 X Duty
		//	Cycle
		System.out.println("Update Schedular method called.");
		System.out.println("System service object =" + this.systemService);
		System.out.println("Eligible system are =" + this.systemService.findAllEligibleSystems());

	}
}
