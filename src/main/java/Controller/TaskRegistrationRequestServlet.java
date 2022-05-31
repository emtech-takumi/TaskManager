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
import Model.entity.TaskBean;
/**
 * タスク登録の処理を行います。
 * @author 野中美天
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("USER_ID");
		String url = "";
		
		if(user_id == null) {
			
			// ログイン画面
			url = "login.jsp";
			
		}else {
			
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
			
			try {
				if(task.getTaskName().equals("")) {
					throw new SQLException("タスク名が記入されておりません。");
				}
				else if(task.getTaskName().length() > 50) {
					throw new SQLException("タスク名に記入できる文字数は50文字までです。");
				}
				else if(task.getMemo().length() > 100) {
					throw new SQLException("メモに記入できる文字数は100文字までです。");
				}
				else {
					if(dao.insert(task) != 1) {
						throw new SQLException("タスクの登録に失敗しました。");
					}
				}
				

				// 登録完了画面
				url = "task-regist-complete.html";

			} catch (ClassNotFoundException | SQLException e) {

				// 登録失敗画面
				url = "registerror.jsp";

				String errorMessage = e.getMessage();

				request.setAttribute("errorMessage", errorMessage);
			}

		}
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);
	}

}
