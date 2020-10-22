package com.provigil.mapper;

import java.util.function.Function;

import com.provigil.model.Location;
import com.provigil.model.Plan;
import com.provigil.model.Subscription;

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
			result.setId(input.getId());
			result.setCost(cost);
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
		} else {
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
		}
		return result;
	}

}
