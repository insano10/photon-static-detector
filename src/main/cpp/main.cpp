#include "application.h"
#include "HttpClient.h"

int powerPin = D5;
int staticInputPin = A0;

int staticValue = 0;

HttpClient http;
http_header_t headers[] = {
     { "Content-Type", "application/json" },
     { NULL, NULL } // NOTE: Always terminate headers with NULL
};
http_request_t request;
http_response_t response;

void setup() {

    Serial.begin(9600);
    pinMode(powerPin, OUTPUT);
    pinMode(staticInputPin, INPUT);

    digitalWrite(powerPin, HIGH);
}

void loop() {

    //Take a reading every second
    delay(1000);

    staticValue = analogRead(staticInputPin);


    //Change this to be the IP of the web server
    request.ip = IPAddress(192,168,1,169);
    request.port = 8080;
    request.path = "/photon/measurements";
    request.body = "{\"measurementType\":\"static\", \"value\":" + String(staticValue) + "}";


    //Send reading to the web server
    http.post(request, response, headers);
    Serial.print("HTTP Response: ");
    Serial.println(response.status);
    Serial.println(response.body);
}
