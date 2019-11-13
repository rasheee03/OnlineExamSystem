package com.lti.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.model.Cart;
import com.lti.model.Item;

public class CartTest {

	@Test
	public void addcart()
	{
		GenericDao dao=new GenericDao();
		Cart cart=new Cart();
		cart.setTotal(124567.00);
		dao.save(cart);
		
		GenericDao dao1=new GenericDao();
		Cart cart1=new Cart();
		cart1.setTotal(1.00);
		dao.save(cart1);
		
		GenericDao dao2=new GenericDao();
		Cart cart2=new Cart();
		cart2.setTotal(3.00);
		dao.save(cart2);
	}
	@Test
	public void addItems()
	{
		GenericDao dao=new GenericDao();
		Cart cart=(Cart) dao.fetchById(Cart.class, 10000);
		List<Item> items=new ArrayList<Item>();
		Item item=new Item();
		item.setQuantity(56);
		item.setCart(cart);
		dao.save(item);
		items.add(item);
		
		
		GenericDao dao1=new GenericDao();
		Cart cart1=(Cart) dao1.fetchById(Cart.class, 10002);
		List<Item> items1=new ArrayList<Item>();
		Item item1=new Item();
		item1.setQuantity(300);
		item1.setCart(cart1);
		dao.save(item1);
		items1.add(item1);
		
		GenericDao dao2=new GenericDao();
		Cart cart2=(Cart) dao2.fetchById(Cart.class, 10005);
		List<Item> items2=new ArrayList<Item>();
		Item item2=new Item();
		item2.setQuantity(980);
		item2.setCart(cart2);
		dao.save(item2);
		items2.add(item2);
	}
	@Test
	public void updateItemsToCart()
	{
		GenericDao dao=new GenericDao();
		Cart cart=(Cart) dao.fetchById(Cart.class, 10001);
		List<Item> items=new ArrayList<Item>();
		Item item=new Item();
		item.setQuantity(16);
		item.setCart(cart);
		dao.save(item);
		
		Item item1=new Item();
		item1.setQuantity(13);
		item1.setCart(cart);
		dao.save(item1);
		
		Item item2=new Item();
		item2.setQuantity(8);
		item2.setCart(cart);
		dao.save(item2);
		
		items.add(item);
		items.add(item1);
		items.add(item2);
		

		GenericDao dao1=new GenericDao();
		Cart cart1=(Cart) dao1.fetchById(Cart.class, 10005);
		List<Item> items1=new ArrayList<Item>();
		Item item3=new Item();
		item3.setQuantity(30);
		item3.setCart(cart1);
		dao.save(item3);
		items.add(item3);
	}
}
