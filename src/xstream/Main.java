package xstream;

import com.thoughtworks.xstream.XStream;
import modelos.Empleado;

public class Main {

    public static void main(String[] args) {
        Empleado empleado = new Empleado(1, "García", 20, 2456.45f);

        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[] {
                "modelos.*"
        });


        String xml = xStream.toXML(empleado);
        System.out.println(xml);

        Empleado empleado2 = new Empleado();
        xStream.fromXML(xml, empleado2);
        System.out.println(empleado2);
    }
}
