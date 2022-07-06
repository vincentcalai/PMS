package com.pms.pmsapp.util.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate5.HibernateTemplate;

public abstract class RootHibernateDAO<T, PK extends Serializable> implements RootDAO<T, PK>, InitializingBean {

	private HibernateTemplate hibernateTemplate;
	private Class<T> persistantClass;

	protected Class<T> getPersistantClass() {
		return this.persistantClass;
	}

	protected Session getSession() {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession();
	}

	@Override
	public void flush() {
		this.hibernateTemplate.flush();
	}

	@Override
	public PK add(final T obj) {
		return (PK) this.hibernateTemplate.save(obj);
	}

	@Override
	public void addList(final List<T> objs) {
		for (T t : objs) {
			this.add(t);
		}
	}

	@Override
	public void remove(PK id) {
		this.remove(this.selectMatchingId(id));
	}

	@Override
	public void remove(T t) {
		if (t != null) {
			this.hibernateTemplate.delete(t);
		}
	}

	@Override
	public void removeList(List<T> list) {
		for (T t : list) {
			this.remove(t);
		}
	}

	@Override
	public T selectMatchingId(final PK id) {
		return this.hibernateTemplate.get(this.persistantClass, id);
	}

	@Override
	public void updateList(List<T> objs) {
		for (T t : objs) {
			this.update(t);
		}
	}

	@Override
	public void update(final T obj) {
		Serializable id = this.getId(this.persistantClass, obj);
		if (id != null) {
			Object sessionObj = this.getSession().load(this.persistantClass, id);
			if (sessionObj != null) {
				this.evict(sessionObj);
			}
		}
		if (this.getSession().contains(obj)) {
			this.evict(obj);
		}

		this.hibernateTemplate.update(obj);
	}

	protected void evict(Object obj) {
		this.hibernateTemplate.evict(obj);
	}

	private Serializable getId(Class<?> clazz, T obj) {
		EmbeddedId annotationEmbedded = null;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Id annotation = method.getAnnotation(javax.persistence.Id.class);
			if (annotation == null) {
				annotationEmbedded = method.getAnnotation(javax.persistence.EmbeddedId.class);
			}
			if (annotation != null || annotationEmbedded != null) {
				try {
					Serializable value = (Serializable) method.invoke(obj);
					return value;
				} catch (InvocationTargetException e) {
					return null;
				} catch (IllegalArgumentException e) {
					return null;
				} catch (IllegalAccessException e) {
					return null;
				}
			}
		}
		Class<?> clazz2 = clazz.getSuperclass();
		if (clazz2 != null && clazz2.getAnnotation(javax.persistence.MappedSuperclass.class) != null) {
			return this.getId(clazz2, obj);
		}
		return null;

	}
}
