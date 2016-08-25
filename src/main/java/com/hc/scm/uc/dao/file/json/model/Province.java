package com.hc.scm.uc.dao.file.json.model;

public class Province {
   private   int  id;
   private  String provinceNo;
   private  String provinceName;
   private  String proSort;
   private  String proRemark;
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProSort() {
		return proSort;
	}
	public void setProSort(String proSort) {
		this.proSort = proSort;
	}
	public String getProRemark() {
		return proRemark;
	}
	public void setProRemark(String proRemark) {
		this.proRemark = proRemark;
	}
}
