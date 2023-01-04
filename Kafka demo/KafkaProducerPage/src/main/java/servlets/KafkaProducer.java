package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.ProducerDummy;


@WebServlet("/KafkaProducer")
public class KafkaProducer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KafkaProducer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stockSymbol = (String)request.getParameter("stockSymbol");
		ProducerDummy producer = new ProducerDummy();
		producer.pushMessage(stockSymbol);
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
