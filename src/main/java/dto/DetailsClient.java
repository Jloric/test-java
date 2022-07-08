package dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details")
public class DetailsClient {
    private long idDetail;
    private String tel,mail,adresse;
    private Client client;

    public DetailsClient() {
    }

    public DetailsClient(long idDetail, String tel, String mail, String adresse) {
        this.idDetail = idDetail;
        this.tel = tel;
        this.mail = mail;
        this.adresse = adresse;
    }
    @Id
    public long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(long idDetail) {
        this.idDetail = idDetail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @OneToOne(mappedBy = "DetailsClient")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Details Client{" +
                "idDetail=" + idDetail +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
