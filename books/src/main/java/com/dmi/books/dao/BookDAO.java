package com.dmi.books.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.dmi.books.model.Book;
import com.dmi.books.util.HibernateUtil;

/**
 * Classe DAO que será utilizada para fazer os acessos ao banco.
 * @author luizhenriquesantana
 *
 */
@Component
public class BookDAO {

	/**
	 * Insere um book no banco.
	 * @param entidade
	 * @throws Exception
	 */
	public void create(Book entidade) throws Exception {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao criar o book");
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Deleta um registro do banco
	 * @param entidadeId
	 * @param classeEntidade
	 * @throws Exception
	 */
	public Boolean delete(Long entidadeId) throws Exception {
		Transaction trns = null;
		
		Boolean isRetornoOk = Boolean.FALSE;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Book entidade = (Book) session.load(Book.class, new Long(entidadeId));

			session.delete(entidade);
			session.getTransaction().commit();
			isRetornoOk = Boolean.TRUE;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao excluir o book");
		} finally {
			session.flush();
			session.close();
		}
		
		return isRetornoOk;
	}

	/**
	 * Lista todos os registros
	 * @param entidade
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Book> list() {
		List<Book> list = new ArrayList<Book>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			list = session.createQuery("select id, title, price from Book").list();

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		
		
		return list;
	}
	
	/**
	 * Recupera um registro por id
	 * @param objId
	 * @return
	 */
	public Book getObj(Long objId) {

		Book obj = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
//			obj = (Book) session.createQuery("select id, image, title, author, price from Book where id = :id").setParameter("id", objId).uniqueResult();
			
			Query q = session.createQuery("select id as id, image as image, title as title, author as author, price as price from Book where id = :id");
			q.setParameter("id", objId);
			q.setResultTransformer(Transformers.aliasToBean(Book.class));
			
			obj = (Book) q.uniqueResult();
			
			
			
			
		} finally {
			session.flush();
			session.close();
		}

		return obj;
	}

	/**
	 * Atualiza um registro
	 * @param book
	 * @throws Exception
	 */
	public Boolean update(Book book) throws Exception {
		
		Boolean isRetornoOk = Boolean.FALSE;
		
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(book);
			session.getTransaction().commit();
			
			isRetornoOk = Boolean.TRUE;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error when tried to update the book.");
		} finally {
			session.flush();
			session.close();
		}
		
		return isRetornoOk;
	}
}
