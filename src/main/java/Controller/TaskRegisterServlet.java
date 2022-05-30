package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.SelecterDAO;
import Model.DAO.UserDAO;
/**
 * タスク登録画面への遷移を行います。
 * @author 野中美天
 */
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/task-registration-servlet")
public class TaskRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("USER_ID");
		String url = "";
		
		if(user_id == null) {
			
			// ログイン画面
			url = "login.jsp";
			
		}else {
			
			// タスク登録画面
			url = "taskRegistration.jsp";
			
			UserDAO userDao = new UserDAO();
			SelecterDAO selecterDao = new SelecterDAO();
			
			try {
				request.setAttribute("USER_LIST", userDao.selectAll());
				request.setAttribute("CATEGORY_LIST", selecterDao.getAllCategory());
				request.setAttribute("STATUS_LIST", selecterDao.getAllStatus());
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
