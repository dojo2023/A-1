package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Trainingmenu;

public class TrainingmenuDao{

	// トレーニングメニューごとの倍率を引き出すSQL文

	public double MAGMAG(Trainingmenu tm) {
		Connection conn = null;
		double result = 0;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/A1/myGex", "sa", "");

			String sqlTm = "select training_menu_magnification "
					+ "from TRAINING_MENU where training_menu = ?";
			PreparedStatement pStmtTm = conn.prepareStatement(sqlTm);
			pStmtTm.setString(1,tm.getTrainingMenu());

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

		return result;
	}
}