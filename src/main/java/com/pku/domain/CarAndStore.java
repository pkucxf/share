package com.pku.domain;

import java.util.List;

public class CarAndStore {
    public int id ;
    public String storeId;
    public String storeName;
    public int carNum;
    public String carId;
    public String carName ;
    public String carImg;
    public String def0;
    public String def1;
    public String def2;

    public List<CarList> carList;

    public List getCarList() {
        return carList;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setCarList(List carList) {
        this.carList = carList;
    }

    public CarAndStore() {
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getDef0() {
        return def0;
    }

    public void setDef0(String def0) {
        this.def0 = def0;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }
}
