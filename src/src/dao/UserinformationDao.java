package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Userinformation;

public class UserinformationDao {

	//ログイン処理のDAO

	// ログインできるならtrueを返す
	public int isLoginOK(Userinformation userInformation) {
		Connection conn = null;
		int loginResult = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SELECT文を準備する
			String sql = "select * from USER_INFORMATION where user_mail_address = ? and user_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,userInformation.getUserMailAddress());
			pStmt.setString(2,userInformation.getUserPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
			if (rs.next()) {
				loginResult =rs.getInt( "user_id");
			};
			/*俺は正しかった
			 * if (rs.getInt("count(*)") == 1) {
				String UID = "select user_id from user_information where user_mail_address = ? and user_password = ?";
				PreparedStatement pStmtUID = conn.prepareStatement(UID);
				pStmtUID.setString(1,userinformation.getUser_mail_address());
				pStmtUID.setString(2,userinformation.getUser_password());

			}*/
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = 0;
				}
			}
		}

		// 結果を返す
				return loginResult;
	}

	// ログインユーザーのユーザー情報
	public Userinformation ui(Userinformation userInformation) {
		Connection conn = null;
		Userinformation user =null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "select * from USER_INFORMATION WHERE "
					+ "user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (userInformation.getUserId() != 0) {
				pStmt.setInt(1,userInformation.getUserId());
			}
			else {
				pStmt.setInt(1,0);
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					user = new Userinformation();
					user.setUserName(rs.getString("user_name"));
					user.setUserBirth(rs.getDate("user_birth"));
					user.setUserSex(rs.getInt("user_sex"));
					user.setUserHeight(rs.getInt("user_height"));
					user.setUserWeight(rs.getInt("user_weight"));
					user.setUserMailAddress(rs.getString("user_mail_address"));
				}
				}


		catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 結果を返す
		return user;
	}

	public List<Userinformation> select(Userinformation param) {

		List<Userinformation> userList = new ArrayList<Userinformation>();

		// 結果を返す
				return userList;
	}


	//ユーザー情報登録処理のDAO


	// 引数recordで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Userinformation record) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
						String sql = "insert into USER_INFORMATION "
								+ "(user_name, user_sex, user_birth, user_mail_address, "
								+ "user_password, user_height, user_weight)"
								+ "values(?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
						if (record.getUserName() != null && !record.getUserName().equals("")) {
							pStmt.setString(1, record.getUserName());
						}
						else {
							pStmt.setString(1, null);
						}

						if (record.getUserSex() != 0) {
							pStmt.setInt(2, record.getUserSex());
						}
						else {
							pStmt.setInt(2, 0);
						}

						if (record.getUserBirth() != null && !record.getUserBirth().equals("")) {
							pStmt.setDate(3, record.getUserBirth());
						}
						else {
							pStmt.setString(3, null);
						}

						if (record.getUserMailAddress() != null && !record.getUserMailAddress().equals("")) {
							pStmt.setString(4, record.getUserMailAddress());
						}
						else {
							pStmt.setString(4, null);
						}

						if (record.getUserPassword() != null && !record.getUserPassword().equals("")) {
							pStmt.setString(5, record.getUserPassword());
						}
						else {
							pStmt.setString(5, null);
						}

						if (record.getUserHeight() != 0) {
							pStmt.setInt(6, record.getUserHeight());
						}
						else {
							pStmt.setInt(6, 0);
						}

						if (record.getUserWeight() != 0) {
							pStmt.setInt(7, record.getUserWeight());
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


	//ユーザー情報登録の際のメールアドレス重複チェックの処理のDAO

	public boolean ums(Userinformation umc) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sqlUms = "select * "
				+ "from USER_INFORMATION where user_mail_address = ?";
			PreparedStatement pStmtUms = conn.prepareStatement(sqlUms);
			pStmtUms.setString(1,umc.getUserMailAddress());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmtUms.executeQuery();

		if (rs.next()) {
			//重複していた場合の処理
			result = false;
		}
		else {
			//重複していない場合の処理(いらないかも)
			result = true;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		// 結果を返す
				return result;
	}

	//ユーザー情報登録の際のユーザー名重複チェックの処理のDAO

//		public boolean uns(Userinformation unc) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");
//
//				// SQL文を準備する
//				String sqlUns = "select user_name "
//					+ "from user_information where user_name = ?";
//				PreparedStatement pStmtUns = conn.prepareStatement(sqlUns);
//				pStmtUns.setString(1,unc.getUserName());
//
//				// SELECT文を実行し、結果表を取得する
//				ResultSet rs = pStmtUns.executeQuery();
//
//			if (rs.next()) {
//				//重複していた場合の処理
//				result = false;
//			}
//			else {
//				//重複していない場合の処理(いらないかも)
//				result = true;
//			}
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//				result = false;
//			}
//			catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				result = false;
//			}
//			finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					}
//					catch (SQLException e) {
//						e.printStackTrace();
//						result = false;
//					}
//				}
//			}
//
//			// 結果を返す
//					return result;
//		}


	//ユーザー情報更新処理のDAO(マイページ用)

	// 引数recordで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Userinformation record) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sql = "update USER_INFORMATION set user_name=?, user_height=?, user_weight=? where user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (record.getUserName() != null && !record.getUserName().equals("")) {
					pStmt.setString(1, record.getUserName());
				}
				else {
					pStmt.setString(1, null);
				}

				if (record.getUserHeight() != 0) {
					pStmt.setInt(2, record.getUserHeight());
				}
				else {
					pStmt.setInt(2, 0);
				}

				if (record.getUserWeight() != 0) {
					pStmt.setInt(3, record.getUserWeight());
				}
				else {
					pStmt.setInt(3, 0);
				}

				if (record.getUserId() != 0) {
					pStmt.setInt(4, record.getUserId());
				}
				else {
					pStmt.setInt(4, 0);
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

		//トレーニング記録のための体重を持っていくよの処理のDAO


		public int UW(Userinformation uw) {
			Connection conn = null;
			int result = 0;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sqlUw = "select user_weight "
					+ "from USER_INFORMATION where user_id = ?";
				PreparedStatement pStmtUw = conn.prepareStatement(sqlUw);
				pStmtUw.setInt(1,uw.getUserId());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmtUw.executeQuery();

			if (rs.next()) {
				result =rs.getInt("user_weight");
			};
			}
			catch (SQLException e) {
				e.printStackTrace();
				result = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = 0;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = 0;
					}
				}
			}

			// 結果を返す
					return result;
		}


		//経験値の算出のための性別を持っていくよの処理のDAO

		public int US(Userinformation us) {
			Connection conn = null;
			int result = 0;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sqlUs = "select user_sex "
					+ "from USER_INFORMATION where user_id = ?";
				PreparedStatement pStmtUs = conn.prepareStatement(sqlUs);
				pStmtUs.setInt(1,us.getUserId());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmtUs.executeQuery();

			if (rs.next()) {
				result =rs.getInt( "user_sex");
			};
			}
			catch (SQLException e) {
				e.printStackTrace();
				result = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = 0;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = 0;
					}
				}
			}

			// 結果を返す
					return result;
		}
}