package com.vcom.base.model;

public class ConfigModel {
    private Long configId;
    /**
     * 车牌号
     */
    private String carCode;
    private String serverUrl;
    private Integer serverPort;
    private String sessionKey;
    private String clientMac;
    private String clientNum;
    /**
     * 上车：0  下车：1
     */
    private Integer scanType;
    private Boolean icPay;
    private Boolean isMulti;
    private String updateUrl;
    private Integer gpsInterval;
    private String vehicleNo;//车牌号
    private int vehicleID;//车辆ID
    private String vehicleColor;//车牌颜色
    private Integer inputType;//键盘输入格式，0是输入站点，1是输入价格
    private Integer keyboardType;//旧键盘0，新键盘1
    private Integer countDownTime;//售票对话框倒计时时间（秒）
    private Integer auto_change;//手动切站后多久内不自动切站(秒)
    private Integer gps;//定位方式：0纯GPS，1高精度
    private String ssid;//wifi名称
    private String passwd;//wifi密码

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getGps() {
        return gps;
    }

    public void setGps(Integer gps) {
        this.gps = gps;
    }

    public void setKeyboardType(Integer keyboardType) {
        this.keyboardType = keyboardType;
    }

    public Integer getAuto_change() {
        return auto_change;
    }

    public void setAuto_change(Integer auto_change) {
        this.auto_change = auto_change;
    }

    public String getVehicleNo() {
        if (vehicleNo == null)
            vehicleNo = "";
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleColor() {
        if (vehicleColor == null)
            vehicleColor = "";
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Integer getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(int keyboardType) {
        this.keyboardType = keyboardType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Integer getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(Integer countDownTime) {
        this.countDownTime = countDownTime;
    }

    public ConfigModel() {
    }

    public ConfigModel(Boolean isMulti, Boolean icPay) {
        this.isMulti = isMulti;
        this.icPay = icPay;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getCarCode() {
        if (carCode == null)
            carCode = "";
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getServerUrl() {
        if (serverUrl == null)
            serverUrl = "";
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Integer getServerPort() {
        if (serverPort == null)
            serverPort = 80;
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getClientMac() {
        if (clientMac == null)
            clientMac = "";
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }

    public String getClientNum() {
        if (clientNum == null)
            clientNum = "";
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }


    public Integer getScanType() {
        if (scanType == null)
            scanType = 0;
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public Boolean getIcPay() {
        if (icPay == null)
            icPay = false;
        return icPay;
    }

    public void setIcPay(Boolean icPay) {
        this.icPay = icPay;
    }

    public Boolean getMulti() {
        if (isMulti == null)
            isMulti = false;
        return isMulti;
    }

    public void setMulti(Boolean multi) {
        isMulti = multi;
    }

    public String getUpdateUrl() {
        if (updateUrl == null)
            updateUrl = "";
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public Integer getGpsInterval() {
        return gpsInterval;
    }

    public void setGpsInterval(Integer gpsInterval) {
        this.gpsInterval = gpsInterval;
    }


}
