package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/myGex", "sa", "");

				// SQL文を準備する
							String sql = "insert into TRAINING_RECORD"
									+ "(training_record_date,"
									+ "user_id,"
									+ "training_menu,"
									+ "training_weight,"
									+ "training_count,"
									+ "training_set,"
									+ "training_exp)"
									+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
							PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
							if (card.getTraining_record_date() != null) {

								pStmt.setDate(1, (Date) card.getTraining_record_date());
							}
							else {
								pStmt.setDate(1, null);
							}
							if (card.getUser_id() != 0) {
								pStmt.setInt(2, card.getUser_id());
							}
							else {
								pStmt.setInt(2, 0);
							}

							if (card.getTraining_menu() != null) {
								pStmt.setString(3, card.getTraining_menu());
							}
							else {
								pStmt.setString(3, null);
							}

							if (card.getTraining_weight() != 0) {
								pStmt.setDouble(4, card.getTraining_weight());
							}
							else {
								pStmt.setDouble(4, 0);
							}

							if (card.getTraining_count() != 0) {
								pStmt.setInt(5, card.getTraining_count());
							}
							else {
								pStmt.setInt(5, 0);
							}

							if (card.getTraining_set() != 0) {
								pStmt.setInt(6, card.getTraining_set());
							}
							else {
								pStmt.setInt(6, 0);
							}

							if (card.getTraining_exp() != 0) {
								pStmt.setInt(7, card.getTraining_exp());
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
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Trainingrecord card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/myGex", "sa", "");

				// SQL文を準備する
				String sql = "update set TRAINING_RECORD where"
						+ "(training_menu,"
						+ "training_weight,"
						+ "training_count,"
						+ "training_set,"
						+ "training_exp)"
						+ "VALUES(?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				if (card.getTraining_menu() != null) {

					pStmt.setString(1, card.getTraining_menu());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getTraining_weight() != 0) {
					pStmt.setDouble(2, card.getTraining_weight());
				}
				else {
					pStmt.setDouble(2, 0);
				}

				if (card.getTraining_count() != 0) {
					pStmt.setInt(3, card.getTraining_count());
				}
				else {
					pStmt.setInt(3, 0);
				}

				if (card.getTraining_set() != 0) {
					pStmt.setInt(4, card.getTraining_set());
				}
				else {
					pStmt.setInt(4, 0);
				}

				if (card.getTraining_exp() != 0) {
					pStmt.setInt(5, card.getTraining_exp());
				}
				else {
					pStmt.setInt(5, 0);
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

		// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/myGex", "sa", "");

				// SQL文を準備する
				String sql = "delete from TRAINING_RECORD where training_record_id = ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

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

		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Trainingrecord> select(Trainingrecord param) {
			Connection conn = null;
			List<Trainingrecord> cardList = new ArrayList<Trainingrecord>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/myGex", "sa", "");

				// SQL文を準備する
				String sql = "select * from TRAINING_RECORD WHERE"
						+ "(training_record_date = ? ,"
						+ "user_id =?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getTraining_record_date() != null) {
					java.sql.Date sqlDate = new java.sql.Date(param.getTraining_record_date().getTime());
					pStmt.setDate(1, sqlDate);
				}
				else {
					pStmt.setDate(1, null);
				}
				if (param.getUser_id() != 0) {
					pStmt.setInt(2,param.getUser_id());
				}
				else {
					pStmt.setInt(2,0);
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Trainingrecord card = new Trainingrecord(
					rs.getString("training_menu"),
					rs.getDouble("training_weight"),
					rs.getInt("training_count"),
					rs.getInt("training_set"),
					rs.getInt("training_exp"));
					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}
}