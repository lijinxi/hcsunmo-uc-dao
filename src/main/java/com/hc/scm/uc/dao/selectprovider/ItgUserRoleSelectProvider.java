package com.hc.scm.uc.dao.selectprovider;

import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ItgUserRoleSelectProvider {
    @SuppressWarnings("unchecked")
	public  String  findSelectCountSql(Map<String,Object> params){
    	String  whereSql=" 1=1  ";
    	System.out.println("动态SQL有没有被执行-----");
    	
    	
    	try{
	    	Iterator<String> keys = params.keySet().iterator();
			while(keys.hasNext()){
				String key = (String)keys.next();
				
				if("params".equals(key)){
					@SuppressWarnings("unchecked")
					Iterator<String> keys_ = ((Map<String, Object>)params.get("params")).keySet().iterator();
					while(keys_.hasNext()){
						String key_ = (String)keys_.next();
						if("userId".equals(key_)){
							if(((Map<String, Object>)params.get("params")).get("userId")!=null&&!"".equals(((Map<String, Object>)params.get("params")).get("userId"))){
					    		whereSql+="and user_id ='"+((Map<String, Object>)params.get("params")).get("userId")+"'";
					    	}
						}else if("roleId".equals(key_)){
							if(((Map<String, Object>)params.get("params")).get("roleId")!=null&&!"".equals(((Map<String, Object>)params.get("params")).get("roleId"))){
					    		whereSql+="and role_id like '%"+((Map<String, Object>)params.get("params")).get("roleId")+"%'";
					    	}
						}
						
					}
					
				}	
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("动态SQL有没有被执行-----1111");
    	final  String whereSql_=whereSql;
    	System.out.println("动态SQL有没有被执行-----111122");
    	return  new  SQL(){
    		{
    		  SELECT("COUNT(1) as s");
    		  FROM("itg_user_role");
    		  WHERE(whereSql_);
    		}	
    	}.toString();
    }
}
