package fr.alma2017.api.clientServer;

import fr.alma2017.api.configuration.IConfiguration;
import fr.alma2017.api.server.IServer;

public interface IClientServerConfiguration extends IConfiguration {

	public IServer getServer();

}