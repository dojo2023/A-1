package model;

import java.io.Serializable;
import java.sql.Date;

public class Userinformation implements Serializable{
	//こっからフィールド
	private int userId;
	private String userName;
	private int userSex;
	private Date userBirth;
	private String userMailAddress;
	private String userPassword;
	private int userHeight;
	private int userWeight;

//コンストラクタ
	//全部入れ

	public Userinformation(int userId, String userName, int userSex, Date userBirth, String userMailAddress,
			String userPassword, int userHeight, int userWeight) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userMailAddress = userMailAddress;
		this.userPassword = userPassword;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
	}

	//String型の初期値null避け
	public Userinformation() {
		this.userName="";
		this.userMailAddress = "";
		this.userPassword = "";
	}


	//ログイン用
	public Userinformation(String userMailAddress, String userPassword) {
		super();
		this.userMailAddress = userMailAddress;
		this.userPassword = userPassword;
	}



	//ユーザー登録用

	public Userinformation(String userName, int userSex, Date userBirth, String userMailAddress,
			String userPassword, int userHeight, int userWeight) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userMailAddress = userMailAddress;
		this.userPassword = userPassword;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
	}





	//ユーザー情報更新用
	public Userinformation(String userName, int userHeight, int userWeight, int userId) {
		super();
		this.userName = userName;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userId = userId;
	}




	//メールアドレス重複チェック用
	public Userinformation(String userMailAddress) {
		super();
		this.userMailAddress = userMailAddress;
	}


	//体重と性別の検索用
	public Userinformation(int userId) {
		super();
		this.userId = userId;
	}



	public Userinformation(String userName, int userHeight, int userWeight) {
		super();
		this.userName = userName;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
	}

	//セッター・ゲッター

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserMailAddress() {
		return userMailAddress;
	}

	public void setUserMailAddress(String userMailAddress) {
		this.userMailAddress = userMailAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}

	public int getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}

}