/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Servicio;
import Modelo.Servicio;
import Vista.Vista_Perfil;
import java.awt.Image;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author Usuario
 */
public class Control_Perfil {

    Vista_Perfil vp;
    public boolean mostrar = true;

    public Control_Perfil(Vista_Perfil vista) {
        this.vp = vista;
        this.vp.setLocationRelativeTo(null);
        this.vp.setVisible(true);
        vp.getPassoculto().setVisible(true);
        vp.getTxtcontra1().setVisible(false);
        vp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void iniciarBotones() {
        vp.getBtnEditarPerfil().addActionListener(l -> Editables());
        vp.getBtnExaminar().addActionListener(l -> CargarImagen());
        vp.getBtnpVerContra().addActionListener(l -> Botonver());
        vp.getBtnpGuardar().addActionListener(l->Registrar());
    }

    public void perfil(String usuario) {
        System.out.println("Usuario " + usuario);
        Modelo_Empleado me = new Modelo_Empleado();
        vp.getBtnEditarPerfil().setVisible(true);
        vp.getBtnExaminar().setVisible(false);
        vp.getBtnpGuardar().setVisible(false);
        vp.getPtxtNombre().setEnabled(false);
        vp.getPtxtApellido().setEnabled(false);
        vp.getPtxtTelf().setEnabled(false);
        vp.getPtxtDireccion().setEnabled(false);
        vp.getDatachoser().setEnabled(false);
        vp.getTxtUsuario().setEditable(false);
        List<Empleado> lista = me.BuscarporID(usuario);
        System.out.println(lista);
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            vp.getPlblidempelado().setText(e.getCod_empleado());
            vp.getTxtUsuario().setText(e.getCedula());
            vp.getPtxtNombre().setText(e.getNombre());
            vp.getPtxtApellido().setText(e.getApellido());
            vp.getPtxtTelf().setText(e.getTelefono());
            vp.getPtxtDireccion().setText(e.getDireccion());
            vp.getDatachoser().setDate(e.getFnacimiento());
            vp.getPassoculto().setText(e.getPassword());
            vp.getPassoculto2().setText(e.getPassword());
            vp.getTxtpalabra().setText(e.getPalabra());
            Image img = e.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(165, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vp.getPlblfoto().setIcon(icon);
            } else {
                vp.getPlblfoto().setIcon(null);
            }
        }

    }

    public void mostarServicio(String usuario) {
        Modelo_Servicio ms = new Modelo_Servicio();
        List<Servicio> lista1 = ms.BuscarServicoEmp(usuario);
        System.out.println(usuario);
        System.out.println(lista1);
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vp.getTblVentas().getModel();
        tblModel.setNumRows(0);//vaciar la tabla
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista1.stream().forEach(p -> {
            tblModel.addRow(new Object[ncols]);
            vp.getTblVentas().setValueAt(p.getCodservicio(), i.value, 0);
            vp.getTblVentas().setValueAt(p.getFechaServicio(), i.value, 1);
            vp.getTblVentas().setValueAt(p.getCodcliente(), i.value, 2);
            vp.getTblVentas().setValueAt(p.getCodciudad(), i.value, 3);
            vp.getTblVentas().setValueAt(p.getCodempleado(), i.value, 4);
            vp.getTblVentas().setValueAt(p.getCodvehiculo(), i.value, 5);
            vp.getTblVentas().setValueAt(p.getPrecioServicio(), i.value, 6);
            i.value++;
        });
    }

    public void Editables() {
        vp.getPtxtNombre().setEnabled(true);
        vp.getPtxtApellido().setEnabled(true);
        vp.getPtxtTelf().setEnabled(true);
        vp.getPtxtDireccion().setEnabled(true);
        vp.getDatachoser().setEnabled(true);
        vp.getBtnEditarPerfil().setVisible(false);
        vp.getBtnExaminar().setVisible(true);
        vp.getBtnpGuardar().setVisible(true);
    }

    public void CargarImagen() {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vp.getPlblfoto().getWidth(),
                        vp.getPlblfoto().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                vp.getPlblfoto().setIcon(ic);
                vp.getPlblfoto().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(Control_Empleado.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void Registrar() {
        String cod = vp.getPlblidempelado().getText();
        String nom = vp.getPtxtNombre().getText();
        String ced = vp.getTxtUsuario().getText();
        String palabra = vp.getTxtpalabra().getText();
        String apel = vp.getPtxtApellido().getText();
        String tel = vp.getPtxtTelf().getText();
        String dir = vp.getPtxtDireccion().getText();
        Instant intate = vp.getDatachoser().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnam = Date.valueOf(zot.toLocalDate());
        String contra1 = String.valueOf(vp.getPassoculto().getPassword());
        String contra2 = String.valueOf(vp.getPassoculto2().getPassword());
        String contraver = vp.getTxtcontra1().getText();

        if (contra1.equals(contra2) || contraver.equals(contra2)) {
            Modelo_Empleado mr = new Modelo_Empleado(cod, 0.0, "Servicio Cliente", contra1, palabra, ced, nom, apel, fnam, dir, tel);
            if (vp.getPlblfoto().equals(' ')) {

            } else {
                ImageIcon ic = (ImageIcon) vp.getPlblfoto().getIcon();
                mr.setFoto(ic.getImage());
            }

            if (mr.Editar_Empleado()) {
                JOptionPane.showMessageDialog(vp, "Registro Editado");
                perfil(ced);
            } else {
                JOptionPane.showMessageDialog(vp, "Error al Registrar");
            }

        } else {
            JOptionPane.showMessageDialog(vp, "Las contraseñas no coinciden");
        }
    }

    public void Botonver() {
        if (mostrar) {
            vp.getPassoculto().setVisible(false);
            vp.getTxtcontra1().setVisible(true);
            mostrar = false;
            vp.getTxtcontra1().setText(String.valueOf(vp.getPassoculto().getPassword()));
            vp.getBtnpVerContra().setText("Ocultar");
        } else {
            vp.getPassoculto().setVisible(true);
            vp.getTxtcontra1().setVisible(false);
            vp.getPassoculto().setText(vp.getTxtcontra1().getText());
            vp.getBtnpVerContra().setText("Ver");
            mostrar = true;
        }
    }
}
