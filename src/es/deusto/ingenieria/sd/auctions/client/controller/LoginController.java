package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class LoginController {
private ServiceLocator serviceLocator;
    
    private long token = -1; 

    public LoginController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean loginEmail(String email, String pass) {
        try {
            this.token = this.serviceLocator.getService().login(email, pass);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Fallo " + e);
            this.token = -1;
            return false;
        }
    }

    public boolean loginCuenta(String redireccion){
        try {
            this.token = this.serviceLocator.getService().loginExterno(redireccion);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Fallo " + e);
            this.token = -1;
            return false;
        }
    }

    public void logout() {
        try {
            this.serviceLocator.getService().logOut(this.token);
            this.token = -1;
        } catch (RemoteException e) {
            System.out.println("# Fallo " + e);
        }
    }

    public long getToken() {
        return token;
    }

    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }
}
