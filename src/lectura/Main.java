package lectura;

import modelos.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File ficheroEmpleadosXML = new File("empleados.xml");
        // Parsear el fichero XML => NO leo paso el fichero PASO a PASO
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        // Ahora cargo dentro de una variable Documento (DOM)
        Document document = db.parse(ficheroEmpleadosXML);
        // Limpio los nodos para una mejor visualización
        document.getDocumentElement().normalize();

        System.out.println("Raiz del documento: "+document.getDocumentElement().getNodeName());

        // Obtenemos la lista de nodos
        NodeList nodos = document.getElementsByTagName("empleado");

        for (int i = 0; i < nodos.getLength(); i++) {
            // Extraigo el nodo
            Node nodo = nodos.item(i);
            System.out.println("elemento: "+nodo.getNodeName());
            // Compruebo que tienen hijos dentro
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element empleado = (Element) nodo;
                // ATRIBUTOS
                String dni = empleado.getAttribute("dni");
                String apellido = empleado.getElementsByTagName("apellido").item(0).getTextContent();
                int id = Integer.parseInt(empleado.getElementsByTagName("id").item(0).getTextContent());
                int dep = Integer.parseInt(empleado.getElementsByTagName("dep").item(0).getTextContent());
                float salario = Float.parseFloat(empleado.getElementsByTagName("salario").item(0).getTextContent());


                Empleado emp = new Empleado(id, apellido, dep, salario);
                System.out.println(emp);
            }
        }



    }
}
