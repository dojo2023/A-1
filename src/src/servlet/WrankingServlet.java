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
import model.Alltable;
import model.Trainingrecord;

/**
 * Servlet implementation class WrankingServlet
 */
@WebServlet("/WrankingServlet")
public class WrankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WrankingServlet() {
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

		// 週間ランキングページにフォワードする
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/w_ranking.jsp");
		dispatcher.forward(request, response);*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int userId =  (int) session.getAttribute("id");
//		String userName = request.getParameter("user_name");

		 // Daoからデータを取り出す
		TrainingrecordDao trDao = new TrainingrecordDao ();
		List<Alltable> expSumWM = trDao.sumWeeklyMen(new Trainingrecord(userId));
		List<Alltable> expSumWW = trDao.sumWeeklyWomen(new Trainingrecord(userId));
		System.out.println(expSumWM.size());
		System.out.println(expSumWW.size());
        // System.out.println(exp_sum.size());

				//とりあえずリクエストスコープへセットする
				request.setAttribute("wmrankList", expSumWM);
				request.setAttribute("wwrankList", expSumWW);

				//chart.jspに遷移させる
				String path="/WEB-INF/jsp/w_ranking.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
    	/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/jiro_power/LoginServlet");
			return;
		}*/
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
    }
}

