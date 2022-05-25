package controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] hands={"グー","チョキ","パー"};
	
		request.setCharacterEncoding("utf-8");
		String handStr=request.getParameter("hand");
		
		int userHand=Integer.parseInt(handStr);
		int pcHand=new Random().nextInt(hands.length);
		
		
		String result;
		int diff=(userHand+3-pcHand) % 3;
		if(diff==0){
			result="あいこです";
		}else if(diff==2){
			result="あなたの勝ち";
		}else{
			result="あなたの負け";
		}
		
		request.setAttribute("userHand", hands[userHand]);
		request.setAttribute("pcHand", hands[pcHand]);
		request.setAttribute("result",result);
		doGet(request, response);
	}
}