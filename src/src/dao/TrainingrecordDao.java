package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Alltable;
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

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
			} else {
				pStmt.setDate(1, null);
			}
			if (card.getUser_id() != 0) {
				pStmt.setInt(2, card.getUser_id());
			} else {
				pStmt.setInt(2, 0);
			}

			if (card.getTraining_menu() != null) {
				pStmt.setString(3, card.getTraining_menu());
			} else {
				pStmt.setString(3, null);
			}

			if (card.getTraining_weight() != 0) {
				pStmt.setDouble(4, card.getTraining_weight());
			} else {
				pStmt.setDouble(4, 0);
			}

			if (card.getTraining_count() != 0) {
				pStmt.setInt(5, card.getTraining_count());
			} else {
				pStmt.setInt(5, 0);
			}

			if (card.getTraining_set() != 0) {
				pStmt.setInt(6, card.getTraining_set());
			} else {
				pStmt.setInt(6, 0);
			}

			if (card.getTraining_exp() != 0) {
				pStmt.setInt(7, card.getTraining_exp());
			} else {
				pStmt.setInt(7, 0);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "update TRAINING_RECORD "
					+ "set "
					+ "training_menu = ?,"
					+ "training_weight = ?,"
					+ "training_count = ?,"
					+ "training_set = ?"
					+ "WHERE training_record_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getTraining_menu() != null) {

				pStmt.setString(1, card.getTraining_menu());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getTraining_weight() != 0) {
				pStmt.setDouble(2, card.getTraining_weight());
			} else {
				pStmt.setDouble(2, 0);
			}

			if (card.getTraining_count() != 0) {
				pStmt.setInt(3, card.getTraining_count());
			} else {
				pStmt.setInt(3, 0);
			}

			if (card.getTraining_set() != 0) {
				pStmt.setInt(4, card.getTraining_set());
			} else {
				pStmt.setInt(4, 0);
			}

			if (card.getTraining_record_id() != 0) {
				pStmt.setInt(5, card.getTraining_record_id());
			} else {
				pStmt.setInt(5, 0);
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "delete from TRAINING_RECORD where training_record_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public ArrayList<Trainingrecord> select(Trainingrecord param) {
		Connection conn = null;
		ArrayList<Trainingrecord> trainingList = new ArrayList<Trainingrecord>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "select * from TRAINING_RECORD WHERE "
					+ "user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			/*if (param.getTraining_record_date() != null) {
				pStmt.setDate(1, param.getTraining_record_date());
			} else {
				pStmt.setDate(1, null);
			}*/


			if (param.getUser_id() != 0) {
				pStmt.setInt(1, param.getUser_id());
			} else {
				pStmt.setInt(1, 0);
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				System.out.println(rs.getDate("training_record_date"));
				Trainingrecord record = new Trainingrecord(
						rs.getDate("training_record_date"),
						rs.getInt("training_record_id"),
						rs.getString("training_menu"),
						rs.getDouble("training_weight"),
						rs.getInt("training_count"),
						rs.getInt("training_set"),
						rs.getInt("training_exp"));
				record.setTraining_record_id(rs.getInt("training_record_id"));
				System.out.println(rs.getInt("training_record_id"));
				trainingList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			trainingList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			trainingList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					trainingList = null;
				}
			}
		}

		// 結果を返す
		return trainingList;
	}

	// ログインユーザーの総獲得経験値
	public int sum(Trainingrecord param) {
		Connection conn = null;
		int result = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "select sum (training_exp) as EXP_SUM from TRAINING_RECORD where "
					+ "user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (param.getUser_id() != 0) {
				pStmt.setInt(1, param.getUser_id());
			} else {
				pStmt.setInt(1, 0);
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			if (rs.next()) {
				result = rs.getInt("exp_sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}

		// 結果を返す
		return result;
	}

	//上位10ユーザーの総経験値を出すDAO
	public List<Alltable> sumAll(Trainingrecord param) {
		Connection conn = null;
		List<Alltable> expSumList = new ArrayList<Alltable>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
					+ "from TRAINING_RECORD join USER_INFORMATION "
					+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
					+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 10";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				/*Trainingrecord expSum = new Trainingrecord(
				rs.getInt("exp_sum"));
				expSumList.add(expSum);*/

				Alltable al = new Alltable();

				al.setTraining_exp(rs.getInt("SUM(TRAINING_EXP)"));
				al.setUser_name(rs.getString("user_name"));
				expSumList.add(al);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			expSumList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			expSumList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					expSumList = null;
				}
			}
		}

		// 結果を返す
		return expSumList;
	}

	//男性月間総経験値を出すDAO
		public List<Alltable> sumMonthlyMen(Trainingrecord param) {
			Connection conn = null;
			List<Alltable> expSumList = new ArrayList<Alltable>();


			//日付指定
			Date date = new Date(System.currentTimeMillis());
			java.util.Date utilDate = date;
			Date sqlDate = new Date(utilDate.getTime());
			Calendar c = Calendar.getInstance();
			c.setTime(utilDate);
			int month = c.get(Calendar.MONTH) +1;
			int year = c.get(Calendar.YEAR);

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
						+ "from TRAINING_RECORD join USER_INFORMATION "
						+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
						+ "where TRAINING_RECORD_DATE like ? and USER_SEX = 1 "
						+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 5";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				System.out.println(sql);

				String stYear = String.valueOf(year);
				String stMonth = String.valueOf(month);
				if (stMonth.length()==1) {
					stMonth = "0" + stMonth;
				}
				pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					/*Trainingrecord expSum = new Trainingrecord(
					rs.getInt("exp_sum"));
					expSumList.add(expSum);*/

					Alltable al = new Alltable();

					al.setTraining_exp(rs.getInt("SUM(TRAINING_EXP)"));
					al.setUser_name(rs.getString("user_name"));
					expSumList.add(al);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				expSumList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				expSumList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						expSumList = null;
					}
				}
			}

			// 結果を返す
			return expSumList;
		}

		//女性月間総経験値を出すDAO
				public List<Alltable> sumMonthlyWomen(Trainingrecord param) {
					Connection conn = null;
					List<Alltable> expSumList = new ArrayList<Alltable>();


					//日付指定
					Date date = new Date(System.currentTimeMillis());
					java.util.Date utilDate = date;
					Date sqlDate = new Date(utilDate.getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(utilDate);
					int month = c.get(Calendar.MONTH) +1;
					int year = c.get(Calendar.YEAR);

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

						// SQL文を準備する
						String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
								+ "from TRAINING_RECORD join USER_INFORMATION "
								+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
								+ "where TRAINING_RECORD_DATE like ? and USER_SEX = 2 "
								+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 5";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						System.out.println(sql);

						String stYear = String.valueOf(year);
						String stMonth = String.valueOf(month);
						if (stMonth.length()==1) {
							stMonth = "0" + stMonth;
						}
						pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							/*Trainingrecord expSum = new Trainingrecord(
							rs.getInt("exp_sum"));
							expSumList.add(expSum);*/

							Alltable al = new Alltable();

							al.setTraining_exp(rs.getInt("SUM(TRAINING_EXP)"));
							al.setUser_name(rs.getString("user_name"));
							expSumList.add(al);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						expSumList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						expSumList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								expSumList = null;
							}
						}
					}

					// 結果を返す
					return expSumList;
				}


				//男性週間総経験値を出すDAO
				public List<Alltable> sumWeeklyMen(Trainingrecord param) {
					Connection conn = null;
					List<Alltable> expSumList = new ArrayList<Alltable>();


					//日付指定
					Date date = new Date(System.currentTimeMillis());
					java.util.Date utilDate = date;
					Date sqlDate = new Date(utilDate.getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(utilDate);
					int month = c.get(Calendar.MONTH) +1;
					int year = c.get(Calendar.YEAR);

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

						// SQL文を準備する
						String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
								+ "from TRAINING_RECORD join USER_INFORMATION "
								+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
								+ "where TRAINING_RECORD_DATE like ? and USER_SEX = 1 "
								+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 5";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						System.out.println(sql);

						String stYear = String.valueOf(year);
						String stMonth = String.valueOf(month);
						if (stMonth.length()==1) {
							stMonth = "0" + stMonth;
						}
						pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							/*Trainingrecord expSum = new Trainingrecord(
							rs.getInt("exp_sum"));
							expSumList.add(expSum);*/

							Alltable al = new Alltable();

							al.setTraining_exp(rs.getInt("SUM(TRAINING_EXP)"));
							al.setUser_name(rs.getString("user_name"));
							expSumList.add(al);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						expSumList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						expSumList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								expSumList = null;
							}
						}
					}

					// 結果を返す
					return expSumList;
				}


				//女性月間総経験値を出すDAO
				public List<Alltable> sumWeeklyWomen(Trainingrecord param) {
					Connection conn = null;
					List<Alltable> expSumList = new ArrayList<Alltable>();


					//日付指定
					Date date = new Date(System.currentTimeMillis());
					java.util.Date utilDate = date;
					Date sqlDate = new Date(utilDate.getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(utilDate);
					int month = c.get(Calendar.MONTH) +1;
					int year = c.get(Calendar.YEAR);

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

						// SQL文を準備する
						String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
								+ "from TRAINING_RECORD join USER_INFORMATION "
								+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
								+ "where TRAINING_RECORD_DATE like ? and USER_SEX = 2 "
								+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 5";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						System.out.println(sql);

						String stYear = String.valueOf(year);
						String stMonth = String.valueOf(month);
						if (stMonth.length()==1) {
							stMonth = "0" + stMonth;
						}
						pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");


						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							/*Trainingrecord expSum = new Trainingrecord(
							rs.getInt("exp_sum"));
							expSumList.add(expSum);*/

							Alltable al = new Alltable();

							al.setTraining_exp(rs.getInt("SUM(TRAINING_EXP)"));
							al.setUser_name(rs.getString("user_name"));
							expSumList.add(al);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						expSumList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						expSumList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								expSumList = null;
							}
						}
					}

					// 結果を返す
					return expSumList;
				}
}