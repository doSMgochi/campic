package model.vo;

public class UserSession {
	String userId;
	int reservation;
	int favorite;
	String campsiteCoupon;
	String storeCoupon;
	int storePoint;

	public UserSession() {
		super();
	}

	public UserSession(String userId, int reservation, int favorite, String campsiteCoupon, String storeCoupon,
			int storePoint) {
		super();
		this.userId = userId;
		this.reservation = reservation;
		this.favorite = favorite;
		this.campsiteCoupon = campsiteCoupon;
		this.storeCoupon = storeCoupon;
		this.storePoint = storePoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public String getCampsiteCoupon() {
		return campsiteCoupon;
	}

	public void setCampsiteCoupon(String campsiteCoupon) {
		this.campsiteCoupon = campsiteCoupon;
	}

	public String getStoreCoupon() {
		return storeCoupon;
	}

	public void setStoreCoupon(String storeCoupon) {
		this.storeCoupon = storeCoupon;
	}

	public int getStorePoint() {
		return storePoint;
	}

	public void setStorePoint(int storePoint) {
		this.storePoint = storePoint;
	}

}
