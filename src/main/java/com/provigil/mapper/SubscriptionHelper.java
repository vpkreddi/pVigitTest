package com.provigil.mapper;

import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.provigil.model.Location;
import com.provigil.model.Plan;
import com.provigil.model.Subscription;

@Component
public class SubscriptionHelper implements Function<Subscription, com.provigil.model.result.Subscription> {

	@Override
	public com.provigil.model.result.Subscription apply(Subscription input) {
		
		com.provigil.model.result.Subscription result = new com.provigil.model.result.Subscription();
		double cost=0.0;
		if (input.getArea() <= 2500) {
			if (input.getLocation().equals(Location.Indoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
				cost = input.getArea()*2;
				}else if(input.getPlan().equals(Plan.YEARLY)){
					cost=input.getArea()*1.5;
				}
			} else if (input.getLocation().equals(Location.Outdoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = input.getArea()*2.5;
					}else if(input.getPlan().equals(Plan.YEARLY)){
						cost=input.getArea()*2;
					}
			}
			
		} else if (input.getArea() <= 5000) {
			if (input.getLocation().equals(Location.Indoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
				cost = 2500*2+(input.getArea()-2500)*1.5;
				}else if(input.getPlan().equals(Plan.YEARLY)){
					cost=2500*1.5+(input.getArea()-2500)*1;
				}
			} else if (input.getLocation().equals(Location.Outdoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = 2500*2.5+(input.getArea()-2500)*1.5;
					}else if(input.getPlan().equals(Plan.YEARLY)){
						cost=2500*2+(input.getArea()-2500)*1;
					}
			}
		} else if (input.getArea() <= 50000) {
			if (input.getLocation().equals(Location.Indoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = 2500*2+2500*1.5+(input.getArea()-5000)*1;
				}else if(input.getPlan().equals(Plan.YEARLY)){
					cost = 2500*1.5+2500*1+(input.getArea()-5000)*0.6;
				}
			} else if (input.getLocation().equals(Location.Outdoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = 2500*2.5+(2500*1.5)+(input.getArea()-5000)*1.2;
					}else if(input.getPlan().equals(Plan.YEARLY)){
						cost=2500*2+(2500*1)+(input.getArea()-5000)*0.8;
					}
			}
		} else {
			if (input.getLocation().equals(Location.Indoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = 2500*2+2500*1.5+(45000*1)+(input.getArea()-50000)*0.8;
				}else if(input.getPlan().equals(Plan.YEARLY)){
					cost = 2500*1.5+2500*1+(45000*0.6)+(input.getArea()-50000)*0.5;
				}
			} else if (input.getLocation().equals(Location.Outdoor)) {
				if(input.getPlan().equals(Plan.MONTHLY)) {
					cost = 2500*2.5+(2500*1.5)+(45000*1.2)+(input.getArea()-50000)*0.8;
					}else if(input.getPlan().equals(Plan.YEARLY)){
						cost=2500*2+(2500*1)+(45000*0.8)+(input.getArea()-50000)*0.5;
					}
			}
		}
		result.setId(input.getId());
		result.setCost(cost);
		return result;
	}

}
