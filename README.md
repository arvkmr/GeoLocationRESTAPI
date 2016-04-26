# GeoLocationRESTAPI
A basic REST API for geo locations around given GPS cordinates. This was made for a small class project.

The project is a Java based API and uses GPS coordinates to provide a list of points of
interest around any given GPS coordinates. All the points so far have been extracted
from Wikipedia articles. The API also supports adding a given point to the database
through create method. The info is returned in a json format.

The project needs mongodb and Java Installed to run.
To install mongodb on ubuntu

sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10

echo "deb http://repo.mongodb.org/apt/ubuntu "$(lsb_release -sc)"/mongodb-org/3.0

multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list

sudo apt-get update

sudo apt-get install -y mongodb-org


To Test the project.
1. mongorestore is a mongodb command to get the original database from dump folder 
To get the original database
mongorestore --collection points --db wikip dump/wikip/points.bson

2. Run the server and API through
Java -jar service.jar

3. The API should be active at
http://localhost:8080/

API documentation

1.Create

Method: GET

Path: /api/wiki/add?

Parameters: 

Lat

Log

Title

Url (Optional)

Example
http://localhost:8080/api/wiki/add?lat=42.630933&log=-
71.370210&Title=MyPlace&url=http://www.princetonproperties.com/property/9063/M
A/Lowell/Princeton-Park-Apartments.aspx
Response:
["success"]
Search by coordinates and Max distance.
Method: GET
Path: /api/wiki/loc
Parameters:
{
Lat: Latitude (Required)
Log: Longitude (Required)
Max: Max distance in Meters (Required)
}
