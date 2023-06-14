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
import model.Trainingrecord;

/**
 * Servlet implementation class TrainingRecordServlet
 */
@WebServlet("/TrainingRecordServlet")
public class TrainingRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingRecordServlet() {
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

		// 記録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
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
				int training_id  = 0;
				String training_record_date = request.getParameter("training_record_id");
				int user_id = 0;
				String training_menu = request.getParameter("training_menu");
				double training_weight = 0;
				int training_count = 0;
				int training_set = 0;

				//TrainingmenuDaoの倍率だけのメソッドを用意してをnewする。

				//経験値計算式
				int training_exp = 0;

				// 登録処理を行う
				TrainingrecordDao TRDao = new TrainingrecordDao ();
				if (TRDao.insert(new Trainingrecord(training_id, training_record_date,user_id,training_menu, training_weight, training_count,training_set))) {	// 登録成功
					TRDao.insert(new Trainingrecord(training_exp));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
					dispatcher.forward(request, response);
				}
				else {												// 登録失敗
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
					dispatcher.forward(request, response);
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
				dispatcher.forward(request, response);
			}


    }

