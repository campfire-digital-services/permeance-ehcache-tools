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

import au.com.permeance.ehcache.management.CacheStatisticsExporter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
* Unit test for CacheStatisticsExporter.
* 
* @author Terry Mueller <terry.mueller@permeance.com.au>
* @author Tim Telcik <tim.telcik@permeance.com.au>
* 
* @see CacheStatisticsExporter
*/
public class CacheStatisticsExporterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CacheStatisticsExporterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CacheStatisticsExporterTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testExport()
    {
        assertTrue( true );
    }
}
