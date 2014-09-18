# Permeance ehcache

*permeance-ehcache*

This project contain ehcache tools.

## Overview

This project contains the ehCache Statistics Exporter.


## Usage

Please refer to blog article [How to export ehcache statistics to a CSV file](https://www.permeance.com.au/web/terry.mueller/home/-/blogs/how-to-export-ehcache-statistics-to-a-csv-file "How to export ehcache statistics to a CSV file”) for usage details.

## Building

### Step 1. Checkout source from GitHub project

#### Step 1.1. Checkout master from GitHub project

    $ md work
    $ cd work
    % md -p permeance-ehcache/master
    % cd permeance-ehcache/master
    $ git clone https://github.com/permeance/ehcache
    Cloning into ‘permeance-ehcache'...
    remote: Counting objects: 518, done.
    remote: Compressing objects: 100% (223/223), done.
    remote: Total 518 (delta 173), reused 502 (delta 157)
    Receiving objects: 100% (518/518), 622.65 KiB | 273.00 KiB/s, done.
    Resolving deltas: 100% (173/173), done.
    Checking connectivity... done

### Step 2. Build and package

    % mvn -U clean package

This will build “permeance-ehcache-XXX.jar” in the “target” folder.

## Project Team

* Terry Mueller - terry.mueller@permeance.com.au
* Tim Telcik - tim.telcik@permeance.com.au

## References

* [How to export ehcache statistics to a CSV file](https://www.permeance.com.au/web/terry.mueller/home/-/blogs/how-to-export-ehcache-statistics-to-a-csv-file "How to export ehcache statistics to a CSV file”) 
