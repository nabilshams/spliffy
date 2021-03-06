package org.spliffy.server.db;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;

/**
 *
 * @author brad
 */
@javax.persistence.Entity
@Table(name="USER_ENTITY")
@DiscriminatorValue("U")
public class User extends BaseEntity {

    private String passwordDigest;
    
    private String email;

    @Column
    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String password) {
        this.passwordDigest = password;
    }

    @Column(nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}
