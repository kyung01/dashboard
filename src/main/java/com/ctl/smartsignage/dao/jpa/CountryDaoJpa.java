package com.ctl.smartsignage.dao.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.ctl.smartsignage.dao.CountriesDao;
import com.ctl.smartsignage.domain.Countries;

public class CountryDaoJpa extends BaseDaoJpa<Countries> implements CountriesDao {

	public CountryDaoJpa() {
		super(Countries.class, "CountryDao");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Countries save(Countries entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Countries loadById(Long entityId) throws ObjectRetrievalFailureException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Countries> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Countries entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Countries> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Countries> getAllCountriesForSync(Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

}
