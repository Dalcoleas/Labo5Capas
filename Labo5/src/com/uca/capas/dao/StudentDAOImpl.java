package com.uca.capas.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student order by id_student asc");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List <Student> resulset = query.getResultList();
		return resulset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		try {
			if(newRow==1) entityManager.persist(s); //Si agrego una nueva fila, se usa persist
			else entityManager.merge(s); //Si existe la fila, se usa merge
			entityManager.flush();// Se sincroniza con la base de datos
			return 1;
		}catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Transactional
	public int delete(Student s) throws DataAccessException {
		
		return 0;
	}
	

}
