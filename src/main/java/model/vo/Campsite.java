package model.vo;

import java.sql.Date;

public class Campsite {
	int id;
	String name;
	String businessNumber;
	String lineIntro;
	String intro;
	String feature;
	String induty;
	String environmnet;
	String zipCode;
	String address;
	String direction;
	String tel;
	String homepage;
	String resveUrl;
	String resveCl;
	int gnrlSite;
	int autoSite;
	int glampSite;
	int caravSite;
	int indvdlCaravSite;
	String tooltip;
	String glampInner;
	String caravInner;
	String operPd;
	String operDe;
	int toilet;
	int swrm;
	int wtrpl;
	String sbrs;
	String sbrsEtc;
	String posbl;
	String posblEtc;
	String imageUrl;
	String animal;
	Date createdTime;
	Date modifiedTime;

	public Campsite() {
		super();
	}

	public Campsite(int id, String name, String businessNumber, String lineIntro, String intro, String feature,
			String induty, String environmnet, String zipCode, String address, String direction, String tel,
			String homepage, String resveUrl, String resveCl, int gnrlSite, int autoSite, int glampSite, int caravSite,
			int indvdlCaravSite, String tooltip, String glampInner, String caravInner, String operPd, String operDe,
			int toilet, int swrm, int wtrpl, String sbrs, String sbrsEtc, String posbl, String posblEtc,
			String imageUrl, String animal, Date createdTime, Date modifiedTime) {
		super();
		this.id = id;
		this.name = name;
		this.businessNumber = businessNumber;
		this.lineIntro = lineIntro;
		this.intro = intro;
		this.feature = feature;
		this.induty = induty;
		this.environmnet = environmnet;
		this.zipCode = zipCode;
		this.address = address;
		this.direction = direction;
		this.tel = tel;
		this.homepage = homepage;
		this.resveUrl = resveUrl;
		this.resveCl = resveCl;
		this.gnrlSite = gnrlSite;
		this.autoSite = autoSite;
		this.glampSite = glampSite;
		this.caravSite = caravSite;
		this.indvdlCaravSite = indvdlCaravSite;
		this.tooltip = tooltip;
		this.glampInner = glampInner;
		this.caravInner = caravInner;
		this.operPd = operPd;
		this.operDe = operDe;
		this.toilet = toilet;
		this.swrm = swrm;
		this.wtrpl = wtrpl;
		this.sbrs = sbrs;
		this.sbrsEtc = sbrsEtc;
		this.posbl = posbl;
		this.posblEtc = posblEtc;
		this.imageUrl = imageUrl;
		this.animal = animal;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getLineIntro() {
		return lineIntro;
	}

	public void setLineIntro(String lineIntro) {
		this.lineIntro = lineIntro;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getInduty() {
		return induty;
	}

	public void setInduty(String induty) {
		this.induty = induty;
	}

	public String getEnvironmnet() {
		return environmnet;
	}

	public void setEnvironmnet(String environmnet) {
		this.environmnet = environmnet;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getResveUrl() {
		return resveUrl;
	}

	public void setResveUrl(String resveUrl) {
		this.resveUrl = resveUrl;
	}

	public String getResveCl() {
		return resveCl;
	}

	public void setResveCl(String resveCl) {
		this.resveCl = resveCl;
	}

	public int getGnrlSite() {
		return gnrlSite;
	}

	public void setGnrlSite(int gnrlSite) {
		this.gnrlSite = gnrlSite;
	}

	public int getAutoSite() {
		return autoSite;
	}

	public void setAutoSite(int autoSite) {
		this.autoSite = autoSite;
	}

	public int getGlampSite() {
		return glampSite;
	}

	public void setGlampSite(int glampSite) {
		this.glampSite = glampSite;
	}

	public int getCaravSite() {
		return caravSite;
	}

	public void setCaravSite(int caravSite) {
		this.caravSite = caravSite;
	}

	public int getIndvdlCaravSite() {
		return indvdlCaravSite;
	}

	public void setIndvdlCaravSite(int indvdlCaravSite) {
		this.indvdlCaravSite = indvdlCaravSite;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getGlampInner() {
		return glampInner;
	}

	public void setGlampInner(String glampInner) {
		this.glampInner = glampInner;
	}

	public String getCaravInner() {
		return caravInner;
	}

	public void setCaravInner(String caravInner) {
		this.caravInner = caravInner;
	}

	public String getOperPd() {
		return operPd;
	}

	public void setOperPd(String operPd) {
		this.operPd = operPd;
	}

	public String getOperDe() {
		return operDe;
	}

	public void setOperDe(String operDe) {
		this.operDe = operDe;
	}

	public int getToilet() {
		return toilet;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
	}

	public int getSwrm() {
		return swrm;
	}

	public void setSwrm(int swrm) {
		this.swrm = swrm;
	}

	public int getWtrpl() {
		return wtrpl;
	}

	public void setWtrpl(int wtrpl) {
		this.wtrpl = wtrpl;
	}

	public String getSbrs() {
		return sbrs;
	}

	public void setSbrs(String sbrs) {
		this.sbrs = sbrs;
	}

	public String getSbrsEtc() {
		return sbrsEtc;
	}

	public void setSbrsEtc(String sbrsEtc) {
		this.sbrsEtc = sbrsEtc;
	}

	public String getPosbl() {
		return posbl;
	}

	public void setPosbl(String posbl) {
		this.posbl = posbl;
	}

	public String getPosblEtc() {
		return posblEtc;
	}

	public void setPosblEtc(String posblEtc) {
		this.posblEtc = posblEtc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
