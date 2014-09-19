/**
* Copyright (C) 2013 - 2014 Permeance Technologies
*
* This program is free software: you can redistribute it and/or modify it under the terms of the
* GNU General Public License as published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* General Public License for more details.
*
* You should have received a copy of the GNU General Public License along with this program. If
* not, see <http://www.gnu.org/licenses/>.
*/
package au.com.permeance.ehcache.management;


/**
* Cache Statistics Exporter
*
* @author Terry Mueller <terry.mueller@permeance.com.au>
* @author Tim Telcik <tim.telcik@permeance.com.au>
* 
* @see http://ehcache.org/apidocs/net/sf/ehcache/management/CacheStatistics.html
*/
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class CacheStatisticsExporter {

    private static String[] ATTRIBUTE_NAMES = new String[] { 
    	"AssociatedCacheName",
    	"CacheHitPercentage",
    	"CacheHits",
    	"CacheMissPercentage",
    	"CacheMisses",
    	"DiskStoreObjectCount",
    	"InMemoryHitPercentage",
    	"InMemoryHits",
    	"InMemoryMisses",
    	"MemoryStoreObjectCount",
    	"ObjectCount",
    	"OffHeapHitsPercentage",
    	"OffHeapHits",
    	"OffHeapMisses",
    	"OffHeapStoreObjectCount",
    	"OnDiskHitsPercentage",
    	"OnDiskHits",
    	"OnDiskMisses",
    	"WriterMaxQueueSize",
    	"WriterQueueLength"
    };

    public static void main(String[] args) {
    	
    	// Parse commnad line arguments
    	
    	if (args.length < 2 || !args[1].matches("[0-9]+")) {
            System.err.println("usage: java " + CacheStatisticsExporter.class.getName() + " host port [username password]");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.valueOf(args[1]);

        HashMap<String, Object> map = new HashMap<String, Object>();
        
        if (args.length == 4) {
            String[] credentials = new String[2];
            credentials[0] = args[2];
            credentials[1] = args[3];
            map.put("jmx.remote.credentials", credentials);
        }

        // Output header
        
        for (String attributeName : ATTRIBUTE_NAMES) {
            System.out.print(attributeName);
            System.out.print(",");
        }
        System.out.println();

        // Output values
        
        try {
            JMXConnector c = JMXConnectorFactory.newJMXConnector(createConnectionURL(host, port), map);
            c.connect();
            MBeanServerConnection connection = c.getMBeanServerConnection();
            Set<ObjectInstance> mbeansSet = connection.queryMBeans(null, new ObjectName("net.sf.ehcache:type=CacheStatistics,*")); 
            for (ObjectInstance instance : mbeansSet) {
            	AttributeList attrList = connection.getAttributes(instance.getObjectName(), ATTRIBUTE_NAMES);
            	Map<String,Attribute> attrMap = toNameAttributeMap(attrList);
                for (String attrName : ATTRIBUTE_NAMES) {
                    Attribute attr = (Attribute) attrMap.get(attrName);
                    Object value = "";
                    if (attr != null) {
                    	value = attr.getValue();
                    }
                    System.out.print("\"");
                    System.out.print(value);
                    System.out.print("\",");
                }
            	
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JMXServiceURL createConnectionURL(String host, int port) throws MalformedURLException {
        return new JMXServiceURL("rmi", "", 0, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
    }
    
    private static Map<String,Attribute> toNameAttributeMap( AttributeList attrList ) {
    	
    	HashMap<String,Attribute> attrMap = new HashMap<String,Attribute>();
    	
    	if (attrList != null)
    	
        for (Object attrObject : attrList) {
            Attribute attr = (Attribute) attrObject;
            String name = attr.getName();
            attrMap.put(name, attr);
        }
    	
    	return attrMap;
    }

}
