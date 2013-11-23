package br.com.fluentcode.ejb.remote.impl;

import javax.ejb.Stateless;

import br.com.fluentcode.ejb.remote.CalculatorRemote;

@Stateless
public class CalculatorBean implements CalculatorRemote{

	@Override
	public int add(int x, int y) {
		return x + y;
	}

}
