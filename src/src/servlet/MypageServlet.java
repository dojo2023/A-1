package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		/*if (session.getAttribute("id") == null) {
			response.sendRedirect("/jiro_power/LoginServlet");
			return;
		}*/

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
		/*if (session.getAttribute("id") == null) {
			response.sendRedirect("/jiro_power/LoginServlet");
			return;
		}*/
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_name = request.getParameter("USER_NAME");
				int user_sex = Integer.parseInt(request.getParameter("SEX"));
				Date user_birth = Date.valueOf(request.getParameter("USER_BIRTH"));
				String user_mail_address = request.getParameter("USER_MAIL_ADDRESS");
				String user_password = request.getParameter("USER_PASSWORD");
				int user_height = Integer.parseInt(request.getParameter("USER_HEIGHT"));
				int user_weight = Integer.parseInt(request.getParameter("USER_WEIGHT"));


    }

	/*シェア画面（リザルト画面）*/
}
