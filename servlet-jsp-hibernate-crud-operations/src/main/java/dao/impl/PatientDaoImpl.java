package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.PatientDao;
import entity.Patient;
import util.HibernateUtil;

public class PatientDaoImpl implements PatientDao {

	private static PatientDaoImpl patientDaoImpl = null;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Long savePatient(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(patient);
		transaction.commit();
		session.close();

		return id;
	}

	@Override
	public void updatePatient(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(patient);
		transaction.commit();
		session.close();
	}

	@Override
	public void deletePatient(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Patient patient = session.get(Patient.class, id);
		session.delete(patient);
		transaction.commit();
		session.close();
	}

	@Override
	public Patient findPatientById(Long id) {
		Session session = this.sessionFactory.openSession();
		Patient patient = session.get(Patient.class, id);
		session.close();

		return patient;
	}

	@Override
	@SuppressWarnings("unchecked")//"unchecked"используется для подавления непроверенные предупреждения
	public List<Patient> findAllPatients() {
		Session session = this.sessionFactory.openSession();
		List<Patient> patientList = session.createCriteria(Patient.class).list();//Критерии-это упрощенный API для извлечения сущностей составляя объекты критерия
		session.close();

		return patientList;
	}

	public static PatientDao getInstance() {
		if (patientDaoImpl == null)
			patientDaoImpl = new PatientDaoImpl();

		return patientDaoImpl;//Метод getInstance() называется factory.
//Он используется для создания одноэлементного класса. Это означает, что будет создан только один
		//экземпляр этого класса, а другие получат ссылку на этот класс.
	}
}
