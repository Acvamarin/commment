package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	//Вся работа в Hibernate осуществляется через сессии. Для запуска Hibernate необходимо создать глобальный объект
	//org.hibernate.SessionFactory и хранить его где-нибудь в коде приложения. org.hibernate.SessionFactory используется для 
	//получения экземпляров org.hibernate.Session. Сессии представляют собой однопоточные элементы для каждой отдельной задачи.
	//Фабрика сессий — это потокобезопасный глобальный объект, который нужно инициализировать всего один раз.

	public static SessionFactory getSessionFactory() {//Возвращает фабрику сессий (SessionFactory), которая создала данную сессию.
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory;
	}
}
// класс, который будет хавать наш конфиг-файл и возвращать нам объект типа SessionFactory, 
//который отвечает за создание hibernate-сессии.
