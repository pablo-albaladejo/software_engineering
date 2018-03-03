package concesionario.presentacion.ventas;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;


public class GUIAnadirProductos extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String identificador;
	InterfazTransferVentas venta=FactoriaTransfers.getInstancia().dameTVentas();
	ArrayList<String> carrito=new ArrayList<String>(0);
	ArrayList<String> cantidad=new ArrayList<String>(0);
	int eventoGUI;
	/** Creates new form GUIAnadirProductos */
	public GUIAnadirProductos() {
		initComponents();
	}
	@SuppressWarnings("unchecked")
	public void actualiza(int evento,Object datos){
		eventoGUI=evento;
		switch(evento){
		case EventoGUI.GUI_ALTA_VENTA:
			identificador=(String)datos;

			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			venta.setIdCliente(Integer.valueOf(identificador));
			break;
		case EventoGUI.GUI_MODIFICA_VENTA:
			identificador=(String)datos;

			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_CLIENTE, Integer.valueOf(identificador));
			break;
		case EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES:
			venta=(InterfazTransferVentas)datos;


			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			for (int i=0;i<venta.getListaCompra().size();i++){
				Vector<String> fila=new Vector<String>();
				fila.add("");
				fila.add("");
				((DefaultTableModel)jTable1.getModel()).addRow(fila);
				jTable1.setValueAt(venta.getListaCompra().get(i),i, 0);
				jTable1.setValueAt(venta.getCantidades().get(i),i, 1);
				carrito.add(venta.getListaCompra().get(i));
			}
			break;
		case EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES:
			venta=(InterfazTransferVentas)datos;
			jTable1.setEnabled(false);

			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			for (int i=0;i<venta.getListaCompra().size();i++){
				Vector<String> fila=new Vector<String>();
				fila.add("");
				fila.add("");
				((DefaultTableModel)jTable1.getModel()).addRow(fila);
				jTable1.setValueAt(venta.getListaCompra().get(i),i, 0);
				jTable1.setValueAt(venta.getCantidades().get(i),i, 1);
				carrito.add(venta.getListaCompra().get(i));
			}
			this.jLabel1.setText("id.cliente: "+venta.getIdCliente()+"    PRECIO TOTAL= "+ venta.getMontante()+ " euros");
			this.jButton1.setVisible(false);
			this.jButton2.setVisible(false);
			this.textField1.setVisible(false);
			break;
		case EventoGUI.GUI_MUESTRA_LISTADO_VENTAS:
			ArrayList<InterfazTransferVentas> listadoVentas=(ArrayList<InterfazTransferVentas>)datos;

			jTable1.setEnabled(false);
			this.setLocation(400,300);
			this.setSize(450,300);
			this.setResizable(false);
			this.setVisible(true);
			Object [] nombres={"ID.COMPRA","ID.CLIENTE","MONTANTE (euros)"};
			((DefaultTableModel)jTable1.getModel()).setColumnIdentifiers(nombres);

			for (int i=0;i<listadoVentas.size();i++){
				Vector<String> fila=new Vector<String>();
				fila.add("");
				fila.add("");
				((DefaultTableModel)jTable1.getModel()).addRow(fila);
				jTable1.setValueAt(listadoVentas.get(i).getIdCompra(),i, 0);
				jTable1.setValueAt(listadoVentas.get(i).getIdCliente(),i, 1);
				jTable1.setValueAt(listadoVentas.get(i).getMontante(),i, 2);

			}
			this.jLabel1.setText("Listado ventas");
			this.jButton1.setVisible(false);
			this.jButton2.setVisible(false);
			this.textField1.setVisible(false);
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

				new Object [1][1],
				new String [] {
						"ID PRODUCTO", "CANTIDAD"
				}
		));




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
	}

	/**
	 * @param args the command line arguments
	 */

	private void button1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

		String textoEntrada=(String)textField1.getText();

		try {
			Integer.valueOf(textoEntrada);
			carrito.add(textField1.getText().toString());

			jTable1.setValueAt(textField1.getText().toString(),carrito.size()-1, 0);
			jTable1.setValueAt("1",carrito.size()-1, 1);
			Vector<String> fila=new Vector<String>();
			fila.add("");
			fila.add("");
			((DefaultTableModel)jTable1.getModel()).addRow(fila);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. Compruebe el campo producto.");



		}



	}
	private void button2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

		//int nuevaCantidad;
		ArrayList<String> carritoTemp=new ArrayList<String> (0);
		for (int i=0;i<carrito.size();i++){
			try{

				Integer.valueOf((String)jTable1.getValueAt(i,1));	

			}
			catch(Exception e){
				jTable1.setValueAt("0",i, 1);


			}
			if (Integer.valueOf((String) jTable1.getValueAt(i,1))>0){
				if (carritoTemp.contains(carrito.get(i))){
					for (int j=0;j<carritoTemp.size();j++){


						cantidad.set(j, Integer.toString((Integer.valueOf(cantidad.get(j))+Integer.valueOf((String)jTable1.getValueAt(i,1)))));	


					}

				}
				else{

					carritoTemp.add(carrito.get(i));



					cantidad.add((String)jTable1.getValueAt(i,1));


					cantidad.add((String)jTable1.getValueAt(i,1));
				}
			}

		}
		venta.setListaCompra(carritoTemp);
		venta.setCantidades(cantidad);
		venta.setAlta(true);
		switch(eventoGUI){ 
		case EventoGUI.GUI_ALTA_VENTA:
			Controlador.getInstancia().accion(EventoNegocio.ALTA_VENTA, venta);
			break;
		case EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES:

			Controlador.getInstancia().accion(EventoNegocio.MODIFICA_VENTA_INSERTA_DATOS, venta);
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
