package info.dgsoft.restful.api.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import info.dgsoft.restful.api.domain.base.DomainBase;

@Entity
@Table(name = "users")
public class User extends DomainBase {

  private static final long serialVersionUID = 2353528370345499815L;
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  private String username;
  @NotNull
  private String password;
  private String email;
  @Column(name = "last_password_reset")
  private Date lastPasswordReset;
  private String authorities;

  public User() {
    super();
  }

  public User(String username, String password, String email, Date lastPasswordReset, String authorities) {
    this.setUsername(username);
    this.setPassword(password);
    this.setEmail(email);
    this.setLastPasswordReset(lastPasswordReset);
    this.setAuthorities(authorities);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getLastPasswordReset() {
    return this.lastPasswordReset;
  }

  public void setLastPasswordReset(Date lastPasswordReset) {
    this.lastPasswordReset = lastPasswordReset;
  }

  public String getAuthorities() {
    return this.authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

}
