package concesionario.presentacion.ventas;


import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.presentacion.controlador.EventoGUI;


public class GUIRespuesta extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GUIRespuesta() {

		initComponents();

		this.jLabel1.setText("NOTAS A LA VENTA:");
		this.setLocation(300,300);
		this.setSize(580,300);
		this.setResizable(false);
		this.jButton1.setVisible(false);
		this.jButton2.setVisible(false);
		this.textField1.setVisible(false);
		this.setVisible(true);


	}





	public void actualiza(int evento,Object datos){
		switch(evento){
		case EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA:
			InterfazTransferRespuesta respuesta=(InterfazTransferRespuesta)datos;
			for (int i=0;i<respuesta.getNotas().size();i++){
				Vector<String> fila=new Vector<String>();
				fila.add("");

				((DefaultTableModel)jTable1.getModel()).addRow(fila);
				jTable1.setValueAt(respuesta.getNotas().get(i),i, 0);


			}
			break;
		}
	}
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

				new Object [][] {
						{null}

				},
				new String [] {
						"NOTAS", 
				}
		));


		jTable1.repaint();
		jScrollPane1.setViewportView(jTable1);





		jLabel1.setText("producto :");

		textField1.setText("");

		

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
						.addComponent(jScrollPane1, 550, 550, 550)
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1)
								.addComponent(jButton2)
								.addGap(55, 55, 55))

								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jScrollPane1, 150, 150, 150))
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
