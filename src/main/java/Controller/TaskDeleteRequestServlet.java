package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.TaskDAO;
/**
 * 指定したタスクの削除処理を行います。
 * @author 岩永史哉
 */
/**
 * Servlet implementation class TaskDeleteRequestServlet
 */
@WebServlet("/task-delete-request-servlet")
public class TaskDeleteRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteRequestServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String user_id = (String)session.getAttribute("USER_ID");
		String url = "";
		if(user_id != null) {
			TaskDAO dao = new TaskDAO();
			int result = 0;
			String[] taskIds = (String[])session.getAttribute("TASK_IDs");
			try {
				for(String id : taskIds) {
					result += dao.delete(Integer.parseInt(id));
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if(result == taskIds.length) {
				url = "task-delete-complete.html";
			}else{
				url = "deleteerror.html";
			}
			
		}else {
			// ログイン画面
			url = "login.jsp";
		}
		
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

}
