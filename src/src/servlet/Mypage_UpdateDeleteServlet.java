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
 * Servlet implementation class Mypage_UpdateDelete
 */
@WebServlet("/Mypage_UpdateDeleteServlet")
public class Mypage_UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/jiro_power/LoginServlet");
			return;
		}


		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
    	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/jiro_power/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String user_name = request.getParameter("user_name");
			/*int user_sex = Integer.parseInt(request.getParameter("USER_SEX"));
			Date user_birth = Date.valueOf(request.getParameter("USER_BIRTH"));
			String user_mail_address = request.getParameter("USER_MAIL_ADDRESS");
			String user_password = request.getParameter("USER_PASSWORD");*/
			int user_height = Integer.parseInt(request.getParameter("user_height"));
			int user_weight = Integer.parseInt(request.getParameter("user_weight"));
			int user_id = (int) session.getAttribute("id");




		//登録処理を行う
		UserinformationDao uDao = new UserinformationDao();
		if (request.getParameter("update").equals("update")) {
			if(uDao.update(new Userinformation(user_name, user_height, user_weight, user_id))) {
				//登録成功
				//登録成功時の処理を書く
				//セッションスコープにIDを格納する
				/*HttpSession session = request.getSession();*/
				session.setAttribute("user_name_session", user_name);
				session.setAttribute("user_height_session", user_height);
				session.setAttribute("user_weight_session", user_weight);

                System.out.println(session.getAttribute("user_name_session"));

			}
		}
		else {//登録失敗
			//登録失敗時の処理を書く
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
				dispatcher.forward(request, response);


	/*シェア画面（リザルト画面）*/
    }

}
