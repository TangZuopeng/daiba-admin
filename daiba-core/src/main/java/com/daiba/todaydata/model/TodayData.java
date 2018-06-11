package com.daiba.todaydata.model;


/**
 * Created by tinydolphin on 2018/5/16.
 */
public class TodayData {

    // 今日新用户数
    private int reguser;

    // 今日登录用户数
    private int login;

    // 今日发单数
    private int give;

    // 今日退单数
    private int back;

    // 今日总订单数
    private int firmsum;

    // 今日带客总收入
    private int income;

    public int getReguser() {
        return reguser;
    }

    public void setReguser(int reguser) {
        this.reguser = reguser;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getGive() {
        return give;
    }

    public void setGive(int give) {
        this.give = give;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int getFirmsum() {
        return firmsum;
    }

    public void setFirmsum(int firmsum) {
        this.firmsum = firmsum;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "TodayData{" +
                "reguser=" + reguser +
                ", login=" + login +
                ", give=" + give +
                ", back=" + back +
                ", firmsum=" + firmsum +
                ", income=" + income +
                '}';
    }
}
