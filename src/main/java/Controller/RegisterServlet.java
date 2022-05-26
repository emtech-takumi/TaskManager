package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.SelecterDAO;
import Model.DAO.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/task-registration-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			url = "login.html";
			
		}else {
			
			// タスク登録画面
			url = "taskRegistration.jsp";
			
			UserDAO userDao = new UserDAO();
			SelecterDAO dao = new SelecterDAO();
			
			try {
				request.setAttribute("USER_LIST", userDao.selectAll());
				request.setAttribute("CATEGORY_LIST", dao.getAllCategory());
				request.setAttribute("STATUS_LIST", dao.getAllStatus());
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
//		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	}

}
