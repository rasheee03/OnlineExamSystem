package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.model.Bus;
import com.lti.model.Cart;
import com.lti.model.Item;
import com.lti.model.Stop;

public class BusTest{

@Test
public void addBus()
{
	GenericDao dao=new GenericDao();
	Bus bus=new Bus();
	bus.setOperator("mayank");
	bus.setSource("Mumbai");
	bus.setDestination("Pune");
	bus.setArrivalTime(LocalTime.of(10,30));
	bus.setDepartureTime(LocalTime.of(12,20));
	dao.save(bus);
	
	
	GenericDao dao1=new GenericDao();
	Bus bus1=new Bus();
	bus1.setOperator("vishal");
	bus1.setSource("delhi");
	bus1.setDestination("aligarh");
	bus1.setArrivalTime(LocalTime.of(11,31));
	bus1.setDepartureTime(LocalTime.of(13,20));
	dao1.save(bus1);
	
	GenericDao dao2=new GenericDao();
	Bus bus2=new Bus();
	bus2.setOperator("mamba");
	bus2.setSource("delhi");
	bus2.setDestination("etawah");
	bus2.setArrivalTime(LocalTime.of(11,31));
	bus2.setDepartureTime(LocalTime.of(13,20));
	dao2.save(bus2);

	
	}

@Test
public void addStops()
{
	GenericDao dao=new GenericDao();
 Bus bus=(Bus) dao.fetchById(Bus.class, 341);
	List<Stop> stops=new ArrayList<Stop>();
	Stop stop=new Stop();
stop.setArrivalTime(LocalTime.of(12, 36));
stop.setDepartureTime(LocalTime.of(16, 32));
stop.setName("himachal");
stop.setBus(bus);
	dao.save(stop);
	//stops.add(stop);

	GenericDao dao1=new GenericDao();
	 Bus bus1=(Bus) dao1.fetchById(Bus.class, 359);
		List<Stop> stops1=new ArrayList<Stop>();
		Stop stop1=new Stop();
	stop1.setArrivalTime(LocalTime.of(15, 36));
	stop1.setDepartureTime(LocalTime.of(20, 32));
	stop1.setName("andhra");
	stop1.setBus(bus1);
		dao1.save(stop1);
		

		GenericDao dao2=new GenericDao();
		 Bus bus2=(Bus) dao2.fetchById(Bus.class, 359);
			List<Stop> stops2=new ArrayList<Stop>();
			Stop stop2=new Stop();
		stop2.setArrivalTime(LocalTime.of(15, 36));
		stop2.setDepartureTime(LocalTime.of(20, 32));
		stop2.setName("kabul");
		stop2.setBus(bus2);
			dao2.save(stop2);
}
@Test
public void fetchBus() {
	GenericDao dao = new GenericDao();
	Bus bus =(Bus) dao.fetchById(Bus.class, 341);
	
	System.out.println(bus.getOperator());
	System.out.println(bus.getDepartureTime());
	System.out.println(bus.getArrivalTime());
	
	for(Stop stop : bus.getStops()) {
		
		System.out.println(stop.getName());
		System.out.println(stop.getArrivalTime());
		System.out.println(stop.getDepartureTime());
	}
	GenericDao dao1 = new GenericDao();
	Bus bus1 =(Bus) dao1.fetchById(Bus.class, 359);
	
	System.out.println(bus1.getOperator());
	System.out.println(bus1.getDepartureTime());
	System.out.println(bus1.getArrivalTime());
	
	for(Stop stop : bus1.getStops()) {
		
		System.out.println(stop.getName());
		System.out.println(stop.getArrivalTime());
		System.out.println(stop.getDepartureTime());
	}
	
	GenericDao dao2 = new GenericDao();
	Bus bus2 =(Bus) dao2.fetchById(Bus.class, 360);
	
	System.out.println(bus2.getOperator());
	System.out.println(bus2.getDepartureTime());
	System.out.println(bus2.getArrivalTime());
	
	for(Stop stop : bus2.getStops()) {
		
		System.out.println(stop.getName());
		System.out.println(stop.getArrivalTime());
		System.out.println(stop.getDepartureTime());
	}
	
	}

@Test
public void fetchStop() {
	GenericDao dao = new GenericDao();
	Stop stop = (Stop)dao.fetchById(Stop.class, 364);
			
			System.out.println(stop.getName());
			System.out.println(stop.getArrivalTime());
		
			Bus bus = stop.getBus();
			System.out.println(bus.getOperator());
			System.out.println(bus.getSource());
			System.out.println(bus.getDestination());
			
	
	
}
}


