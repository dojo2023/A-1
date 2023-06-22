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
		UserinformationDao uDao = new UserinformationDao();
		TrainingrecordDao trDao = new TrainingrecordDao();
		int id =  uDao.isLoginOK(new Userinformation(email, pw));
		if(id != 0) {
			// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id",id);

		//セッションスコープに諸情報を格納する
		Userinformation user = uDao.ui(new Userinformation(id));
		session.setAttribute("user_name_session",user.getUser_name());
		session.setAttribute("user_birth_session",user.getUser_birth());
		session.setAttribute("user_sex_session",user.getUser_sex());
		session.setAttribute("user_height_session",user.getUser_height());
		session.setAttribute("user_weight_session",user.getUser_weight());
		session.setAttribute("user_mail_address_session",user.getUser_mail_address());

		//セッションスコープに総経験値を格納する

		int expSum = trDao.sum(new Trainingrecord(id));
		System.out.println(expSum);
		session.setAttribute("exp_sum_session", expSum);
		System.out.println(session.getAttribute("exp_sum_session"));
//		System.out.println(session.getAttribute("user_name_session"));


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
