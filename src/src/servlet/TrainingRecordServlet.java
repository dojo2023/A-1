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

import dao.TrainingmenuDao;
import dao.TrainingrecordDao;
import dao.UserinformationDao;
import model.Trainingmenu;
import model.Trainingrecord;
import model.Userinformation;

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
				String strDate = request.getParameter("training_record_date");
	            Date training_record_date = Date.valueOf(strDate);
	            System.out.println("Date型 = " +  training_record_date);
				System.out.println(session.getAttribute("id")+ "AAAAAAAAAAAAAA");
				int user_id =  (int) session.getAttribute("id");
				String training_menu = request.getParameter("training_menu");
				double training_weight = Double.parseDouble(request.getParameter("training_weight"));
				int training_count = Integer.parseInt(request.getParameter("training_count"));
				int training_set = Integer.parseInt(request.getParameter("training_set"));

				//TrainingmenuDaoの倍率だけのメソッドを用意してをnewする。
				TrainingmenuDao TMDao = new TrainingmenuDao();
				double mag =  TMDao.MAGMAG(new Trainingmenu(training_menu));
				//Userinfortationの体重だけのメソッドを用意してnewする。
				UserinformationDao UIDao = new UserinformationDao();
				int weight = UIDao.UW(new Userinformation(user_id));
				//Userinfortationの性別だけのメソッドを用意してnewする。
				UIDao = new UserinformationDao();
				int sex = UIDao.US(new Userinformation(user_id));
				//経験値計算式
				int EXP = 0;
				if(sex == 1) {
					EXP = (int) ((int) (training_weight * training_count *  training_set * mag )/ weight );
				}
				else if(sex == 2) {
					EXP = (int) ((int) (training_weight * training_count *  training_set * mag )/ weight * 1.5);
				}
				int training_exp = EXP;

				// 登録処理を行う
				TrainingrecordDao TRDao = new TrainingrecordDao ();
				if (TRDao.insert(new Trainingrecord(training_record_date,user_id,training_menu, training_weight, training_count,training_set,training_exp))) {	// 登録成功
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

