package es.deusto.ingenieria.sd.auctions.client.remote;

import java.rmi.Naming;


//This class implements Service Locator pattern
public class ServiceLocator {
	
	private IRemoteFacade serv;

    public void setService(String dirip, String puerto, String servNom) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String URL = "//" + dirip + ":" + puerto + "/" + servNom;
            this.service = (IRemoteFacade) Naming.lookup(URL);
        } catch (Exception ex) {
            System.err.println("# Fallo " + ex);
        }
    }

    public IRemoteFacade getService() {
        return this.service;
    }
}