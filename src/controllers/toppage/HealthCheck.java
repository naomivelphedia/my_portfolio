package controllers.toppage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health;
import models.HealthCheckLogic;

/**
 * Servlet implementation class HealthCheck
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher dispatcher = request.getRequestDispatcher("/healthCheck.jsp"); //移動先を決定
        dispatcher.forward(request, response); //移動先のページへ移動
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        Health health = new Health();
        health.setHeight(Double.parseDouble(height));
        health.setWeight(Double.parseDouble(weight));

        HealthCheckLogic healthCheckLogic = new HealthCheckLogic();

        healthCheckLogic.execute(health);

        request.setAttribute("health", health);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/healthCheckResult.jsp");
        dispatcher.forward(request, response);
    }

}
