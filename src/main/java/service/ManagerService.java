package service;

import model.Manager;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ManagerService {

    private static ManagerService managerService;
    private EntityManager entityManager;

    private ManagerService(){
    }

    public static ManagerService getInstance() {
        if (Objects.isNull(managerService)) {
            managerService = new ManagerService();
        }
        return managerService;
    }

    public Manager save(Manager manager){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entityManager = session.getEntityManagerFactory().createEntityManager();

            entityManager.getTransaction().begin();
            Manager saving = entityManager.find(Manager.class, manager.getId());
            if (Objects.isNull(saving))
                saving = new Manager();

            saving.setPersonCode(manager.getPersonCode());
            saving.setEmail(manager.getEmail());
            saving.setFirstName(manager.getFirstName());
            saving.setLastName(manager.getLastName());
            saving.setPassword(manager.getPassword());

            entityManager.persist(saving);
            entityManager.getTransaction().commit();
            return saving;
        } catch (Exception e) {
            return null;
        }
    }

    public Manager login(String username, String password){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            entityManager = session.getEntityManagerFactory().createEntityManager();

            entityManager.getTransaction().begin();
            String jpql = "select m from Manager m where m.email = :username and m.password = :pass";
            return entityManager.createQuery(jpql, Manager.class)
                    .setParameter("username", username)
                    .setParameter("pass", password)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
