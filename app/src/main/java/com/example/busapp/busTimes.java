package com.example.busapp;

import java.io.Serializable;

    public class busTimes implements Serializable {
        String DepartureTime;
        String ArrivalTime;
        String DestinationStart;
        String DestinationEnd;
        String Route;
        String Price;

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }




        public String getDepartureTime() {
            return DepartureTime;
        }

        public void setDepartureTime(String departureTime) {
            DepartureTime = departureTime;
        }

        public String getArrivalTime() {
            return ArrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            ArrivalTime = arrivalTime;
        }

        public String getDestinationStart() {
            return DestinationStart;
        }

        public void setDestinationStart(String destinationStart) {
            DestinationStart = destinationStart;
        }

        public String getDestinationEnd() {
            return DestinationEnd;
        }

        public void setDestinationEnd(String destinationEnd) {
            DestinationEnd = destinationEnd;
        }

        public String getRoute() {
            return Route;
        }

        public void setRoute(String route) {
            Route = route;
        }
    }


