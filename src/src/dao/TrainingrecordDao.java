package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Trainingrecord;

public class TrainingrecordDao {
	
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Trainingrecord card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

				// SQL文を準備する
							String sql = "insert into TRAINING_RECORD"
									+ "(training_record_date,user_id,training_menu,training_weight,training_count,training_set,training_exp)"
									+ "VALUES(GETTIME(), ?, ?, ?, ?, ?, ?)";
							PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
							if (card.getUser_name() != null && !card.getUser_name().equals("")) {
								pStmt.setString(1, card.getUser_name());
							}
							else {
								pStmt.setString(1, null);
							}

							if (card.getUser_sex() != 0) {
								pStmt.setInt(2, card.getUser_sex());
							}
							else {
								pStmt.setInt(2, 0);
							}

							if (card.getUser_birth() != null && !card.getUser_birth().equals("")) {
								pStmt.setString(3, card.getUser_birth());
							}
							else {
								pStmt.setString(3, null);
							}

							if (card.getUser_mail_address() != null && !card.getUser_mail_address().equals("")) {
								pStmt.setString(4, card.getUser_mail_address());
							}
							else {
								pStmt.setString(4, null);
							}

							if (card.getUser_password() != null && !card.getUser_password().equals("")) {
								pStmt.setString(5, card.getUser_password());
							}
							else {
								pStmt.setString(5, null);
							}

							if (card.getUser_height() != 0) {
								pStmt.setInt(6, card.getUser_height());
							}
							else {
								pStmt.setInt(6, 0);
							}

							if (card.getUser_weight() != 0) {
								pStmt.setInt(7, card.getUser_weight());
							}
							else {
								pStmt.setInt(7, 0);
							}

							// SQL文を実行する
							if (pStmt.executeUpdate() == 1) {
								result = true;
							}
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						finally {
							// データベースを切断
							if (conn != null) {
								try {
									conn.close();
								}
								catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}

			// 結果を返す
				return result;
		}

}