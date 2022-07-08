package dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    private long id;
    @Basic
    private String nom;
    @Basic
    private String prenom;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = DetailsClient.class)
    private DetailsClient detail;

    public Client() {
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(long idClient, String nom, String prenom) {
        this.id = idClient;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public DetailsClient getDetail() {
        return detail;
    }

    public void setDetail(DetailsClient detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\''+
                '}';
    }
}
