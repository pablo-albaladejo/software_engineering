
package concesionario.presentacion.controlador;

import java.util.ArrayList;

import concesionario.logica.factoria.FactoriaServicio;
import concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;
import concesionario.presentacion.clientes.GUIClientes;
import concesionario.presentacion.vista.GUIConcesionario;
import concesionario.presentacion.pedidos.GUIPedidos;
import concesionario.presentacion.productos.GUIProductos;
import concesionario.presentacion.proveedores.GUIProveedores;

public class ControladorImp extends Controlador {
    
    public ControladorImp() {
    }
    
    public void accion(int evento, Object datos) {
    	int id;
    	int resultado;
    	ArrayList<InterfazTransferClientes> listaclientes;
    	ArrayList<InterfazTransferProveedores> listaProveedores;
    	ArrayList<InterfazTransferProductos>listaproductos;
    	InterfazTransferClientes cliente;
    	InterfazTransferVentas venta;
    	InterfazTransferProductos producto;
    	InterfazTransferRespuesta respuesta;
    	InterfazTransferProveedores proveedor;
    	
    	switch (evento) {
            case EventoNegocio.INICIA_APLICACION :
                GUIConcesionario.getInstancia().setVisible(true);
                break;
            case EventoNegocio.FIN_APLICACION :
                System.exit(0);
                
            //CLIENTES
            case EventoNegocio.ALTA_CLIENTE :
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().altaCliente((InterfazTransferClientes)datos);
            	if (id > 0 ) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ALTA_CORRECTO, id);
            	else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ALTA_ERROR, id);
            	break;
            case EventoNegocio.BAJA_CLIENTE :
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().bajaCliente((Integer)datos);
            	if ( id > 0 ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_CORRECTO, id);
            	} else {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR, id);
            	}
            	break;
            case EventoNegocio.MODIFICA_CLIENTE:
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().modificaCliente((InterfazTransferClientes)datos);
            	if ( id > 0 ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_CORRECTO, id);
            	} else{
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_ERROR, id);
            	}
            	break;
            case EventoNegocio.MUESTRA_DETALLES_CLIENTE :
            	cliente = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesCliente((Integer)datos);
            	if ( cliente == null ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
        		} else {
        			GUIClientes.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE_CORRECTO, cliente);
        		}
            	break;
            case EventoNegocio.MUESTRA_DETALLES_CLIENTE_MODIFICAR :
            	cliente = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesCliente((Integer)datos);
            	if ( cliente == null ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
        		} else {
        			GUIClientes.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE_MODIFICAR_CORRECTO, cliente);
        		}
            	break;
            case EventoNegocio.LISTA_CLIENTES :
            	listaclientes = FactoriaServicio.getInstancia().dameFachadaNegocio().listaClientes();
            	GUIClientes.getInstancia().actualiza(EventoGUI.GUI_LISTA_CLIENTES,listaclientes);
            	break;
			//PROVEEDORES
            case EventoNegocio.ALTA_PROVEEDOR :
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().altaProveedor((InterfazTransferProveedores)datos);
            	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ALTA_CORRECTO, id);
            	break;
            case EventoNegocio.BAJA_PROVEEDOR :
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().bajaProveedor((Integer)datos);
            	if ( id > 0 ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_CORRECTO, id);
            	} else {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR, id);
            	}
            	break;
            case EventoNegocio.MODIFICA_PROVEEDOR:
            	id = FactoriaServicio.getInstancia().dameFachadaNegocio().modificaProveedor((InterfazTransferProveedores)datos);
            	if ( id > 0 ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_CORRECTO, id);
            	} else{
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_ERROR, id);
            	}
            	break;
            case EventoNegocio.MUESTRA_DETALLES_PROVEEDOR :
            	proveedor = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesProveedor((Integer)datos);
            	if ( proveedor == null ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
        		} else {
        			GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR_CORRECTO, proveedor);
        		}
            	break;
            case EventoNegocio.MUESTRA_DETALLES_PROVEEDOR_MODIFICAR :
            	proveedor = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesProveedor((Integer)datos);
            	if ( proveedor == null ) {
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
        		} else {
        			GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR_MODIFICAR_CORRECTO, proveedor);
        		}
            	break;
            case EventoNegocio.LISTA_PROVEEDORES :
            	listaProveedores = FactoriaServicio.getInstancia().dameFachadaNegocio().listaProveedores();
            	GUIProveedores.getInstancia().actualiza(EventoGUI.GUI_LISTA_PROVEEDORES,listaProveedores);
            	break;
            case EventoNegocio.VINCULA_PROVEEDORES :
            	resultado = FactoriaServicio.getInstancia().dameFachadaNegocio().vinculaProveedor((InterfazTransferVinculo)datos);
            	if(resultado < 0){ //fallo producto
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_VINCULA_PROVEEDORES_ERROR_PRODUCTO,null);
            	}else if(resultado == 0){//fallo proveedor
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_VINCULA_PROVEEDORES_ERROR_PROVEEDOR, null);
            	}else{//Todo ok!
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_VINCULA_PROVEEDORES_CORRECTO, null);
            	}
            	
            	break;
            case EventoNegocio.DESVINCULA_PROVEEDORES :
            	resultado = FactoriaServicio.getInstancia().dameFachadaNegocio().desvinculaProveedor((InterfazTransferVinculo)datos);
            	if(resultado < 0){ //fallo producto
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_DESVINCULA_PROVEEDORES_ERROR_PRODUCTO,null);
            	}else if(resultado == 0){//fallo proveedor o no estaba vinculado
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_DESVINCULA_PROVEEDORES_ERROR_PROVEEDOR, null);
            	}else{//Todo ok!
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_DESVINCULA_PROVEEDORES_CORRECTO, null);
            	}
            	
            	break;	
            //VENTAS
            case EventoNegocio.ALTA_VENTA:
            	respuesta = FactoriaServicio.getInstancia().dameFachadaNegocio().altaVenta((InterfazTransferVentas)datos);
            	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA, respuesta);
            	break;	
            case EventoNegocio.BAJA_VENTA:
            	id=Integer.valueOf((String)datos);
            	boolean bajaCorrecta=FactoriaServicio.getInstancia().dameFachadaNegocio().bajaVenta(id,true);
            	if (bajaCorrecta){
            		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_CORRECTO, id);
            	}
            	else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR, id);
            	break;
            case EventoNegocio.MODIFICA_VENTA:
            	venta = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesVentaModificar(Integer.valueOf((String)datos));
            	if (venta!=null) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES, venta);
            	else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_NO_EXISTE, Integer.valueOf((String)datos));
            	
            	break;
            case EventoNegocio.MODIFICA_VENTA_INSERTA_DATOS:
            	respuesta = FactoriaServicio.getInstancia().dameFachadaNegocio().modificaVenta((InterfazTransferVentas)datos);
            	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA, respuesta);
            	break;
            case EventoNegocio.MUESTRA_DETALLES_VENTA:
            	id=Integer.valueOf((String)datos);
            	venta = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesVenta(id);
            	if (venta!=null) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES, venta);
            	else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_NO_EXISTE, id);
            	
            	break;
            case EventoNegocio.LISTA_VENTAS:
            	ArrayList<InterfazTransferVentas> listaVentas=FactoriaServicio.getInstancia().dameFachadaNegocio().listaVentas();
            	if (listaVentas.size()>0) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_LISTADO_VENTAS, listaVentas);
            	else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_VENTA_NO_HAY_VENTAS, listaVentas);
            	break;
            
            //PRODUCTOS
           case EventoNegocio.ALTA_PRODUCTO:
            	id=FactoriaServicio.getInstancia().dameFachadaNegocio().altaProducto((InterfazTransferProductos)datos);
            	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ALTA_CORRECTO, id);
            	break;
           case EventoNegocio.BAJA_PRODUCTO:
        	    id=FactoriaServicio.getInstancia().dameServicioProveedores().buscaProducto((Integer)datos);
        	    if(id>0)
        	    	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR_VINCULADO,id);
        	    else{
        	    	id=FactoriaServicio.getInstancia().dameServicioPedidos().buscaProducto((Integer)datos);
        	    	if(id>0)
        	    		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR_PEDIDO, id);
        	    	else{
        	    		id=FactoriaServicio.getInstancia().dameFachadaNegocio().bajaProducto((Integer)datos);
        	    		if (id>0)
        	    			GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_CORRECTO, id);
        	    		else
        	    			GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_BAJA_ERROR, id);
        	    	}
        	    }
        	    break;
           case EventoNegocio.MODIFICA_PRODUCTO:
        	   	id=FactoriaServicio.getInstancia().dameFachadaNegocio().modificaProducto((InterfazTransferProductos)datos);
        	   	if(id>0)
        	   		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_CORRECTO, id);
        	   	else
        	   		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MODIFICA_ERROR, id);
            	break;
           case EventoNegocio.LISTA_PRODUCTOS:
        	    listaproductos=FactoriaServicio.getInstancia().dameServicioProductos().listaProductos();
        	    GUIProductos.getInstancia().actualiza(EventoGUI.GUI_LISTA_PRODUCTOS, listaproductos);
        	    break;
           case EventoNegocio.MUESTRA_DETALLES_PRODUCTO:
        	    producto=FactoriaServicio.getInstancia().dameFachadaNegocio().detallesProducto((Integer)datos);
        	    if(producto==null){
        	    	GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
        	    }else{
        	    	GUIProductos.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO,producto );
        	    }
        	    	break;
           case EventoNegocio.MUESTRA_DETALLES_PRODUCTO_MODIFICAR :
        	   	producto = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesProducto((Integer)datos);
	        	if ( producto == null||!producto.getActivo() ) {
	        		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_MUESTRA_DETALLES_ERROR, null);
	    		} else {
	    			GUIProductos.getInstancia().actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_MODIFICAR_CORRECTO, producto);
	    		}
	        	break;
	        //PEDIDOS
           case EventoNegocio.COMPRUEBA_PROVEEDOR_ALTA :
        	   	InterfazTransferProveedores p = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesProveedor((Integer)datos);
        	   	if ( p == null )
        	   		GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ERROR_PROVEEDOR, (Integer)datos);
        	   	else {
        	   		GUIPedidos.getInstancia().actualiza(EventoGUI.GUI_ALTA_PEDIDO, p.getIdentificador());
        	   	}
        	   	break;
           case EventoNegocio.ALTA_PEDIDO :
        	   InterfazTransferRespuesta respuestaPedido;
        	   respuestaPedido = FactoriaServicio.getInstancia().dameFachadaNegocio().altaPedido((InterfazTransferPedidos)datos);
        	   GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ALTA_PEDIDO, respuestaPedido);
        	   break;
           case EventoNegocio.ANULAR_PEDIDO : 
	       		int res;
	       		res = FactoriaServicio.getInstancia().dameFachadaNegocio().anularPedido((Integer)datos);
	       		if ( res == 0 ) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ERROR_PROVEEDOR, datos);
	       		else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ANULAR_CORRECTO, datos);
	       		break;
           case EventoNegocio.RECIBIR_PEDIDO : 
	       		int resp;
	       		resp = FactoriaServicio.getInstancia().dameFachadaNegocio().recibirPedido((Integer)datos);
	       		if ( resp == 0 ) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ERROR_PEDIDO, datos);
	       		else GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_PEDIDO_RECIBIDO, datos);
	       		break;
           case EventoNegocio.MOSTRAR_PEDIDOS : 
	       		InterfazTransferPedidos pedido;
	       		pedido = FactoriaServicio.getInstancia().dameFachadaNegocio().detallesPedido((Integer)datos);
	       		if ( pedido == null ) GUIConcesionario.getInstancia().actualiza(EventoGUI.GUI_MENSAJE_ERROR_PEDIDO, datos);
	       		else GUIPedidos.getInstancia().actualiza(EventoGUI.GUI_MOSTRAR_DETALLES_PEDIDO, pedido);
	       		break;
           case EventoNegocio.LISTAR_PEDIDOS :
        	   	GUIPedidos.getInstancia().actualiza(EventoGUI.GUI_LISTAR_PEDIDOS, FactoriaServicio.getInstancia().dameFachadaNegocio().listaPedidos());
        	   	break;
           case EventoNegocio.LISTAR_STOCK :
	       	   	GUIPedidos.getInstancia().actualiza(EventoGUI.GUI_LISTAR_STOCK, FactoriaServicio.getInstancia().dameFachadaNegocio().listaStock());
	       	   	break;
        	}
    }
}
