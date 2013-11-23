package br.com.fluentcode.ejb.remote.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import br.com.fluentcode.ejb.remote.ShoppingCartRemote;

/**
 * 
 * Stateful Session Bean
 * 
 */
@Stateful
public class ShoppingCartBean implements ShoppingCartRemote {
	
	private List<String> items = new ArrayList<String>();

	@Override
	public void addItem(String item) {
		this.items.add(item);

	}

	@Override
	public List<String> getItems() {
		return items;
	}

	// The Remove annotation allows the container remove the ejb when the method is invoked
	@Remove
	@Override
	public void finishShopping() {
		System.out.println("Order finalized!");
	}

}
