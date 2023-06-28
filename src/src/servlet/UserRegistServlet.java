package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserinformationDao;
import model.Userinformation;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// ユーザー登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("User_Name");
		int userSex = Integer.parseInt(request.getParameter("User_Sex"));
		Date userBirth = Date.valueOf(request.getParameter("User_Birth"));
		String userMailAddress = request.getParameter("Mail_Address");
		String userPassword = request.getParameter("Password");
		int userHeight = Integer.parseInt(request.getParameter("User_Height"));
		int userWeight = Integer.parseInt(request.getParameter("User_Weight"));
		boolean flg = true;

		UserinformationDao uiDao = new UserinformationDao();
	//メールアドレス重複チェックを行う
		boolean mailAddressCheck = uiDao.ums(new Userinformation(userMailAddress));
		if(mailAddressCheck == false) {
			request.setAttribute("mac", "そのメールアドレスは既に登録されています。");
			flg=false;
		}

	//登録処理を行う
		if(flg==false) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
			dispatcher.forward(request, response);
		}else {
			if(uiDao.insert(new Userinformation(userName, userSex, userBirth, userMailAddress,
					userPassword, userHeight, userWeight))) {
				//ログインページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}

		}
	}
}
