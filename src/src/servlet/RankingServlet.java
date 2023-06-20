package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class RankingServlet
 */
@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		/*// ランキングページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
		dispatcher.forward(request, response);
		*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int user_id =  (int) session.getAttribute("id");
		String user_name = request.getParameter("user_name");

		 // Daoからデータを取り出す
		TrainingrecordDao TRDao = new TrainingrecordDao ();
		int exp_sum = TRDao.sum(new Trainingrecord(user_id));

		//cardListに入れたい
		ArrayList<Trainingrecord> cardList = new ArrayList<Trainingrecord>();
		cardList.add(exp_sum);

				//とりあえずリクエストスコープへセットする
				request.setAttribute("cardList", cardList);

				//chart.jspに遷移させる
				String path="/WEB-INF/jsp/ranking.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
    }

}
