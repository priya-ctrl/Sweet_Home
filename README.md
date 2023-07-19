# Hotel_Room_Booking

UpgradProject_Microservices

Requirements and Diagrams 

We are breaking the Hotel room booking application into three different microservices, which are as follows:
API-Gateway - This service is exposed to the outer world and is responsible for routing all requests to the microservices internally.
Booking service - This service is responsible for collecting all information related to user booking and sending a confirmation message once the booking is confirmed.
Payment service - This is a dummy payment service; this service is called by the booking service for initiating payment after confirming rooms.

Proposed Diagram
![image](https://github.com/priya-ctrl/HotelBookingApplication/assets/64701881/ee1686fe-f68f-421b-bb32-ba9409b2caef)
