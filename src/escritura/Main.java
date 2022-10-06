package escritura;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // Creo un elemento
        Element raiz = document.createElement("estudiantes");
        // Se lo enchufo al padre
        document.appendChild(raiz);

        // Creamos Primer Estudiante
        Element estudiante1 = document.createElement("estudiante");
        raiz.appendChild(estudiante1);

        Attr dni1 = document.createAttribute("dni");
        dni1.setValue("12345678H");
        estudiante1.setAttributeNode(dni1);

        Element nombre1 = document.createElement("nombre");
        estudiante1.appendChild(nombre1);
        nombre1.setTextContent("Yeffry");

        Element nota1 = document.createElement("nota");
        estudiante1.appendChild(nota1);
        nota1.setTextContent("4.5");

        // Creamos Segundo Estudiante
        Element estudiante2 = document.createElement("estudiante");
        raiz.appendChild(estudiante2);

        Attr dni2 = document.createAttribute("dni");
        dni2.setValue("12345678C");
        estudiante2.setAttributeNode(dni2);

        Element nombre2 = document.createElement("nombre");
        estudiante2.appendChild(nombre2);
        nombre2.setTextContent("DANI");

        Element nota2 = document.createElement("nota");
        estudiante2.appendChild(nota2);
        nota2.setTextContent("3.5");

        // Creamos un Traductor de Elements a DOM
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer optimus = tf.newTransformer();
        DOMSource ds = new DOMSource(document);

        // OJO LA LINEA DEL MILLON DE DOLARES
        optimus.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new File("estudiantes.xml"));
        optimus.transform(ds, result);

    }
}
