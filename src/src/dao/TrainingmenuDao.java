package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Trainingmenu;

public class TrainingmenuDao{
	// 引数tmで指定されたレコードを登録し、成功したらtrueを返す
			public double MAGMAG(Trainingmenu tm) {
				Connection conn = null;
				double result = 0;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

					// SQL文を準備する
					String sqlTm = "select training_menu_magnification "
						+ "from training_menu where training_menu = ?";
					PreparedStatement pStmtTm = conn.prepareStatement(sqlTm);
					pStmtTm.setString(1,tm.getTraining_menu());

					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmtTm.executeQuery();

				if (rs.next()) {
					result =rs.getDouble( "training_menu_magnification");
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