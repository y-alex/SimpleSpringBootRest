package demo.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy ;


@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Long mId;
	
	@Column(name="USER_NAME")
	private String mUserName;

	@Column(name="USER_LAST_NAME")
	private String mUserLastName;
	
	@Column(name="USER_ADRESS")
	private String mUserAdress;
	
	@OneToMany(mappedBy = "mUser")
	private Set<Shop> mShops = new HashSet<Shop>();
	
	
	
	public User(Long mId, String mUserName, String mUserLastName, String mUserAdress) {
		super();
		this.mId = mId;
		this.mUserName = mUserName;
		this.mUserLastName = mUserLastName;
		this.mUserAdress = mUserAdress;
	}

	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="USER_ID")
	//@OrderBy
	//private Set<Shop> mShops;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmUserLastName() {
		return mUserLastName;
	}

	public void setmUserLastName(String mUserLastName) {
		this.mUserLastName = mUserLastName;
	}

	public String getmUserAdress() {
		return mUserAdress;
	}

	public void setmUserAdress(String mUserAdress) {
		this.mUserAdress = mUserAdress;
	}

	public Set<Shop> getmShops() {
		return mShops;
	}

	public void setmShops(Set<Shop> mShops) {
		this.mShops = mShops;
	}

	@Override
	public String toString() {		
		return getmId() +", "+getmUserName() +", "+getmUserLastName();
	}

	
}
