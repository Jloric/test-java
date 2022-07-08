package utility;

import dto.Client;
import dto.DetailsClient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class JPADemo {
    private static final String PERSISTENCE_UNIT_NAME = "Test";

    public static void main(String[] args) {

        EntityManagerFactory emFactoryObj = null;
        EntityManager entityMgr = null;
        try {
            emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityMgr = emFactoryObj.createEntityManager();

            Client client = new Client("combalt","camille");
            DetailsClient details =new DetailsClient("04478569875","orange@pomme.com","15 rue de la brouette");
            client.setDetail(details);
            Client client2 = new Client("aaaa","cazzee");
            DetailsClient details2 =new DetailsClient("044784754775","gert@pomme.com","15 rue de tete");
            client.setDetail(details2);
            JPADemo main = new JPADemo();
            main.addClient(entityMgr,client);
            main.addClient(entityMgr,client2);
            //List<Client> list=main.getClients(entityMgr);
            //System.out.println("La liste des clients est: \n"+list);
            entityMgr.clear();
            System.out.println("Record Successfully Inserted In The Database");

        } finally {
            if (entityMgr != null) entityMgr.close();
            if (emFactoryObj != null) emFactoryObj.close();
        }
    }
    public List<Client> getClients(EntityManager em){
        List<Client> clientList=new ArrayList<>();
        Query q =em.createQuery("select c from Client c");
        clientList=q.getResultList();
        return clientList;
    }
    public Client getClientById(EntityManager em,int idClient){
        Query q =em.createQuery("select c from Client c where c.id=?");
        Client client=(Client)q.getSingleResult();
        return client;
    }
    public void addClient(EntityManager em,Client client){
        em.getTransaction().begin();
        em.persist(client);

    }
    public void updateClient(EntityManager em,int idCLient,Client client){
        Query q =em.createQuery("update Client c where c.id=:idClient");
        q.setParameter("idClient",idCLient);
        q.executeUpdate();
    }
    public void deleteClient(EntityManager em,int idCLient){
        Query q =em.createQuery("delete u from Client c where c.id=:idClient");
        q.setParameter("idClient",idCLient);
        q.executeUpdate();
    }
}
