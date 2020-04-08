GC Convert is a utility written in Java that will create LIRC Conf files from a Global-cache IR Codeset file. The initial motivation for this application was to produce [AndyMOTE](https://andymote.abondservices.com) friendly lirc.conf files, but, of course, any such files should be compatible with any front end application using LIRC as a back-end IR Transmitter.

The instructions in this article are for a Linux Desktop environment; but, as GC Convert is a Java application, most instructions will apply directly to windows.

irrecord is a command line application provided by [lirc.org](http://www.lirc.org/html/irrecord.html) which creates lirc.conf files by recording the signals from your original remote control using an appropriate hardware setup.  The benefits of using GC Convert over irrecord are:

    * Global-cache IR Codeset Files often contain codes that are not available on the original remote control.
    * Configurations can be easily modified/regenerated once created.
    * Access to the original remote control is not required.

To obtain Global-Cache IR Codest files you need to register with Global-Cache [here](https://irdb.globalcache.com/Account/Register).

Once you have obtained your account, login and go to the database section and get your IR Codeset!

It will be sent to you by email (you can ask for 5 codesets per day).

When the email arrives create a txt file containing the entire body of the email Global-Cache sent you, and use this file (the GCC RAW File) as the input to gcConvert.

Creating your lirc.conf files is as easy as 1-2-3...

1. Load the codeset file into gcConvert.
2. Select the codes you wish to include in your conf file and their key names.
3. Save the conf file.

Use 'Export' and 'Import' to save and restore your config/progress.

Note: Apart from when you open the GCC Raw File or Import there are no dialogs; all files are saved in the same directory as the GCC Raw File. 

# how to install and run gcConvert

Instructions below are for a Ubuntu 18.04.4 Desktop installation but should be similar for other linux distributions (especially those that are debian based)

Check your java environemt

    $ java -version
    
If JRE is installed you should see something like

    openjdk version "11.0.6" 2020-01-14
    OpenJDK Runtime Environment (build 11.0.6+10-post-Ubuntu-1ubuntu118.04.1)
    OpenJDK 64-Bit Server VM (build 11.0.6+10-post-Ubuntu-1ubuntu118.04.1, mixed mode)

Here, version 11 is installed, gcConvert should run OK with versions 8 and above.

If JRE is not installed you can install it using the following command:

    $ sudo apt install openjdk-11-jre-headless

Once JRE is installed follow the following steps to get gcConvert up and running

    a. download the zip file (above)
    b. unzip the file
    c. open a terminal in the directory /path/to/gcConvert-master/target
    d. run gc-convert using the command line 
    
        $ java -jar gcConvert-1.0-SNAPSHOT.jar
