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
 * Servlet implementation class Calendar_UpdateDelete
 */
@WebServlet("/Calendar_UpdateDeleteServlet")
public class Calendar_UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
				int trainingRecordId =Integer.parseInt(request.getParameter("trainingRecordId")) ;
				String trainingMenu = request.getParameter("trainingMenu");
				Double trainingWeight = Double.parseDouble(request.getParameter("trainingWeight"));
				int trainingCount = Integer.parseInt(request.getParameter("trainingCount"));
				int trainingSet =Integer.parseInt(request.getParameter("trainingSet"));
				System.out.println(trainingRecordId);
				System.out.println(trainingMenu);
				System.out.println(trainingWeight);
				System.out.println(trainingCount);
				System.out.println(trainingSet);


		//更新処理
				TrainingrecordDao tDao = new TrainingrecordDao();
				if(request.getParameter("update")!=null) {
					if (request.getParameter("update").equals("update")) {
						if (tDao.update(new Trainingrecord(trainingRecordId,trainingMenu, trainingWeight, trainingCount,trainingSet))){
							System.out.println("更新完了");
						}
					}else {
						System.out.println("更新失敗");
					}
				}
		//削除処理
				if(request.getParameter("delete")!=null) {
					if(request.getParameter("delete").equals("delete")) {
						if(tDao.delete(trainingRecordId)) {
							System.out.println("削除成功");
						}
					}else {
						System.out.println("削除失敗");
					}
				}



		// ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/training_record.jsp");
				dispatcher.forward(request, response);
    }
}

