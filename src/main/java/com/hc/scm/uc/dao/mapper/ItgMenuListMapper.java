package com.hc.scm.uc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hc.scm.common.base.mapper.BaseCrudMapper;
import com.hc.scm.uc.dao.model.UserMenuTreeModel;

/**
 * Description: 请写出类的用途
 * All rights Reserved, Designed Byhcopyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * @author:     liutao
 * @date:  2015-03-06 15:42:11
 * @version 1.0.0
 */
public interface ItgMenuListMapper extends BaseCrudMapper {
	public List<UserMenuTreeModel>  selectUserModuleList(@Param("projectCode") String projectCode, @Param("userId") int userId);
	
	@Select("select a.menu_no,a.menu_name,a.parent_menu_no,a.module_no,(c.app_url+d.module_url) url,d.right_value rights,c.js_url,"
			+ "c.app_url,c.app_code,d.module_url,d.right_value,d.module_code,case when a.module_no is null then 'false' else 'true' "
			+ "end leaf  from itg_menu_list a "
			+ "left join itg_module_list d on a.module_no = d.module_no and d.enable_flag=1"
			+ "left join itg_application c on d.app_no = c.app_no and c.enable_flag=1"
			+ "where a.project_code=#{projectCode}  and exists(select 1 from itg_module_list x "
			+ "inner join itg_menu_list y on x.module_no = y.module_no"
			+ " inner join itg_application z on x.app_no=z.app_no and z.enable_flag=1"
			+ "where x.enable_flag=1 and a.project_code = y.project_code and y.search_code like a.search_code+'%'"
			+ ") order by a.level_no,a.order_no")
	
	@Results(
	 {
		 @Result(id=true,column="menu_no", property="menuNo")

		 , @Result(column="menu_name", property="menuName")

		 , @Result(column="parent_menu_no", property="parentMenuNo")

		 , @Result(column="module_no", property="moduleNo")

		 , @Result(column="right_value", property="rightValue")

		 , @Result(column="url" , property="url")

		 , @Result( column="module_code", property="moduleCode" )

		 , @Result( column="js_url", property="jsUrl")

		 , @Result(column="rights", property="rights")

		 , @Result(column="app_url" ,property="appUrl")

		 , @Result(column="module_url", property="moduleUrl")

		 , @Result(column="app_code", property="appCode")

		 , @Result(column="leaf", property="leaf")
		 
		 , @Result(column="expanded", property="expanded")
	 }
	)
	public List<UserMenuTreeModel>  selectAllMenuList(@Param("projectCode") String projectCode);
	
	
	public List<UserMenuTreeModel>  selectUserMenuListBySQL(@Param("projectCode") String projectCode, @Param("userId") int userId);
}