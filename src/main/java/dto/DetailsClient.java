package dto;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name="details_client")
@Table(name = "details")
public class DetailsClient {
    @Id
    @GeneratedValue(generator = "foreignkeygen")
    @GenericGenerator(strategy = "foreign", name="foreignkeygen",parameters = @Parameter(name="property",value="client"))
    private long id;
    @Basic
    private String tel;
    @Basic
    private String   mail;
    @Basic
    private String    adresse;
    @OneToOne(mappedBy = "detail",targetEntity = Client.class)
    private Client client;

    public DetailsClient() {
    }

    public DetailsClient(String tel, String mail, String adresse) {
        this.tel = tel;
        this.mail = mail;
        this.adresse = adresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Details Client{" +
                "idDetail=" + id +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
