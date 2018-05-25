package com.example.springbootjdbcexample.model2;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Table(name = "TESTERSJOURNAL_DEVICE")
@JsonIgnoreType
public class Device extends RootObject {
    private static final long serialVersionUID = 8745677301574611408L;

    @Column(name = "NAME_DEVICE", nullable = false)
    protected String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TESTING_ID")
    protected Testing testing;

    @Column(name = "STATE")
    protected Integer state;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEVICE_OS_ID")
    protected OperationSystem deviceOs;

    @Column(name = "SCREEN_RESOLUTION")
    protected String screenResolution;

    @Column(name = "DESCRIPTION")
    protected String description;

    public void setTesting(Testing testing) {
        this.testing = testing;
    }

    public Testing getTesting() {
        return testing;
    }


    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }


    public void setState(States state) {
        this.state = state == null ? null : state.getId();
    }

    public States getState() {
        return state == null ? null : States.fromId(state);
    }


    public OperationSystem getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(OperationSystem deviceOs) {
        this.deviceOs = deviceOs;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(name, device.name) &&
                Objects.equals(testing, device.testing) &&
                Objects.equals(state, device.state) &&
                Objects.equals(deviceOs, device.deviceOs) &&
                Objects.equals(screenResolution, device.screenResolution) &&
                Objects.equals(description, device.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, testing, state, deviceOs, screenResolution, description);
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", testing=" + testing +
                ", state=" + state +
                ", deviceOs=" + deviceOs +
                ", screenResolution='" + screenResolution + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}