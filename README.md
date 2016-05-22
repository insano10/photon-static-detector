# Photon Static Detector #

A Particle Photon project to detect the presence of static electricity and report measurements back to a web server (so you can chart it or whatever)

## Set up


### Photon

1. Set up your photon circuit to detect static electricity. Instructions [here](https://codefrieze.blogspot.co.uk/2016/05/detecting-static-electricity-with-photon.html)

2. Compile the contents of src/main/cpp
    ```
    cd src/main/cpp
    particle compile p .
    ```
3. Connect your photon to your computer with a USB cable and put it in DFU mode
  * (for instructions on how to do this see [here](http://codefrieze.blogspot.co.uk/2015/08/using-particle-cli-on-ubuntu-1404.html))
 
4. Flash the binary onto your photon
    ```
    sudo particle flash --usb photon_firmware_xxxxxxxxx.bin
    ```
Note: you may get prompted to log in to the particle API if your session has expired since the last time you used it


### Web server

If running in IntelliJ, simply run JettyLauncher.scala

If running on the CLI

    sbt
    jetty:start
