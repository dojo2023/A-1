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

		TrainingrecordDao trDao = new TrainingrecordDao ();
		UserinformationDao uiDao = new UserinformationDao();

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String strDate = request.getParameter("training_record_date");
	            Date trainingRecordDate = Date.valueOf(strDate);
				int userId =  (int) session.getAttribute("id");
				String trainingMenu = request.getParameter("training_menu");
				double trainingWeight = Double.parseDouble(request.getParameter("training_weight"));
				int trainingCount = Integer.parseInt(request.getParameter("training_count"));
				int trainingSet = Integer.parseInt(request.getParameter("training_set"));
//				String trainingRecordDow = request.getParameter("training_record_dow");

//				//レベルアップ用参考
//
//				int requiredExp = 10;
//				int currentLevel = 0;
//				for(int i=0; i<100; i++) {
//					requiredExp = (requiredExp + requiredExp * i) / 2;
//					if(requiredExp > expSum) {
//						currentLevel = i + 1;
//						break;
//					};
//				};

				//TrainingmenuDaoの倍率だけのメソッドを用意してをnewする。
				TrainingmenuDao tmDao = new TrainingmenuDao();
				double mag =  tmDao.MAGMAG(new Trainingmenu(trainingMenu));
				//Userinfortationの体重だけのメソッドを用意してnewする。
				int weight = uiDao.UW(new Userinformation(userId));
				//Userinfortationの性別だけのメソッドを用意してnewする。
				uiDao = new UserinformationDao();
				int userSex = uiDao.US(new Userinformation(userId));
				//経験値計算式
				int EXP = 0;
				if(userSex == 1) {
					EXP = (int) ((int) (trainingWeight * trainingCount *  trainingSet * mag )/ weight );
				}
				else if(userSex == 2) {
					EXP = (int) ((int) (trainingWeight * trainingCount *  trainingSet * mag )/ weight * 1.5);
				}
				int trainingExp = EXP;

				//レベル判定
				int currentLevel = 0;
			    int requiredExp = 10;
			    int expSum = trDao.sum(new Trainingrecord(userId));
			    for(int i=0; i<100; i++) {
			    	requiredExp = (requiredExp + requiredExp * i) / 2;
			    	if(requiredExp > expSum) {
			    		currentLevel = i + 1;
			    		break;
			    	};
			    };

			    expSum = trDao.sum(new Trainingrecord(userId)) + trainingExp;
			    requiredExp = 10;
			    for(int i=0; i<currentLevel; i++) {
			    	requiredExp = (requiredExp + requiredExp * i) / 2;
			    };
				if(requiredExp < expSum) {
					//レベルアップ時の処理
					request.setAttribute("level_up", "レベルがアップしました！");
				} else {
					//レベルアップしない時の処理
					request.setAttribute("level_up", null);
				}

				// 登録処理を行う

				if (trDao.insert(new Trainingrecord(trainingRecordDate,
						userId,trainingMenu, trainingWeight,
						trainingCount,trainingSet,trainingExp/*, training_record_dow*/))) {	// 登録成功
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
					dispatcher.forward(request, response);
				}
				else {												// 登録失敗
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
					dispatcher.forward(request, response);
				}

				//経験値の即時反映
				expSum = trDao.sum(new Trainingrecord(userId));
				session.setAttribute("exp_sum_session", expSum);

				//レベル計算
				requiredExp = 10;
				int amountOfRise = 0;
				for(int i=1; i<10000; i++) {
					if(i % 2 != 0) {
						amountOfRise = requiredExp + i / 2;
						requiredExp = (requiredExp + requiredExp * i) / 2;
					} else {
						requiredExp = requiredExp + amountOfRise;
					}
			    	if(requiredExp > expSum) {
			    		int level = i;
			    		session.setAttribute("level_session", level);
			    		break;
			    	};
			    };

			}
    }