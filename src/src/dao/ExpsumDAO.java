package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Alltable;

public class ExpsumDAO{
	public String expSum(Alltable alltable) {
		Connection conn = null;
		int expResult = 0;

		request.setCharacterEncoding("UTF-8");

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myGex", "sa", "");

			// SELECT文を準備する
				String sqlUS = "select user_sex from user_information where user_id = ?";
				PreparedStatement pStmtUS = conn.prepareStatement(sqlUS);
				pStmtUS.setInt(1, );

			if()
			//計算式の準備
			String sql ="select ? * ? * ? * ? / ? * "
		}
	}
}

weight * count * set * magnification / weight * sexmagnification
