package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.TaskDAO;
import Model.entity.TaskBean;

/**
 * Servlet implementation class TaskRegistrationRequestServlet
 */
@WebServlet("/task-registration-request-servlet")
public class TaskRegistrationRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistrationRequestServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		// リクエスト取得
		String taskName = request.getParameter("task_name");
		int taskCategoryId = Integer.parseInt(request.getParameter("task_category"));
		String taskLimit = request.getParameter("task_limit");
		String taskUserId = request.getParameter("task_user");
		String taskStatusCode = request.getParameter("task_status");
		String taskMemo = request.getParameter("task_memo");
		
		// TaskBeanオブジェクト生成
		TaskBean task = new TaskBean();
		task.setTaskName(taskName);
		task.setCategoryId(taskCategoryId);
		task.setDeadLine(taskLimit);
		task.setUserId(taskUserId);
		task.setStatusId(taskStatusCode);
		task.setMemo(taskMemo);
		
		TaskDAO dao = new TaskDAO();		
		String url = "";
		try {
			int processingNumder = dao.insert(task);
			
			if(processingNumder == 0) {
				
				// 登録失敗画面
				url = "registerror.html";
				
			}else {
				
				// 登録完了画面
				url = "task-regist-complete.html";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		// リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
