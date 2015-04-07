package com.cdk.spring.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by khana on 4/7/15.
 */
public class UserPrimaryKey implements Serializable {


    private Long id;

    private String name;

    public UserPrimaryKey() {
    }

    public UserPrimaryKey(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * method to get hashCode .
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).toHashCode();
    }

    /**
     * equals method for primary fields .
     * @param obj
     * @return eqaulity result .
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserPrimaryKey rhs = (UserPrimaryKey) obj;
        return new EqualsBuilder().append(id, rhs.id)
                .append(name, rhs.name).isEquals();
    }
}
