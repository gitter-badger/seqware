[![Build Status](https://travis-ci.org/SeqWare/seqware.svg?branch=develop)](https://travis-ci.org/SeqWare/seqware)
[![DOI](https://zenodo.org/badge/4360/SeqWare/seqware.svg)](http://dx.doi.org/10.5281/zenodo.13358)


## Introduction 

This README is just a quick overview of building SeqWare. See our
[project homepage](http://seqware.github.com) for much more documentation.

This is top level of the [SeqWare Project](http://seqware.github.com).
This contains the 6 major components of the SeqWare project along with
documentation and testing:

* seqware-meta-db
* seqware-webservice
* seqware-admin-webservice
* seqware-portal
* seqware-pipeline
* seqware-queryengine
* seqware-common
* the http://seqware.github.com website and manual
* seqware-ext-testing
* seqware-ext-admin-testing

The seqware-common sub-project provides a location for common code
and most of the other sub-projects have this as a dependency.

## Prerequisites 

###A Recent Linux Distribution

This pretty much goes without saying but the SeqWare project is targeted at
Linux.  You may be able to compile and use the software on MacOS X but, in all
honesty, we recommend you use a recent Linux distribution such as Debian
(Ubuntu, Linux Mint, etc) or RedHat (RedHat Enterprise, Fedora, etc).  This
software, although written in Java mostly, was never intended to work on
Windows. If you need to use Windows for development or deployment we recommend
you simply use our VirtualBox VM for both activities, see our extensive documentation
on http://seqware.github.com for more information. You can also use this same
approach on MacOS (or even another version of Linux).

###Java

SeqWare requires Oracle JDK 1.7 or greater, we primarily write and test with JDK 1.7.x.
An example of instructions on how to update your Linux installation can be found [here](https://ccp.cloudera.com/display/CDH4DOC/Before+You+Install+CDH4+on+a+Single+Node#BeforeYouInstallCDH4onaSingleNode-InstalltheOracleJavaDevelopmentKit). You will need to use the method appropriate to your distribution to install this.

## Building 

### Getting the Source Code 

Our source code is available from [GitHub](https://github.com/SeqWare/seqware) or the "Fork me on GitHub" banner at the upper right of our website

To get a copy of of our source code you will first need to install Git (<code>sudo apt-get install git</code> in Ubuntu) and then clone our repository.

<pre title="Cloning the git repository">
<span class="prompt">~$</span> <kbd>git clone git://github.com/SeqWare/seqware.git</kbd>
Cloning into 'seqware'...
remote: Counting objects: 8984, done.
remote: Compressing objects: 100% (2908/2908), done.
remote: Total 8984 (delta 4308), reused 8940 (delta 4265)
Receiving objects: 100% (8984/8984), 33.57 MiB | 392 KiB/s, done.
Resolving deltas: 100% (4308/4308), done.
</pre>

By default, this will land you on the default branch. You will want to check-out the latest release. 

For example:

	~$ cd seqware_github/
	~/seqware_github$ git checkout 0.13.6.5
	HEAD is now at f8698e9... Merge branch 'hotfix/0.13.6.5'

### Building and Automated Testing 

We're moving to Maven for our builds, this is currently how
you build without running any tests in the trunk directory:

    mvn clean install -DskipTests

Maven now runs unit tests as follows (unit tests in the SeqWare context are quick tests that do not require the embedded HBase or Tomcat instance):

    mvn clean install  

In order to run the integration tests on the entire project, please ensure that you have followed the steps in each of the integration testing guides for our sub-projects. This includes [MetaDB](http://seqware.github.com/docs/github_readme/3-metadb/) , [Web Service](http://seqware.github.com/docs/github_readme/4-webservice/) , and [Query Engine](http://seqware.github.com/docs/github_readme/2-queryengine/). 

**WARNING:  While integration and extended tests are running, launching workflows and workflow status checking MUST not occur.  If you have a cronjob performing these tasks it MUST be disabled prior to integration and extended testing.**

When this is complete: 

    export MAVEN_OPTS="-Xmx1024m -XX:MaxPermSize=512m" 
(This ensures that enough memory is allocated for integration tests)
    mvn clean install -DskipITs=false
(This runs all unit tests and integration tests that only require postgres as a prerequisite)
    mvn clean install -DskipITs=false -P extITs,embeddedTomcat
(runs all unit tests and all integration tests including those that require Oozie)

In the last case, the extended integration tests profile is used to trigger integration tests that run our command line utilities. 
In order to point your command-line tools at the web service brought up by the integration tests, you will need to comment out your crontab and modify your SeqWare ~/.seqware/settings to include:

    SW_REST_URL=http://localhost:8889/seqware-webservice

It is possible to disable our embedded tomcat instance and run against both a remote postgres and Tomcat instance. Set the following variables in your .seqware/settings to override these settings for basic integration tests and extended integration tests respectively:

    BASIC_TEST_DB_HOST=otherserver.ca
    BASIC_TEST_DB_NAME=test_seqware_meta_db
    BASIC_TEST_DB_USER=seqware
    BASIC_TEST_DB_PASSWORD=seqware

    EXTENDED_TEST_DB_HOST=otherserver.ca
    EXTENDED_TEST_DB_NAME=test_seqware_meta_db
    EXTENDED_TEST_DB_USER=seqware
    EXTENDED_TEST_DB_PASSWORD=seqware

Then set your SW_REST_URL to the web service that uses the above database and invoke the following command. Note that you will need to deploy the seqware-webservice war yourself. 

    mvn clean install -DskipITs=false -P 'extITs,!embeddedTomcat'

Alternatively, if you wish to still use an embedded tomcat instance for testing, modify the properties at the beginning of your seqware-webservice/pom.xml to match the above databases and invoke the integration tests with your SW_REST_URL set to http://localhost:8889/seqware-webservice

    mvn clean install -DskipITs=false -P extITs,embeddedTomcat

You can also run the integration tests by using a locally installed tomcat instance. Make sure the BASIC_TEST_* and EXTENDED_TEST_* are defined to get this to work:

    mvn clean install -DskipITs=false -P extITs

You can also build individual components such as the new query engine with: 

    cd seqware-queryengine
    mvn clean install

### Coding Standards

Please refer to SeqWare's [Coding Standards](https://seqware.github.io/docs/100-coding-standards/). 

### Building Our Site

In order to publish to seqware.io , checkout our current master and publish our site:

    git checkout master 
    mvn site-deploy

Then you would look at the site at: http://seqware.io

In order to publish our docs leading up to 1.1.x , checkout from develop and publish:

    git checkout develop 
    mvn site-deploy

Then you would look at the site at: http://seqware.github.io/unstable.seqware.io/

###Problems with Maven

Sometimes we run into problems when building, strange missing dependency issues
and broken packages. A lot of the time this is an issue with Maven, try
deleting your ~/.m2 directory and running the build process again.

## Citations

Browse DOI codes for SeqWare and related software for software engineering at OICR at [Software Engineering at Zenodo](https://zenodo.org/collection/user-softeng-at-oicr)


## Installing

See our [Installation Guide](http://seqware.github.com/docs/2-installation/) for detailed installation instructions
including links to a pre-configured virtual machine that can be used for
testing, development, and deployment.

## seqware-docker
This organization as a whole also documents the various docker distributions used by the SeqWare and Pancancer projects.
Prerequisite containers can be resolved from Docker Hub which also runs continuous integration (except for seqware\_full which does not work in the docker hub environment). 

Install Docker using the following script. This will automatically setup AUFS which is recommended for performance reasons. 

        curl -sSL https://get.docker.com/ | sudo sh
        sudo usermod -aG docker ubuntu

When using Ubuntu, we recommend 14.04. 
After setting up, remember to exit your shell and log back in to refresh your environment.

Currently, most of these containers (including all of the SeqWare ones) are available and served as [automated builds](https://registry.hub.docker.com/repos/seqware/) on Docker Hub. We are also working on [quay.io](https://quay.io/repository/?namespace=seqware). 

### Java

You will need Java 7 to extract the workflow .zip bundles.  Please install that version for your system.

### SeqWare WhiteStar 

This version of SeqWare uses the WhiteStar workflow engine to quickly run workflows without any dependencies on SGE, Oozie, Hadoop, or even the SeqWare webservice. These containers start quickly and with no running services or overhead. The trade-off is that running workflows is less robust and access to features such as throttling based on memory (SGE), retrying workflows (Oozie), or querying metadata (webservice) are not available.

Go to [seqware\_whitestar](https://github.com/SeqWare/seqware_whitestar) for setup instructions

#### Documentation Builder 

Pre-requisite: SeqWare WhiteStar

Used internally for the SeqWare project to build documentation via jenkins when changes are pushed to GitHub. 

Go to [documentation\_builder](https://github.com/SeqWare/documentation_builder) for setup instructions

### SeqWare Oozie-SGE 

This version of SeqWare uses the Oozie-SGE workflow engine to run workflows. This requires SGE, Oozie, Hadoop, and the SeqWare webservice and thus containers are started with a script which spins up these services. These containers should be functionally very similar to full VMs spun up using [Bindle](https://github.com/CloudBindle/Bindle) and ansible-playbooks from [seqware-bag](https://github.com/SeqWare/seqware-bag).

Go to [seqware\_full](https://github.com/SeqWare/seqware_full) for setup instructions


## Copyright

Copyright 2008-2015 Brian D O'Connor, OICR, UNC, and Nimbus Informatics, LLC

## Contributors

Please see our [partners and contributors](http://seqware.github.com/partners/)

## License

SeqWare is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SeqWare is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with SeqWare.  If not, see <http://www.gnu.org/licenses/>.


