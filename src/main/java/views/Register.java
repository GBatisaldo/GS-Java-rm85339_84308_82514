package main.java.views;

import main.java.listeners.CheckBoxActionListener;
import main.java.listeners.SubmitButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Register extends JPanel {

    JTextField name = new JTextField(12);

    JTextField road = new JTextField();
    JTextField district = new JTextField();
    JTextField city = new JTextField();
    String[] stateList = {
            "Acre",
            "Alagoas",
            "Amapá",
            "Amazonas",
            "Bahia",
            "Ceará",
            "Espírito Santo",
            "Federal District",
            "Goiás",
            "Maranhão",
            "Mato Grosso",
            "Mato Grosso do Sul",
            "Minas Gerais",
            "Paraná",
            "Paraíba",
            "Pará",
            "Pernambuco",
            "Piauí",
            "Rio Grande do Norte",
            "Rio Grande do Sul",
            "Rio de Janeiro",
            "Rondônia",
            "Roraima",
            "Santa Catarina",
            "Sergipe",
            "São Paulo",
            "Tocantins"
    };
    JComboBox<String> state = new JComboBox<>(stateList);

    JSpinner review = new JSpinner(new SpinnerNumberModel(0, 0, 5, 0.5));

    CheckBoxActionListener cbActionListener = new CheckBoxActionListener();

    JCheckBox tipo1Box = new JCheckBox("tipo1");
    JCheckBox tipo2Box = new JCheckBox("tipo2");
    JCheckBox css2Box = new JCheckBox("CSS2");
    JCheckBox chademoBox = new JCheckBox("CHAdeMO");

    public Register(AvailableStations stations) {
        super(new GridBagLayout());
        setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;

        //Nome
        JLabel nameInputLabel = new JLabel("Nome");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 20, 0, 0);
        add(nameInputLabel, c);
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 10, 0, 20);
        add(name, c);

        JLabel enderecoLabel = new JLabel("Endereço:");
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 20, 20, 0);
        add(enderecoLabel, c);

        //Rua e Bairro
        JLabel ruaInputLabel = new JLabel("Rua");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 20, 0, 20);
        add(ruaInputLabel, c);
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(0, 10, 0, 10);
        add(road, c);
        JLabel bairroInputLabel = new JLabel("Bairro");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        add(bairroInputLabel, c);
        c.weightx = 1;
        c.gridx = 4;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(0, -10, 0, 20);
        add(district, c);

        //Espaço vertical
        JLabel verticalSpace = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 5, 0);
        add(verticalSpace, c);

        //Cidade e Estado
        JLabel cidadeInputLabel = new JLabel("Cidade");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 20, 0, 20);
        add(cidadeInputLabel, c);
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0, 10, 0, 10);
        add(city, c);
        JLabel estadoInputLabel = new JLabel("Estado");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 4;
        add(estadoInputLabel, c);
        c.weightx = 1.0;
        c.gridx = 4;
        c.gridy = 4;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, -10, 0, 20);
        add(state, c);

        //Espaço vertical
        verticalSpace = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(20, 0, 20, 0);
        add(verticalSpace, c);

        //Review e preço
        JLabel reviewInputLabel = new JLabel("Análise");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0, 20, 0, 20);
        add(reviewInputLabel, c);
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        add(review, c);
        JLabel priceInputLabel = new JLabel("Preço por kWh");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 6;
        c.insets = new Insets(0, 20, 0, 20);
        add(priceInputLabel, c);
        NumberFormat priceFormat = DecimalFormat.getCurrencyInstance();
        priceFormat.setMaximumFractionDigits(2);
        JFormattedTextField price = new JFormattedTextField(priceFormat);
        c.weightx = 1.0;
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 1;
        price.setValue(0.0);
        add(price, c);

        //Espaço vertical
        verticalSpace = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(20, 0, 20, 0);
        add(verticalSpace, c);

        //Plugs
        JLabel availablePlugsLabel = new JLabel("Plugs disponíveis");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0, 20, 0, 20);
        add(availablePlugsLabel, c);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0, 10, 0, 0);
        tipo1Box.addActionListener(cbActionListener);
        add(tipo1Box, c);
        c.gridx = 2;
        c.gridy = 8;
        tipo2Box.addActionListener(cbActionListener);
        add(tipo2Box, c);
        c.gridx = 3;
        c.gridy = 8;
        css2Box.addActionListener(cbActionListener);
        add(css2Box, c);
        c.gridx = 4;
        c.gridy = 8;
        chademoBox.addActionListener(cbActionListener);
        add(chademoBox, c);

        //Espaço vertical
        verticalSpace = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(30, 0, 30, 0);
        add(verticalSpace, c);

        //Botão de cadastro
        JButton submitButton = new JButton("Cadastrar");
        submitButton.addActionListener(new SubmitButtonActionListener(
                name, road, district, city, state, review,
                cbActionListener.getSelectedPlugsList(), price, stations
        ));
        c.gridx = 3;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 0, 20);
        add(submitButton, c);
    }
}
