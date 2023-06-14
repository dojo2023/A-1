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
	// ログインできるならtrueを返す
	public String isLoginOK(Userinformation userinformation) {
		Connection conn = null;
		String loginResult = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

			// SELECT文を準備する
			String sql = "select * from user_information where user_mail_address = ? and user_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,userinformation.getUser_mail_address());
			pStmt.setString(2,userinformation.getUser_password());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// メールアドレスとパスワードが一致するユーザーがいたかどうかをチェックする
			if (rs.next()) {
				loginResult =rs.getString( "user_id");
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
			loginResult = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = null;
				}
			}
		}

		// 結果を返す
				return loginResult;
	}

	public List<Userinformation> select(Userinformation param) {

		List<Userinformation> cardList = new ArrayList<Userinformation>();

		// 結果を返す
				return cardList;
	}


	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Userinformation card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

			// SQL文を準備する
						String sql = "insert into USER_INFORMATION "
								+ "(USER_NAME,USER_SEX,USER_BIRTH,USER_MAIL_ADDRESS,USER_PASSWORD,USER_HEIGHT,USER_WEIGHT)"
								+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Userinformation card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

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
}