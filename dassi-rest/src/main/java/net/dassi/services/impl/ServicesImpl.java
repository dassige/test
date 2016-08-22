package net.dassi.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import net.dassi.services.api.Service;
import net.dassi.services.impl.persistence.ServicesDAO;

public class ServicesImpl {
	ServicesDAO services = new ServicesDAO();
	
    public Collection<Service> getServices() {
        return services.getServices();
    }
    
 
}