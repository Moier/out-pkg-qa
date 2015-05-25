package com.moier.mvc.service;

public interface ISqliteService {

	
	public boolean saveQuestion(String host,String question);
	public boolean doSended(String host);
	public void query();
}
