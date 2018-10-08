package com.pku.domain;

public class CarType {
    public int id ;
    public String carName ;
    public String carProduce ;
    public String carDrive ;
    public String carTypes ;
    public int carSeat ;
    public String img ;

    public String carMoney;
    public String def0 ;
    public String def1 ;
    public String def2 ;
    public String def3 ;
    public String def4 ;


    public CarType() {

    }

    public CarType(int id, String carName, String carProduce, String carDrive, String carTypes, int carSeat, String img, String carMoney, String def0, String def1, String def2, String def3, String def4) {
        this.id = id;
        this.carName = carName;
        this.carProduce = carProduce;
        this.carDrive = carDrive;
        this.carTypes = carTypes;
        this.carSeat = carSeat;
        this.img = img;
        this.carMoney = carMoney;
        this.def0 = def0;
        this.def1 = def1;
        this.def2 = def2;
        this.def3 = def3;
        this.def4 = def4;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarProduce() {
        return carProduce;
    }

    public void setCarProduce(String carProduce) {
        this.carProduce = carProduce;
    }

    public String getCarDrive() {
        return carDrive;
    }

    public void setCarDrive(String carDrive) {
        this.carDrive = carDrive;
    }

    public String getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(String carTypes) {
        this.carTypes = carTypes;
    }

    public int getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(int carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarMoney() {
        return carMoney;
    }

    public void setCarMoney(String carMoney) {
        this.carMoney = carMoney;
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

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }
}
