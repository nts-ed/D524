package Main;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mode1.Cart;
import mode1.CartLogic;
import mode1.Vegetable;

@WebServlet("/cc")
public class Main extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		if(name.isEmpty() || price.isEmpty()) {
			request.setAttribute("err", "未記入の項目があります");
		}else {
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null) {
				cart=new Cart();
			}
			Vegetable vege=new Vegetable(name,Integer.parseInt(price));
			CartLogic logic=new CartLogic();
			logic.execute(cart, vege);
			session.setAttribute("cart", cart);
			request.setAttribute("msg", vege.getName()+"をカートに追加しました");
		}

		doGet(request, response);
	}

}