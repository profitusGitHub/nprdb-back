package com.profitus.nprdbservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MessageId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long nextId;
    @CreationTimestamp
    private Date createDateTime;
    @UpdateTimestamp
    private Date updateDateTime;

    public MessageId() {
    }

    public MessageId(Long nextId) {
        this.nextId = nextId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @PrePersist
    protected void onCreate() {
        this.createDateTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDateTime = new Date();
    }


    public void increse() {
        this.nextId = this.nextId + 1;
    }
}
