package ru.company.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import ru.company.service.MethodVclBean;
 
public class CountryValueListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		
		//получаем бин и далее делаем с ним тоже самое что и в случае использования метода
		MethodVclBean country = (MethodVclBean) FacesContext.getCurrentInstance().
			getExternalContext().getSessionMap().get("country");

		country.setLocaleCode(event.getNewValue().toString());
		
	}
	
	
}