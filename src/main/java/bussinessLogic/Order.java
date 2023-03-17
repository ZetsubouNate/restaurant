package bussinessLogic;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int id;
    private String clientID;
    private Date orderDate;

    public Order(int id, String clientID, Date orderDate) {
        this.id = id;
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public int hashCode() {
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order id: " + id +
                ", Client id: " + clientID +
                ", Order Date : " + orderDate;
    }
}
