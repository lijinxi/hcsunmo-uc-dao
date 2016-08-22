package com.hc.scm.uc.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.scm.common.base.mapper.BaseCrudMapper;
import com.hc.scm.uc.dao.entity.ItgLoginUser;
import com.hc.scm.uc.dao.selectprovider.ItgLoginUserSelectProvider;


/**
 * Description: 请写出类的用途
 * All rights Reserved, Designed Byhcopyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * @author:     jinwen
 * @date:  2015-03-07 13:30:53
 * @version 1.0.0
 */
public interface ItgLoginUserMapper extends BaseCrudMapper {
	
	@SelectProvider(type=ItgLoginUserSelectProvider.class, method = "findselectByParamsSql")
	
	 @Results(
	 {
		 @Result(id=true,column="user_id", property="userId")
	   , @Result(column="user_code", property="userCode")
	   , @Result(column="user_name", property="userName")
	   , @Result(column="enable_flag", property="enableFlag")
	   , @Result(column="password", property="password")
	   , @Result(column="pwd_level_no" , property="pwdLevelNo")
	   , @Result( column="pwd_modify_time", property="pwdModifyTime" )
	   , @Result( column="dept_no", property="deptNo")
	   , @Result(column="dept_no", property="deptNo")
	   , @Result(column="check_mac" ,property="checkMac")
		, @Result(column="address_mac", property="addressMac")
		, @Result(column="check_ip", property="checkIp")
		, @Result(column="address_ip", property="addressIp")
		, @Result(column="mobile_no", property="mobileNo")
		, @Result(column="email", property="email" )
		, @Result(column="creator" , property="creator")
		, @Result(column="create_time", property="createTime")
		, @Result(column="modifier", property="modifier" )
		, @Result(column="modify_time", property="modifyTime")
		, @Result(column="remarks" ,property="remarks")
		, @Result(column="dept_name" ,property="deptName")
	 })
	public  List<ItgLoginUser> selectByParams(@Param("params")Map<String,Object> params);
}