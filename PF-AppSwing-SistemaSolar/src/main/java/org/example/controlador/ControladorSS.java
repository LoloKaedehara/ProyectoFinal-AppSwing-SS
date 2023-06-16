package org.example.controlador;
import org.example.modelo.ModeloTabla;
import org.example.modelo.SistemaSolar;
import org.example.ventana.VentanaSistemaSolar;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.SQLException;
public class ControladorSS extends MouseAdapter{
    private VentanaSistemaSolar view;
    private ModeloTabla modelo;

    private int filaSeleccionada;
    private int columnaSeleccionada;

    public ControladorSS(VentanaSistemaSolar view) {
        this.view = view;
        this.view.getBotonAdd().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        this.view.getBotonCargar().addMouseListener(this);
        this.view.getBotonActualizar().addMouseListener(this);
        this.view.getBotonEliminar().addMouseListener(this);
        modelo = new ModeloTabla();
        this.view.getTabla().setModel((TableModel) modelo);




    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBotonCargar()){
            modelo = new ModeloTabla();
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        if(e.getSource() == view.getBotonAdd()){
            SistemaSolar sistemasolar = new SistemaSolar();
            sistemasolar.setID(0);
            sistemasolar.setPlaneta(this.view.getTxtPlaneta().getText());
            sistemasolar.setLuna(this.view.getTxtLuna().getText());
            sistemasolar.setColores(this.view.getTxtColores().getText());
            sistemasolar.setDiasOrbitales(Integer.parseInt(this.view.getTxtDiasOrbitales().getText()));
            sistemasolar.setURLimagen(this.view.getTxtURLimagen().getText());
            if (modelo.agregarSistemaSolar(sistemasolar)){
                JOptionPane.showMessageDialog(view, "Se agrego correctamente" , "Aviso" , JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Por favor" +
                        " revise su conexion", "Error al insertar",JOptionPane.ERROR_MESSAGE);
            }

            this.view.getTabla().updateUI();
        }
        if(e.getSource() == this.view.getBotonEliminar()){
            int index = this.view.getTabla().getSelectedRow();
            int ID = modelo.getSistemaSolarAtIndex(index).getID();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Desea eliminar la fila seleccionada?", "Cuidado", JOptionPane.YES_NO_OPTION);
            if(respuesta == 0){
                if(modelo.eliminarSistemaSolar(String.valueOf(ID))){
                    JOptionPane.showMessageDialog(view, "Se elimino");
                    modelo.cargarDatos();
                    this.view.getTabla().setModel((TableModel) modelo);
                    this.view.getTabla().updateUI();
                }
            }
            System.out.println("Eliminar...");
        }
        if(e.getSource() == this.view.getBotonActualizar()){
            int index = this.view.getTabla().getSelectedRow();
            SistemaSolar tmp = modelo.getSistemaSolarAtIndex(index);
            int ID = tmp.getID();
            String datoActualizado = JOptionPane.showInputDialog(view, "Introduce el dato a actualizar " + this.view.getTabla().getColumnName(view.getTabla().getSelectedColumn())+ " del registro "+ ID, " UPDATE ", JOptionPane.INFORMATION_MESSAGE);
            int colIndex = this.view.getTabla().getSelectedColumn();

            try{
                if(modelo.actualizarElemento(datoActualizado, ID, colIndex)){
                    System.out.println("Se actualizo");
                    modelo.cargarDatos();
                    this.view.getTabla().setModel(modelo);
                    this.view.getTabla().updateUI();
                }else{
                    System.out.println("Fallo actualizar el dato");
                }
            }catch (SQLException sqle){
                throw new RuntimeException(sqle);
            }

        }


        if(e.getSource() == view.getTabla()){
            System.out.println("Elemento seleccionado");
            int index = this.view.getTabla().getSelectedRow();
            SistemaSolar tmp = modelo.getSistemaSolarAtIndex(index);

            try{
                this.view.getImagenSistemaSolar().setIcon(tmp.getImagen());
                this.view.getImagenSistemaSolar().setText("");
            }catch (MalformedURLException mfue){
                System.out.println(e);

            }

        }

    }
}
