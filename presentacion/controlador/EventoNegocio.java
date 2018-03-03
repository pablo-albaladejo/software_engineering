/*
 * EventoNegocio.java
 *
 * Created on 1 de abril de 2008, 17:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package concesionario.presentacion.controlador;

/**
 *
 * @author Pablo
 */
public class EventoNegocio {
    
    public static final int FIN_APLICACION = 0;
    public static final int INICIA_APLICACION = 1;
    
    //Eventos de clientes
    public static final int ALTA_CLIENTE = 101;
    public static final int BAJA_CLIENTE = 102;
    public static final int MODIFICA_CLIENTE = 103;
    public static final int MUESTRA_DETALLES_CLIENTE = 104;
    public static final int MUESTRA_DETALLES_CLIENTE_MODIFICAR = 105;
    public static final int LISTA_CLIENTES = 107;
    
	//  Eventos de proveedores
    public static final int ALTA_PROVEEDOR = 201;
    public static final int BAJA_PROVEEDOR = 202;
    public static final int MODIFICA_PROVEEDOR = 203;
    public static final int MUESTRA_DETALLES_PROVEEDOR = 204;
    public static final int MUESTRA_DETALLES_PROVEEDOR_MODIFICAR = 205;
    public static final int LISTA_PROVEEDORES = 207;
    public static final int VINCULA_PROVEEDORES = 208;
    public static final int DESVINCULA_PROVEEDORES = 209;
	
	//Eventos de productos
    public static final int ALTA_PRODUCTO = 301;
    public static final int BAJA_PRODUCTO = 302;
    public static final int MODIFICA_PRODUCTO = 303;
    public static final int MUESTRA_DETALLES_PRODUCTO = 304;
    public static final int LISTA_PRODUCTOS = 305;
    public static final int MUESTRA_DETALLES_PRODUCTO_MODIFICAR = 306;
	
    //Eventos de ventas
    public static final int ALTA_VENTA = 401;
    public static final int BAJA_VENTA = 402;
    public static final int MODIFICA_VENTA = 403;
    public static final int MODIFICA_VENTA_INSERTA_DATOS = 406;
    public static final int MUESTRA_DETALLES_VENTA = 404;
    public static final int LISTA_VENTAS = 405;
    
//  Pedidos
    public static final int ALTA_PEDIDO = 501;
    public static final int RECIBIR_PEDIDO = 502;
    public static final int ANULAR_PEDIDO = 503;
    public static final int LISTAR_PEDIDOS = 504;
    public static final int COMPRUEBA_PROVEEDOR_ALTA = 505;
    public static final int MOSTRAR_PEDIDOS = 506;
    public static final int LISTAR_STOCK = 507;

}


