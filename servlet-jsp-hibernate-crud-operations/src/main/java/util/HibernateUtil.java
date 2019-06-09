package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	//��� ������ � Hibernate �������������� ����� ������. ��� ������� Hibernate ���������� ������� ���������� ������
	//org.hibernate.SessionFactory � ������� ��� ���-������ � ���� ����������. org.hibernate.SessionFactory ������������ ��� 
	//��������� ����������� org.hibernate.Session. ������ ������������ ����� ������������ �������� ��� ������ ��������� ������.
	//������� ������ � ��� ���������������� ���������� ������, ������� ����� ���������������� ����� ���� ���.

	public static SessionFactory getSessionFactory() {//���������� ������� ������ (SessionFactory), ������� ������� ������ ������.
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory;
	}
}
// �����, ������� ����� ������ ��� ������-���� � ���������� ��� ������ ���� SessionFactory, 
//������� �������� �� �������� hibernate-������.
