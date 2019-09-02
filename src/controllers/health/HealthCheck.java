package controllers.health;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health;
import models.HealthCheckLogic;
import utils.DBUtil;
import validators.HealthValidator;

/**
 * Servlet implementation class HealthCheck
 */
@WebServlet("/index.html")
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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/health/healthCheck.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        String age = request.getParameter("age");
        String gender_flag = request.getParameter("gender_flag");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String fat_percentage = request.getParameter("fat_percentage");
        String waist = request.getParameter("waist");
        String activity = request.getParameter("activity");

        Health health = new Health();

        health.setAge(age);
        health.setGender_flag(gender_flag);
        health.setHeight(height);
        health.setWeight(weight);
        health.setFat_percentage(fat_percentage);
        health.setWaist(waist);
        health.setActivity(activity);

        // 未入力チェック（年齢、身長、体重のみ必須）
        List<String> errors = HealthValidator.validate(health);
            if(errors.size() > 0) {
                em.close();
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("health", health);
                request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/health/healthCheck.jsp");
            rd.forward(request, response);
        }

        HealthCheckLogic healthCheckLogic = new HealthCheckLogic();

        healthCheckLogic.execute(health);

        request.setAttribute("health", health);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/health/healthCheckResult.jsp");
        dispatcher.forward(request, response);
    }

}
