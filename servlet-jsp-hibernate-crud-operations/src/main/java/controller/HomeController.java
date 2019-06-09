package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.impl.PatientDaoImpl;
import entity.Patient;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDao patientDao = PatientDaoImpl.getInstance();

	public HomeController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)//Вызывается сервером (с помощью serviceметода) разрешить сервлету обрабатывать запрос GET.
			throws ServletException, IOException {//обрабатывает адресную строку, которая получается при вызове сервлета

		List<Patient> patients = patientDao.findAllPatients();

		request.setAttribute("patientList", patients);//req - HttpServletRequestобъект, который содержит запрос клиента сервлета
		//resp - HttpServletResponseобъект, который содержит ответ, отправленный сервлетом клиенту

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)//обрабатывает загруженный контент
	//(картинку, файл, строки, объектные данные), в общем, всё, что можно передать через HTTP
			throws ServletException, IOException {
		doGet(request, response);
	}

}
