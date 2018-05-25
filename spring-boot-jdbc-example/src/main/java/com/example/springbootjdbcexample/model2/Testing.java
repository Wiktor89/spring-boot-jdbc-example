package com.example.springbootjdbcexample.model2;

import com.example.springbootjdbcexample.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;

@Entity
@Table(name = "TESTERSJOURNAL_TESTING")
@JsonIgnoreType
public class Testing extends RootObject {
    private static final long serialVersionUID = 4926609256758433390L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME", nullable = false)
    protected Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME")
    protected Date endTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "testing")
    protected Device device;

    public void setDevice(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }


}