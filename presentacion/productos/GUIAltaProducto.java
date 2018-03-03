package concesionario.presentacion.productos;

import concesionario.logica.transferencia.productos.*;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;
import javax.swing.*;
/**
 *
 * @author  Juan Jose
 */
public class GUIAltaProducto extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	private int tipoAlta;
	private Object dato;
	
    /** Creates new form GUIAltaProducto */
    public GUIAltaProducto() {
        initComponents();
    }
    
    public void actualiza(int evento, Object datos) {
    	jPanelProducto.setVisible(true);
    	jPanelBotones.setVisible(true);
    	switch (evento){
    	case EventoGUI.GUI_ALTA_PRODUCTO_TURISMO : 
    		this.setSize(530, 400);
    		jPanelMoto.setVisible(false);
    		jPanelComercial.setVisible(false);
    		jPanelTurismo.setVisible(true);
    		
    		this.setVisible(true);
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_MOTO :
    		this.setSize(530, 400);
    		jPanelComercial.setVisible(false);
    		jPanelTurismo.setVisible(false);
    		jPanelMoto.setVisible(true);
    		this.setVisible(true);
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL :
    		this.setSize(530, 400);
    		jPanelTurismo.setVisible(false);
    		jPanelMoto.setVisible(false);
    		jPanelComercial.setVisible(true);
    		this.setVisible(true);
    		break;
    	case EventoGUI.GUI_MODIFICA_PRODUCTO :
    		this.setSize(530, 400);
    		jTextFieldMarca.setText(((InterfazTransferProductos)datos).getMarca());
    		jTextFieldModelo.setText(((InterfazTransferProductos)datos).getModelo());
    		jTextFieldAño.setText(Integer.toString(((InterfazTransferProductos)datos).getAño()));
    		jTextFieldPrecio.setText(Float.toString(((InterfazTransferProductos)datos).getPrecio()));
    		jTextFieldCilindrada.setText(((InterfazTransferProductos)datos).getCilindrada());
    		jTextFieldExistencias.setText(Integer.toString(((InterfazTransferProductos)datos).getExistencias()));
    		jTextFieldExistencias.setEnabled(false);
    		jTextFieldMarca.setEnabled(false);
    		jTextFieldModelo.setEnabled(false);
    		if (datos instanceof InterfazTransferTurismos){
    			jPanelTurismo.setVisible(true);
    			jPanelMoto.setVisible(false);
        		jPanelComercial.setVisible(false);
    			jTextFieldPuertas.setText(Integer.toString(((InterfazTransferTurismos)datos).getPuertas()));
    			jTextFieldPlazas.setText(Integer.toString(((InterfazTransferTurismos)datos).getPlazas()));
    			jTextFieldChasis.setText(((InterfazTransferTurismos)datos).getChasis());
    			jTextFieldCambio.setText(((InterfazTransferTurismos)datos).getCambio());
    		}else
    			if (datos instanceof InterfazTransferMotos){
    				jPanelComercial.setVisible(false);
    	    		jPanelTurismo.setVisible(false);
    				jPanelMoto.setVisible(true);
    				jTextFieldTipo.setText(((InterfazTransferMotos)datos).getTipo());
    				jTextFieldArranque.setText(((InterfazTransferMotos)datos).getArranque());
    				jTextFieldEmbrague.setText(((InterfazTransferMotos)datos).getEmbrague());
    			}else{
    				jPanelTurismo.setVisible(false);
    	    		jPanelMoto.setVisible(false);
    				jPanelComercial.setVisible(true);
    				jTextFieldCapacidad.setText(Integer.toString(((InterfazTransferComerciales)datos).getCapcarga()));
    				jTextFieldVolumen.setText(Integer.toString(((InterfazTransferComerciales)datos).getVolutil()));
    				jTextFieldPuertasCom.setText(Integer.toString(((InterfazTransferComerciales)datos).getCapcarga()));
    			}
    		this.setVisible(true);
    		break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO:
    		this.setSize(530, 400);
    		this.setVisible(true);
    		if (datos instanceof InterfazTransferTurismos){
    			InterfazTransferTurismos turismo=(InterfazTransferTurismos)datos;
    			jPanelTurismo.setVisible(true);
    			jPanelMoto.setVisible(false);
    			jPanelComercial.setVisible(false);
    			jTextFieldMarca.setText(turismo.getMarca());
    			jTextFieldMarca.setEnabled(false);
    			jTextFieldModelo.setText(turismo.getModelo());
    			jTextFieldModelo.setEnabled(false);
    			jTextFieldAño.setText(Integer.toString(turismo.getAño()));
    			jTextFieldAño.setEnabled(false);
    			jTextFieldPrecio.setText(Float.toString(turismo.getPrecio()));
    			jTextFieldPrecio.setEnabled(false);
    			jTextFieldCilindrada.setText(turismo.getCilindrada());
    			jTextFieldCilindrada.setEnabled(false);
    			jTextFieldExistencias.setText(Integer.toString(turismo.getExistencias()));
    			jTextFieldExistencias.setEnabled(false);
    			jTextFieldPuertas.setText(Integer.toString(turismo.getPuertas()));
    			jTextFieldPuertas.setEnabled(false);
    			jTextFieldPlazas.setText(Integer.toString(turismo.getPlazas()));
    			jTextFieldPlazas.setEnabled(false);
    			jTextFieldChasis.setText(turismo.getChasis());
    			jTextFieldChasis.setEnabled(false);
    			jTextFieldCambio.setText(turismo.getCambio());
    			jTextFieldCambio.setEnabled(false);
    		}else if(datos instanceof InterfazTransferMotos){
    			InterfazTransferMotos moto=(InterfazTransferMotos)datos;
    			jPanelTurismo.setVisible(false);
    			jPanelMoto.setVisible(true);
    			jPanelComercial.setVisible(false);
    			jTextFieldMarca.setText(moto.getMarca());
    			jTextFieldMarca.setEnabled(false);
    			jTextFieldModelo.setText(moto.getModelo());
    			jTextFieldModelo.setEnabled(false);
    			jTextFieldAño.setText(Integer.toString(moto.getAño()));
    			jTextFieldAño.setEnabled(false);
    			jTextFieldPrecio.setText(Float.toString(moto.getPrecio()));
    			jTextFieldPrecio.setEnabled(false);
    			jTextFieldCilindrada.setText(moto.getCilindrada());
    			jTextFieldCilindrada.setEnabled(false);
    			jTextFieldExistencias.setText(Integer.toString(moto.getExistencias()));
    			jTextFieldExistencias.setEnabled(false);
    			jTextFieldTipo.setText(moto.getTipo());
    			jTextFieldTipo.setEnabled(false);
    			jTextFieldArranque.setText(moto.getArranque());
    			jTextFieldArranque.setEnabled(false);
    			jTextFieldEmbrague.setText(moto.getEmbrague());
    			jTextFieldEmbrague.setEnabled(false);
    		}else if (datos instanceof InterfazTransferComerciales){
    			InterfazTransferComerciales comercial=(InterfazTransferComerciales)datos;
    			jPanelTurismo.setVisible(false);
    			jPanelMoto.setVisible(false);
    			jPanelComercial.setVisible(true);
    			jTextFieldMarca.setText(comercial.getMarca());
    			jTextFieldMarca.setEnabled(false);
    			jTextFieldModelo.setText(comercial.getModelo());
    			jTextFieldModelo.setEnabled(false);
    			jTextFieldAño.setText(Integer.toString(comercial.getAño()));
    			jTextFieldAño.setEnabled(false);
    			jTextFieldPrecio.setText(Float.toString(comercial.getPrecio()));
    			jTextFieldPrecio.setEnabled(false);
    			jTextFieldCilindrada.setText(comercial.getCilindrada());
    			jTextFieldCilindrada.setEnabled(false);
    			jTextFieldExistencias.setText(Integer.toString(comercial.getExistencias()));
    			jTextFieldExistencias.setEnabled(false);
    			jTextFieldCapacidad.setText(Integer.toString(comercial.getCapcarga()));
    			jTextFieldCapacidad.setEnabled(false);
    			jTextFieldVolumen.setText(Integer.toString(comercial.getVolutil()));
    			jTextFieldVolumen.setEnabled(false);
    			jTextFieldPuertasCom.setText(Integer.toString(comercial.getPuertas()));
    			jTextFieldPuertasCom.setEnabled(false);
    		}else JOptionPane.showMessageDialog(null,"Tipo incorrecto.");
    		break;	
    	default:
			this.setVisible(false);
    		break;
    	}
    	
    	tipoAlta=evento;
    	dato=datos;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Generado  ">
    private void initComponents() {
        jPanelProducto = new javax.swing.JPanel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelCilindrada = new javax.swing.JLabel();
        jLabelExistencias = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldCilindrada = new javax.swing.JTextField();
        jTextFieldExistencias = new javax.swing.JTextField();
        jPanelTurismo = new javax.swing.JPanel();
        jLabelPuertas = new javax.swing.JLabel();
        jLabelPlazas = new javax.swing.JLabel();
        jLabelChasis = new javax.swing.JLabel();
        jLabelCambio = new javax.swing.JLabel();
        jTextFieldPuertas = new javax.swing.JTextField();
        jTextFieldPlazas = new javax.swing.JTextField();
        jTextFieldChasis = new javax.swing.JTextField();
        jTextFieldCambio = new javax.swing.JTextField();
        jPanelMoto = new javax.swing.JPanel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelArranque = new javax.swing.JLabel();
        jLabelEmbrague = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldArranque = new javax.swing.JTextField();
        jTextFieldEmbrague = new javax.swing.JTextField();
        jPanelComercial = new javax.swing.JPanel();
        jLabelCapacidad = new javax.swing.JLabel();
        jLabelVolumen = new javax.swing.JLabel();
        jLabelPuertasCom = new javax.swing.JLabel();
        jTextFieldCapacidad = new javax.swing.JTextField();
        jTextFieldVolumen = new javax.swing.JTextField();
        jTextFieldPuertasCom = new javax.swing.JTextField();
        jPanelBotones = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
       

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        this.setTitle("Formulario de alta de productos");
        jButtonAceptar.setText("Aceptar");
        jButtonCancelar.setText("Cancelar");
        jPanelBotones.setVisible(true);
        
        jLabelMarca.setText("Marca");

        jLabelModelo.setText("Modelo");

        jLabelAño.setText("A\u00f1o");

        jLabelPrecio.setText("Precio");

        jLabelCilindrada.setText("Cilindrada");

        jLabelExistencias.setText("Existencias");
        jTextFieldExistencias.setText("0");
        jTextFieldExistencias.setEnabled(false);

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelModelo)
                    .addComponent(jLabelAño)
                    .addComponent(jLabelPrecio)
                    .addComponent(jLabelCilindrada)
                    .addComponent(jLabelExistencias)
                    .addComponent(jLabelMarca))
                .addGap(13, 13, 13)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jTextFieldModelo)
                    .addComponent(jTextFieldAño)
                    .addComponent(jTextFieldPrecio)
                    .addComponent(jTextFieldCilindrada)
                    .addComponent(jTextFieldExistencias))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAño)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCilindrada)
                    .addComponent(jTextFieldCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelExistencias)
                    .addComponent(jTextFieldExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabelPuertas.setText("Puertas");

        jLabelPlazas.setText("Plazas");

        jLabelChasis.setText("Chasis");

        jLabelCambio.setText("Cambio");

        javax.swing.GroupLayout jPanelTurismoLayout = new javax.swing.GroupLayout(jPanelTurismo);
        jPanelTurismo.setLayout(jPanelTurismoLayout);
        jPanelTurismoLayout.setHorizontalGroup(
            jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTurismoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPuertas)
                    .addComponent(jLabelPlazas)
                    .addComponent(jLabelChasis)
                    .addComponent(jLabelCambio))
                .addGap(27, 27, 27)
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCambio)
                    .addComponent(jTextFieldChasis)
                    .addComponent(jTextFieldPlazas)
                    .addComponent(jTextFieldPuertas, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanelTurismoLayout.setVerticalGroup(
            jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTurismoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPuertas)
                    .addComponent(jTextFieldPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlazas)
                    .addComponent(jTextFieldPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChasis)
                    .addComponent(jTextFieldChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTurismoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCambio)
                    .addComponent(jTextFieldCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelTipo.setText("Tipo");

        jLabelArranque.setText("Arranque");

        jLabelEmbrague.setText("Embrague");

        javax.swing.GroupLayout jPanelMotoLayout = new javax.swing.GroupLayout(jPanelMoto);
        jPanelMoto.setLayout(jPanelMotoLayout);
        jPanelMotoLayout.setHorizontalGroup(
            jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipo)
                    .addComponent(jLabelArranque)
                    .addComponent(jLabelEmbrague))
                .addGap(16, 16, 16)
                .addGroup(jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEmbrague)
                    .addComponent(jTextFieldArranque)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanelMotoLayout.setVerticalGroup(
            jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipo)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArranque)
                    .addComponent(jTextFieldArranque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmbrague)
                    .addComponent(jTextFieldEmbrague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCapacidad.setText("Capacidad");

        jLabelVolumen.setText("Volumen");

        jLabelPuertasCom.setText("Puertas");

        javax.swing.GroupLayout jPanelComercialLayout = new javax.swing.GroupLayout(jPanelComercial);
        jPanelComercial.setLayout(jPanelComercialLayout);
        jPanelComercialLayout.setHorizontalGroup(
            jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComercialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCapacidad)
                    .addComponent(jLabelVolumen)
                    .addComponent(jLabelPuertasCom))
                .addGap(14, 14, 14)
                .addGroup(jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldPuertasCom)
                    .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVolumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelComercialLayout.setVerticalGroup(
            jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComercialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCapacidad)
                    .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVolumen)
                    .addComponent(jTextFieldVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPuertasCom)
                    .addComponent(jTextFieldPuertasCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButtonAceptar)
                .addGap(83, 83, 83)
                .addComponent(jButtonCancelar)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMoto, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTurismo, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelComercial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTurismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	switch(tipoAlta){
    	case EventoGUI.GUI_ALTA_PRODUCTO_TURISMO:
    		if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
    			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
    			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldPuertas.getText().equals("") ||
    			this.jTextFieldPlazas.getText().equals("") || this.jTextFieldChasis.getText().equals("") ||
    			this.jTextFieldCambio.getText().equals(""))
    			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
    		else{
    			try{
    			  Integer.valueOf(this.jTextFieldAño.getText());
    			  Float.valueOf(this.jTextFieldPrecio.getText());
    			  Integer.valueOf(this.jTextFieldPuertas.getText());
    			  Integer.valueOf(this.jTextFieldPlazas.getText());
    			  }catch(Exception e){
    				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año,precio,puertas y plazas.");
    				break;
    			}
    		
    		InterfazTransferTurismos producto=(InterfazTransferTurismos)FactoriaTransfers.getInstancia().dameTProductoTurismo();
    		producto.setMarca(this.jTextFieldMarca.getText());
    		producto.setModelo(this.jTextFieldModelo.getText());
    		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
    		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
    		producto.setCilindrada(this.jTextFieldCilindrada.getText());
    		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
    		producto.setPuertas(Integer.valueOf(this.jTextFieldPuertas.getText()).intValue());
    		producto.setPlazas(Integer.valueOf(this.jTextFieldPlazas.getText()).intValue());
    		producto.setChasis(this.jTextFieldChasis.getText());
    		producto.setCambio(this.jTextFieldCambio.getText());
    		producto.setActivo(true);
    		Controlador.getInstancia().accion(EventoNegocio.ALTA_PRODUCTO, producto);
    		this.setVisible(false);
    	}
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_MOTO:
    		if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
        			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
        			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldTipo.getText().equals("") ||
        			this.jTextFieldArranque.getText().equals("") || this.jTextFieldEmbrague.getText().equals("")) 
        			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
        		else{
        			try{
        			  Integer.valueOf(this.jTextFieldAño.getText());
        			  Float.valueOf(this.jTextFieldPrecio.getText());
        			  }catch(Exception e){
        				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año y precio.");
        				break;
        			  }
        		
    		InterfazTransferMotos producto=(InterfazTransferMotos)FactoriaTransfers.getInstancia().dameTProductoMoto();
    		producto.setMarca(this.jTextFieldMarca.getText());
    		producto.setModelo(this.jTextFieldModelo.getText());
    		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
    		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
    		producto.setCilindrada(this.jTextFieldCilindrada.getText());
    		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
    		producto.setTipo(this.jTextFieldTipo.getText());
    		producto.setArranque(this.jTextFieldArranque.getText());
    		producto.setEmbrague(this.jTextFieldEmbrague.getText());
    		producto.setActivo(true);
    		Controlador.getInstancia().accion(EventoNegocio.ALTA_PRODUCTO, producto);
    		this.setVisible(false);
    	}
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL:
    		if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
        			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
        			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldCapacidad.getText().equals("") ||
        			this.jTextFieldVolumen.getText().equals("") || this.jTextFieldPuertasCom.getText().equals("") )
        			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
        		else{
        			try{
        			  Integer.valueOf(this.jTextFieldAño.getText());
        			  Float.valueOf(this.jTextFieldPrecio.getText());
        			  Integer.valueOf(this.jTextFieldPuertasCom.getText());
        			  Integer.valueOf(this.jTextFieldCapacidad.getText());
        			  Integer.valueOf(this.jTextFieldVolumen.getText());
        			  }catch(Exception e){
        				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año, precio, capacidad, volumen y puertas.");
        				break;
        			}
        			InterfazTransferComerciales producto=(InterfazTransferComerciales)FactoriaTransfers.getInstancia().dameTProductoComercial();
        			producto.setMarca(this.jTextFieldMarca.getText());
            		producto.setModelo(this.jTextFieldModelo.getText());
            		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
            		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
            		producto.setCilindrada(this.jTextFieldCilindrada.getText());
            		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
            		producto.setCapcarga(Integer.valueOf(this.jTextFieldCapacidad.getText()).intValue());
            		producto.setVolutil(Integer.valueOf(this.jTextFieldVolumen.getText()).intValue());
            		producto.setPuertas(Integer.valueOf(this.jTextFieldPuertasCom.getText()).intValue());
            		producto.setActivo(true);
            		Controlador.getInstancia().accion(EventoNegocio.ALTA_PRODUCTO, producto);
            		this.setVisible(false);
        		}
    			break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO:
    		this.setVisible(false);
    		break;
    	case EventoGUI.GUI_MODIFICA_PRODUCTO:
    		if(dato instanceof InterfazTransferTurismos){
    			if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
    	    			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
    	    			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldPuertas.getText().equals("") ||
    	    			this.jTextFieldPlazas.getText().equals("") || this.jTextFieldChasis.getText().equals("") ||
    	    			this.jTextFieldCambio.getText().equals(""))
    	    			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
    	    		else{
    	    			try{
    	    			  Integer.valueOf(this.jTextFieldAño.getText());
    	    			  Float.valueOf(this.jTextFieldPrecio.getText());
    	    			  Integer.valueOf(this.jTextFieldPuertas.getText());
    	    			  Integer.valueOf(this.jTextFieldPlazas.getText());
    	    			  }catch(Exception e){
    	    				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año, precio, puertas y plazas.");
    	    				break;
    	    			}
    	    			  InterfazTransferTurismos producto=(InterfazTransferTurismos)FactoriaTransfers.getInstancia().dameTProductoTurismo();
    	    	    		producto.setIdentificador(((InterfazTransferTurismos)dato).getIdentificador());
    	    			  	producto.setMarca(this.jTextFieldMarca.getText());
    	    	    		producto.setModelo(this.jTextFieldModelo.getText());
    	    	    		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
    	    	    		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
    	    	    		producto.setCilindrada(this.jTextFieldCilindrada.getText());
    	    	    		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
    	    	    		producto.setPuertas(Integer.valueOf(this.jTextFieldPuertas.getText()));
    	    	    		producto.setPlazas(Integer.valueOf(this.jTextFieldPlazas.getText()));
    	    	    		producto.setChasis(this.jTextFieldChasis.getText());
    	    	    		producto.setCambio(this.jTextFieldCambio.getText());
    	    	    		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_PRODUCTO, producto);
    	    	    		this.setVisible(false);
    	    			  
    	    			}
    		}else if(dato instanceof InterfazTransferMotos){
    			if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
            			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
            			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldTipo.getText().equals("") ||
            			this.jTextFieldArranque.getText().equals("") || this.jTextFieldEmbrague.getText().equals("")) 
            			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
            		else{
            			try{
            			  Integer.valueOf(this.jTextFieldAño.getText());
            			  Float.valueOf(this.jTextFieldPrecio.getText());
            			  }catch(Exception e){
            				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año y precio.");
            				break;
            			  }
            		InterfazTransferMotos producto=(InterfazTransferMotos)FactoriaTransfers.getInstancia().dameTProductoMoto();
            		producto.setIdentificador(((InterfazTransferMotos)dato).getIdentificador());
            		producto.setMarca(this.jTextFieldMarca.getText());
            		producto.setModelo(this.jTextFieldModelo.getText());
            		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
            		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
            		producto.setCilindrada(this.jTextFieldCilindrada.getText());
            		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
            		producto.setTipo(this.jTextFieldTipo.getText());
            		producto.setArranque(this.jTextFieldArranque.getText());
            		producto.setEmbrague(this.jTextFieldEmbrague.getText());
            		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_PRODUCTO, producto);
            		this.setVisible(false);
            		}
    		}else{
    			if( this.jTextFieldMarca.getText().equals("") || this.jTextFieldModelo.getText().equals("") || this.jTextFieldAño.getText().equals("") ||
            			this.jTextFieldPrecio.getText().equals("") || this.jTextFieldCilindrada.getText().equals("") ||
            			this.jTextFieldExistencias.getText().equals("") || this.jTextFieldCapacidad.getText().equals("") ||
            			this.jTextFieldVolumen.getText().equals("") || this.jTextFieldPuertasCom.getText().equals("") )
            			JOptionPane.showMessageDialog(null,"Debe de rellenar todos los campos!");
            		else{
            			try{
            			  Integer.valueOf(this.jTextFieldAño.getText());
            			  Float.valueOf(this.jTextFieldPrecio.getText());
            			  Integer.valueOf(this.jTextFieldPuertasCom.getText());
            			  Integer.valueOf(this.jTextFieldCapacidad.getText());
            			  Integer.valueOf(this.jTextFieldVolumen.getText());
            			  }catch(Exception e){
            				JOptionPane.showMessageDialog(null, "Tipos de dato incorrectos. Revise los campos año, precio, capacidad, volumen y puertas.");
            				break;
            			}
            			InterfazTransferComerciales producto=(InterfazTransferComerciales)FactoriaTransfers.getInstancia().dameTProductoComercial();
            			producto.setIdentificador(((InterfazTransferComerciales)dato).getIdentificador());
            			producto.setMarca(this.jTextFieldMarca.getText());
                		producto.setModelo(this.jTextFieldModelo.getText());
                		producto.setAño(Integer.valueOf(this.jTextFieldAño.getText()).intValue());
                		producto.setPrecio(Float.valueOf(this.jTextFieldPrecio.getText()).floatValue());
                		producto.setCilindrada(this.jTextFieldCilindrada.getText());
                		producto.setExistencias(Integer.valueOf(this.jTextFieldExistencias.getText()).intValue());
                		producto.setCapcarga(Integer.valueOf(this.jTextFieldCapacidad.getText()).intValue());
                		producto.setVolutil(Integer.valueOf(this.jTextFieldVolumen.getText()).intValue());
                		producto.setPuertas(Integer.valueOf(this.jTextFieldPuertasCom.getText()).intValue());
                		Controlador.getInstancia().accion(EventoNegocio.MODIFICA_PRODUCTO, producto);
                		this.setVisible(false);
            		}
    		}
    		break;
    	}
    }
    
    // Declaración de varibales -no modificar
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelArranque;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelCambio;
    private javax.swing.JLabel jLabelCapacidad;
    private javax.swing.JLabel jLabelChasis;
    private javax.swing.JLabel jLabelCilindrada;
    private javax.swing.JLabel jLabelEmbrague;
    private javax.swing.JLabel jLabelExistencias;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPlazas;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPuertas;
    private javax.swing.JLabel jLabelPuertasCom;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelVolumen;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelComercial;
    private javax.swing.JPanel jPanelMoto;
    private javax.swing.JPanel jPanelProducto;
    private javax.swing.JPanel jPanelTurismo;
    private javax.swing.JTextField jTextFieldArranque;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldCambio;
    private javax.swing.JTextField jTextFieldCapacidad;
    private javax.swing.JTextField jTextFieldChasis;
    private javax.swing.JTextField jTextFieldCilindrada;
    private javax.swing.JTextField jTextFieldEmbrague;
    private javax.swing.JTextField jTextFieldExistencias;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPlazas;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldPuertas;
    private javax.swing.JTextField jTextFieldPuertasCom;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldVolumen;
    // Fin de declaración de variables
    
}
