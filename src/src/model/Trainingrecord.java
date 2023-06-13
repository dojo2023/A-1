package model;

import java.io.Serializable;

public class Trainingrecord implements Serializable {

private int user_id;
private int training_record_id;
private String training_record_date;
private double training_weight;
private int training_count;
private int training_set;
private int training_exp;


public Trainingrecord(int user_id, int training_record_id, String training_record_date, double training_weight,
		int training_count, int training_set, int training_exp) {
	super();
	this.user_id = user_id;
	this.training_record_id = training_record_id;
	this.training_record_date = training_record_date;
	this.training_weight = training_weight;
	this.training_count = training_count;
	this.training_set = training_set;
	this.training_exp = training_exp;
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