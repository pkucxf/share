package com.pku.domain;

public class StoreInfo {
    public String storeId ;
    public String storeName;
    public String storeAddress ;    // 具体地址
    public String storeAddressProvince ;  // 市
    public String storeAddressCity ;    // 地级
    public String storeAddressArea ;    // 区镇
    public String storePhone;
    public int storeStar ;
    public int phone ;
    public int def0;
    public int def1;
    public int def2;

    public StoreInfo() {
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreStar() {
        return storeStar;
    }

    public void setStoreStar(int storeStar) {
        this.storeStar = storeStar;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getDef0() {
        return def0;
    }

    public void setDef0(int def0) {
        this.def0 = def0;
    }

    public int getDef1() {
        return def1;
    }

    public void setDef1(int def1) {
        this.def1 = def1;
    }

    public int getDef2() {
        return def2;
    }

    public void setDef2(int def2) {
        this.def2 = def2;
    }
    public String getStoreAddressProvince() {
        return storeAddressProvince;
    }

    public void setStoreAddressProvince(String storeAddressProvince) {
        this.storeAddressProvince = storeAddressProvince;
    }

    public String getStoreAddressCity() {
        return storeAddressCity;
    }

    public void setStoreAddressCity(String storeAddressCity) {
        this.storeAddressCity = storeAddressCity;
    }

    public String getStoreAddressArea() {
        return storeAddressArea;
    }

    public void setStoreAddressArea(String storeAddressArea) {
        this.storeAddressArea = storeAddressArea;
    }

}
