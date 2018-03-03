package concesionario.integracion.xml;


import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.util.ArrayList;

public class AccesoXml {
    private String id;
    private String ruta;
    private String entidad;
    private ArrayList<String> estructura;
    public AccesoXml(String id,String ruta,String entidad,ArrayList<String> estructura) { 
    	this.id = id;
    	this.ruta = ruta;
    	this.entidad = entidad;
    	this.estructura = estructura;
    }

/**
 * Acceso al contenido de un fichero XML
 * @param filename la ruta del fichero
 * @return el contenido del XML, null si hubo fallo
 */    
    private Document readFile(String filename) {
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new File(filename));
        return doc;
    }catch(java.lang.Exception e){
        return null;
    }
    }

/**
 * Escritura interna del documento
 * @param doc el objeto documento a guardar
 * @param filename la ruta completa del archivo de salida
 */
    private void writeFile(Document doc, String filename) {
    try {
        Source source = new DOMSource(doc);
        //File file = new File(filename);
        Result result = new StreamResult(filename);
        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        //formato de salida del documento
        xformer.setOutputProperty(OutputKeys.INDENT, "yes");
        xformer.setOutputProperty(OutputKeys.METHOD, "xml");
        xformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
 
        xformer.transform(source, result);
    }catch(java.lang.Exception e){
        System.out.println(e);
    }
    }
/**
 * Busqueda de un nodo con un campo y un valor deseados, en una lista
 * @param lista lista de nodos a procesar
 * @param atributo El atributo a buscar
 * @param valorAtributo El valor que debe tener el atributo
 * @return el nodo encontrado, null si no existe.
 */
    private Node buscaNodo(NodeList lista,String atributo,String valorAtributo){
        //busqueda lineal
        for(int i = 0;i<lista.getLength();i++){
                Element elemento = (Element)lista.item(i);//entidad
                NodeList campos =elemento.getElementsByTagName(atributo);//campos
                Node campo = campos.item(0);
                if(valorAtributo.equals(campo.getTextContent())) 
                    return lista.item(i);//encontrado
        }
        return null; //no encontrado
    }
/**
 * busqueda de entidad con id especifico
 * @param doc documento del xml
 * @param id El valor de identificador
 * @return la entidad pedida, null si no se encontro
 */
    private Element dameEntidad(Document doc,String id){
         Element raiz =(Element)doc.getDocumentElement();//datos
         NodeList list = raiz.getElementsByTagName(this.entidad);//entidades
         Element elemento = (Element) buscaNodo(list,this.id,id);
         return elemento; //null si no existe
    }

/**
 * Dada una entidad, devuelve el valor de un atributo conocido
 * @param elemento el elemento que contiene la entidad
 * @param atributo el nombre del atributo a consultar
 * @return el conenido del atributo
 */
    private String dameContenidoAtributo(Element elemento,String atributo){
        NodeList campos = elemento.getElementsByTagName(atributo);//campos
        if(campos.getLength() >0){//solo debe de haber uno
            Node campo = campos.item(0);
            return campo.getTextContent(); //el contenido
        }return null;//error si repeticion
    }
 /**
 * actualiza el valor de UN SOLO atributo
 * @param elemento El elemetno a modificar
 * @param atributo El campo a modificar
 * @param nuevoValor EL nuevo valor
 */
    private void setContenidoAtributo(Element elemento,String atributo,String nuevoValor){
        NodeList campos = elemento.getElementsByTagName(atributo);//campos
        if(campos.getLength() >0){//si hay mas de uno, no se modifica
            Node campo = campos.item(0);
           campo.setTextContent(nuevoValor); //actualizado!
        };
    }
/**
 * Actualiza el contenido de una entidad. Los nuevos valores se insertan
 * en orden, menos el identificador. Si se tiene menos valores que campos
 * en la entidad, se rellenan a caracter balnco.
 * @param elemento Entidad a actualizar
 * @param campos Lista con los nuevos valores
 */
    private void setContenidoAtributo(Element elemento,ArrayList campos){
        int numAtributos = 0;
        NodeList list = elemento.getChildNodes(); //campos del elemento
        for(int i = 0;i<list.getLength();i++){
            Node campo = list.item(i); //campo actual
            if(!campo.getNodeName().equals("#text") && //no es contenido
               !campo.getNodeName().equals(this.id)){ //no es id
                String nuevoValor = " "; numAtributos++;
                if(numAtributos <= campos.size()){
                    //si quedan elementos en campos, se carga el actual
                    nuevoValor = (String)campos.get(numAtributos-1);
                }
                campo.setTextContent(nuevoValor);//caracter blanco si
            }//if                               //campos vacio
        }//for
    }

/**
 * Dada una entidad, devuelve el valor de TODOS sus atributos
 * @param elemento el elemento que contiene la entidad
 * @return una lista con todos los atributos 
 */
     private ArrayList<String> dameContenidoAtributo(Element elemento){
        //Uso de template necesario para operacion segura
        ArrayList<String> salida = new ArrayList<String>();
        NodeList list = elemento.getChildNodes();
        for(int i = 0;i<list.getLength();i++){
            Node campo = list.item(i);
            if(! campo.getNodeName().equals("#text")){
                //es un campo de valor
                salida.add(campo.getTextContent());
            }
        }
        return salida;
    }
     
/**
 * Lectura de un atributo.
 * @param id el identificador de la identidad buscada
 * @param atributo
 * @return el campo que se quiere consultar de la entidad
 */
    public String getAtributo(String id,String atributo){
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        if(doc != null){
            Element elemento = dameEntidad(doc,id);        
            if(elemento != null){
                return dameContenidoAtributo(elemento,atributo);
            }return null; //no existe elemento con tal identificador
        }
        return null;//no existe el archivo xml
    }
/**
 * Lectura de todos los atributos de una entidad
 * @param id
 * @return el identificador de la identidad buscada
 */
    public ArrayList<String> getAtributo(String id){
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        if(doc != null){
        Element elemento = dameEntidad(doc,id);   
            if(elemento != null){
              return dameContenidoAtributo(elemento);
            }return null; //no existe elemento con tal identificador
        }
        return null;//no existe el archivo xml
    }
/**
 * Escritura de datos
 * @param id el identificador de la identidad buscada
 * @param atributo el campo que se quiere actualizar de la entidad
 * @param nuevoValor el nuevo valor a insertar
 */
    public void setAtributo(String id,String atributo,String nuevoValor){
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        if(doc != null){
            Element elemento = dameEntidad(doc,id);
            if(elemento != null){
                setContenidoAtributo(elemento,atributo,nuevoValor);
            }
        }
        writeFile(doc, this.ruta+"\\"+this.entidad+".xml");
    }
 /**
 * Escritura de datos
 * @param id el identificador de la identidad buscada
 * @param campos Lista de los nuevos valores
 */
     public void setAtributo(String id,ArrayList campos){
      Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        if(doc != null){
            Element elemento = dameEntidad(doc,id);
            if(elemento != null){
                setContenidoAtributo(elemento,campos);
            }
        }
        writeFile(doc, this.ruta+"\\"+this.entidad+".xml");
     }

/**
 * Escritura de datos
 * @param id el identificador de la identidad buscada
 * @param campos Lista de los nuevos valores
 * @param estructura Nueva estructura
 */
     public void setAtributo(String id,ArrayList campos,ArrayList estructura){
       Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
         if(doc != null){
        	 //obtenemos la entidad
             Element elemento = dameEntidad(doc,id);
             if(elemento != null){
                 NodeList lista = elemento.getChildNodes();
                 //la vaciamos
                 while(lista.getLength()>0){
                	 elemento.removeChild(lista.item(0));
                 }
                 //Creamos los campos y la rellenamos
                 for(int i=0;i<estructura.size();i++){
                	 Element campo = doc.createElement((String)estructura.get(i));
                	 if(i == 0){//el identificador
                		 campo.setTextContent(id);
                	 }else{//campos modificables
                		 if(campos.size()> i){
                			 campo.setTextContent((String)campos.get(i));
                		 }else campo.setTextContent(" ");
                	 }
                	 elemento.appendChild(campo);
                 }
             }
         }
         writeFile(doc, this.ruta+"\\"+this.entidad+".xml");
      }
/**
 * Para obtener la cardinalidad del fichero
 * @return el numero de elementoS
 */
     public int numElem(){
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        Element raiz =(Element)doc.getDocumentElement();//datos
        NodeList list = raiz.getElementsByTagName(this.entidad);//entidades
        return list.getLength(); 
     }
/**
 * Anyade una nueva entrada VACIA al fichero. Se le asigna una nueva id.
 * @return el nuevo id
 */
     public int nuevaEntidad(){
        //acceso al xml
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        
        //carga del contenido de datos
        Element raiz =(Element)doc.getDocumentElement();//datos
        
        //calculo del nuevo id
        NodeList list = raiz.getElementsByTagName(this.entidad);//entidades
        int nuevoId = list.getLength()+1;
        
        //entidad nueva a insertar 
        Element nuevaEntrada = doc.createElement(this.entidad);
        
        for(int i = 0;i<this.estructura.size();i++){
           Element campo = doc.createElement(this.estructura.get(i));
           if(i== 0)//identificador es privado
              campo.setTextContent(Integer.toString(nuevoId));
           else
               //no crearlo vacio! poner al menos un blanco
               campo.setTextContent(" ");
           //se anyade a la nueva entrada
           nuevaEntrada.appendChild(campo);
        }
        
        //Se inserta en datos
        raiz.appendChild(nuevaEntrada);
        
        //Escritura en el documento
        writeFile(doc, this.ruta+"\\"+this.entidad+".xml");
        return nuevoId;
     }
     
/**
 * Crea una nueva endidad en el archivo XML, con un id predeterminado.
 * Se anyade con la estructura que se definio en la creacion de la clase,
 * con sus valores vacios. No se comprueba si el id ya existia.
 * @param id nuevo id
 */
     public void nuevaEntidad(String id){
        //acceso al xml
        Document doc = readFile(this.ruta+"\\"+this.entidad+".xml");
        
        //carga del contenido de datos
        Element raiz =(Element)doc.getDocumentElement();//datos
        
        //entidad nueva a insertar 
        Element nuevaEntrada = doc.createElement(this.entidad);
        
        for(int i = 0;i<estructura.size();i++){
           Element campo = doc.createElement(this.estructura.get(i));
           if(i== 0)//identificador es privado
              campo.setTextContent(id);
           else
               //no crearlo vacio! poner al menos un blanco
               campo.setTextContent(" ");
           //se anyade a la nueva entrada
           nuevaEntrada.appendChild(campo);
        }
        
        //Se inserta en datos
        raiz.appendChild(nuevaEntrada);
        
        //Escritura en el documento
        writeFile(doc, this.ruta+"\\"+this.entidad+".xml");
     }
}
