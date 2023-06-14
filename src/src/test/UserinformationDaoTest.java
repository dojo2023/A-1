package test;

import java.util.List;

import dao.UserinformationDao;
import model.Userinformation;

public class UserinformationDaoTest {
	public static void main(String[] args) {
		testIsLoginOK1();	// ユーザーが見つかる場合のテスト
		testIsLoginOK2();	// ユーザーが見つからない場合のテスト
		testUserRegist(); //ユーザー登録のテスト
		testUserUpdate(); //ユーザー情報更新のテスト
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		UserinformationDao dao = new UserinformationDao();
		if (dao.isLoginOK(new Userinformation("jiro@jiro", "jiro"))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		UserinformationDao dao = new UserinformationDao();
		if (!dao.isLoginOK(new Userinformation("DOJO", "pass"))) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		}
		else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}


	// insert()のテスト
	public static void testUserRegist() {

	UserinformationDao dao = new UserinformationDao();

			System.out.println("---------- insert()のテスト ----------");
			Userinformation insTes = new Userinformation(
					"MK",1,"2000-09-13","mk@mk","mk",170,65
					);

			if (dao.insert(insTes)) {
				System.out.println("登録成功！");
				List<Userinformation> cardList1 = dao.select(insTes);
				for (Userinformation card : cardList1) {
					System.out.println("USER_ID：" + card.getUser_id());
						insTes.setUser_id(card.getUser_id());
					System.out.println("USER_NAME：" + card.getUser_name());
					System.out.println("USER_SEX : " + card.getUser_sex());
					System.out.println("USER_BIRTH：" + card.getUser_birth());
					System.out.println("USER_MAIL_ADDRESS : " + card.getUser_mail_address());
					System.out.println("USER_PASSWORD : " + card.getUser_password());
					System.out.println("USER_HEIGHT : " + card.getUser_height());
					System.out.println("USER_WEIGHT : " + card.getUser_weight());
					System.out.println();
				}
			}
			else {
				System.out.println("登録失敗！");
			}
	}
	//update()のテスト

	public static void testUserUpdate(){

		UserinformationDao dao = new UserinformationDao();
	System.out.println("---------- update()のテスト ----------");
		Userinformation upRec = new Userinformation("maki",165,70, 2);

		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Userinformation> cardList1 = dao.select(upRec);
			for (Userinformation card : cardList1) {
				System.out.println("USER_NAME：" + card.getUser_name());
				System.out.println("USER_HEIGHT : " + card.getUser_height());
				System.out.println("USER_WEIGHT : " + card.getUser_weight());
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}
}
