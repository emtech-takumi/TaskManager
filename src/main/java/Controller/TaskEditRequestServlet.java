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
			bean.setTaskId(0);
			bean.setTaskName(request.getParameter("task_name"));
			bean.setCategoryId(0);
			bean.setCategoryName(request.getParameter("category_name"));
			bean.setDeadLine(request.getParameter("limit_date"));
			bean.setUserId((Integer.parseInt(request.getParameter("user_id"))));
			bean.setUserName(request.getParameter("user_name"));
			bean.setStatusId(request.getParameter("status_code"));
			bean.setStatus(request.getParameter("status_name"));
			bean.setMemo(request.getParameter("memo"));
			bean.setRegisterDate(request.getParameter("create_datetime"));
			bean.setUpdateDate(request.getParameter("update_datetime"));
			
			TaskDAO dao = new TaskDAO();
			int result = 0;
			try {
				if(!bean.getTaskName().equals("")) {
					result = dao.update((Integer)session.getAttribute("TASK_ID"), bean);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			if(result >= 1) {
				url = "task-edit-complete.html";
			}else{
				url = "editerror.html";
			}
			
		}else {
			
			// ログイン画面
			url = "login.html";
			
		}
		
		// リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
