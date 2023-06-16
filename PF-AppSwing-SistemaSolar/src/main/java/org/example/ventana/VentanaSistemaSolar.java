package org.example.ventana;

import org.example.datos.ConexionDB;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class VentanaSistemaSolar extends JFrame {
    private JLabel lblID;
    private JLabel lblPlaneta;
    private JLabel lblLuna;
    private JLabel lblColores;
    private JLabel lblDiasOrbitales;
    private JLabel lblURLimagen;
    private JTextField txtID;
    private JTextField txtPlaneta;
    private JTextField txtLuna;
    private JTextField txtColores;
    private JTextField txtDiasOrbitales;
    private JTextField txtURLimagen;
    private JButton botonAdd;
    private JButton botonCargar;
    private JButton botonEliminar;
    private JButton botonActualizar;
    private JLabel imagenSistemaSolar;

    private JTable tabla;
    private GridLayout layout;
    private JScrollPane scroll;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    private JLabel lblActualizar;
    private JTextField txtActualizar;

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblPlaneta() {
        return lblPlaneta;
    }

    public void setLblPlaneta(JLabel lblPlaneta) {
        this.lblPlaneta = lblPlaneta;
    }

    public JLabel getLblLuna() {
        return lblLuna;
    }

    public void setLblLuna(JLabel lblLuna) {
        this.lblLuna = lblLuna;
    }

    public JLabel getLbColores() {
        return lblColores;
    }

    public void setLblColores(JLabel lblColores) {
        this.lblColores = lblColores;
    }

    public JLabel getLblDiasOrbitales() {
        return lblDiasOrbitales;
    }

    public void setLblDiasOrbitales(JLabel lblDiasOrbitales) {
        this.lblDiasOrbitales = lblDiasOrbitales;
    }

    public JLabel getLblURLimagen() {
        return lblURLimagen;
    }

    public void setLblURLimagen(JLabel lblURLimagen) {
        this.lblURLimagen = lblURLimagen;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtPlaneta() {
        return txtPlaneta;
    }

    public void setTxtPlaneta(JTextField txtPlaneta) {
        this.txtPlaneta = txtPlaneta;
    }

    public JTextField getTxtLuna() {
        return txtLuna;
    }

    public void setTxtLuna(JTextField txtLuna) {
        this.txtLuna = txtLuna;
    }

    public JTextField getTxtColores() {
        return txtColores;
    }

    public void setTxtColores(JTextField txtLColores) {
        this.txtColores = txtColores;
    }

    public JTextField getTxtDiasOrbitales() {
        return txtDiasOrbitales;
    }

    public void setTxtDiasOrbitales(JTextField txtDiasOrbitales) {
        this.txtDiasOrbitales = txtDiasOrbitales;
    }

    public JTextField getTxtURLimagen() {
        return txtURLimagen;
    }

    public void setTxtURLimagen(JTextField txtURLimagen) {
        this.txtURLimagen = txtURLimagen;
    }

    public JButton getBotonAdd() {
        return botonAdd;
    }

    public void setBotonAdd(JButton botonAdd) {
        this.botonAdd = botonAdd;
    }

    public JButton getBotonCargar() {
        return botonCargar;
    }

    public void setBotonCargar(JButton botonCargar) {
        this.botonCargar = botonCargar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(JButton botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public void setBotonActualizar(JButton botonActualizar) {
        this.botonActualizar = botonActualizar;
    }

    public JLabel getImagenSistemaSolar() {
        return imagenSistemaSolar;
    }

    public void setImagenSistemaSolar(JLabel imagenSistemaSolar) {
        this.imagenSistemaSolar = imagenSistemaSolar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblActualizar() {
        return lblActualizar;
    }

    public void setLblActualizar(JLabel lblActualizar) {
        this.lblActualizar = lblActualizar;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtActualizar(JTextField txtActualizar) {
        this.txtActualizar = txtActualizar;
    }
    public void limpiar(){
        txtPlaneta.setText("");
        txtLuna.setText("");
        txtColores.setText("");
        txtDiasOrbitales.setText("");
        txtURLimagen.setText("");
    }

    public VentanaSistemaSolar(String title) throws HeadlessException {
        super(title);
        this.setSize(950,900);
        layout = new GridLayout(2,2 );
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(93, 139, 158));
        lblID = new JLabel("ID:");
        lblPlaneta = new JLabel("Planeta:");
        lblLuna = new JLabel("Luna:");
        lblColores = new JLabel("Colores:");
        lblDiasOrbitales = new JLabel("Dias Orbitales:");
        lblURLimagen = new JLabel("URLimagen:");
        txtID = new JTextField(3);
        txtID.setText("0");
        txtID.setEnabled(false);
        txtPlaneta = new JTextField(15);
        txtLuna = new JTextField(8);
        txtColores = new JTextField(15);
        txtDiasOrbitales = new JTextField(5);
        txtURLimagen = new JTextField(30);
        panel1.add(lblID);
        panel1.add(txtID);
        panel1.add(lblPlaneta);
        panel1.add(txtPlaneta);
        panel1.add(lblLuna);
        panel1.add(txtLuna);
        panel1.add(lblColores);
        panel1.add(txtColores);
        panel1.add(lblDiasOrbitales);
        panel1.add(txtDiasOrbitales);
        panel1.add(lblURLimagen);
        panel1.add(txtURLimagen);
        botonAdd = new JButton("Agregar");
        panel1.add(botonAdd);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(93, 98, 158));
        botonCargar = new JButton("Cargar datos");
        panel2.add(botonCargar);
        tabla = new JTable();
        scroll = new JScrollPane(tabla);
        panel2.add(scroll);


        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(155, 93, 158));
        panel3.setLayout(new FlowLayout());
        imagenSistemaSolar = new JLabel("Imagen del Sistema Solar");
        panel3.add(imagenSistemaSolar);


        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(158, 120, 93));
        panel4.setLayout(new FlowLayout());
        botonEliminar = new JButton("DELETE");
        panel4.add(botonEliminar);
        botonActualizar = new JButton("UPDATE");
        panel4.add(botonActualizar);



        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);



    }
}