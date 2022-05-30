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
			TaskBean bean = new TaskBean();
			bean.setTaskId((Integer)session.getAttribute("TASK_ID"));
			bean.setTaskName(request.getParameter("task_name"));
			bean.setCategoryId(Integer.parseInt(request.getParameter("task_category")));
			bean.setDeadLine(request.getParameter("task_limit"));
			bean.setUserId(request.getParameter("task_user"));
			bean.setStatusId(request.getParameter("task_status"));
			bean.setMemo(request.getParameter("task_memo"));
			
			TaskDAO dao = new TaskDAO();
			int result = 0;
			try {
				if(!bean.getTaskName().equals("")) {
					result = dao.update((Integer)session.getAttribute("TASK_ID"), bean);
				}
				else {
					throw new SQLException("タスク名が記入されておりません。");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				String errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);

			}
			if(result >= 1) {
				url = "task-edit-complete.html";
			}else{
				url = "editerror.jsp";
			}
			
		}else {
			
			// ログイン画面
			url = "login.jsp";
			
		}
		
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
