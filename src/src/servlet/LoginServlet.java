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

		Userinformation user = uiDao.ui(new Userinformation(id));
		session.setAttribute("user_name_session",user.getUser_name());
		session.setAttribute("user_birth_session",user.getUser_birth());
		session.setAttribute("user_sex_session",user.getUser_sex());
		session.setAttribute("user_height_session",user.getUser_height());
		session.setAttribute("user_weight_session",user.getUser_weight());
		session.setAttribute("user_mail_address_session",user.getUser_mail_address());

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
