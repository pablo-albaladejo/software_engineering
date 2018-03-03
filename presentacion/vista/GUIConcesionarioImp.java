
package concesionario.presentacion.vista;

import javax.swing.*;

import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.presentacion.clientes.GUIClientes;
import concesionario.presentacion.ventas.GUIVentas;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.pedidos.GUIPedidos;
import concesionario.presentacion.productos.GUIProductos;
import concesionario.presentacion.proveedores.GUIProveedores;

public class GUIConcesionarioImp extends GUIConcesionario {
 
	private static final long serialVersionUID = 1L;
	
    public GUIConcesionarioImp() {
        initComponents();
    }
   
    private void initComponents() {
        jMenuBar1 = new javax.swing.JMenuBar();
        jOpciones = new javax.swing.JMenu();
        jOpcionesSalir = new javax.swing.JMenuItem();
        
        //Clientes
        jMenuClientes = new javax.swing.JMenu();
        jClientesItemAlta = new javax.swing.JMenuItem();
        jClientesItemAltaEmpresa = new javax.swing.JMenuItem();
        jClientesItemBaja = new javax.swing.JMenuItem();
        jClientesItemModificar = new javax.swing.JMenuItem();
        jClientesItemDetalles = new javax.swing.JMenuItem();
        jClientesItemListar = new javax.swing.JMenuItem();
        
		//Proveedores
        jMenuProveedores = new javax.swing.JMenu();
        jProveedoresItemAlta = new javax.swing.JMenuItem();
        jProveedoresItemBaja = new javax.swing.JMenuItem();
        jProveedoresItemModificar = new javax.swing.JMenuItem();
        jProveedoresItemDetalles = new javax.swing.JMenuItem();
        jProveedoresItemListar = new javax.swing.JMenuItem();
        jProveedoresItemVincular = new javax.swing.JMenuItem();
        jProveedoresItemDesvincular = new javax.swing.JMenuItem();
		
        //Ventas
        jMenuVentas = new javax.swing.JMenu();
        jVentasItemAlta = new javax.swing.JMenuItem();
        jVentasItemBaja = new javax.swing.JMenuItem();
        jVentasItemModificar = new javax.swing.JMenuItem();
        jVentasItemDetalles = new javax.swing.JMenuItem();
        jVentasItemListar = new javax.swing.JMenuItem();
        
        //Productos
        jMenuProductos = new javax.swing.JMenu();
        jProductosItemAltaTurismo=new javax.swing.JMenuItem();
        jProductosItemAltaMoto= new javax.swing.JMenuItem();
        jProductosItemAltaComercial=new javax.swing.JMenuItem();
        jProductosItemBaja=new javax.swing.JMenuItem();
        jProductosItemDetalles=new javax.swing.JMenuItem();
        jProductosItemModificar=new javax.swing.JMenuItem();
        jProductosItemListar=new javax.swing.JMenuItem();
       
        //Pedidos
        jMenuPedidos = new javax.swing.JMenu();
        jPedidosItemHacerPedido = new javax.swing.JMenuItem();
        jPedidosItemRecibir= new javax.swing.JMenuItem();
        jPedidosItemMostrar = new javax.swing.JMenuItem();
        jPedidosItemAnular = new javax.swing.JMenuItem();
        jPedidosItemListar = new javax.swing.JMenuItem();
        jPedidosItemStock = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jOpciones.setText("Opciones");
        jOpcionesSalir.setText("Salir");
        jOpcionesSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpcionesSalirActionPerformed(evt);
            }
        });

        jOpciones.add(jOpcionesSalir);

        jMenuBar1.add(jOpciones);

//      *******************************CLIENTES************************************//
        
        jMenuClientes.setText("Clientes");
        
        //ALTA CLIENTES
        jClientesItemAlta.setText("Alta cliente");
        jClientesItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesItemAltaActionPerformed(evt);
            }
        });
        jMenuClientes.add(jClientesItemAlta);
        
        
        //ALTA CLIENTES EMPRESA
        jClientesItemAltaEmpresa.setText("Alta cliente empresa");
        
        jClientesItemAltaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesItemAltaEmpresaActionPerformed(evt);
            }
        });

        jMenuClientes.add(jClientesItemAltaEmpresa);
        
        
        //BAJA CLIENTES
        jClientesItemBaja.setText("Baja cliente");
        jClientesItemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesItemBajaActionPerformed(evt);
            }
        });        
        jMenuClientes.add(jClientesItemBaja);

        
        //MODIFICAR CLIENTES
        jClientesItemModificar.setText("Modificar cliente");
        jClientesItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesItemModificaActionPerformed(evt);
            }
        });
        jMenuClientes.add(jClientesItemModificar);

        
        //MOSTRAR DETALLES CLIENTE
        jClientesItemDetalles.setText("Mostrar detalles cliente");
        jClientesItemDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jClientesItemDetallesActionPerformed(evt);
            }
        });
        jMenuClientes.add(jClientesItemDetalles);
        
        
        //LISTAR CLIENTES
        jClientesItemListar.setText("Listar clientes");
        jClientesItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesItemListarActionPerformed(evt);
            }
        });
        jMenuClientes.add(jClientesItemListar);

        jMenuBar1.add(jMenuClientes);
        
		//      *******************************PROVEEDORES************************************//
        
        jMenuProveedores.setText("Proveedores");
        
        //ALTA PROVEEDORES
        jProveedoresItemAlta.setText("Alta proveedor");
        jProveedoresItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemAltaActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemAlta);        
        
        //BAJA PROVEEDORES
        jProveedoresItemBaja.setText("Baja proveedor");
        jProveedoresItemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemBajaActionPerformed(evt);
            }
        });        
        jMenuProveedores.add(jProveedoresItemBaja);

        
        //MODIFICAR PROVEEDORES
        jProveedoresItemModificar.setText("Modificar proveedor");
        jProveedoresItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemModificaActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemModificar);

        
        //MOSTRAR DETALLES PROVEEDORES
        jProveedoresItemDetalles.setText("Mostrar detalles proveedor");
        jProveedoresItemDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jProveedoresItemDetallesActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemDetalles);
        
        
        //LISTAR PROVEEDORES
        jProveedoresItemListar.setText("Listar Proveedores");
        jProveedoresItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemListarActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemListar);
        
        //VINCULAR PROVEEDORES
        jProveedoresItemVincular.setText("Vincular Proveedores");
        jProveedoresItemVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemVincularActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemVincular);
        
        //DESVINCULAR PROVEEDORES
        jProveedoresItemDesvincular.setText("Desvincular Proveedores");
        jProveedoresItemDesvincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProveedoresItemDesvincularActionPerformed(evt);
            }
        });
        jMenuProveedores.add(jProveedoresItemDesvincular);
        
        jMenuBar1.add(jMenuProveedores);
        //*******************************VENTAS************************************//
        jMenuVentas.setText("Ventas");
        
        jVentasItemAlta.setText("Alta venta");
        jVentasItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVentasItemAltaActionPerformed(evt);
            }
        });
        jVentasItemBaja.setText("Baja venta");
        jVentasItemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVentasItemBajaActionPerformed(evt);
            }
        });
        jVentasItemModificar.setText("Modifica venta");
        jVentasItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVentasItemModificarActionPerformed(evt);
            }
        });
        jVentasItemDetalles.setText("Detalles venta");
        jVentasItemDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVentasItemDetallesActionPerformed(evt);
            }
        });
        jVentasItemListar.setText("Listar ventas");
        jVentasItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVentasItemListarActionPerformed(evt);
            }
        });

        jMenuVentas.add(jVentasItemAlta);
        jVentasItemBaja.setText("Baja venta");
        jMenuVentas.add(jVentasItemBaja);

        jVentasItemModificar.setText("Modificar venta");
        jMenuVentas.add(jVentasItemModificar);

        jVentasItemDetalles.setText("Mostrar detalles venta");
        jMenuVentas.add(jVentasItemDetalles);

        jVentasItemListar.setText("Listar ventas");
        jMenuVentas.add(jVentasItemListar);
        
        jMenuBar1.add(jMenuVentas);
        
        
      //*****************************PRODUCTOS**********************************//
        
        jMenuProductos.setText("Productos");
        
        jProductosItemAltaTurismo.setText("Alta turismo");
        jProductosItemAltaTurismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemAltaTurismoActionPerformed(evt);
            }
        });
        jProductosItemAltaMoto.setText("Alta moto");
        jProductosItemAltaMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemAltaMotoActionPerformed(evt);
            }
        });
        jProductosItemAltaComercial.setText("Alta vehículo comercial");
        jProductosItemAltaComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemAltaComercialActionPerformed(evt);
            }
        });
        jProductosItemBaja.setText("Baja producto");
        jProductosItemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemBajaActionPerformed(evt);
            }
        });
        jProductosItemDetalles.setText("Mostrar detalles producto");
        jProductosItemDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemDetallesActionPerformed(evt);
            }
        });
        jProductosItemModificar.setText("Modificar producto");
        jProductosItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemModificarActionPerformed(evt);
            }
        });
        jProductosItemListar.setText("Listar productos");
        jProductosItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProductosItemListarActionPerformed(evt);
            }
        });
        
        jMenuProductos.add(jProductosItemAltaTurismo);
        jMenuProductos.add(jProductosItemAltaMoto);
        jMenuProductos.add(jProductosItemAltaComercial);
        jMenuProductos.add(jProductosItemBaja);
        jMenuProductos.add(jProductosItemModificar);
        jMenuProductos.add(jProductosItemDetalles);
        jMenuProductos.add(jProductosItemListar);
        
        jMenuBar1.add(jMenuProductos);
        
        //*****************************PEDIDOS**********************************//
        jMenuPedidos.setText("Pedidos");
        
        jPedidosItemHacerPedido.setText("Hacer pedido");
        jPedidosItemHacerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemHacerPedidoActionPerformed(evt);
            }
        });
        jPedidosItemRecibir.setText("Recibir pedido");
        jPedidosItemRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemRecibirActionPerformed(evt);
            }
        });
        jPedidosItemMostrar.setText("Mostrar pedido");
        jPedidosItemMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemMostrarActionPerformed(evt);
            }
        });
        jPedidosItemAnular.setText("Anular pedido");
        jPedidosItemAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemAnularActionPerformed(evt);
            }
        });
        jPedidosItemListar.setText("Listar pedidos");
        jPedidosItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemListarActionPerformed(evt);
            }
        });
        jPedidosItemStock.setText("Listar stock");
        jPedidosItemStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPedidosItemStockActionPerformed(evt);
            }
        });
        
        jMenuPedidos.add(jPedidosItemHacerPedido);
        jMenuPedidos.add(jPedidosItemRecibir);
        jMenuPedidos.add(jPedidosItemMostrar);
        jMenuPedidos.add(jPedidosItemAnular);
        jMenuPedidos.add(jPedidosItemListar);
        jMenuPedidos.add(jPedidosItemStock);
        
        
        jMenuBar1.add(jMenuPedidos);
        
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-532)/2, (screenSize.height-459)/2, 532, 459);
    }
    
	//CLIENTES
    private void jOpcionesSalirActionPerformed(java.awt.event.ActionEvent evt) {
        Controlador.getInstancia().accion(EventoNegocio.FIN_APLICACION, null);
    }

    private void jClientesItemAltaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {
        this.actualiza(EventoGUI.GUI_ALTA_CLIENTE_EMPRESA, null);
    }

    private void jClientesItemAltaActionPerformed(java.awt.event.ActionEvent evt) {
        this.actualiza(EventoGUI.GUI_ALTA_CLIENTE, null);
    }
    
    private void jClientesItemBajaActionPerformed(java.awt.event.ActionEvent evt) {
        this.actualiza(EventoGUI.GUI_BAJA_CLIENTE, null);
    }
    
    private void jClientesItemModificaActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_MODIFICA_CLIENTE, null);
    }
    
    private void jClientesItemDetallesActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE, null);
	}
    
    private void jClientesItemListarActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_LISTA_CLIENTES, null);
    }
    
	// PROVEEDORES
    private void jProveedoresItemAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
        this.actualiza(EventoGUI.GUI_ALTA_PROVEEDOR, null);
    }
    
    private void jProveedoresItemBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
        this.actualiza(EventoGUI.GUI_BAJA_PROVEEDOR, null);
    }
    
    private void jProveedoresItemModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
    	this.actualiza(EventoGUI.GUI_MODIFICA_PROVEEDOR, null);
    }
    
    private void jProveedoresItemDetallesActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR, null);
	}
    
    private void jProveedoresItemListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
    	this.actualiza(EventoGUI.GUI_LISTA_PROVEEDORES, null);
    }
	
    private void jProveedoresItemVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
    	this.actualiza(EventoGUI.GUI_VINCULA_PROVEEDORES, null);
    }
    private void jProveedoresItemDesvincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProveedoresItemAltaActionPerformed
    	this.actualiza(EventoGUI.GUI_DESVINCULA_PROVEEDORES, null);
    }
    ////VENTAS
    private void jVentasItemAltaActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_ALTA_VENTA, null);
    }
    private void jVentasItemBajaActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_BAJA_VENTA, null);
    }
    private void jVentasItemModificarActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_MODIFICA_VENTA, null);
    }
    private void jVentasItemDetallesActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_VENTA, null);
    }
    private void jVentasItemListarActionPerformed(java.awt.event.ActionEvent evt) {
    	this.actualiza(EventoGUI.GUI_LISTA_VENTAS, null);
    }
    
    ///PRODUCTOS
    private void jProductosItemAltaTurismoActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_ALTA_PRODUCTO_TURISMO, null);
    }
    private void jProductosItemAltaMotoActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_ALTA_PRODUCTO_MOTO, null);
    }
    private void jProductosItemAltaComercialActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL, null);
    }
    private void jProductosItemBajaActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_BAJA_PRODUCTO, null);
    }
    private void jProductosItemModificarActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_MODIFICA_PRODUCTO, null);
    }
    private void jProductosItemDetallesActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO, null);
    }
    private void jProductosItemListarActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_LISTA_PRODUCTOS, null);
    }
    //PEDIDOS
    private void jPedidosItemHacerPedidoActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_ALTA_PEDIDO, null);
    }
    private void jPedidosItemRecibirActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_RECIBIR_PEDIDO, null);
    }
    private void jPedidosItemAnularActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_ANULAR_PEDIDO, null);
    }
    private void jPedidosItemListarActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_LISTAR_PEDIDOS, null);
    }
    private void jPedidosItemMostrarActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_MOSTRAR_PEDIDOS, null);
    }
    private void jPedidosItemStockActionPerformed(java.awt.event.ActionEvent evt){
    	this.actualiza(EventoGUI.GUI_LISTAR_STOCK, null);
    }

    //CLIENTES
    private javax.swing.JMenuItem jClientesItemAlta;
    private javax.swing.JMenuItem jClientesItemAltaEmpresa;
    private javax.swing.JMenuItem jClientesItemBaja;
    private javax.swing.JMenuItem jClientesItemDetalles;
    private javax.swing.JMenuItem jClientesItemListar;
    private javax.swing.JMenuItem jClientesItemModificar;
    private javax.swing.JMenu jMenuClientes;
    
	//PROVEEDORES
    private javax.swing.JMenuItem jProveedoresItemAlta;
    private javax.swing.JMenuItem jProveedoresItemBaja;
    private javax.swing.JMenuItem jProveedoresItemDetalles;
    private javax.swing.JMenuItem jProveedoresItemListar;
    private javax.swing.JMenuItem jProveedoresItemModificar;
    private javax.swing.JMenuItem jProveedoresItemVincular;
    private javax.swing.JMenuItem jProveedoresItemDesvincular;
    private javax.swing.JMenu jMenuProveedores;
    
	
    //VENTAS
    private javax.swing.JMenuItem jVentasItemAlta;
    private javax.swing.JMenuItem jVentasItemBaja;
    private javax.swing.JMenuItem jVentasItemDetalles;
    private javax.swing.JMenuItem jVentasItemListar;
    private javax.swing.JMenuItem jVentasItemModificar;
    private javax.swing.JMenu jMenuVentas;
    
    //PRODUCTOS
    private javax.swing.JMenuItem jProductosItemAltaTurismo;
    private javax.swing.JMenuItem jProductosItemAltaMoto;
    private javax.swing.JMenuItem jProductosItemAltaComercial;
    private javax.swing.JMenuItem jProductosItemBaja;
    private javax.swing.JMenuItem jProductosItemDetalles;
    private javax.swing.JMenuItem jProductosItemListar;
    private javax.swing.JMenuItem jProductosItemModificar;
    private javax.swing.JMenu jMenuProductos;
    //PEDIDOS
    private javax.swing.JMenuItem jPedidosItemHacerPedido;
    private javax.swing.JMenuItem jPedidosItemRecibir;
    private javax.swing.JMenuItem jPedidosItemMostrar;
    private javax.swing.JMenuItem jPedidosItemAnular;
    private javax.swing.JMenuItem jPedidosItemListar;
    private javax.swing.JMenuItem jPedidosItemStock;
    private javax.swing.JMenu jMenuPedidos;
    
    
    private javax.swing.JMenuBar jMenuBar1;
    
    private javax.swing.JMenu jOpciones;
    private javax.swing.JMenuItem jOpcionesSalir;
    
    public void actualiza(int evento, Object datos) {
    	String mensaje;
    	switch (evento) {
    	//CLIENTES
    	case EventoGUI.GUI_ALTA_CLIENTE_EMPRESA :
    		GUIClientes.getInstancia().actualiza(EventoGUI.GUI_ALTA_CLIENTE_EMPRESA, null);
    		break;
    	case EventoGUI.GUI_ALTA_CLIENTE :
    		GUIClientes.getInstancia().actualiza(EventoGUI.GUI_ALTA_CLIENTE, null);
    		break;
    	case EventoGUI.GUI_BAJA_CLIENTE :
    		GUIClientes.getInstancia().actualiza(EventoGUI.GUI_BAJA_CLIENTE, null);
    		break;
    	case EventoGUI.GUI_MODIFICA_CLIENTE :
    		GUIClientes.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_CLIENTE, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE :
    		GUIClientes.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE, null);
    		break;
    	case EventoGUI.GUI_LISTA_CLIENTES :
    		Controlador.getInstancia().accion(EventoNegocio.LISTA_CLIENTES, null);
    		break;
		//PROVEEDORES
		case EventoGUI.GUI_ALTA_PROVEEDOR :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_ALTA_PROVEEDOR, null);
    		break;
    	case EventoGUI.GUI_BAJA_PROVEEDOR :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_BAJA_PROVEEDOR, null);
    		break;
    	case EventoGUI.GUI_MODIFICA_PROVEEDOR :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_PROVEEDOR, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR, null);
    		break;
    	case EventoGUI.GUI_LISTA_PROVEEDORES :
    		Controlador.getInstancia().accion(EventoNegocio.LISTA_PROVEEDORES, null);
    		break;
    	case EventoGUI.GUI_VINCULA_PROVEEDORES :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_VINCULA_PROVEEDORES, null);
    		break;
    	case EventoGUI.GUI_DESVINCULA_PROVEEDORES :
    		GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_DESVINCULA_PROVEEDORES, null);
    		break;
    	///VENTAS
    	case EventoGUI.GUI_ALTA_VENTA :
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_ALTA_VENTA, null);
    		break;
    	case EventoGUI.GUI_MODIFICA_VENTA :
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_VENTA, null);
    		break;
    	case EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES :
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES, datos);
    		break;
    	case EventoGUI.GUI_BAJA_VENTA :
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_BAJA_VENTA, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_VENTA:
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_VENTA, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES :
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES, datos);
    		break;
    	case EventoGUI.GUI_LISTA_VENTAS:
    		Controlador.getInstancia().accion(EventoNegocio.LISTA_VENTAS, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_LISTADO_VENTAS:
    		GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_LISTADO_VENTAS, datos);
    		break;
    	//PRODUCTOS
    	case EventoGUI.GUI_ALTA_PRODUCTO_TURISMO:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_ALTA_PRODUCTO_TURISMO, null);
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_MOTO:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_ALTA_PRODUCTO_MOTO, null);
    		break;
    	case EventoGUI.GUI_BAJA_PRODUCTO:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_BAJA_PRODUCTO, null);
    		break;
    	case EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL, null);
    		break;
    	case EventoGUI.GUI_MODIFICA_PRODUCTO:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_PRODUCTO, null);
    		break;
    	case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO:
    		GUIProductos.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO, null);
    		break;
    	case EventoGUI.GUI_LISTA_PRODUCTOS:
    		Controlador.getInstancia().accion(EventoNegocio.LISTA_PRODUCTOS, null);
    		break;
    	//PEDIDOS
    	case EventoGUI.GUI_ALTA_PEDIDO : 
    		GUIPedidos.getInstancia().actualiza(EventoGUI.GUI_ALTA_PEDIDO_COMPROBAR, null);
    		break;
    	case EventoGUI.GUI_ANULAR_PEDIDO : 
    		GUIPedidos.getInstancia().actualiza(evento, null);
    		break;
    	case EventoGUI.GUI_RECIBIR_PEDIDO :
    		GUIPedidos.getInstancia().actualiza(evento, null);
    		break;
    	case EventoGUI.GUI_MOSTRAR_PEDIDOS :
    		GUIPedidos.getInstancia().actualiza(evento, null);
    		break;
    	case EventoGUI.GUI_LISTAR_PEDIDOS :
    		Controlador.getInstancia().accion(EventoNegocio.LISTAR_PEDIDOS, null);
    		break;
    	case EventoGUI.GUI_LISTAR_STOCK :
    		Controlador.getInstancia().accion(EventoNegocio.LISTAR_STOCK, null);
    		break;
    		
    	//MENSAJES
    	case EventoGUI.GUI_MENSAJE_ALTA_CORRECTO :
    		mensaje = "Registro insertado con éxito. Su nuevo id es " + datos + ".";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	case EventoGUI.GUI_MENSAJE_ALTA_ERROR :
    		mensaje = "El registro está ya dado de alta. Su id es " + (int)(-(Integer)datos) + ".";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	case EventoGUI.GUI_MENSAJE_BAJA_CORRECTO :
    		mensaje = "Registro borrado con éxito.";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	case EventoGUI.GUI_MENSAJE_MODIFICA_CORRECTO :
    		mensaje = "Registro modificado con éxito.";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	case EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR :
			JOptionPane.showMessageDialog(null,"El registro solicitado no existe o está dado de baja.");
			break;
    	case EventoGUI.GUI_MENSAJE_BAJA_ERROR :
    		mensaje = "El registro no existe, ya está dado de baja o tiene dependencias activas.";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	case EventoGUI.GUI_MENSAJE_VENTA_NO_EXISTE :
    		mensaje = "El registro solicitado no existe o está dado de baja.";
    		JOptionPane.showMessageDialog(null,mensaje);
    		break;
    	 case EventoGUI.GUI_MENSAJE_VENTA_NO_HAY_VENTAS :
    			mensaje = "No existen ventas registradas en este momento";
    			JOptionPane.showMessageDialog(null,mensaje);
    			break;
    	 case EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA :
    		 	GUIVentas.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA, datos);
    			
    			break;
    	 case EventoGUI.GUI_VINCULA_PROVEEDORES_ERROR_PROVEEDOR :
    		 mensaje = "Hubo un error al vincular el proveedor.";
 			 JOptionPane.showMessageDialog(null,mensaje);
    		 break;
    	 case EventoGUI.GUI_VINCULA_PROVEEDORES_ERROR_PRODUCTO :
    		 mensaje = "Hubo un error al vincular el producto.";
 			 JOptionPane.showMessageDialog(null,mensaje);
    		 break;
    	 case EventoGUI.GUI_VINCULA_PROVEEDORES_CORRECTO :
    		 mensaje = "La vinculación se realizó con éxito.";
 			 JOptionPane.showMessageDialog(null,mensaje);
    		 break;
	    case EventoGUI.GUI_DESVINCULA_PROVEEDORES_ERROR_PROVEEDOR :
			 mensaje = "Hubo un error al desvincular el proveedor.";
			 JOptionPane.showMessageDialog(null,mensaje);
			 break;
		 case EventoGUI.GUI_DESVINCULA_PROVEEDORES_ERROR_PRODUCTO :
			 mensaje = "Hubo un error al desvincular el producto.";
			 JOptionPane.showMessageDialog(null,mensaje);
			 break;
		 case EventoGUI.GUI_DESVINCULA_PROVEEDORES_CORRECTO :
			 mensaje = "La desvinculación se realizó con éxito.";
			 JOptionPane.showMessageDialog(null,mensaje);
			 break;
		 case EventoGUI.GUI_MENSAJE_BAJA_ERROR_VINCULADO :
			 mensaje = "No puede darse de baja el producto; está vinculado al proveedor " +datos;
			 JOptionPane.showMessageDialog(null, mensaje);
			 break;
		 case EventoGUI.GUI_MENSAJE_BAJA_ERROR_PEDIDO :
			 mensaje = "No puede darse de baja el producto; está pendiente de recepción en el pedido "+datos;
			 JOptionPane.showMessageDialog(null, mensaje);
			 break;
	    case EventoGUI.GUI_MENSAJE_ANULAR_CORRECTO :
		   	 JOptionPane.showMessageDialog(null, "El pedido con id "+datos.toString()+" ha sido anulado.");
		   	 break;
	    case EventoGUI.GUI_MENSAJE_ERROR_PROVEEDOR :
	       	 JOptionPane.showMessageDialog(null, "El proveedor con id "+datos.toString()+" no existe.");
			 break;
	    case EventoGUI.GUI_MENSAJE_ALTA_PEDIDO :
	       	 InterfazTransferRespuesta respuesta;
	       	 respuesta = (InterfazTransferRespuesta)datos;
	       	 for ( int i=0 ; i<respuesta.getNotas().size() ; i++) {
	       		 JOptionPane.showMessageDialog(null, respuesta.getNotas().get(i));
	       	 }
	       	 break;
	    case EventoGUI.GUI_MENSAJE_ERROR_PEDIDO :
	    	JOptionPane.showMessageDialog(null, "El pedido con id "+datos.toString()+" no existe.");
	    	break;
	    case EventoGUI.GUI_MENSAJE_PEDIDO_RECIBIDO :
	    	JOptionPane.showMessageDialog(null, "El pedido con id "+datos.toString()+" se ha recibido correctamente. El stock ha sido actualizado.");
	    	break;
    	}
    }
}
