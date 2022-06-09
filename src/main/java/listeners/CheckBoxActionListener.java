package main.java.listeners;

import lombok.Getter;
import main.java.model.Plugs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

@Getter
public class CheckBoxActionListener implements ActionListener {

    private final Set<Plugs> selectedPlugsList = new HashSet<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getSource();

        Plugs plug = Plugs.fromCheckboxLabel(checkBox.getText());
        if(checkBox.isSelected()) {
            selectedPlugsList.add(plug);
        } else {
            selectedPlugsList.remove(plug);
        }
    }
}
