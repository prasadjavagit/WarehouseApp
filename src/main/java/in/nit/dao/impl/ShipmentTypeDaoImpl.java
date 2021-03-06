package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveShipmentType(ShipmentType ob) {
		Integer id = (Integer) ht.save(ob);
		return id;
	}

	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> list = ht.loadAll(ShipmentType.class);
		return list;
	}

	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
	}

	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentIdAndCode() {
		String hql="select shipId, shipCode from "+ShipmentType.class.getName()+" where enbShip='YES'";
		return (List<Object[]>) ht.find(hql);
	}
}
