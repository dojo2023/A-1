package model;

import java.io.Serializable;

public class Trainingmenu implements Serializable{
	//こっからフィールド

	private int training_menu_id;
	private String training_menu;
	private double training_menu_magnification;

	//コンストラクタ
	public Trainingmenu(int training_menu_id, String training_menu, double training_menu_magnification) {
		super();
		this.training_menu_id = training_menu_id;
		this.training_menu = training_menu;
		this.training_menu_magnification = training_menu_magnification;
	}

	public Trainingmenu(double training_menu_magnification) {
		super();
		this.training_menu_magnification = training_menu_magnification;
	}


	public Trainingmenu(String training_menu) {
		super();
		this.training_menu = training_menu;
	}

	//セッター・ゲッター
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
}