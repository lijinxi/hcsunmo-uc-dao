package com.hc.scm.uc.dao.selectprovider;

import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ItgLoginUserSelectProvider {
	 public  String  findselectByParamsSql(Map<String,Object> params){
		 
	    	String  whereSql=" 1=1  ";
	    	try{
		    	Iterator<String> keys = params.keySet().iterator();
				while(keys.hasNext()){
					String key = (String)keys.next();
					
					if("params".equals(key)){
						@SuppressWarnings("unchecked")
						Iterator<String> keys_ = ((Map<String, Object>)params.get("params")).keySet().iterator();
						while(keys_.hasNext()){
							String key_ = (String)keys_.next();
							if("password".equals(key_)){
								if(((Map<String, Object>)params.get("params")).get("password")!=null&&!"".equals(((Map<String, Object>)params.get("params")).get("password"))){
						    		whereSql+="and password ='"+((Map<String, Object>)params.get("params")).get("password")+"'";
						    	}
							}else if("userCode".equals(key_)){
								if(((Map<String, Object>)params.get("params")).get("userCode")!=null&&!"".equals(((Map<String, Object>)params.get("params")).get("userCode"))){
						    		whereSql+="and user_code like '%"+((Map<String, Object>)params.get("params")).get("userCode")+"%'";
						    	}
							}
							
						}
						
					}	
				}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			final  String whereSql_=whereSql;
	    	return new  SQL(){
	    		{
		    		  SELECT(" user_id, user_code, user_name, enable_flag, password, pwd_level_no," +
		    		  		" pwd_modify_time, dept_no, is_admin_group, check_mac, address_mac, check_ip," +
		    		  		" address_ip, mobile_no, email, creator, create_time, modifier, modify_time, remarks "
		    		  		+ ",(select d.dept_name from itg_department d where d.dept_no =t.dept_no)dept_name");
		    		 
		    		  FROM("itg_login_user t");
		    		  WHERE(whereSql_);
		    		}	
		    	}.toString();
	    }
}
