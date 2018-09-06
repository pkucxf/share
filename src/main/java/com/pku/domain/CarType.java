package com.pku.domain;

public class CarType {
    public int id ;
    public String carName ;
    public String carProduce ;
    public String carDrive ;
    public String carTypes ;
    public int carSeat ;
    public String def0 ;
    public String def1 ;
    public String def2 ;
    public String def3 ;
    public String def4 ;


   public int pageNo;
   public int pageSize;

    public CarType() {

    }

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carProduce='" + carProduce + '\'' +
                ", carDrive='" + carDrive + '\'' +
                ", carTypes='" + carTypes + '\'' +
                ", carSeat=" + carSeat +
                ", def0='" + def0 + '\'' +
                ", def1='" + def1 + '\'' +
                ", def2='" + def2 + '\'' +
                ", def3='" + def3 + '\'' +
                ", def4='" + def4 + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
