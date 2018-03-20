# Welcome to the sensor data feeder

This tool simulates from 0 to n number of sensor lectures and sends the corresponding json rest request to the given end point.

### How to run
Go to the releases webpage and download your lastest release, then in your command-line tool executhe the following command.
```bash
java -jar sensor-feed.jar ENDPOINT NUMBER_OF_LECTURES
```
For example the followin line will send `200` lectures to the endpoint `https://mana-module.herokuapp.com/sensor-feed`
```bash
java -jar sensor-feed.jar https://mana-module.herokuapp.com/sensor-feed 200
```
