package io.loyloy.nicky.databases;

import io.loyloy.nicky.Nicky;
import org.bukkit.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;



public class MySQL extends SQL
{
    public MySQL( Nicky plugin )
    {
        super(plugin);
    }

    protected Connection getNewConnection()
    {
        Configuration config = plugin.getConfig();

        try
        {
            Class.forName ("org.mariadb.jdbc.Driver");

            String url = "jdbc:mariadb://" + config.getString("host") + ":" + config.getString("port") + "/" + config.getString("database");

            return DriverManager.getConnection( url, config.getString( "user" ), config.getString( "password" ) );
        }
        catch (Exception e)
        {

            e.printStackTrace();
            return null;
        }
    }

    public String getName()
    {
        return "MySQL";
    }
}