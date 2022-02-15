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


General structure of packets sent from the client to the server :
Length (4 Byte)
 Header (6 Byte)
  Data or Command 
  CRC (2 Byte)

structure header : 
Packet Tag (1 Byte) 
client Serial Number (4 Byte) 
Number Of Data Element (1 Byte)





create client :
send data in loop : 
for i in range(10) :

    client.send("hello server")
    print(client.recv(1024))