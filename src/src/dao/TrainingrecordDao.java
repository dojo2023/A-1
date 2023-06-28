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

	// トレーニング記録の登録SQL文

	public boolean insert(Trainingrecord record) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "insert into TRAINING_RECORD"
					+ "(training_record_date,"
					+ "user_id,"
					+ "training_menu,"
					+ "training_weight,"
					+ "training_count,"
					+ "training_set,"
					+ "training_exp)"
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (record.getTrainingRecordDate() != null) {
				pStmt.setDate(1, (Date) record.getTrainingRecordDate());
			} else {
				pStmt.setDate(1, null);
			}

			if (record.getUserId() != 0) {
				pStmt.setInt(2, record.getUserId());
			} else {
				pStmt.setInt(2, 0);
			}

			if (record.getTrainingMenu() != null) {
				pStmt.setString(3, record.getTrainingMenu());
			} else {
				pStmt.setString(3, null);
			}

			if (record.getTrainingWeight() != 0) {
				pStmt.setDouble(4, record.getTrainingWeight());
			} else {
				pStmt.setDouble(4, 0);
			}

			if (record.getTrainingCount() != 0) {
				pStmt.setInt(5, record.getTrainingCount());
			} else {
				pStmt.setInt(5, 0);
			}

			if (record.getTrainingSet() != 0) {
				pStmt.setInt(6, record.getTrainingSet());
			} else {
				pStmt.setInt(6, 0);
			}

			if (record.getTrainingExp() != 0) {
				pStmt.setInt(7, record.getTrainingExp());
			} else {
				pStmt.setInt(7, 0);
			}

			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// トレーニング記録の更新用SQL文

	public boolean update(Trainingrecord record) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "update TRAINING_RECORD "
					+ "set "
					+ "training_menu = ?,"
					+ "training_weight = ?,"
					+ "training_count = ?,"
					+ "training_set = ? "
					+ "where training_record_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (record.getTrainingMenu() != null) {
				pStmt.setString(1, record.getTrainingMenu());
			} else {
				pStmt.setString(1, null);
			}

			if (record.getTrainingWeight() != 0) {
				pStmt.setDouble(2, record.getTrainingWeight());
			} else {
				pStmt.setDouble(2, 0);
			}

			if (record.getTrainingCount() != 0) {
				pStmt.setInt(3, record.getTrainingCount());
			} else {
				pStmt.setInt(3, 0);
			}

			if (record.getTrainingSet() != 0) {
				pStmt.setInt(4, record.getTrainingSet());
			} else {
				pStmt.setInt(4, 0);
			}

			if (record.getTrainingRecordId() != 0) {
				pStmt.setInt(5, record.getTrainingRecordId());
			} else {
				pStmt.setInt(5, 0);
			}

			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// トレーニング記録の削除SQL文

	public boolean delete(int param) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "delete from TRAINING_RECORD where training_record_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す

	public ArrayList<Trainingrecord> select(Trainingrecord param) {
		Connection conn = null;
		ArrayList<Trainingrecord> trainingList = new ArrayList<Trainingrecord>();

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select * from TRAINING_RECORD where "
					+ "user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserId() != 0) {
				pStmt.setInt(1, param.getUserId());
			} else {
				pStmt.setInt(1, 0);
			}

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Trainingrecord record = new Trainingrecord(
					rs.getDate("training_record_date"),
					rs.getInt("training_record_id"),
					rs.getString("training_menu"),
					rs.getDouble("training_weight"),
					rs.getInt("training_count"),
					rs.getInt("training_set"),
					rs.getInt("training_exp")
				);

				record.setTrainingRecordId(rs.getInt("training_record_id"));

				trainingList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			trainingList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			trainingList = null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					trainingList = null;
				}
			}
		}

		return trainingList;
	}

	// ログインユーザーの総獲得経験値

	public int sum(Trainingrecord param) {
		Connection conn = null;
		int result = 0;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select sum (training_exp) as EXP_SUM from TRAINING_RECORD where "
					+ "user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserId() != 0) {
				pStmt.setInt(1, param.getUserId());
			} else {
				pStmt.setInt(1, 0);
			}

			ResultSet rs = pStmt.executeQuery();

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}

		return result;
	}

	//上位10ユーザーの総経験値を出すDAO

	public List<Alltable> sumAll(Trainingrecord param) {
		Connection conn = null;
		List<Alltable> expSumList = new ArrayList<Alltable>();

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
					+ "from TRAINING_RECORD join USER_INFORMATION "
					+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
					+ "group by TRAINING_RECORD.USER_ID order by sum (training_exp) desc limit 10";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Alltable al = new Alltable();

				al.setTrainingExp(rs.getInt("sum(training_exp)"));
				al.setUserName(rs.getString("user_name"));
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

		return expSumList;
	}

	//男性月間総経験値を出すDAO

		public List<Alltable> sumMonthlyMen(Trainingrecord param) {
			Connection conn = null;
			List<Alltable> expSumList = new ArrayList<Alltable>();


			//日付指定
			Date date = new Date(System.currentTimeMillis());
			java.util.Date utilDate = date;
			Calendar c = Calendar.getInstance();
			c.setTime(utilDate);
			int month = c.get(Calendar.MONTH) +1;
			int year = c.get(Calendar.YEAR);

			try {
				Class.forName("org.h2.Driver");

				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
						+ "from TRAINING_RECORD join USER_INFORMATION "
						+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
						+ "where TRAINING_RECORD_DATE like ? and user_sex = 1 "
						+ "group by TRAINING_RECORD.user_id order by sum (training_exp) desc limit 5";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				String stYear = String.valueOf(year);
				String stMonth = String.valueOf(month);
				if (stMonth.length()==1) {
					stMonth = "0" + stMonth;
				}
				pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");

				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Alltable al = new Alltable();

					al.setTrainingExp(rs.getInt("sum(training_exp)"));
					al.setUserName(rs.getString("user_name"));
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

		return expSumList;
	}

	//女性月間総経験値を出すDAO

	public List<Alltable> sumMonthlyWomen(Trainingrecord param) {
		Connection conn = null;
		List<Alltable> expSumList = new ArrayList<Alltable>();

		//日付指定
		Date date = new Date(System.currentTimeMillis());
		java.util.Date utilDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(utilDate);
		int month = c.get(Calendar.MONTH) +1;
		int year = c.get(Calendar.YEAR);

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
					+ "from TRAINING_RECORD join USER_INFORMATION "
					+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
					+ "where TRAINING_RECORD_DATE like ? and user_sex = 2 "
					+ "group by TRAINING_RECORD.user_id order by sum (training_exp) desc limit 5";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			String stYear = String.valueOf(year);
			String stMonth = String.valueOf(month);
			if (stMonth.length()==1) {
				stMonth = "0" + stMonth;
			}
			pStmt.setString(1, "%" + stYear + "-" + stMonth + "%");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Alltable al = new Alltable();

				al.setTrainingExp(rs.getInt("sum(training_exp)"));
				al.setUserName(rs.getString("user_name"));
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

		return expSumList;
	}


	//男性週間総経験値を出すDAO

	public List<Alltable> sumWeeklyMen(Trainingrecord param) {
		Connection conn = null;
		List<Alltable> expSumList = new ArrayList<Alltable>();

		//日付指定
		Date date = new Date(System.currentTimeMillis());
		java.util.Date utilDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(utilDate);
		int month = c.get(Calendar.MONTH) +1;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
					+ "from TRAINING_RECORD join USER_INFORMATION "
					+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
					+ "where training_record_date >= (NOW() - INTERVAL 7 DAY) and user_sex = 1 "
					+ "group by TRAINING_RECORD.user_id order by sum (training_exp) desc limit 5";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			String stMonth = String.valueOf(month);
			if (stMonth.length()==1) {
				stMonth = "0" + stMonth;
			}

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Alltable al = new Alltable();

				al.setTrainingExp(rs.getInt("sum(training_exp)"));
				al.setUserName(rs.getString("user_name"));
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

		return expSumList;
	}


	//女性週間総経験値を出すDAO

	public List<Alltable> sumWeeklyWomen(Trainingrecord param) {
		Connection conn = null;
		List<Alltable> expSumList = new ArrayList<Alltable>();

		//日付指定
		Date date = new Date(System.currentTimeMillis());
		java.util.Date utilDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(utilDate);
		int month = c.get(Calendar.MONTH) +1;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select TRAINING_RECORD.user_id, sum (training_exp), USER_INFORMATION.user_name as EXP_SUM "
					+ "from TRAINING_RECORD join USER_INFORMATION "
					+ "on TRAINING_RECORD.user_id = USER_INFORMATION.user_id "
					+ "where training_record_date >= (NOW() - INTERVAL 7 DAY) and user_sex = 2 "
					+ "group by TRAINING_RECORD.user_id order by sum (training_exp) desc limit 5";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			String stMonth = String.valueOf(month);
			if (stMonth.length()==1) {
				stMonth = "0" + stMonth;
			}

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Alltable al = new Alltable();

				al.setTrainingExp(rs.getInt("sum(training_exp)"));
				al.setUserName(rs.getString("user_name"));
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

		return expSumList;
	}


	// ログインユーザーのランキング順位

	public int rank(Trainingrecord param) {
		Connection conn = null;
		int result = 0;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select RANK() over(order by sum(training_exp) desc) as RANKING from TRAINING_RECORD "
					+ "where user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserId() != 0) {
				pStmt.setInt(1, param.getUserId());
			} else {
				pStmt.setInt(1, 0);
			}
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("ranking");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = 0;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}

		return result;
	}


	// ログインユーザーの月間ランキング順位

	public int mrank(Trainingrecord param) {
		Connection conn = null;
		int result = 0;

		//日付指定
		Date date = new Date(System.currentTimeMillis());
		java.util.Date utilDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(utilDate);
		int month = c.get(Calendar.MONTH) +1;
		int year = c.get(Calendar.YEAR);

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select RANK() over(order by sum(training_exp) desc) as MRANKING from TRAINING_RECORD "
					+ "where user_id =? and training_record_date like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserId() != 0) {
				pStmt.setInt(1, param.getUserId());
			} else {
				pStmt.setInt(1, 0);
			}

			String stYear = String.valueOf(year);
			String stMonth = String.valueOf(month);
			if (stMonth.length()==1) {
				stMonth = "0" + stMonth;
			}
			pStmt.setString(2, "%" + stYear + "-" + stMonth + "%");

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("mranking");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = 0;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}

		return result;
	}


	// ログインユーザーの週間ランキング順位

	public int wrank(Trainingrecord param) {
		Connection conn = null;
		int result = 0;

		//日付指定
		Date date = new Date(System.currentTimeMillis());
		java.util.Date utilDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(utilDate);
		int month = c.get(Calendar.MONTH) +1;
		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sql = "select RANK() over(order by sum(training_exp) desc) as WRANKING from TRAINING_RECORD "
					+ "where user_id =? and training_record_date >= (NOW() - INTERVAL 7 DAY)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserId() != 0) {
				pStmt.setInt(1, param.getUserId());
			} else {
				pStmt.setInt(1, 0);
			}

			String stMonth = String.valueOf(month);
			if (stMonth.length()==1) {
				stMonth = "0" + stMonth;
			}

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("wranking");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = 0;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}

		return result;
	}
}