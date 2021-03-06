package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.Consulta;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HistoricoConsultasScreen extends JFrame {
    private JButton buttonBack;
    private JList<String> jList2;
    private JScrollPane jScrollPane3;
    private JScrollPane scrollApointments;
    private JTable tableApointments;
    private JLabel windowTitle;

    public HistoricoConsultasScreen() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane3 = new JScrollPane();
        jList2 = new JList<>();
        windowTitle = new JLabel();
        buttonBack = new JButton();
        scrollApointments = new JScrollPane();
        tableApointments = new JTable();

        jList2.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        windowTitle.setText("Histórico de consultas");

        buttonBack.setText("Voltar");
        buttonBack.addActionListener(this::goBackButtonActionPerformed);

        scrollApointments.setViewportView(tableApointments);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(windowTitle)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(scrollApointments, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(buttonBack)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(windowTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollApointments, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonBack)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        updateConsultasData();
        setVisible(true);
    }

    private void goBackButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaPrincipal();
        this.dispose();
    }

    private void updateConsultasData() {
        DefaultTableModel modelTdItens = new DefaultTableModel();
        modelTdItens.addColumn("Data");
        modelTdItens.addColumn("Sintomas");
        modelTdItens.addColumn("Status");
        List<Consulta> consultas = new ArrayList<>();
        try {
            consultas = ControladorUsuario.getInstance().getUsuarioSessao().getHistoricoDeConsultas();
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        for (Consulta c : consultas) {
            modelTdItens.addRow(new Object[]{c.getData(), c.getFichaSintomas().getCorpo(), c.getStatus()});
        }
        tableApointments.setModel(modelTdItens);
        this.repaint();
    }
}
