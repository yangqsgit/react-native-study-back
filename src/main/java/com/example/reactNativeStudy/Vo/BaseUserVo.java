package com.example.reactNativeStudy.Vo;

  public class BaseUserVo {
    private String account;
    private String pwd;

    private BaseUserVo() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BaseUserVo(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "BaseUserVo{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
