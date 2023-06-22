package model;

import java.io.Serializable;

public class Trainingmenu implements Serializable{
	//こっからフィールド

	private int trainingMenuId;
	private String trainingMenu;
	private double trainingMenuMagnification;

	//コンストラクタ
	public Trainingmenu(int trainingMenuId, String trainingMenu, double trainingMenuMagnification) {
		super();
		this.trainingMenuId = trainingMenuId;
		this.trainingMenu = trainingMenu;
		this.trainingMenuMagnification = trainingMenuMagnification;
	}

	//String型の初期値null避け
	public Trainingmenu() {
		this.trainingMenu = "";
	}

	public Trainingmenu(double trainingMenuMagnification) {
		super();
		this.trainingMenuMagnification = trainingMenuMagnification;
	}


	public Trainingmenu(String trainingMenu) {
		super();
		this.trainingMenu = trainingMenu;
	}

	//セッター・ゲッター

	public int getTrainingMenuId() {
		return trainingMenuId;
	}

	public void setTrainingMenuId(int trainingMenuId) {
		this.trainingMenuId = trainingMenuId;
	}

	public String getTrainingMenu() {
		return trainingMenu;
	}

	public void setTrainingMenu(String trainingMenu) {
		this.trainingMenu = trainingMenu;
	}

	public double getTrainingMenuMagnification() {
		return trainingMenuMagnification;
	}

	public void setTrainingMenuMagnification(double trainingMenuMagnification) {
		this.trainingMenuMagnification = trainingMenuMagnification;
	}

}