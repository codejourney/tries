package com.demos.rest.RestUtil;

public class ONOSDeviceBO {

    private String id;
    private String type;
    private Boolean available;
    private String role;
    private String mfr;
    private String hw;
    private String sw;
    private String serial;
    private String driver;
    private String chassisId;
    private String lastUpdate;
    private String humanReadableLastUpdate;

    private ONOSAnontationBO annotations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public String getHw() {
        return hw;
    }

    public void setHw(String hw) {
        this.hw = hw;
    }

    public String getSw() {
        return sw;
    }

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getChassisId() {
        return chassisId;
    }

    public void setChassisId(String chassisId) {
        this.chassisId = chassisId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getHumanReadableLastUpdate() {
        return humanReadableLastUpdate;
    }

    public void setHumanReadableLastUpdate(String humanReadableLastUpdate) {
        this.humanReadableLastUpdate = humanReadableLastUpdate;
    }

    public ONOSAnontationBO getAnnotations() {
        return annotations;
    }

    public void setAnnotations(ONOSAnontationBO annotations) {
        this.annotations = annotations;
    }
}
