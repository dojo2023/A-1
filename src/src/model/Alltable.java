package model;

import java.io.Serializable;

public class Alltable implements Serializable{

	//こっからフィールド
	private int user_id;
	private String user_name;
	private int user_sex;
	private String user_birth;
	private String user_mail_address;
	private String user_password;
	private int user_height;
	private int user_weight;
	private int training_menu_id;
	private String training_menu;
	private double training_menu_magnification;
	private int training_record_id;
	private String training_record_date;
	private double training_weight;
	private int training_count;
	private int training_set;
	private int training_exp;

	//こっからコンストラクタ
	public Alltable(int user_id, String user_name, int user_sex, String user_birth, String user_mail_address,
			String user_password, int user_height, int user_weight, int training_menu_id, String training_menu,
			double training_menu_magnification, int training_record_id, String training_record_date,
			double training_weight, int training_count, int training_set, int training_exp) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_birth = user_birth;
		this.user_mail_address = user_mail_address;
		this.user_password = user_password;
		this.user_height = user_height;
		this.user_weight = user_weight;
		this.training_menu_id = training_menu_id;
		this.training_menu = training_menu;
		this.training_menu_magnification = training_menu_magnification;
		this.training_record_id = training_record_id;
		this.training_record_date = training_record_date;
		this.training_weight = training_weight;
		this.training_count = training_count;
		this.training_set = training_set;
		this.training_exp = training_exp;
	}
	//こっからセッター・ゲッター
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

	public int getTraining_menu_id() {
		return training_menu_id;
	}

	public void setTraining_menu_id(int training_menu_id) {
		this.training_menu_id = training_menu_id;
	}

	public String getTraining_menu() {
		return training_menu;
	}

	public void setTraining_menu(String training_menu) {
		this.training_menu = training_menu;
	}

	public double getTraining_menu_magnification() {
		return training_menu_magnification;
	}

	public void setTraining_menu_magnification(double training_menu_magnification) {
		this.training_menu_magnification = training_menu_magnification;
	}

	public int getTraining_record_id() {
		return training_record_id;
	}

	public void setTraining_record_id(int training_record_id) {
		this.training_record_id = training_record_id;
	}

	public String getTraining_record_date() {
		return training_record_date;
	}

	public void setTraining_record_date(String training_record_date) {
		this.training_record_date = training_record_date;
	}

	public double getTraining_weight() {
		return training_weight;
	}

	public void setTraining_weight(double training_weight) {
		this.training_weight = training_weight;
	}

	public int getTraining_count() {
		return training_count;
	}

	public void setTraining_count(int training_count) {
		this.training_count = training_count;
	}

	public int getTraining_set() {
		return training_set;
	}

	public void setTraining_set(int training_set) {
		this.training_set = training_set;
	}

	public int getTraining_exp() {
		return training_exp;
	}

	public void setTraining_exp(int training_exp) {
		this.training_exp = training_exp;
	}
}