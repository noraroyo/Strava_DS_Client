package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class RetoController {
	private ServiceLocator serviceLocator;

    public RetoController(ServiceLocator sl) {
    	this.serviceLocator = serviceLocator;
    }
    
    public boolean aceptarReto(long token, RetoDTO reto){
        try{
            return this.serviceLocator.getService().aceptarReto(token, reto);
        } catch (RemoteException e) {
            System.out.println("Error");
            return false;
        }

    }

    public boolean crearReto(long token, String nombre, String fecIni, String fecFin, float distanciaObjetivo, String deporte){
        try{
            return this.serviceLocator.getService().crearReto(token, nombre, fecIni, fecFin, distanciaObjetivo, deporte);

        }catch (RemoteException e){
            System.out.println("Error");
            return false;
        }
    public List<RetoDTO> getRetos(String fecFin){
        try {
            return this.serviceLocator.getService().getRetos(fecFin);
        } catch (RemoteException e){
            System.out.println("# Fallo: " + e);
            return null;
        }
    }

    
    }


 
    
    }
