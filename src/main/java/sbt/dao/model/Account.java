package sbt.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="sberfood_account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="n_id")
    private Long id;
    @Column(name="c_login")
    private String login;
    @Column(name="c_password")
    private String password;
    @Column(name="b_payed")
    private Boolean isPayed;
    @Column(name="d_expire_date")
    private Timestamp expireDate;

    public Account() {
    }

    public Account(Long id, String login, String password, Boolean isPayed, Timestamp expireDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isPayed = isPayed;
        this.expireDate = expireDate;
    }

    public Account(String login, String password, Boolean isPayed, Timestamp expireDate) {
        this.login = login;
        this.password = password;
        this.isPayed = isPayed;
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isPayed=" + isPayed +
                ", expireDate=" + expireDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
