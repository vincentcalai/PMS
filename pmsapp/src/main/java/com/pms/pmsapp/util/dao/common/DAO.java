package com.pms.pmsapp.util.dao.common;

import java.io.Serializable;
import java.util.List;

public interface DAO<View, PK extends Serializable> {
	void saveInsert(final View obj);

	void saveUpdate(final View obj);

	void saveRemove(PK id);

	void saveRemove(View t);

	void saveInsertList(List<View> list);

	void saveRemoveList(List<View> list);

	void saveUpdateList(List<View> list);
}
