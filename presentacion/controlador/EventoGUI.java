/*
 * EventoGUI.java
 *
 * Created on 3 de abril de 2008, 0:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package concesionario.presentacion.controlador;

/**
 *
 * @author Pablo
 */
public class EventoGUI {
    
    //Eventos de clientes
    public static final int GUI_ALTA_CLIENTE = 1001;
    public static final int GUI_ALTA_CLIENTE_EMPRESA = 1002;
    public static final int GUI_BAJA_CLIENTE = 1003;
    public static final int GUI_MODIFICA_CLIENTE = 1004;
    public static final int GUI_MUESTRA_DETALLES_CLIENTE = 1005;
    public static final int GUI_MUESTRA_DETALLES_CLIENTE_CORRECTO = 1006;
    public static final int GUI_LISTA_CLIENTES = 1007;
    public static final int GUI_MUESTRA_DETALLES_CLIENTE_MODIFICAR = 1009;
    public static final int GUI_MUESTRA_DETALLES_CLIENTE_MODIFICAR_CORRECTO = 1010;
    
    public static final int GUI_MENSAJE_ALTA_CORRECTO = 1017;
    public static final int GUI_MENSAJE_ALTA_ERROR = 1018;
    public static final int GUI_MENSAJE_BAJA_CORRECTO = 1019;
    public static final int GUI_MENSAJE_BAJA_ERROR = 1020;
    public static final int GUI_MENSAJE_MODIFICA_CORRECTO = 1021;
    public static final int GUI_MENSAJE_MODIFICA_ERROR = 1022;
    public static final int GUI_MENSAJE_MUESTRA_DETALLES_ERROR = 1023;
    
	//  Eventos de proveedores
    public static final int GUI_ALTA_PROVEEDOR = 2001;
    public static final int GUI_BAJA_PROVEEDOR = 2003;
    public static final int GUI_MODIFICA_PROVEEDOR = 2004;
    public static final int GUI_MUESTRA_DETALLES_PROVEEDOR = 2005;
    public static final int GUI_MUESTRA_DETALLES_PROVEEDOR_CORRECTO = 21006;
    public static final int GUI_LISTA_PROVEEDORES = 2007;
    public static final int GUI_MUESTRA_DETALLES_PROVEEDOR_MODIFICAR = 2009;
    public static final int GUI_MUESTRA_DETALLES_PROVEEDOR_MODIFICAR_CORRECTO = 2010;
    public static final int GUI_VINCULA_PROVEEDORES = 2011;
    public static final int GUI_VINCULA_PROVEEDORES_CORRECTO = 2012;
    public static final int GUI_VINCULA_PROVEEDORES_ERROR_PRODUCTO = 2013;
    public static final int GUI_VINCULA_PROVEEDORES_ERROR_PROVEEDOR = 2014;
    public static final int GUI_DESVINCULA_PROVEEDORES = 2015;
    public static final int GUI_DESVINCULA_PROVEEDORES_CORRECTO = 2016;
    public static final int GUI_DESVINCULA_PROVEEDORES_ERROR_PRODUCTO = 2017;
    public static final int GUI_DESVINCULA_PROVEEDORES_ERROR_PROVEEDOR = 2018;
    
	//Productos
    public static final int GUI_ALTA_PRODUCTO_TURISMO = 3001;
    public static final int GUI_ALTA_PRODUCTO_MOTO = 3002;
    public static final int GUI_ALTA_PRODUCTO_COMERCIAL = 3003;
    public static final int GUI_BAJA_PRODUCTO = 3004;
    public static final int GUI_MUESTRA_DETALLES_PRODUCTO= 3005;
    public static final int GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO= 3006;
    public static final int GUI_MUESTRA_DETALLES_PRODUCTO_MODIFICAR = 3007;
    public static final int GUI_MUESTRA_DETALLES_PRODUCTO_MODIFICAR_CORRECTO = 3010;
    public static final int GUI_LISTA_PRODUCTOS = 3008;
    public static final int GUI_MODIFICA_PRODUCTO = 3009;
    public static final int GUI_MENSAJE_BAJA_ERROR_VINCULADO = 3011;
    public static final int GUI_MENSAJE_BAJA_ERROR_PEDIDO = 3012;
	
    //Ventas
    public static final int GUI_ALTA_VENTA = 4001;
    public static final int GUI_BAJA_VENTA = 4002;
    public static final int GUI_MODIFICA_VENTA = 4003;
    public static final int GUI_MODIFICA_VENTA_RECUPERAR_DETALLES = 4012;
    public static final int GUI_MODIFICA_VENTA_REENVIAR_DATOS = 4013;    
    public static final int GUI_MUESTRA_DETALLES_VENTA = 4004;
    public static final int GUI_MUESTRA_VENTA_RECUPERAR_DETALLES = 4014;
    public static final int GUI_LISTA_VENTAS = 4005;
    public static final int GUI_LISTA_VENTAS_RECUPERAR_DETALLES = 4015;
    public static final int GUI_MENSAJE_ALTA_VENTA_CORRECTO = 4006;
    public static final int GUI_MENSAJE_ALTA_VENTA_ERROR = 4007;
    public static final int GUI_MENSAJE_MODIFICA_VENTA_CORRECTO = 4008;
    public static final int GUI_MENSAJE_MODIFICA_VENTA_ERROR = 4009;
    public static final int GUI_MUESTRA_DETALLES_VENTA_CORRECTO = 4010;
    public static final int GUI_MUESTRA_LISTADO_VENTAS = 4011;
    public static final int GUI_MENSAJE_VENTA_RESPUESTA = 4016;
    public static final int GUI_MENSAJE_VENTA_NO_EXISTE = 4017;
    public static final int GUI_MENSAJE_VENTA_NO_HAY_VENTAS = 4018;
    //Pedidos
    public static final int GUI_ALTA_PEDIDO = 5001;
    public static final int GUI_RECIBIR_PEDIDO = 5002;
    public static final int GUI_ANULAR_PEDIDO = 5003;
    public static final int GUI_LISTAR_PEDIDOS = 5004;
    public static final int GUI_MENSAJE_ERROR_PROVEEDOR = 5005;
    public static final int GUI_MENSAJE_ALTA_PEDIDO = 5006;
    public static final int GUI_MENSAJE_ANULAR_CORRECTO = 5007;
    public static final int GUI_MENSAJE_ERROR_PEDIDO = 5008;
    public static final int GUI_MENSAJE_PEDIDO_RECIBIDO = 5009;
    public static final int GUI_MOSTRAR_PEDIDOS = 5010;
    public static final int GUI_MOSTRAR_DETALLES_PEDIDO = 5011;
    public static final int GUI_LISTAR_STOCK = 5012;
    public static final int GUI_ALTA_PEDIDO_COMPROBAR = 5013;
}
