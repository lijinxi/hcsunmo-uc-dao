package com.hc.scm.uc.dao.purchasing.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hc.scm.common.base.mapper.BaseCrudMapper;
import com.hc.scm.uc.dao.purchasing.model.HcSupplier;

/**
 * Description: 请写出类的用途
 * All rights Reserved, Designed Byhcopyright:   Copyright(C) 2016-2017
 * Company:     hc.
 * @author:     jinxi.li
 * @date:  2016年8月21日
 * @version 1.0.0
 */
public interface HcSupplierManagementMapper extends BaseCrudMapper {
	 @Select("SELECT  [co_number],[coname],[coaddr],[copost],[city],[country],[province],[cofrdb],[cozzxs],[cozczb]"
	 		+ ",[coyyzz],[cotypes],[tradetypes],[cokhjb],[cokhyh],[coyhzh],[coclrq],[ifjckq],[cotel],[cofax]"
	 		+ ",[codzyj],[conet],[cosyhb],[cojsfs],[nshm],[number],[username],[dept],[deptjb],[modman]"
	 		+ ",[mod_date],[share],[yearearning],[valueco],[rg_date],[annual_sales],[sales_ability]"
	 		+ ",[qlty_control],[companymt],[scale],[warehouse],[describee] ,(province+city) as provincesandcities  FROM [supplier]"
	 		+ "  where  1=1")
	 @Results(
			 {
				 @Result(id=true,column="co_number", property="companyNo")  //供应商编码
				 , @Result(column="coname", property="companyName")  //供应商名称
				 , @Result(column="coaddr", property="companyAddr")//供应商地址
				 , @Result(column="copost", property="companyZipCode")//邮编
				 , @Result(column="city", property="city")//城市
				 , @Result(column="country" , property="country")//国家
				 , @Result( column="province", property="province" )//省份
				 , @Result( column="cofrdb", property="legalRepresentative")//法人代表
				 , @Result(column="cozzxs", property="organizationForm")//组织形式
				 , @Result(column="cozczb" ,property="registeredCapital")//注册资本
				 , @Result(column="coyyzz", property="businessLicense")//营业执照
				 , @Result(column="cotypes", property="supplierTypes") //供应商性质
				 , @Result(column="tradetypes", property="industryTypes")//行业类型
				 , @Result(column="cokhjb", property="supplierLevel")//供应商级别
				 , @Result(column="cokhyh", property="bankOfDeposit")//开户银行
				 , @Result(column="coyhzh", property="bankAccount")//银行账号
				 , @Result(column="coclrq", property="dateOfEstablishment")//成立日期
				 , @Result(column="ifjckq", property="paymentMethod")//付款方式
				 , @Result(column="cotel", property="companyTel")//公司电话
				 , @Result(column="cofax", property="companyFax")//公司传真
				 , @Result(column="codzyj", property="email")//电子邮件
				 , @Result(column="conet", property="companyNet")//公司网址
				 , @Result(column="cosyhb", property="useCurrency")//使用货币
				 , @Result(column="cojsfs", property="linkMan")//联系人
				 , @Result(column="nshm", property="linkManTel")//联系人手机
				 , @Result(column="number", property="docPurchasing")//跟单采购
				 , @Result(column="username", property="createUser")//创建用户
				 , @Result(column="dept", property="localDepartment")//所在部门
				 , @Result(column="modman", property="modifyUser")//修改用户
				 , @Result(column="mod_date", property="modifyDate")//修改日期
				 , @Result(column="share", property="whetherToShare")//是否共享
				 , @Result(column="yearearning", property="yearEarning")//年度收入
				 , @Result(column="rg_date", property="loginDate")//登录日期
				 , @Result(column="annual_sales", property="companyScale")//公司规模
				 , @Result(column="sales_ability", property="abilityToSell")//销售能力
				 , @Result(column="qlty_control", property="qualityControl")//质量控制
				 , @Result(column="companymt", property="companyProfile")//公司简介
				 , @Result(column="scale", property="categoryOfTheProduct")//产品类别
				 , @Result(column="warehouse", property="cooperationOpportunities")//合作机会
				 , @Result(column="describee", property="describee")//备注  
				 , @Result(column="provincesandcities", property="provincesAndCities")//省市   
			 }		 
	 )
	 public  List<HcSupplier> selectByParams(@Param("params")Map<String,Object> params);

}
