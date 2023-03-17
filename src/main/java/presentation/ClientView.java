package presentation;

import bussinessLogic.DeliveryService;

import javax.swing.*;
import java.awt.*;

public class ClientView extends JFrame{
    JButton backButton;
    JButton orderButton;
    JButton addButton;
    JButton searchButton;
    JTextField keyword;

    public ClientView(DeliveryService service, String client) {
        int mainHeight = 800;
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel cartPanel = new JPanel(new BorderLayout());
        DefaultListModel<MenuItem> productCartModel = new DefaultListModel<>();
        JList<MenuItem> productCartList = new JList<>(productCartModel);
        JScrollPane listPanel = new JScrollPane(productCartList);
        cartPanel.add(listPanel, BorderLayout.CENTER);
        JPanel orderPricePanel = new JPanel(new GridLayout(0, 1, 3, 3));
        orderPricePanel.add(new JLabel("Total price:           "));
        JLabel price = new JLabel("0.0");
        orderPricePanel.add(price);

        orderButton = new JButton("Order");
        orderPricePanel.add(orderButton);
        backButton = new JButton("Back");
        orderPricePanel.add(backButton);
        cartPanel.add(orderPricePanel, BorderLayout.PAGE_END);

        JPanel productPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new GridLayout(0, 1, 3, 3));
        searchPanel.add(new JLabel("Keyword:"));
        keyword = new JTextField();
        searchPanel.add(keyword);

        searchPanel.add(new JLabel("Rating between:"));
        JPanel ratingPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner ratingMin = new JSpinner();
        ratingMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        ratingMin.setEditor(new JSpinner.NumberEditor(ratingMin, "##.##"));
        JSpinner ratingMax = new JSpinner();
        ratingMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        ratingMax.setEditor(new JSpinner.NumberEditor(ratingMax, "##.##"));
        ratingPanel.add(ratingMin);
        ratingPanel.add(ratingMax);
        searchPanel.add(ratingPanel);

        searchPanel.add(new JLabel("Calories between:"));
        JPanel caloriesPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner caloriesMin = new JSpinner();
        caloriesMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        caloriesMin.setEditor(new JSpinner.NumberEditor(caloriesMin, "##.##"));
        JSpinner caloriesMax = new JSpinner();
        caloriesMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        caloriesMax.setEditor(new JSpinner.NumberEditor(caloriesMax, "##.##"));
        caloriesPanel.add(caloriesMin);
        caloriesPanel.add(caloriesMax);
        searchPanel.add(caloriesPanel);

        searchPanel.add(new JLabel("Proteins between:"));
        JPanel proteinsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner proteinsMin = new JSpinner();
        proteinsMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        proteinsMin.setEditor(new JSpinner.NumberEditor(proteinsMin, "##.##"));
        JSpinner proteinsMax = new JSpinner();
        proteinsMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        proteinsMax.setEditor(new JSpinner.NumberEditor(proteinsMax, "##.##"));
        proteinsPanel.add(proteinsMin);
        proteinsPanel.add(proteinsMax);
        searchPanel.add(proteinsPanel);

        searchPanel.add(new JLabel("Fats between:"));
        JPanel fatsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner fatsMin = new JSpinner();
        fatsMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        fatsMin.setEditor(new JSpinner.NumberEditor(fatsMin, "##.##"));
        JSpinner fatsMax = new JSpinner();
        fatsMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        fatsMax.setEditor(new JSpinner.NumberEditor(fatsMax, "##.##"));
        fatsPanel.add(fatsMin);
        fatsPanel.add(fatsMax);
        searchPanel.add(fatsPanel);

        searchPanel.add(new JLabel("Sodium between:"));
        JPanel sodiumPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner sodiumMin = new JSpinner();
        sodiumMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        sodiumMin.setEditor(new JSpinner.NumberEditor(sodiumMin, "##.##"));
        JSpinner sodiumMax = new JSpinner();
        sodiumMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        sodiumMax.setEditor(new JSpinner.NumberEditor(sodiumMax, "##.##"));
        sodiumPanel.add(sodiumMin);
        sodiumPanel.add(sodiumMax);
        searchPanel.add(sodiumPanel);

        searchPanel.add(new JLabel("Price between:"));
        JPanel pricePanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JSpinner priceMin = new JSpinner();
        priceMin.setModel(new SpinnerNumberModel(0, 0, 100000, 0.01));
        priceMin.setEditor(new JSpinner.NumberEditor(priceMin, "##.##"));
        JSpinner priceMax = new JSpinner();
        priceMax.setModel(new SpinnerNumberModel(100000, 0, 100000, 0.01));
        priceMax.setEditor(new JSpinner.NumberEditor(priceMax, "##.##"));
        pricePanel.add(priceMin);
        pricePanel.add(priceMax);
        searchPanel.add(pricePanel);

        searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        productPanel.add(searchPanel, BorderLayout.PAGE_START);

        mainPanel.add(productPanel, BorderLayout.CENTER);
        mainPanel.add(cartPanel, BorderLayout.LINE_END);

        DefaultListModel<MenuItem> foundModel = new DefaultListModel<>();
        JList<MenuItem> foundList = new JList<>(foundModel);
        JScrollPane foundPanel = new JScrollPane(foundList);
        productPanel.add(foundPanel, BorderLayout.CENTER);
        addButton = new JButton("Add");
        productPanel.add(addButton, BorderLayout.PAGE_END);

        this.setBounds(100, 100, 700, mainHeight);
        this.setTitle("Client");
        this.setContentPane(mainPanel);
        this.revalidate();
    }
}
