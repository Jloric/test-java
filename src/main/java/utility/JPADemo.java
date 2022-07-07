package utility;

import dto.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPADemo {
    private static final String PERSISTENCE_UNIT_NAME = "Test";

    public static void main(String[] args) {

        EntityManagerFactory emFactoryObj = null;
        EntityManager entityMgr = null;
        try {
            emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityMgr = emFactoryObj.createEntityManager();

            entityMgr.getTransaction().begin();

            Client client = new Client();
            client.setIdClient(1);
            client.setNom("antoine");
            client.setPrenom("daniel");
            entityMgr.merge(client);

            entityMgr.getTransaction().commit();

            entityMgr.clear();
            System.out.println("Record Successfully Inserted In The Database");

        } finally {
            if (entityMgr != null) entityMgr.close();
            if (emFactoryObj != null) emFactoryObj.close();
        }
    }
}
