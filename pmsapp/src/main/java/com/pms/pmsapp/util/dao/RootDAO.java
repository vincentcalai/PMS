package com.pms.pmsapp.util.dao;

import java.io.Serializable;
import java.util.List;

public interface RootDAO<T, PK extends Serializable> {

	PK add(final T obj);

	void addList(List<T> objs);

	void remove(PK id);

	void remove(T t);

	void removeList(List<T> list);

	T selectMatchingId(final PK id);

	void updateList(List<T> objs);

	void update(final T obj);

	void flush();

}
