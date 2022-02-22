package com.revature.monster_lab.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.monster_lab.models.Scientist;


@Repository
public class ScientistDAO implements CrudDAO<Scientist> {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public ScientistDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Scientist findByUsernameAndPassword(String username, String password) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Scientist s where s.username = :username and s.password = :password", Scientist.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
	}

	public Scientist findScientistByEmail(String email) {
		return null;
	}

	public Scientist findScientistByUsername(String username) {
		return null;
	}

	@Override
	public Scientist create(Scientist newScientist) {
		sessionFactory.getCurrentSession().save(newScientist);
		return newScientist;
	}

	@Override
	public List<Scientist> findAll() {
		return null;
	}

	@Override
	public Scientist findById(String id) {
		return sessionFactory.getCurrentSession().get(Scientist.class, id);
	}

	@Override
	public boolean update(Scientist updatedObj) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
