package dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;
import dto.Fooditem;

public class MyDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(Customer c) {
		transaction.begin();
		manager.persist(c);
		transaction.commit();
	}
	public void Additem(Fooditem item)
	{
		transaction.begin();
		manager.persist(item);
		transaction.commit();
	}

	public Customer fetchByEmail(String email) {
		Query query=manager.createQuery("select x from Customer x where email=?1").setParameter(1, email);
        List<Customer> list=query.getResultList();
        if(list.isEmpty())
        	return null;
        else
        	return list.get(0);
	}

	public Customer FetchByMobile(long mobile)
	{
		Query query=manager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile);
        List<Customer> list=query.getResultList();
        if(list.isEmpty())
        	return null;
        else
        	return list.get(0);
      
	}
	  public List<Fooditem> fetchAllFooditem()
	  {
		  return manager.createQuery("select x from Fooditem x").getResultList();
	  }
	public Fooditem find(int id) 
	{
		return manager.find(Fooditem.class,id);
	}
	public void delete(Fooditem item) 
	{
		
		transaction.begin();
		manager.remove(item);
		transaction.commit();
	}
	public void update(Fooditem item) {
		transaction.begin();
		manager.merge(item);
		transaction.commit();
	}
	public List<Customer> fetchAllCustomer() {
		  return manager.createQuery("select x from Customer x").getResultList();
}
	public Customer findCustomer(int id) {
              return manager.find(Customer.class,id) ;    
	}
	public void delete(Customer c) {
		transaction.begin();
		manager.remove(c);
		transaction.commit();
	}
}
