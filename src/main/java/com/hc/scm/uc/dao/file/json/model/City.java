package com.hc.scm.uc.dao.file.json.model;

public class City {
    private  String cityID;
    private  String cityName;
    private  String provinceNo;
    private  String citySort;
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getCitySort() {
		return citySort;
	}
	public void setCitySort(String citySort) {
		this.citySort = citySort;
	}
}
