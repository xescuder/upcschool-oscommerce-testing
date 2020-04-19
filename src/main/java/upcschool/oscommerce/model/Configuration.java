package upcschool.oscommerce.model;

import java.util.Currency;

public class Configuration {

    private static Configuration configuration_instance = null; 

    private Currency defaultCurrency; 
  
    private Configuration() 
    { 
    	defaultCurrency=Currency.getInstance("EUR");
    } 
  
    // static method to create instance of Singleton class 
    public static Configuration getInstance() 
    { 
        if (configuration_instance == null) 
        	configuration_instance = new Configuration(); 
  
        return configuration_instance; 
    }

	public Currency getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(Currency defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	} 
    
    
}

