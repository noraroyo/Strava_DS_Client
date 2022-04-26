package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;


public class EntrenamientoController {
	private ServiceLocator serviceLocator;
    public EntrenamientoController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
    
    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }

    public boolean crearEntrenamiento(long token, String titulo, String deporte, float distancia, String fecInicio, String horaFinal, float duracion){ 
        try{
            serviceLocator.getService().crearEntrenamiento(token, titulo, deporte, distancia, fecInicio, horaFinal, duracion);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Fallo: " + e);
            return false;
        }
    public List<EntrenamientoDTO> getEntrenamientos(long token) {
        try {
            return serviceLocator.getService().getEntrenamientos(token);
        } catch (RemoteException e) {
            System.out.println("# Fallo: " + e);
            return null;
        }
    }

    

    }

   
}
