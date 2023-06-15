package model;

import java.io.Serializable;
import java.util.Date;

//フィールド
public class Trainingrecord implements Serializable {


private int training_record_id;
private Date training_record_date;
private int user_id;
private String training_menu;
private double training_weight;
private int training_count;
private int training_set;
private int training_exp;

//コンストラクタ
public Trainingrecord( int training_record_id, Date training_record_date,int user_id,String training_menu, double training_weight,
		int training_count, int training_set, int training_exp) {
	super();

	this.training_record_id = training_record_id;
	this.training_record_date = training_record_date;
	this.user_id = user_id;
	this.training_menu = training_menu;
	this.training_weight = training_weight;
	this.training_count = training_count;
	this.training_set = training_set;
	this.training_exp = training_exp;
}

//トレーニング記録登録のコンストラクタ

public Trainingrecord(Date training_record_date, int user_id, String training_menu,
		double training_weight, int training_count, int training_set, int training_exp) {
	super();
	this.training_record_date = training_record_date;
	this.user_id = user_id;
	this.training_menu = training_menu;
	this.training_weight = training_weight;
	this.training_count = training_count;
	this.training_set = training_set;
	this.training_exp = training_exp;
}

//トレーニング記録更新のコンストラクタ

public Trainingrecord(String training_menu, double training_weight, int training_count, int training_set,
		int training_exp) {
	super();
	this.training_menu = training_menu;
	this.training_weight = training_weight;
	this.training_count = training_count;
	this.training_set = training_set;
	this.training_exp = training_exp;
}

//トレーニング記録検索のコンストラクタ

public Trainingrecord(Date training_record_date, int user_id) {
	super();
	this.training_record_date = training_record_date;
	this.user_id = user_id;
}

//セッターとゲッターよ
public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public int getTraining_record_id() {
	return training_record_id;
}


public void setTraining_record_id(int training_record_id) {
	this.training_record_id = training_record_id;
}


public Date getTraining_record_date() {
	return training_record_date;
}


public void setTraining_record_date(Date training_record_date) {
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


public String getTraining_menu() {
	return training_menu;
}


public void setTraining_menu(String training_menu) {
	this.training_menu = training_menu;
}
}