package bpi.edu.pharmacy.bean;

public class userBean {
    String userName;
    String userPassword;
    String userPhone;
    String userAddress;
    String userSex;
    String userPow;

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPow() {
        return userPow;
    }

    public void setUserPow(String userPow) {
        this.userPow = userPow;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public userBean(String userName, String userPassword, String userPhone, String userAddress, String userSex, String userPow) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userPow = userPow;
    }
}
