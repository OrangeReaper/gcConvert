GC Convert is a utility written in Java that will create LIRC Conf files from a Global-cache IR Codeset file. The initial motivation for this application was to produce [AndyMOTE]: (https://andymote.abondservices.com) friendly lirc.conf files, but, of course, any such files should be compatible with any front end application using LIRC as a back-end IR Transmitter.

The instructions in this article are for a Linux Desktop environment; but, as GC Convert is a Java application, most instructions will apply directly to windows.

The benefits of using GC Convert over irrecord (provided by [lirc.org]: (http://www.lirc.org/html/irrecord.html) are:

    * Global-cache IR Codeset Files often contain codes that are not available on the original remote control.
    * Configurations can be easily modified/regenerated once created.
    * Access to the original remote control is not required.

To obtain Global-Cache IR Codest files you need to register with Global-Cache [here]: (https://irdb.globalcache.com/Account/Register).

Once you have obtained your account, login and go to the database section and get your IR Codeset!

It will be sent to you by email (you can ask for 5 codesets per day).

When the email arrives create a txt file containing the entire body of the email Global-Cache sent you, and use this file (the GCC RAW File) as the input to gcConvert.

Creating your lirc.conf files is as easy as 1-2-3...

. Load the codeset file into gcConvert.
. Select the codes you wish to include in your conf file and their key names.
. Save the conf file.

Use 'Export' and 'Import' to save and restore your config/progress.

Note: Apart from when you open the GCC Raw File or Import there are no dialogs; all files are saved in the same directory as the GCC Raw File. 

