# Permeance ehcache Tools

*permeance-ehcache-tools*

This project contain ehcache tools.

## Overview

This project contains ehcache tools, including the ehcache Statistics Exporter.

Please refer to Permeance Technologies’ blog article [How to export ehcache statistics to a CSV file](https://www.permeance.com.au/web/terry.mueller/home/-/blogs/how-to-export-ehcache-statistics-to-a-csv-file/ "How to export ehcache statistics to a CSV file") for usage details.


## Usage

### Run CacheStatisticsExporter

    % java -cp ./permeance-ehcache-tools-0.0.1-SNAPSHOT.jar au.com.permeance.ehcache.management.CacheStatisticsExporter
    usage: java au.com.permeance.ehcache.management.CacheStatisticsExporter host port [username password]

## Building

### Step 1. Checkout source from GitHub project

#### Step 1.1. Checkout master from GitHub project

    $ md work
    $ cd work
    % md -p permeance-ehcache-tools/master
    % cd permeance-ehcache-tools/master
    $ git clone https://github.com/permeance/ehcache
    Cloning into ‘permeance-ehcache-tools’…
    remote: Counting objects: 518, done.
    remote: Compressing objects: 100% (223/223), done.
    remote: Total 518 (delta 173), reused 502 (delta 157)
    Receiving objects: 100% (518/518), 622.65 KiB | 273.00 KiB/s, done.
    Resolving deltas: 100% (173/173), done.
    Checking connectivity... done

### Step 2. Build and package

    % mvn -U clean package

This will build “permeance-ehcache-tools-XXX.jar” in the “target” folder.

## Project Team

* Terry Mueller - terry.mueller@permeance.com.au
* Tim Telcik - tim.telcik@permeance.com.au

## References

* [PT Blog - How to export ehcache statistics to a CSV file](https://www.permeance.com.au/web/terry.mueller/home/-/blogs/how-to-export-ehcache-statistics-to-a-csv-file/ "How to export ehcache statistics to a CSV file")
* [ehcache - Management and Monitoring using JMX](http://www.ehcache.org/documentation/user-guide/jmx/ "ehcache - Management and Monitoring using JMX")

