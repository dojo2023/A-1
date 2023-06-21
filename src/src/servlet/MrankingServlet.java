package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TrainingrecordDao;
import model.Trainingrecord;

/**
 * Servlet implementation class MrankingServlet
 */
@WebServlet("/MrankingServlet")
public class MrankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MrankingServlet() {
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

		// 月間ランキングページにフォワードする
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/m_ranking.jsp");
		dispatcher.forward(request, response); */

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int user_id =  (int) session.getAttribute("id");

		 // Daoからデータを取り出す
		TrainingrecordDao TRDao = new TrainingrecordDao ();
		List<Trainingrecord> exp_sum = TRDao.sumAll(new Trainingrecord(user_id));

				//とりあえずリクエストスコープへセットする
				request.setAttribute("rankList", exp_sum);


				//chart.jspに遷移させる
				String path="/WEB-INF/jsp/m_ranking.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
    }
}
