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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)//���������� �������� (� ������� service������) ��������� �������� ������������ ������ GET.
			throws ServletException, IOException {//������������ �������� ������, ������� ���������� ��� ������ ��������

		List<Patient> patients = patientDao.findAllPatients();

		request.setAttribute("patientList", patients);//req - HttpServletRequest������, ������� �������� ������ ������� ��������
		//resp - HttpServletResponse������, ������� �������� �����, ������������ ��������� �������

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)//������������ ����������� �������
	//(��������, ����, ������, ��������� ������), � �����, ��, ��� ����� �������� ����� HTTP
			throws ServletException, IOException {
		doGet(request, response);
	}

}
