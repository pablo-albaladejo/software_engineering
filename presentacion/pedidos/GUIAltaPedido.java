package concesionario.presentacion.pedidos;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;

/**
 *
 * @author  carlos
 */
public class GUIAltaPedido extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int tipoEvento;
	int identifica;
	/** Creates new form GUIAnadirProductos */
	
	public GUIAltaPedido(){
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	public void actualiza(int evento,Object datos) {
		tipoEvento = evento;
		switch(evento){
		case EventoGUI.GUI_ALTA_PEDIDO:
			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			this.jButton1.setVisible(true);
			this.jButton2.setVisible(true);
			this.jLabel1.setVisible(true);
			this.textField1.setVisible(true);
			this.setTitle("Formulario de alta de pedidos");
			identifica = (Integer)datos;
			break;
		case EventoGUI.GUI_MOSTRAR_DETALLES_PEDIDO :
			InterfazTransferPedidos pedido = (InterfazTransferPedidos)datos;
			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			this.jButton1.setVisible(false);
			this.jButton2.setVisible(true);
			this.jLabel1.setVisible(false);
			this.textField1.setVisible(false);
			this.setTitle("Formulario de detalles del pedido "+pedido.getIdentificador());
			jTable1.setModel(new javax.swing.table.DefaultTableModel(

					new Object [0][1],
					new String [] {
							"ID PRODUCTO", "MARCA", "MODELO", "PRECIO U.", "PAX.", "SUBTOTAL"
					}
			));
			Vector<String> filaPedido;
			float total = 0;
			for ( int i=0 ; i<pedido.getNumElems() ; i++ ) {
				filaPedido = new Vector<String>();
				filaPedido.add(Integer.toString(pedido.getProducto(i).getIdentificador()));
				filaPedido.add(pedido.getProducto(i).getMarca());
				filaPedido.add(pedido.getProducto(i).getModelo());
				filaPedido.add(Float.toString(pedido.getPrecioProducto(i)));
				filaPedido.add(Integer.toString(pedido.getNumProductos(i)));
				total +=pedido.getPrecioProducto(i)*pedido.getNumProductos(i);
				filaPedido.add(Float.toString(pedido.getPrecioProducto(i)*pedido.getNumProductos(i)));
				((DefaultTableModel)this.jTable1.getModel()).addRow(filaPedido);
			}
			filaPedido = new Vector<String>();
			filaPedido.add("Importe");
			filaPedido.add("TOTAL");
			filaPedido.add(">>>>>>");
			filaPedido.add(">>>>>>");
			filaPedido.add(">>>>>>");
			filaPedido.add(Float.toString(total));
			((DefaultTableModel)this.jTable1.getModel()).addRow(filaPedido);
			break;
		case EventoGUI.GUI_LISTAR_PEDIDOS :
			ArrayList<InterfazTransferPedidos> listaPedidos = (ArrayList<InterfazTransferPedidos>) datos;
			if ( listaPedidos.size() == 0)JOptionPane.showMessageDialog(null, "No hay pedidos pendientes");
			else {
				this.setLocation(400,300);
				this.setSize(450,300);
				this.setResizable(false);
				this.setVisible(true);
				this.jButton1.setVisible(false);
				this.jButton2.setVisible(true);
				this.jLabel1.setVisible(false);
				this.textField1.setVisible(false);
				this.setTitle("Formulario de lista de pedidos");
				jTable1.setModel(new javax.swing.table.DefaultTableModel(
	
						new Object [0][1],
						new String [] {
								"ID PEDIDO", "ID PROVEEDOR", "UNIDADES", "IMPORTE"
						}
				));
				Vector<String> filaLista;
				for ( int i=0 ; i<listaPedidos.size() ; i++ ) {
					filaLista = new Vector<String>();
					filaLista.add(Integer.toString(listaPedidos.get(i).getIdentificador()));
					filaLista.add(Integer.toString(listaPedidos.get(i).getProveedor()));
					filaLista.add(Integer.toString(listaPedidos.get(i).getUnidades()));
					filaLista.add(Float.toString(listaPedidos.get(i).getTotal()));
					((DefaultTableModel)this.jTable1.getModel()).addRow(filaLista);
				}
			}
			break;
		case EventoGUI.GUI_LISTAR_STOCK :
			ArrayList<InterfazTransferProductos> listaProductos = (ArrayList<InterfazTransferProductos>) datos;
			if ( listaProductos.size() == 0)JOptionPane.showMessageDialog(null, "No hay productos en stock.");
			else {
				this.setLocation(400,300);
				this.setSize(450,300);
				this.setResizable(false);
				this.setVisible(true);
				this.jButton1.setVisible(false);
				this.jButton2.setVisible(true);
				this.jLabel1.setVisible(false);
				this.textField1.setVisible(false);
				this.setTitle("Formulario de lista de productos con stock bajo");
				jTable1.setModel(new javax.swing.table.DefaultTableModel(
	
						new Object [0][1],
						new String [] {
								"ID PRODUCTO", "MARCA", "MODELO", "UNIDADES"
						}
				));
				Vector<String> filaListaP;
				for ( int i=0 ; i<listaProductos.size() ; i++ ) {
					filaListaP = new Vector<String>();
					filaListaP.add(Integer.toString(listaProductos.get(i).getIdentificador()));
					filaListaP.add(listaProductos.get(i).getMarca());
					filaListaP.add(listaProductos.get(i).getModelo());
					filaListaP.add(Integer.toString(listaProductos.get(i).getExistencias()));
					((DefaultTableModel)this.jTable1.getModel()).addRow(filaListaP);
				}
			}
			break;
		}
	}



	// 
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		textField1 = new java.awt.TextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTable1 = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();


		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(

				new Object [0][1],
				new String [] {
						"ID PRODUCTO", "CANTIDAD"
				}
		));
		//jTable1.setSize(50, 50);
		jTable1.setBounds(10, 20, 30, 40);
		jScrollPane1.setViewportView(jTable1);

		jLabel1.setText("producto :");

		textField1.setText("");

		jButton1.setText("AÑADIR");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button1(evt);
			}
		});

		jButton2.setText("TERMINAR");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button2(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addGap(55, 55, 55)
						.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButton2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(jScrollPane1, 420, 420, 420)
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1)
								.addComponent(jButton2))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                		.addComponent(jScrollPane1, 200, 200, 200))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(385, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(244, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>

	private void button1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		//Boton aceptar
		String textoEntrada=(String)textField1.getText();
		String numElems;
		Vector<String> fila = new Vector<String>();
		try {
			Integer.valueOf(textoEntrada);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El valor introducido en producto no es correcto.");
		}

		try {
			numElems = JOptionPane.showInputDialog("Introduce el número de productos a solicitar");
			if (numElems==null)JOptionPane.showMessageDialog(null,"No has introducido ninguna cantidad.");
			else {
				Integer.valueOf(numElems);
				fila.add(textoEntrada);
				fila.add(numElems);
				((DefaultTableModel)this.jTable1.getModel()).addRow(fila);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El valor introducido en producto no es correcto.");
		}
	}
	private void button2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		switch(tipoEvento){ 
		case EventoGUI.GUI_ALTA_PEDIDO:
			InterfazTransferPedidos pedido = FactoriaTransfers.getInstancia().dameTPedidos();
			InterfazTransferProductos producto;
			if ( this.jTable1.getRowCount()==0 )JOptionPane.showMessageDialog(null, "No hay elementos en la tabla.");
			else{
				try {
					for (int i=0 ; i<this.jTable1.getRowCount() ; i++) {
						producto = FactoriaTransfers.getInstancia().dameTProductos();
						producto.setIdentificador(Integer.valueOf(this.jTable1.getValueAt(i,0).toString()));
						pedido.addElementoPedido(producto,Integer.valueOf(this.jTable1.getValueAt(i,1).toString()), 0);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hay valores incorrectos en la tabla.");
					break;
				}
				pedido.setProveedor(identifica);
				Controlador.getInstancia().accion(EventoNegocio.ALTA_PEDIDO, pedido);
			}
			break;
		}
		this.setVisible(false);

	}
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private java.awt.TextField textField1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTable jTable1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration
}
