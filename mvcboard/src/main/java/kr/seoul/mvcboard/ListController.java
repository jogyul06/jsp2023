package kr.seoul.mvcboard;

import java.io.IOException; import java.util.HasMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/list.do")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCBoardDAO dao = new MVCBoardDAO();
		Map<String, Object> map = new HashMap<>();
		map.put("start", 0);
		map.put("end", 2);
		int count = dao.selectCount(map);
		List<MVCBoardDTO> board = new Vector<>();
		req.setAttribute("count", count);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/14MVCBoard/List.jsp").forward(req, resp);
		super.doGet(req, resp);
	}
}
