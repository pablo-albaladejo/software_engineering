/*
 * GUIAltaCliente.java
 *
 * Created on 1 de abril de 2008, 15:56
 */

package concesionario.presentacion.clientes;

import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import javax.swing.*;



import concesionario.logica.transferencia.clientes.InterfazTransferClienteEmpresa;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteNormal;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;

public class GUIAltaCliente extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	private int tipoAlta;
	private Object dato;
	
    public GUIAltaCliente() {
        initComponents();
    }
    
    public void actualiza(int evento, Object datos) {
    	switch (evento) {
            case EventoGUI.GUI_ALTA_CLIENTE :
            	this.setSize(530,350);
            	this.setTitle("Formulario de alta cliente");
            	this.jPanelAltaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta cliente"));
                this.jPanelAltaClienteEmpresa.setVisible(false);
                this.jPanelAltaCliente.setVisible(true);
                this.jPanelAltaCliente.setPreferredSize(new java.awt.Dimension(500, 250));
                jLabelId.setVisible(false);
                jTextId.setVisible(false);
                this.jLabelFechaNacimiento.setVisible(true);
                this.jTextFechaNacimiento.setVisible(true);
                this.setVisible(true);
                break;
            case EventoGUI.GUI_ALTA_CLIENTE_EMPRESA : 
            	this.setSize(530,350);
            	this.setTitle("Formulario de alta cliente empresa");
                this.jPanelAltaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta cliente empresa"));
            	this.jPanelAltaCliente.setVisible(false);
                this.jPanelAltaClienteEmpresa.setVisible(true);
                jPanelAltaClienteEmpresa.setPreferredSize(new java.awt.Dimension(500, 250));
                jLabelId.setVisible(false);
                jTextId.setVisible(false);
                this.jLabelFechaNacimiento.setVisible(true);
                this.jTextFechaNacimiento.setVisible(true);
                this.setVisible(true);
                break;
            case EventoGUI.GUI_MODIFICA_CLIENTE :
            	if ( datos instanceof InterfazTransferClienteNormal ) {
            		this.setSize(530,330);
            		this.setTitle("Formulario de modificación de cliente");
	            	jLabelId.setVisible(true);
	                jTextId.setVisible(true);
	                jTextId.setText(((Integer)(((InterfazTransferClienteNormal)datos).getIdentificador())).toString());
	            	this.jTextDNI.setEnabled(false);
	            	this.jTextNombre.setText(((InterfazTransferClienteNormal)datos).getNombre());
	            	this.jTextApellidos.setText(((InterfazTransferClienteNormal)datos).getApellidos());
	            	this.jTextDNI.setText(((Integer)(((InterfazTransferClienteNormal)datos).getDNI())).toString());
	            	this.jTextTelefono.setText(((Integer)(((InterfazTransferClienteNormal)datos).getTelefono())).toString());
	            	this.jTextDireccion.setText(((InterfazTransferClienteNormal)datos).getDireccion());
	            	this.jTextEmail.setText(((InterfazTransferClienteNormal)datos).getEmail());
	                this.jPanelAltaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifica cliente"));
	            	this.jPanelAltaClienteEmpresa.setVisible(false);
	                this.jPanelAltaCliente.setVisible(true);
	                this.jLabelFechaNacimiento.setVisible(false);
	                this.jTextFechaNacimiento.setVisible(false);
	                this.jPanelAltaCliente.setPreferredSize(new java.awt.Dimension(500, 210));
	                this.setVisible(true);
            	} else {
            		this.setSize(530,330);
            		this.setTitle("Formulario de modificacion de cliente empresa");
	        		System.out.println(((InterfazTransferClienteEmpresa)datos).getNombre());
            		jLabelId.setVisible(true);
	                jTextId.setVisible(true);
	                jTextId.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getIdentificador())).toString());
	        		this.jTextCIFEmp.setEnabled(false);
	            	this.jTextNombreEmp.setText(((InterfazTransferClienteEmpresa)datos).getNombre());
	            	this.jTextCIFEmp.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getCIF())).toString());
	            	this.jTextTelefonoEmp.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getTelefono())).toString());
	            	this.jTextDireccionEmp.setText(((InterfazTransferClienteEmpresa)datos).getDireccion());
	            	this.jTextEmailEmp.setText(((InterfazTransferClienteEmpresa)datos).getEmail());
	            	this.jTextDescuento.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getDescuento())).toString());
	            	this.jPanelAltaClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifica cliente empresa"));
	            	this.jPanelAltaCliente.setVisible(false);
	            	this.jPanelAltaClienteEmpresa.setVisible(true);
	                this.jLabelFechaNacimiento.setVisible(false);
	                this.jTextFechaNacimiento.setVisible(false);
	                this.jPanelAltaClienteEmpresa.setPreferredSize(new java.awt.Dimension(500, 210));
	                this.setVisible(true);
            	}
        		break;
            case EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE :
            	if ( datos instanceof InterfazTransferClienteNormal ) {
            		this.setSize(530,330);
            		this.setTitle("Formulario de detalles de cliente");
	            	jLabelId.setVisible(true);
	                jTextId.setVisible(true);
	                jTextId.setText(((Integer)(((InterfazTransferClienteNormal)datos).getIdentificador())).toString());
	            	this.jTextDNI.setEditable(false);
	            	this.jTextNombre.setEditable(false);
	            	this.jTextApellidos.setEditable(false);
	            	this.jTextTelefono.setEditable(false);
	            	this.jTextDireccion.setEditable(false);
	            	this.jTextEmail.setEditable(false);
	            	this.jTextNombre.setText(((InterfazTransferClienteNormal)datos).getNombre());
	            	this.jTextApellidos.setText(((InterfazTransferClienteNormal)datos).getApellidos());
	            	this.jTextDNI.setText(((Integer)(((InterfazTransferClienteNormal)datos).getDNI())).toString());
	            	this.jTextTelefono.setText(((Integer)(((InterfazTransferClienteNormal)datos).getTelefono())).toString());
	            	this.jTextDireccion.setText(((InterfazTransferClienteNormal)datos).getDireccion());
	            	this.jTextEmail.setText(((InterfazTransferClienteNormal)datos).getEmail());
	                this.jPanelAltaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles cliente"));
	            	this.jPanelAltaClienteEmpresa.setVisible(false);
	                this.jPanelAltaCliente.setVisible(true);
	                this.jLabelFechaNacimiento.setVisible(false);
	                this.jTextFechaNacimiento.setVisible(false);
	                this.jPanelAltaCliente.setPreferredSize(new java.awt.Dimension(500, 210));
	                this.setVisible(true);
            	} else {
	        		this.setSize(530,330);
	        		this.setTitle("Formulario de detalles de cliente empresa");
	        		jLabelId.setVisible(true);
	                jTextId.setVisible(true);
	                jTextId.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getIdentificador())).toString());
	        		this.jTextCIFEmp.setEditable(false);
	        		this.jTextNombreEmp.setEditable(false);
	        		this.jTextTelefonoEmp.setEditable(false);
	        		this.jTextDireccionEmp.setEditable(false);
	        		this.jTextEmailEmp.setEditable(false);
	        		this.jTextDescuento.setEditable(false);
	            	this.jTextNombreEmp.setText(((InterfazTransferClienteEmpresa)datos).getNombre());
	            	this.jTextCIFEmp.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getCIF())).toString());
	            	this.jTextTelefonoEmp.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getTelefono())).toString());
	            	this.jTextDireccionEmp.setText(((InterfazTransferClienteEmpresa)datos).getDireccion());
	            	this.jTextEmailEmp.setText(((InterfazTransferClienteEmpresa)datos).getEmail());
	            	this.jTextDescuento.setText(((Integer)(((InterfazTransferClienteEmpresa)datos).getDescuento())).toString());
	            	this.jPanelAltaClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles cliente empresa"));
	            	this.jPanelAltaCliente.setVisible(false);
	                this.jPanelAltaClienteEmpresa.setVisible(true);
	                this.jLabelFechaNacimiento.setVisible(false);
	                this.jTextFechaNacimiento.setVisible(false);
	                this.jPanelAltaClienteEmpresa.setPreferredSize(new java.awt.Dimension(500, 210));
	                this.setVisible(true);
            	}
        		break;
            default :
            	this.setVisible(false);
        }
        tipoAlta = evento;
        dato = datos;
    }
   
    private void initComponents() {
        jPanelAltaClienteEmpresa = new javax.swing.JPanel();
        jLabelNombreEmp = new javax.swing.JLabel();
        jLabelDireccionEmp = new javax.swing.JLabel();
        jLabelCIFEmp = new javax.swing.JLabel();
        jLabelTelefonoEmp = new javax.swing.JLabel();
        jLabelEmailEmp = new javax.swing.JLabel();
        jTextNombreEmp = new javax.swing.JTextField();
        jTextCIFEmp = new javax.swing.JTextField();
        jTextDireccionEmp = new javax.swing.JTextField();
        jTextTelefonoEmp = new javax.swing.JTextField();
        jTextEmailEmp = new javax.swing.JTextField();
        jTextFechaNacimiento = new javax.swing.JTextField();
        jLabelDescuento = new javax.swing.JLabel();
        jTextDescuento = new javax.swing.JTextField();
        jPanelAltaCliente = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();;
        jTextNombre = new javax.swing.JTextField();
        jTextApellidos = new javax.swing.JTextField();
        jTextDNI = new javax.swing.JTextField();
        jTextDireccion = new javax.swing.JTextField();
        jTextTelefono = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jPanelBotones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jTextId = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();

        setTitle("Formulario de alta clientes");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("Alta cliente");
        setResizable(false);
        jPanelAltaClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta cliente empresa"));
        jPanelAltaClienteEmpresa.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelAltaClienteEmpresa.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelAltaClienteEmpresa.setPreferredSize(new java.awt.Dimension(500, 240));
        jLabelNombreEmp.setText("Nombre");

        jLabelId.setVisible(false);
        jTextId.setVisible(false);
        jTextId.setEditable(false);
        
        jLabelDireccionEmp.setText("Direccion");

        jLabelCIFEmp.setText("CIF");

        jLabelTelefonoEmp.setText("Telefono");

        jLabelEmailEmp.setText("Email");

        jTextCIFEmp.setPreferredSize(new java.awt.Dimension(59, 20));
        jTextCIFEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCIFEmpActionPerformed(evt);
            }
        });

        jTextTelefonoEmp.setPreferredSize(new java.awt.Dimension(59, 20));

        jLabelDescuento.setText("Descuento (%)");

        javax.swing.GroupLayout jPanelAltaClienteEmpresaLayout = new javax.swing.GroupLayout(jPanelAltaClienteEmpresa);
        jPanelAltaClienteEmpresa.setLayout(jPanelAltaClienteEmpresaLayout);
        jPanelAltaClienteEmpresaLayout.setHorizontalGroup(
            jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreEmp)
                            .addComponent(jLabelCIFEmp))
                        .addGap(22, 22, 22)
                        .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCIFEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombreEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                    .addGroup(jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDireccionEmp)
                            .addComponent(jLabelTelefonoEmp))
                        .addGap(16, 16, 16)
                        .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextTelefonoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDireccionEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabelEmailEmp)
                        .addGap(35, 35, 35)
                        .addComponent(jTextEmailEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                    .addGroup(jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabelDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelAltaClienteEmpresaLayout.setVerticalGroup(
            jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaClienteEmpresaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreEmp)
                    .addComponent(jTextNombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCIFEmp)
                    .addComponent(jTextCIFEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDireccionEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccionEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefonoEmp)
                    .addComponent(jTextTelefonoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmailEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmailEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanelAltaClienteEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescuento)
                    .addComponent(jTextDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelAltaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta cliente"));
        jPanelAltaCliente.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabelNombre.setText("Nombre");

        jLabelApellidos.setText("Apellidos");

        jLabelDireccion.setText("Direccion");

        jLabelDNI.setText("DNI");

        jLabelTelefono.setText("Telefono");

        jLabelEmail.setText("Email");

        jTextDNI.setPreferredSize(new java.awt.Dimension(59, 20));
        jTextDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDNIActionPerformed(evt);
            }
        });

        jTextTelefono.setPreferredSize(new java.awt.Dimension(59, 20));
        
        jLabelFechaNacimiento.setText("Fecha de Nacimiento");
        jTextFechaNacimiento.setText("");
        javax.swing.GroupLayout jPanelAltaClienteLayout = new javax.swing.GroupLayout(jPanelAltaCliente);
        jPanelAltaCliente.setLayout(jPanelAltaClienteLayout);
        jPanelAltaClienteLayout.setHorizontalGroup(
            jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelDNI)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelFechaNacimiento))
                .addGap(16, 16, 16)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jTextFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelAltaClienteLayout.setVerticalGroup(
            jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaClienteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI)
                    .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jTextFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdActionPerformed(evt);
            }
        });

        jLabelId.setText("Identificador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelAltaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelAltaClienteEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelId)
                        .addGap(14, 14, 14)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAltaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAltaClienteEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }

    private void jTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdActionPerformed

    }
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
    	//Comprobacion de campos vacios
    	switch (tipoAlta) {
    	case EventoGUI.GUI_ALTA_CLIENTE :
	    	if( this.jTextApellidos.getText().equals("") || this.jTextDNI.getText().equals("") || 
	    		this.jTextDireccion.getText().equals("") || this.jTextDireccion.getText().equals("") ||
	    		this.jTextEmail.getText().equals("") || this.jTextNombre.getText().equals("") ||
	    		this.jTextTelefono.getText().equals("") || this.jTextFechaNacimiento.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
	    	}else if(!validaFecha(this.jTextFechaNacimiento.getText())){
	    		JOptionPane.showMessageDialog(null, "La fecha es incorecta o no eres mayor de edad");
	    	}else{
	    		try {
	    			Integer.valueOf(this.jTextDNI.getText());
	    			Integer.valueOf(this.jTextTelefono.getText());
	    		} catch (Exception e) {
	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe los campos telefono y DNI.");
	    			break;
	    		}
	    		InterfazTransferClienteNormal cliente = (InterfazTransferClienteNormal)FactoriaTransfers.getInstancia().dameTClienteNormal();
	    		cliente.setApellidos(this.jTextApellidos.getText());
	    		cliente.setNombre(this.jTextNombre.getText());
	    		cliente.setDireccion(this.jTextDireccion.getText());
	    		cliente.setDNI(Integer.valueOf(this.jTextDNI.getText()).intValue());
	    		cliente.setEmail(this.jTextEmail.getText());
	    		cliente.setTelefono(Integer.valueOf(this.jTextTelefono.getText()).intValue());
	    		Controlador.getInstancia().accion(EventoNegocio.ALTA_CLIENTE, cliente);
	    		this.setVisible(false);
	    	}
	    	break;
    	case EventoGUI.GUI_ALTA_CLIENTE_EMPRESA :
    		if( this.jTextCIFEmp.getText().equals("") || 
    				this.jTextNombreEmp.getText().equals("") || this.jTextDireccionEmp.getText().equals("") ||
    	    		this.jTextEmailEmp.getText().equals("") || this.jTextTelefonoEmp.getText().equals("") ) {
    	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
    	    	}else{
    	    		try {
    	    			Integer.valueOf(this.jTextCIFEmp.getText());
    	    			Integer.valueOf(this.jTextTelefonoEmp.getText());
    	    		} catch (Exception e) {
    	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe los campos telefono y CIF.");
    	    			break;
    	    		}
    	    		InterfazTransferClienteEmpresa cliente = (InterfazTransferClienteEmpresa)FactoriaTransfers.getInstancia().dameTClienteEmpresa();
    	    		cliente.setNombre(this.jTextNombreEmp.getText());
    	    		cliente.setDireccion(this.jTextDireccionEmp.getText());
    	    		cliente.setCIF(Integer.valueOf(this.jTextCIFEmp.getText()).intValue());
    	    		cliente.setEmail(this.jTextEmailEmp.getText());
    	    		cliente.setTelefono(Integer.valueOf(this.jTextTelefonoEmp.getText()).intValue());
    	    		cliente.setDescuento(Integer.valueOf(this.jTextDescuento.getText()).intValue());
    	    		Controlador.getInstancia().accion(EventoNegocio.ALTA_CLIENTE, cliente);
    	    		this.setVisible(false);
    	    	}
    		break;
    	case EventoGUI.GUI_MODIFICA_CLIENTE :
    		if ( dato instanceof InterfazTransferClienteNormal ) {
	    		if( this.jTextApellidos.getText().equals("") || this.jTextDNI.getText().equals("") || 
	    	    		this.jTextDireccion.getText().equals("") || this.jTextDireccion.getText().equals("") ||
	    	    		this.jTextEmail.getText().equals("") || this.jTextNombre.getText().equals("") ||
	    	    		this.jTextTelefono.getText().equals("") ) {
    	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
    	    	}else{
    	    		try {
    	    			Integer.valueOf(this.jTextTelefono.getText());
    	    		} catch (Exception e) {
    	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe el campo telefono.");
    	    			break;
    	    		}
    	    		InterfazTransferClienteNormal cliente = (InterfazTransferClienteNormal)FactoriaTransfers.getInstancia().dameTClienteNormal();
    	    		cliente.setApellidos(this.jTextApellidos.getText());
    	    		cliente.setNombre(this.jTextNombre.getText());
    	    		cliente.setDireccion(this.jTextDireccion.getText());
    	    		cliente.setDNI(Integer.valueOf(this.jTextDNI.getText()).intValue());
    	    		cliente.setEmail(this.jTextEmail.getText());
    	    		cliente.setTelefono(Integer.valueOf(this.jTextTelefono.getText()).intValue());
    	    		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_CLIENTE, cliente);
    	    		this.setVisible(false);
    	    	}
    		} else {
	    		if( this.jTextCIFEmp.getText().equals("") || 
	    				this.jTextNombreEmp.getText().equals("") || this.jTextDireccionEmp.getText().equals("") ||
	    	    		this.jTextEmailEmp.getText().equals("") || this.jTextTelefonoEmp.getText().equals("") ) {
    	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
    	    	}else{
    	    		try {
    	    			Integer.valueOf(this.jTextCIFEmp.getText());
    	    			Integer.valueOf(this.jTextTelefonoEmp.getText());
    	    		} catch (Exception e) {
    	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe el campo telefono.");
    	    			break;
    	    		}
    	    		InterfazTransferClienteEmpresa cliente = (InterfazTransferClienteEmpresa)FactoriaTransfers.getInstancia().dameTClienteEmpresa();
    	    		cliente.setNombre(this.jTextNombreEmp.getText());
    	    		cliente.setDireccion(this.jTextDireccionEmp.getText());
    	    		cliente.setCIF(Integer.valueOf(this.jTextCIFEmp.getText()).intValue());
    	    		cliente.setEmail(this.jTextEmailEmp.getText());
    	    		cliente.setTelefono(Integer.valueOf(this.jTextTelefonoEmp.getText()).intValue());
    	    		cliente.setDescuento(Integer.valueOf(this.jTextDescuento.getText()).intValue());
    	    		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_CLIENTE, cliente);
    	    		this.setVisible(false);
    	    	}
    		}
    		break;
    		default : 
    			this.setVisible(false);
    			break;
    	}
    }

    private void jTextCIFEmpActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jTextDNIActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCIFEmp;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDescuento;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDireccionEmp;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmailEmp;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreEmp;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTelefonoEmp;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JPanel jPanelAltaCliente;
    private javax.swing.JPanel jPanelAltaClienteEmpresa;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JTextField jTextApellidos;
    private javax.swing.JTextField jTextCIFEmp;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextDescuento;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextDireccionEmp;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextEmailEmp;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextNombreEmp;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JTextField jTextTelefonoEmp;
    private javax.swing.JTextField jTextFechaNacimiento;
    
    
    private boolean validaFecha(String strDate){
    	//568080000000 -- constante de tiempo de 18 anyos
    	long tiempo = 56808; tiempo *= 10000000; 
    	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
    	ParsePosition pos = new ParsePosition(0);
    	formato.setLenient(false);
    	Date date = formato.parse(strDate, pos);
    	
    	if(date == null  || pos.getErrorIndex() != -1) return false; //error en el formato 	
    	if(date.getTime() < 0) return false; //fecha en el futuro
    	
    	//tiempo de hoy
    	Date hoy = new Date();
    	long tiempoPresente = hoy.getTime();	
    	
    	//tiempo de la fecha en el pasado
    	long tiempoPasado = date.getTime();
    
     	long restaTiempo = tiempoPresente - tiempoPasado;
    	
    	return (restaTiempo >= tiempo);  //distancia entre las fechas    	
    }
    
    
}
