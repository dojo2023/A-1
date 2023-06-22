package model;

import java.io.Serializable;

public class Alltable implements Serializable{

	//こっからフィールド
	private int userId;
	private String userName;
	private int userSex;
	private String userBirth;
	private String userMailAddress;
	private String userPassword;
	private int userHeight;
	private int userWeight;
	private int trainingMenuId;
	private String trainingMenu;
	private double trainingMenuMagnification;
	private int trainingRecordId;
	private String trainingRecordDate;
	private double trainingWeight;
	private int trainingCount;
	private int trainingSet;
	private int trainingExp;
	private String trainingRecordDow;

	//こっからコンストラクタ
	public Alltable(int userId, String userName, int userSex, String userBirth, String userMailAddress,
			String userPassword, int userHeight, int userWeight, int trainingMenuId, String trainingMenu,
			double trainingMenuMagnification, int trainingRecordId, String trainingRecordDate, double trainingWeight,
			int trainingCount, int trainingSet, int trainingExp, String trainingRecordDow) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userMailAddress = userMailAddress;
		this.userPassword = userPassword;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.trainingMenuId = trainingMenuId;
		this.trainingMenu = trainingMenu;
		this.trainingMenuMagnification = trainingMenuMagnification;
		this.trainingRecordId = trainingRecordId;
		this.trainingRecordDate = trainingRecordDate;
		this.trainingWeight = trainingWeight;
		this.trainingCount = trainingCount;
		this.trainingSet = trainingSet;
		this.trainingExp = trainingExp;
		this.trainingRecordDow = trainingRecordDow;
	}

	public Alltable() {

	}

	//こっからセッター・ゲッター

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

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
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

	public int getTrainingRecordId() {
		return trainingRecordId;
	}

	public void setTrainingRecordId(int trainingRecordId) {
		this.trainingRecordId = trainingRecordId;
	}

	public String getTrainingRecordDate() {
		return trainingRecordDate;
	}

	public void setTrainingRecordDate(String trainingRecordDate) {
		this.trainingRecordDate = trainingRecordDate;
	}

	public double getTrainingWeight() {
		return trainingWeight;
	}

	public void setTrainingWeight(double trainingWeight) {
		this.trainingWeight = trainingWeight;
	}

	public int getTrainingCount() {
		return trainingCount;
	}

	public void setTrainingCount(int trainingCount) {
		this.trainingCount = trainingCount;
	}

	public int getTrainingSet() {
		return trainingSet;
	}

	public void setTrainingSet(int trainingSet) {
		this.trainingSet = trainingSet;
	}

	public int getTrainingExp() {
		return trainingExp;
	}

	public void setTrainingExp(int trainingExp) {
		this.trainingExp = trainingExp;
	}

	public String getTrainingRecordDow() {
		return trainingRecordDow;
	}

	public void setTrainingRecordDow(String trainingRecordDow) {
		this.trainingRecordDow = trainingRecordDow;
	}

}