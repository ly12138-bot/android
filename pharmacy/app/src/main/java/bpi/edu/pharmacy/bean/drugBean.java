package bpi.edu.pharmacy.bean;

import java.util.ArrayList;

public class drugBean {
    private String d_id;
    private String d_name;
    private String d_type;
    private String d_price;
    private String d_jj;

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_type() {
        return d_type;
    }

    public void setD_type(String d_type) {
        this.d_type = d_type;
    }

    public String getD_price() {
        return d_price;
    }

    public void setD_price(String d_price) {
        this.d_price = d_price;
    }

    public String getD_jj() {
        return d_jj;
    }

    public void setD_jj(String d_jj) {
        this.d_jj = d_jj;
    }

    public drugBean(String d_id, String d_name, String d_type, String d_price, String d_jj) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_type = d_type;
        this.d_price = d_price;
        this.d_jj = d_jj;
    }
}
