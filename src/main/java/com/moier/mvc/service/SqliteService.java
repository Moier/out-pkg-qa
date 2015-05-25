package com.moier.mvc.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SqliteService implements ISqliteService {

//	@Autowired
//	private JdbcTemplate template;
//	
	
	
	private static Set<String> HOST = new HashSet<String>();
	
	public boolean saveQuestion(String host,String question){
//		template.execute("insert into question values(\""+host+"\",\""+question+"\")");
		return HOST.add(host);
	}
	
	public boolean doSended(String host){
//		List list = template.queryForList("select * from question where host='"+host+"'");
//		return (list != null && list.size() > 0);
		return HOST.contains(host);
	}
	
	public void query(){
//		List<UserInfo> list= template.queryForList("select * from user",UserInfo.class);
//		List<Map<String,Object>> maps = template.queryForList("select * from user");
//		System.out.println(maps.size());
//		for(Map ui : maps){
//			Set set = ui.entrySet();
//			Iterator iterator = set.iterator();
//			while(iterator.hasNext()){
//				System.out.println(iterator.next());
//			}
//			System.out.println(ui.get("id"+","+ui.get("name")));
//		}
	}

	
	
}
