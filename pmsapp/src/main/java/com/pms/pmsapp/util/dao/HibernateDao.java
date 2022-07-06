package com.pms.pmsapp.util.dao;

import java.io.Serializable;
import java.util.List;

import com.pms.pmsapp.util.dao.common.DAO;

public abstract class HibernateDao<View, PK extends Serializable> extends RootHibernateDAO<View, PK>
		implements DAO<View, PK> {
	@Override
	public void saveInsert(View obj) {
		add(obj);
	}

	@Override
	public void saveUpdate(View obj) {
		update(obj);
	}

	@Override
	public void saveRemove(PK id) {
		remove(id);
	}

	@Override
	public void saveRemove(View t) {
		remove(t);
	}

	@Override
	public void saveInsertList(List<View> list) {
		addList(list);
	}

	@Override
	public void saveRemoveList(List<View> list) {
		removeList(list);
	}

	@Override
	public void saveUpdateList(List<View> list) {
		for (View v : list) {
			update(v);
		}
	}
}
