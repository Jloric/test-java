package dto;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity

public class Client {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String nom;

    private String prenom;

    private DetailsClient details;

    public Client() {
    }

    public Client(long idClient, String nom, String prenom) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public DetailsClient getDetails() {
        return details;
    }

    public void setDetails(DetailsClient details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\''+
                '}';
    }
}
