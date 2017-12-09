package fr.alma2017.configurationClass;

import java.util.ArrayList;
import java.util.List;

import fr.alma2017.api.composant.IComposant;
import fr.alma2017.api.configuration.IInterfaceConfiguration;
import fr.alma2017.api.lien.IBinding;
import fr.alma2017.api.lien.IBindingPFSF;

public class InterfaceConfiguration implements IInterfaceConfiguration {

	private List<IBinding> bindComposants;
	
	public InterfaceConfiguration() {
		this.bindComposants = new ArrayList<IBinding>();
	}
	
	@Override
	public void bind(IComposant composant) {
		
	}

}
