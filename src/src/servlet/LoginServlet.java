package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserinformationDao;
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
		String email = request.getParameter("EMAIL");
		String pw = request.getParameter("PW");

		// ログイン処理を行う
		UserinformationDao uiDao = new UserinformationDao();
		int id =  uiDao.isLoginOK(new Userinformation(email, pw));
		if(id != 0) {
			// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id",id);

		HttpSession sessionUi = request.getSession();
		Userinformation user = uiDao.ui(new Userinformation(id));
		sessionUi.setAttribute("user_name",user.getUser_name());
		sessionUi.setAttribute("user_birth",user.getUser_birth());
		sessionUi.setAttribute("user_height",user.getUser_height());
		sessionUi.setAttribute("user_weight",user.getUser_weight());
		sessionUi.setAttribute("user_mail_address",user.getUser_mail_address());

			// 記録サーブレットにリダイレクトする
			response.sendRedirect("/jiro_power/TrainingRecordServlet");
		}
		else {									// ログイン失敗
			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
