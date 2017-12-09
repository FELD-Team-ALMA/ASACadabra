package fr.alma2017.server;

import java.util.ArrayList;
import java.util.List;

import fr.alma2017.api.composant.IComposant;
import fr.alma2017.api.composant.IInterfaceComposantFournie;
import fr.alma2017.api.composant.IInterfaceComposantRequise;
import fr.alma2017.api.configuration.IConfiguration;
import fr.alma2017.api.configuration.IInterfaceConfiguration;
import fr.alma2017.api.connecteur.IConnecteur;
import fr.alma2017.api.server.IBaseDonnees;
import fr.alma2017.api.server.IConnectionManager;
import fr.alma2017.api.server.ISecurityManager;
import fr.alma2017.api.server.IServer;
import fr.alma2017.api.server.IServerConfiguration;
import fr.alma2017.configurationClass.InterfaceConfiguration;

public class ServerConfiguration implements IConfiguration, IServerConfiguration {
	
	private IInterfaceConfiguration interfaceConfiguration;
	private List<IComposant> composantsInterne;
	private List<IConnecteur> connecteurs;

	public ServerConfiguration(List<IConnecteur> connecteurs, IServer server, ISecurityManager securityManager, IConnectionManager connectionManager, IBaseDonnees baseDonnees) {
		this.interfaceConfiguration = new InterfaceConfiguration();
		this.composantsInterne = new ArrayList<IComposant>();	
		this.composantsInterne.add(server);
		this.composantsInterne.add(securityManager);
		this.composantsInterne.add(connectionManager);
		this.composantsInterne.add(baseDonnees);
		this.bindingComposants();
		this.connecteurs = new ArrayList<IConnecteur>();
	}

	private void bindingComposants() {
		for(IComposant composant : this.composantsInterne) {
			this.interfaceConfiguration.bind(composant);
		}
	}

	@Override
	public IInterfaceConfiguration getInterface() {
		return this.interfaceConfiguration;
	}

	@Override
	public List<IConnecteur> getConnecteurs() {
		return this.connecteurs;
	}

	@Override
	public List<IComposant> getComposantsInternes() {
		return this.composantsInterne;
	}

}
