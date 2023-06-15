package test;

import java.sql.Date;
import java.util.List;

import dao.TrainingrecordDao;
import model.Trainingrecord;

public class TrainingRecordDaoTest {
	public static void main(String[] args) {
		//testTrainingRegist(); トレーニング記録登録のテスト
		testTrainingRecordSearch(); //トレーニング記録検索のテスト
		testTrainingRecordUpdate(); //トレーニング記録更新のテスト
	}

	/* insert()のテスト
	public static void testTrainingRegist() {

	TrainingrecordDao dao = new TrainingrecordDao();

			System.out.println("---------- insert()のテスト ----------");


			if (dao.insert(insTes)) {
				System.out.println("登録成功！");
				List<Trainingrecord> trainingRecordList1 = dao(insTes);
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
	}*/

	//select()のテスト
	public static void testTrainingRecordSearch() {
		TrainingrecordDao dao = new TrainingrecordDao();
		System.out.println("---------- select()のテスト ----------");
		Trainingrecord seRec = new Trainingrecord(Date.valueOf("2023-06-15"), 1);

		if (dao.select(seRec) != null) {
			System.out.println("検索成功！");
			List<Trainingrecord> recordList1 = dao.select(seRec);
			for (Trainingrecord record : recordList1) {
				System.out.println("training_menu：" + record.getTraining_menu());
				System.out.println("training_weight : " + record.getTraining_weight());
				System.out.println("training_count : " + record.getTraining_count());
				System.out.println("training_set : " + record.getTraining_set());
				System.out.println("training_exp : " + record.getTraining_exp());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}

	//update()のテスト

	public static void testTrainingRecordUpdate(){

	TrainingrecordDao dao = new TrainingrecordDao();
	System.out.println("---------- update()のテスト ----------");
		Trainingrecord upRec = new Trainingrecord("チェストプレス",70, 3, 2,10);

		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Trainingrecord> recordList1 = dao.select(upRec);
			for (Trainingrecord record : recordList1) {
				System.out.println("training_menu：" + record.getTraining_menu());
				System.out.println("training_weight : " + record.getTraining_weight());
				System.out.println("training_count : " + record.getTraining_count());
				System.out.println("training_set : " + record.getTraining_set());
				System.out.println("training_exp : " + record.getTraining_exp());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}
}
