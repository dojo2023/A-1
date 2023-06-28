package model;

import java.io.Serializable;
import java.sql.Date;

//フィールド
public class Trainingrecord implements Serializable {


private int trainingRecordId;
private Date trainingRecordDate;
private int userId;
private String trainingMenu;
private double trainingWeight;
private int trainingCount;
private int trainingSet;
private int trainingExp;

//コンストラクタ
public Trainingrecord( int trainingRecordId, Date trainingRecordDate,int userId,String trainingMenu, double trainingWeight,
		int trainingCount, int trainingSet, int trainingExp) {
	super();

	this.trainingRecordId = trainingRecordId;
	this.trainingRecordDate = trainingRecordDate;
	this.userId = userId;
	this.trainingMenu = trainingMenu;
	this.trainingWeight = trainingWeight;
	this.trainingCount = trainingCount;
	this.trainingSet = trainingSet;
	this.trainingExp = trainingExp;
}

//String型の初期値null避け
	public Trainingrecord() {
		this.trainingMenu = "";
	}

//トレーニング記録登録のコンストラクタ

public Trainingrecord(Date trainingRecordDate, int userId, String trainingMenu,
		double trainingWeight, int trainingCount, int trainingSet, int trainingExp/*, String trainingRecordDow*/) {
	super();
	this.trainingRecordDate = trainingRecordDate;
	this.userId = userId;
	this.trainingMenu = trainingMenu;
	this.trainingWeight = trainingWeight;
	this.trainingCount = trainingCount;
	this.trainingSet = trainingSet;
	this.trainingExp = trainingExp;
}


//トレーニング記録結果表示のコンストラクタ

public Trainingrecord(String trainingMenu, double trainingWeight, int trainingCount, int trainingSet,
		int trainingExp) {
	super();
	this.trainingMenu = trainingMenu;
	this.trainingWeight = trainingWeight;
	this.trainingCount = trainingCount;
	this.trainingSet = trainingSet;
	this.trainingExp = trainingExp;
}

//トレーニング記録更新のコンストラクタ

public Trainingrecord(int trainingRecordId ,String trainingMenu, double trainingWeight, int trainingCount, int trainingSet) {
	super();
	this.trainingRecordId = trainingRecordId;
	this.trainingMenu = trainingMenu;
	this.trainingWeight = trainingWeight;
	this.trainingCount = trainingCount;
	this.trainingSet = trainingSet;
}



//トレーニング記録検索のコンストラクタ

public Trainingrecord(Date trainingRecordDate, int userId) {
	super();
	this.trainingRecordDate = trainingRecordDate;
	this.userId = userId;
}

//経験値計算用
public Trainingrecord(int userId) {
	super();
	this.userId = userId;
}

//セッターとゲッター

public int getTrainingRecordId() {
	return trainingRecordId;
}

public void setTrainingRecordId(int trainingRecordId) {
	this.trainingRecordId = trainingRecordId;
}

public Date getTrainingRecordDate() {
	return trainingRecordDate;
}

public void setTrainingRecordDate(Date trainingRecordDate) {
	this.trainingRecordDate = trainingRecordDate;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getTrainingMenu() {
	return trainingMenu;
}

public void setTrainingMenu(String trainingMenu) {
	this.trainingMenu = trainingMenu;
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

}