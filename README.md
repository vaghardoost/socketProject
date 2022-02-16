# ProjectWithFarhang
Socket Programing MultiThread  Redis Kafka Geo and ...

first phase of project : 
this project is about socket programming and multi thread programming

this project only use java core language

create a server and client

server that can send and receive data from client

start connection with client, server unkown client


after create server and client

send data from client to server for example ""hello server""

and server will send back data to client for example ""hi client""


this is a simple project !!!

step 2 : real time

stracture data send to server  :

for example :

byte[] data = new byte[]{1,2,4,5,6,6,7,8,9,-1,11,-124};

              hex :  01 02 04 05 06 06 07 08 09 -1 0b 11 7f



3400000000006ACF9A01E0010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

3400000000006ACF9A01E1010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

3400000000006ACF9A01E2010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

3400000000006ACF9A01E3010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

3400000000006ACF9A01E4010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

3400000000006ACF9A01E5010000000000000061FA5E460000000000000000000000000000C00115A96C00237B6700041D00B5080D0095E8

**#General structure of packets sent from the client to the server :

#Length (4 Byte)

#Header (6 Byte)

#Data or Command 

#CRC (2 Byte)

#structure header : 

#Packet Tag (1 Byte) 

#client Serial Number (4 Byte) 

#Number Of Data Element (1 Byte)**


this example event strat from client to server : 
![alt text](https://github.com/MfDevNet/ProjectWithFarhang/blob/main/Screen%20Shot%202022-02-15%20at%209.39.44%20PM.png?raw=true)



Event version is fix number  and not change : 0x01 

Event code : 

0xE0 normal point

0xE1 Start

0xE2 stop 

0xE3 Main power off 

0xE4 Main power Connect GPS No antenna 

0xE5 (G-Sensor) 0 Extreme shock on 

for example :

send data client to server : 

3400000000006ACF9A01E0010000000000000061FA5E460000000000000000000000000000C00015A96C00237B6700041D00B5080D0095E8

data convert in server to this structure :

deviceId=106207154, eventCodeDecimal='224', eventCodeHex='e0', eventCode='normal point', eventCodeInt='-32', eventVersion=1, driverId=0, totalDrivingTime_Minute=0, dateTime_UnixTimeSecond=1643798086000, gpsSpeed=0.0, vehicleSensorSpeed=0, maxSpeed_Gps=0.0, maxSpeed_vehicleSensor=0, engineRPM=0, totalTraveledDistance_Gps=0, totalTraveledDistance_VehicleSensor=0, ioStatus=192, gpsStatus='2D FIX', gpsStatusInt=2, latitude=36.3424768, longitude=59.5289856, altitude=1053.0, bearing=181.0, numberOfSatellites=8, pDOP=13, extraDataLength_Max30=0, extraData=[]




