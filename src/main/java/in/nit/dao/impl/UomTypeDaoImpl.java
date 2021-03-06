package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUomType(UomType ob) {
		Integer id = (Integer) ht.save(ob);
		return id;
	}

	@Override
	public List<UomType> getAllUomTypes() {
		return ht.loadAll(UomType.class);
	}
	@Override
	public void deletUomType(Integer id) {
		UomType ut=new UomType();
		ut.setUomId(id);
		ht.delete(ut);
	}
	@Override
	public UomType getOneUomType(Integer id) {
		return ht.get(UomType.class, id);
	}
	@Override
	public void updateUomType(UomType ob) {
		ht.update(ob);
	}
}
