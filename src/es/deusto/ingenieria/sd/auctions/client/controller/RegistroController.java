package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class RegistroController {
	private ServiceLocator serviceLocator;

    public RegistroController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean registroEmail(String email, String nombre, String fechaNac, String pass){
        try{
            boolean result = serviceLocator.getService().registroEmail(email, nombre, fechaNac, org.apache.commons.codec.digest.DigestUtils.sha1Hex(pass));
            return result;
        }catch (RemoteException e) {
            System.out.println("# Fallo " + e);
            return false;
        }
    }

    public boolean registroCuenta(String redireccion){
        try{
            UserDTO u = this.serviceLocator.getService().registroCuenta(redireccion);
            LoginController l = new LoginController(serviceLocator);
            l.loginCuenta(redireccion);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Fallo " + e);
            return false;
        }
    }

    public ServiceLocator getServiceLocator() {
        return this.serviceLocator;
    }
}
