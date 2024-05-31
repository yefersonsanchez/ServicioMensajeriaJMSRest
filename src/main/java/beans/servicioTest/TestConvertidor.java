package beans.servicioTest;

import beans.clienteservicioRest.ClienteConvertidor;

public class TestConvertidor {

    public static void main(String[] args) {

        String dir = "http://localhost:8080/ServicioRestFull/api/convertidor/process";

        String json = "{\n"
                + "\"nombre\":\"Tom\",\n"
                + "\"apellido\":\"Jackson\",\n"
                + "\"género\":\"masculino\"\n"
                + "}";

        ClienteConvertidor convertir = new ClienteConvertidor();

        String res = convertir.convertiraXML(json, dir);

        System.out.println("Respuesta Convertidor:");
        System.out.println("");

        System.out.println(res);

    }
}
