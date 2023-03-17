package dataAccess;

import bussinessLogic.DeliveryService;
import bussinessLogic.Order;
import bussinessLogic.product.MenuItem;
import bussinessLogic.role.User;
import bussinessLogic.role.UserChecks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class FileWriter {
    DeliveryService deliveryService = new DeliveryService();
    UserChecks userChecks = new UserChecks();

    public FileWriter(DeliveryService deliveryService, UserChecks userChecks) {
        this.deliveryService = deliveryService;
        this.userChecks = userChecks;
    }

    public void load() throws IOException, ClassNotFoundException {
        File file1 = new File("data1.ser");
        File file2 = new File("data2.ser");
        File file3 = new File("data3.ser");

        if(file1.exists() && file1.isFile()) {
            Object data1 = new Object();
            FileInputStream fileInputStream1 = new FileInputStream("data1.ser");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            data1 = objectInputStream1.readObject();
            objectInputStream1.close();
            fileInputStream1.close();
            deliveryService.setProductList((ArrayList<MenuItem>) data1);
        }

        if(file2.exists() && file2.isFile()) {
            Object data2 = new Object();
            FileInputStream fileInputStream2 = new FileInputStream("data2.ser");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            data2 = objectInputStream2.readObject();
            objectInputStream2.close();
            fileInputStream2.close();
            deliveryService.setOrders((Map<Order, Collection<MenuItem>>) data2);
        }

        if(file3.exists() && file3.isFile()) {
            Object data3 = new Object();
            FileInputStream fileInputStream3 = new FileInputStream("data3.ser");
            ObjectInputStream objectInputStream3 = new ObjectInputStream(fileInputStream3);
            data3 = objectInputStream3.readObject();
            objectInputStream3.close();
            fileInputStream3.close();
            userChecks.setUsers((ArrayList<User>) data3);
        }

        System.out.println("Data loaded.");
    }

    public void save() throws IOException {
        Object data1 = new Object();
        data1 = deliveryService.getProductList();

        Object data2 = new Object();
        data2 = deliveryService.getOrders();

        Object data3 = new Object();
        data3 = userChecks.getUsers();

        FileOutputStream fileOutputStream1 = new FileOutputStream("data1.ser");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        objectOutputStream1.writeObject(data1);
        objectOutputStream1.close();
        fileOutputStream1.close();

        FileOutputStream fileOutputStream2 = new FileOutputStream("data2.ser");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
        objectOutputStream2.writeObject(data2);
        objectOutputStream2.close();
        fileOutputStream2.close();

        FileOutputStream fileOutputStream3 = new FileOutputStream("data3.ser");
        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream3);
        objectOutputStream3.writeObject(data3);
        objectOutputStream3.close();
        fileOutputStream3.close();

        System.out.println("Data saved.");
    }
}
