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
 * タスクの編集処理を行います。
 * @author 岩永史哉
 */
/**
 * Servlet implementation class TaskEditRequestServlet
 */
@WebServlet("/task-edit-request-servlet")
public class TaskEditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskEditRequestServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String user_id = (String)session.getAttribute("USER_ID");
		String url = "";
		
		if(user_id != null) {
			TaskBean bean = new TaskBean();
			bean.setTaskId((Integer)session.getAttribute("TASK_ID"));
			bean.setTaskName(request.getParameter("task_name"));
			bean.setCategoryId(Integer.parseInt(request.getParameter("task_category")));
			bean.setDeadLine(request.getParameter("task_limit"));
			bean.setUserId(request.getParameter("task_user"));
			bean.setStatusId(request.getParameter("task_status"));
			bean.setMemo(request.getParameter("task_memo"));
			
			TaskDAO dao = new TaskDAO();
			try {
				if(bean.getTaskName().equals("")) {
					throw new SQLException("タスク名が記入されておりません。");
				}
				else if(bean.getTaskName().length() > 50) {
					throw new SQLException("タスク名に記入できる文字数は50文字までです。");
				}
				else if(bean.getMemo().length() > 100) {
					throw new SQLException("メモに記入できる文字数は100文字までです。");
				}
				else {
					if(dao.update((Integer)session.getAttribute("TASK_ID"), bean) != 1) {
						url = "editerror.jsp";
						throw new SQLException("タスクの更新に失敗しました。");
					}else {
						url = "task-edit-complete.html";
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				String errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);
			}
			
		}else {
			
			// ログイン画面
			url = "login.jsp";
		}
		
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
