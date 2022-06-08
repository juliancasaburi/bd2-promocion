#! /bin/bash

mongoimport --host mongodb --port 27017 --db bbdd2_promocion --collection accidents --type csv --headerline --drop --file "/seed/US_Accidents_Dec19.csv"
