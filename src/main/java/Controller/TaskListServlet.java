package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.TaskDAO;
import Model.entity.TaskBean;
/**
 * タスク一覧画面への遷移を行います。
 * @author 野中美天
 */
/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/task-list-servlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
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
		
		if(user_id != null) {
			
			// タスク一覧
			url = "taskList.jsp";
			TaskDAO dao = new TaskDAO();
			try {
				List<TaskBean> taskList = dao.selectAll();
				session.setAttribute("TASK_LIST", taskList);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		}else {
			// ログイン画面
			url = "login.jsp";
		}
		
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);
	}

}
