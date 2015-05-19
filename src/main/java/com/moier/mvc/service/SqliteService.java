package com.moier.mvc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqliteService implements ISqliteService {

	@Autowired
	private JdbcTemplate template;
	
	
	public boolean saveUserInfo(String name){
		template.execute("insert into user values("+1+",\""+name+"\")");
		return true;
	}
	
	public void query(){
//		List<UserInfo> list= template.queryForList("select * from user",UserInfo.class);
		List<Map<String,Object>> maps = template.queryForList("select * from user");
		System.out.println(maps.size());
		for(Map ui : maps){
			Set set = ui.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
			System.out.println(ui.get("id"+","+ui.get("name")));
		}
	}
	
	
}
