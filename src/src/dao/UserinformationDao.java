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
	public int isLoginOK(Userinformation userinformation) {
		Connection conn = null;
		int loginResult = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SELECT文を準備する
			String sql = "select * from user_information where user_mail_address = ? and user_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,userinformation.getUser_mail_address());
			pStmt.setString(2,userinformation.getUser_password());

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

	// ログインユーザーのユーザーネーム
	public Userinformation ui(Userinformation userinformation) {
		Connection conn = null;
		Userinformation user =null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			// SQL文を準備する
			String sql = "select * from User_information WHERE "
					+ "user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (userinformation.getUser_id() != 0) {
				pStmt.setInt(1,userinformation.getUser_id());
			}
			else {
				pStmt.setInt(1,0);
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					user = new Userinformation();
					user.setUser_name(rs.getString("user_name"));
					user.setUser_birth(rs.getDate("user_birth"));
					user.setUser_sex(rs.getInt("user_sex"));
					user.setUser_height(rs.getInt("user_height"));
					user.setUser_weight(rs.getInt("user_weight"));
					user.setUser_mail_address(rs.getString("user_mail_address"));
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

		List<Userinformation> cardList = new ArrayList<Userinformation>();

		// 結果を返す
				return cardList;
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
								+ "(USER_NAME,USER_SEX,USER_BIRTH,USER_MAIL_ADDRESS,USER_PASSWORD,USER_HEIGHT,USER_WEIGHT)"
								+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
						if (record.getUser_name() != null && !record.getUser_name().equals("")) {
							pStmt.setString(1, record.getUser_name());
						}
						else {
							pStmt.setString(1, null);
						}

						if (record.getUser_sex() != 0) {
							pStmt.setInt(2, record.getUser_sex());
						}
						else {
							pStmt.setInt(2, 0);
						}

						if (record.getUser_birth() != null && !record.getUser_birth().equals("")) {
							pStmt.setDate(3, record.getUser_birth());
						}
						else {
							pStmt.setString(3, null);
						}

						if (record.getUser_mail_address() != null && !record.getUser_mail_address().equals("")) {
							pStmt.setString(4, record.getUser_mail_address());
						}
						else {
							pStmt.setString(4, null);
						}

						if (record.getUser_password() != null && !record.getUser_password().equals("")) {
							pStmt.setString(5, record.getUser_password());
						}
						else {
							pStmt.setString(5, null);
						}

						if (record.getUser_height() != 0) {
							pStmt.setInt(6, record.getUser_height());
						}
						else {
							pStmt.setInt(6, 0);
						}

						if (record.getUser_weight() != 0) {
							pStmt.setInt(7, record.getUser_weight());
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
				+ "from user_information where user_mail_address = ?";
			PreparedStatement pStmtUms = conn.prepareStatement(sqlUms);
			pStmtUms.setString(1,umc.getUser_mail_address());

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

		public boolean uns(Userinformation unc) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sqlUns = "select user_name "
					+ "from user_information where user_name = ?";
				PreparedStatement pStmtUns = conn.prepareStatement(sqlUns);
				pStmtUns.setString(1,unc.getUser_name());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmtUns.executeQuery();

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


	//ユーザー情報更新処理のDAO(マイページ用)

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Userinformation card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

				// SQL文を準備する
				String sql = "update USER_INFORMATION set USER_NAME=?, USER_HEIGHT=?, USER_WEIGHT=? where USER_ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (card.getUser_name() != null && !card.getUser_name().equals("")) {
					pStmt.setString(1, card.getUser_name());
				}
				else {
					pStmt.setString(1, null);
				}

				if (card.getUser_height() != 0) {
					pStmt.setInt(2, card.getUser_height());
				}
				else {
					pStmt.setInt(2, 0);
				}

				if (card.getUser_weight() != 0) {
					pStmt.setInt(3, card.getUser_weight());
				}
				else {
					pStmt.setInt(3, 0);
				}

				if (card.getUser_id() != 0) {
					pStmt.setInt(4, card.getUser_id());
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
					+ "from user_information where user_id = ?";
				PreparedStatement pStmtUw = conn.prepareStatement(sqlUw);
				pStmtUw.setInt(1,uw.getUser_id());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmtUw.executeQuery();

			if (rs.next()) {
				result =rs.getInt("User_weight");
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
				String sqlUs = "select User_sex "
					+ "from user_information where user_id = ?";
				PreparedStatement pStmtUs = conn.prepareStatement(sqlUs);
				pStmtUs.setInt(1,us.getUser_id());

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