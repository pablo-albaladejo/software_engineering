
package concesionario.presentacion.proveedores;

import java.util.ArrayList;

import javax.swing.*;

import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;

public class GUIAltaProveedor extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	
	private int tipoAlta;
	
    public GUIAltaProveedor() {
        initComponents();
    }
    
    public void actualiza(int evento, Object datos) {
    	switch (evento) {
            case EventoGUI.GUI_ALTA_PROVEEDOR :
                this.setSize(530,300);
                this.setTitle("Formulario de alta de proveedor");
                this.jPanelAltaProveedor.setVisible(true);
                this.jPanelAltaProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta proveedor"));
                this.jPanelTabla.setVisible(false);
                this.setVisible(true);
                break;
            case EventoGUI.GUI_MODIFICA_PROVEEDOR :
        		this.setSize(530,300);
        		this.setTitle("Formulario de modificación de proveedor");        		
        		this.jTextCIF.setEnabled(false);
            	this.jTextNombre.setText(((InterfazTransferProveedores)datos).getNombre());
            	this.jTextCIF.setText(((Integer)(((InterfazTransferProveedores)datos).getCIF())).toString());
            	this.jTextTelefono.setText(((Integer)(((InterfazTransferProveedores)datos).getTelefono())).toString());
            	this.jTextDireccion.setText(((InterfazTransferProveedores)datos).getDireccion());
            	this.jTextEmail.setText(((InterfazTransferProveedores)datos).getEmail());
                this.jPanelAltaProveedor.setVisible(true);
                this.jPanelAltaProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifica proveedor"));
                this.setVisible(true);
                this.jPanelTabla.setVisible(false);
        		break;
            case EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR :
        		this.setSize(530,350);
        		this.setTitle("Formulario de detalles de proveedor");
        		this.jTextCIF.setEditable(false);
        		this.jTextNombre.setEditable(false);
        		this.jTextTelefono.setEditable(false);
        		this.jTextDireccion.setEditable(false);
        		this.jTextEmail.setEditable(false);
            	this.jTextNombre.setText(((InterfazTransferProveedores)datos).getNombre());
            	this.jTextCIF.setText(((Integer)(((InterfazTransferProveedores)datos).getCIF())).toString());
            	this.jTextTelefono.setText(((Integer)(((InterfazTransferProveedores)datos).getTelefono())).toString());
            	this.jTextDireccion.setText(((InterfazTransferProveedores)datos).getDireccion());
            	this.jTextEmail.setText(((InterfazTransferProveedores)datos).getEmail());
                this.jPanelAltaProveedor.setVisible(true);
                this.jPanelAltaProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles proveedor"));
                this.jTableListaProductos.setEnabled(false);
                
                ArrayList<InterfazTransferProductos> listaProductos = ((InterfazTransferProveedores)datos).getListaProductos();                
                this.jTableListaProductos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [listaProductos.size()][1],
                            new String [] {
                                "IdProducto", "Precio","Marca","Modelo"}
                        ));
                for(int i = 0;i<listaProductos.size();i++){
                	
                	InterfazTransferProductos producto = listaProductos.get(i);
                	jTableListaProductos.setValueAt(producto.getIdentificador(), i, 0);
                	jTableListaProductos.setValueAt(producto.getPrecio(), i, 1);
                	jTableListaProductos.setValueAt(producto.getMarca(), i, 2);
                	jTableListaProductos.setValueAt(producto.getModelo(), i, 3);
                }
                this.setVisible(true);
        		break;
            default :
            	this.setVisible(false);
        }
        tipoAlta = evento;
    }

    private void initComponents() {
        jPanelAltaProveedor = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCIF = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jTextCIF = new javax.swing.JTextField();
        jTextDireccion = new javax.swing.JTextField();
        jTextTelefono = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jPanelAltaProveedor = new javax.swing.JPanel();
        jPanelBotones = new javax.swing.JPanel();
        jPanelTabla   = new javax.swing.JScrollPane();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jTableListaProductos = new javax.swing.JTable();
        

        setTitle("Formulario de alta Proveedores");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("Alta Proveedor");
        setResizable(false);
        jPanelAltaProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta Proveedor"));
        jPanelAltaProveedor.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelAltaProveedor.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelAltaProveedor.setPreferredSize(new java.awt.Dimension(500, 200));
        jLabelNombre.setText("Nombre");

        jLabelDireccion.setText("Direccion");

        jLabelCIF.setText("CIF");

        jLabelTelefono.setText("Telefono");

        jLabelEmail.setText("Email");

        jTextCIF.setPreferredSize(new java.awt.Dimension(59, 20));

        jTextTelefono.setPreferredSize(new java.awt.Dimension(59, 20));
        
        jPanelTabla.setViewportView(jTableListaProductos);
        
        javax.swing.GroupLayout jPanelAltaProveedorLayout = new javax.swing.GroupLayout(jPanelAltaProveedor);
        jPanelAltaProveedor.setLayout(jPanelAltaProveedorLayout);
        jPanelAltaProveedorLayout.setHorizontalGroup(
            jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaProveedorLayout.createSequentialGroup()
                        .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelCIF))
                        .addGap(22, 22, 22)
                        .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                    .addGroup(jPanelAltaProveedorLayout.createSequentialGroup()
                        .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDireccion)
                            .addComponent(jLabelTelefono))
                        .addGap(16, 16, 16)
                        .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProveedorLayout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addGap(35, 35, 35)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
//                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProveedorLayout.createSequentialGroup()
//                      .addComponent(jTableListaProductos)))
                .addContainerGap())
        );
        
        jPanelAltaProveedorLayout.setVerticalGroup(
            jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaProveedorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCIF)
                    .addComponent(jTextCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(jPanelAltaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  //                  .addComponent(jTableListaProductos,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelAltaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                     .addComponent(jPanelTabla)
                     .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAltaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanelTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
        );
        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	switch (tipoAlta) {
    	case EventoGUI.GUI_ALTA_PROVEEDOR :
    		if( this.jTextCIF.getText().equals("") || 
				this.jTextNombre.getText().equals("") || this.jTextDireccion.getText().equals("") ||
	    		this.jTextEmail.getText().equals("") || this.jTextTelefono.getText().equals("") ) {
	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
	    	}else{
	    		try {
	    			Integer.valueOf(this.jTextCIF.getText());
	    			Integer.valueOf(this.jTextTelefono.getText());
	    		} catch (Exception e) {
	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe los campos telefono y CIF.");
	    			break;
	    		}
	    		InterfazTransferProveedores Proveedor = (InterfazTransferProveedores)FactoriaTransfers.getInstancia().dameTProveedor();
	    		Proveedor.setNombre(this.jTextNombre.getText());
	    		Proveedor.setDireccion(this.jTextDireccion.getText());
	    		Proveedor.setCIF(Integer.valueOf(this.jTextCIF.getText()).intValue());
	    		Proveedor.setEmail(this.jTextEmail.getText());
	    		Proveedor.setTelefono(Integer.valueOf(this.jTextTelefono.getText()).intValue());
	    		Controlador.getInstancia().accion(EventoNegocio.ALTA_PROVEEDOR, Proveedor);
	    		this.setVisible(false);
	    	}
    		break;
    	case EventoGUI.GUI_MODIFICA_PROVEEDOR :
    		if( this.jTextCIF.getText().equals("") || 
    				this.jTextNombre.getText().equals("") || this.jTextDireccion.getText().equals("") ||
    	    		this.jTextEmail.getText().equals("") || this.jTextTelefono.getText().equals("") ) {
	    		JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos!");
	    	}else{
	    		try {
	    			Integer.valueOf(this.jTextCIF.getText());
	    			Integer.valueOf(this.jTextTelefono.getText());
	    		} catch (Exception e) {
	    			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe el campo telefono.");
	    			break;
	    		}
	    		InterfazTransferProveedores proveedor = (InterfazTransferProveedores)FactoriaTransfers.getInstancia().dameTProveedor();
	    		proveedor.setNombre(this.jTextNombre.getText());
	    		proveedor.setDireccion(this.jTextDireccion.getText());
	    		proveedor.setCIF(Integer.valueOf(this.jTextCIF.getText()).intValue());
	    		proveedor.setEmail(this.jTextEmail.getText());
	    		proveedor.setTelefono(Integer.valueOf(this.jTextTelefono.getText()).intValue());
	    		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_PROVEEDOR, proveedor);
	    		this.setVisible(false);
	    	}
    		break;
    		default : 
    			this.setVisible(false);
    			break;
    	}
    }
    
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelCIF;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelAltaProveedor;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JScrollPane jPanelTabla;
    private javax.swing.JTextField jTextCIF;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JTable jTableListaProductos;
}
