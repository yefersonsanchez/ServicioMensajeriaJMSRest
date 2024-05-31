/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.clienteservicioRest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author yefer
 */
public class ClienteConvertidor {

    public String convertiraXML(String json, String dir) {

        Client client = Client.create();
        WebResource webResource = client.resource(dir);

        ClientResponse response = webResource.accept("application/xml").type("application/json").post(ClientResponse.class, json);

        // System.out.println("Respuesta Servidor");
        //System.out.println(response);
        System.out.println("");
        System.out.println("");
        //  System.out.println("Respuesta Convertidor:");
        String xml = response.getEntity(String.class);
        //System.out.println(xml);     

        return xml;
    }

}
