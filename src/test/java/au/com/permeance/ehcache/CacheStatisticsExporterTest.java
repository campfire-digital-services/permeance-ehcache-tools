package au.com.permeance.ehcache;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for CacheStatisticsExporter.
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
