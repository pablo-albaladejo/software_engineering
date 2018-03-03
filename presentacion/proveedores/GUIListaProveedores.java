
package concesionario.presentacion.proveedores;

import java.util.ArrayList;

import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.presentacion.controlador.EventoGUI;

public class GUIListaProveedores extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
   
	public GUIListaProveedores() {
		initComponents();
	}
	
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaProveedores = new javax.swing.JTable();
        jButtonAceptar = new javax.swing.JButton();

        setTitle("Lista de Proveedores");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jTableListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListaProveedores);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jButtonAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaProveedores;
    
    @SuppressWarnings("unchecked")
	public void actualiza(int evento, Object datos) {
    	ArrayList<InterfazTransferProveedores> listaProveedores = (ArrayList<InterfazTransferProveedores>)datos;
    	switch (evento) {
            case EventoGUI.GUI_LISTA_PROVEEDORES :
            	jTableListaProveedores.setEnabled(false);
            	jTableListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [listaProveedores.size()][1] ,
                        new String [] {
                            "Id", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email"
                        }
                    ));
            	jTableListaProveedores.setEnabled(false);
                jTableListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [listaProveedores.size()][1],
                        new String [] {
                            "Id", "CIF", "Nombre", "Direccion", "Telefono", "Email"
                        }
                    ));
            	for( int i=0; i<listaProveedores.size(); i++ ) {
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getIdentificador(), i,0);
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getCIF(), i, 1);
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getNombre(), i, 2);
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getDireccion(), i, 3);
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getTelefono(), i, 4);
                    jTableListaProveedores.setValueAt(((InterfazTransferProveedores)listaProveedores.get(i)).getEmail(), i, 5);
            	}
            	this.setVisible(true);
            	break;
        }
    }
}
