package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shop {

	@Id
	@GeneratedValue
	@Column(name="SHOP_ID")
	private Long mId;
	
	@Column(name="SHOP_NAME")
	private String mShopName;
	
	@Column(name="SHOP_IMG_URI")
	private String mShopImgUri;
	
	@Column(name="SHOP_LON_COORD")
	private String mShopLonCoord;
	
	@Column(name="SHOP_LAT_COORD")
	private String mShopLatCoord;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User mShopUserOwner;

	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getmShopName() {
		return mShopName;
	}

	public void setmShopName(String mShopName) {
		this.mShopName = mShopName;
	}

	public String getmShopImgUri() {
		return mShopImgUri;
	}

	public void setmShopImgUri(String mShopImgUri) {
		this.mShopImgUri = mShopImgUri;
	}

	public String getmShopLonCoord() {
		return mShopLonCoord;
	}

	public void setmShopLonCoord(String mShopLonCoord) {
		this.mShopLonCoord = mShopLonCoord;
	}

	public String getmShopLatCoord() {
		return mShopLatCoord;
	}

	public void setmShopLatCoord(String mShopLatCoord) {
		this.mShopLatCoord = mShopLatCoord;
	}

	public String getmShopUserOwner() {
		return mShopUserOwner;
	}

	public void setmShopUserOwner(String mShopUserOwner) {
		this.mShopUserOwner = mShopUserOwner;
	}
	
	@Override
	public String toString() {		
		return getmId() +", "+getmShopName() +", "+getmShopUserOwner();
	}
	
}
