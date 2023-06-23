package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TrainingrecordDao;
import dao.UserinformationDao;
import model.Trainingrecord;
import model.Userinformation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("Mail_Address");
		String pw = request.getParameter("PW");

		// ログイン処理を行う
		UserinformationDao uiDao = new UserinformationDao();
		TrainingrecordDao trDao = new TrainingrecordDao ();
		int userId =  uiDao.isLoginOK(new Userinformation(email, pw));
		if(userId != 0) {
			// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id",userId);

		//セッションスコープに諸情報を格納する
		Userinformation user = uiDao.ui(new Userinformation(userId));
		session.setAttribute("user_name_session",user.getUserName());
		session.setAttribute("user_birth_session",user.getUserBirth());
		session.setAttribute("user_sex_session",user.getUserSex());
		session.setAttribute("user_height_session",user.getUserHeight());
		session.setAttribute("user_weight_session",user.getUserWeight());
		session.setAttribute("user_mail_address_session",user.getUserMailAddress());

		//経験値表示
		int expSum = trDao.sum(new Trainingrecord(userId));
		session.setAttribute("exp_sum_session", expSum);

		//レベル計算
		for(int i=0; i<100; i++) {
	    	int requiredExp = 10;
	    	requiredExp = requiredExp + requiredExp * i;
	    	if(requiredExp > expSum) {
	    		int level = i + 1;
	    		session.setAttribute("level_session", level);
	    		break;
	    	};
	    };

			// 記録サーブレットにリダイレクトする
			response.sendRedirect("/jiro_power/TrainingRecordServlet");
		}
		else {									// ログイン失敗
			request.setAttribute("errMsg", "※メールアドレス、またはパスワードが間違っています。");
			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
