package test;

import java.util.List;

import dao.TrainingrecordDao;
import model.Trainingrecord;

public class TrainingRecordDaoTest {
	public static void main(String[] args) {
		testTrainingRegist(); //トレーニング記録登録のテスト
		//testTrainingUpdate(); トレーニング記録更新のテスト
	}

	// insert()のテスト
	public static void testTrainingRegist() {

	TrainingrecordDao dao = new TrainingrecordDao();

			System.out.println("---------- insert()のテスト ----------");
			Trainingrecord insTes = new Trainingrecord(
					2, "20230613", 1, "チェストプレス", 30, 20, 2
					);

			if (dao.insert(insTes)) {
				System.out.println("登録成功！");
				List<Trainingrecord> trainingRecordList1 = dao.select(insTes);
				for (Trainingrecord record : trainingRecordList1) {
					System.out.println("TRAINING_RECORD_ID：" + record.getTraining_record_id());
					System.out.println("TRAINING_RECORD_DATE：" + record.getTraining_record_date());
					System.out.println("USER_ID : " + record.getUser_id());
					System.out.println("TRAINING_MENU：" + record.getTraining_menu());
					System.out.println("TRAINING_WEIGHT : " + record.getTraining_weight());
					System.out.println("TRAINING_COUNT : " + record.getTraining_count());
					System.out.println("TRAINING_SET : " + record.getTraining_set());
					System.out.println("TRAINING_EXP : " + record.getTraining_exp());
					System.out.println();
				}
			}
			else {
				System.out.println("登録失敗！");
			}
	}
	//update()のテスト

	//public static void testUserUpdate(){

		//UserinformationDao dao = new UserinformationDao();
	//System.out.println("---------- update()のテスト ----------");
		//Userinformation upRec = new Userinformation("maki",165,70, 2);

		//if (dao.update(upRec)) {
			//System.out.println("更新成功！");
			//List<Userinformation> cardList1 = dao.select(upRec);
			//for (Userinformation card : cardList1) {
				//System.out.println("USER_NAME：" + card.getUser_name());
				//System.out.println("USER_HEIGHT : " + card.getUser_height());
				//System.out.println("USER_WEIGHT : " + card.getUser_weight());
			//}
		//}
		//else {
			//System.out.println("更新失敗！");
		//}
	//}
}
