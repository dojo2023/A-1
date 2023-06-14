package model;

import java.io.Serializable;

public class Userinformation implements Serializable{
	//こっからフィールド
	private int user_id;
	private String user_name;
	private int user_sex;
	private String user_birth;
	private String user_mail_address;
	private String user_password;
	private int user_height;
	private int user_weight;

//コンストラクタ
	//全部入れ
	public Userinformation(int user_id, String user_name, int user_sex, String user_birth, String user_mail_address,
			String user_password, int user_height, int user_weight) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_birth = user_birth;
		this.user_mail_address = user_mail_address;
		this.user_password = user_password;
		this.user_height = user_height;
		this.user_weight = user_weight;
	}


	//ログイン用
	public Userinformation(String user_mail_address, String user_password) {
		super();
		this.user_mail_address = user_mail_address;
		this.user_password = user_password;
	}



	//ユーザー登録用
	public Userinformation(String user_name, int user_sex, String user_birth, String user_mail_address,
			String user_password, int user_height, int user_weight) {
		super();
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_birth = user_birth;
		this.user_mail_address = user_mail_address;
		this.user_password = user_password;
		this.user_height = user_height;
		this.user_weight = user_weight;
	}

	//ユーザー情報更新用
	public Userinformation(String user_name, int user_height, int user_weight, int user_id) {
		super();
		this.user_name = user_name;
		this.user_height = user_height;
		this.user_weight = user_weight;
		this.user_id = user_id;
	}

	//ユーザーの体重
	public Userinformation(int user_weight) {
		super();
		this.user_weight = user_weight;
	}

	//ユーザーの性別
	public Userinformation(int user_sex) {
		super();
		this.user_sex = user_sex;
	}


	//セッター・ゲッター
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_mail_address() {
		return user_mail_address;
	}

	public void setUser_mail_address(String user_mail_address) {
		this.user_mail_address = user_mail_address;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_height() {
		return user_height;
	}

	public void setUser_height(int user_height) {
		this.user_height = user_height;
	}

	public int getUser_weight() {
		return user_weight;
	}

	public void setUser_weight(int user_weight) {
		this.user_weight = user_weight;
	}


}