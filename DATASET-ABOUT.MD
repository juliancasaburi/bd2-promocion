# US Accidents Dataset - About

<table>
   <thead>
      <tr>
         <th style="text-align: center">#</th>
         <th style="text-align: center">Attribute</th>
         <th>Description</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td style="text-align: center">1</td>
         <td style="text-align: center">ID</td>
         <td>This is a unique identifier of the accident record.</td>
      </tr>
      <tr>
         <td style="text-align: center">2</td>
         <td style="text-align: center">Source</td>
         <td>Indicates source of the accident report (i.e. the API which reported the accident.).</td>
      </tr>
      <tr>
         <td style="text-align: center">3</td>
         <td style="text-align: center">TMC</td>
         <td>A traffic accident may have a <a href="https://wiki.openstreetmap.org/wiki/TMC/Event_Code_List">Traffic Message Channel (TMC)</a> code which provides more detailed description of the event.</td>
      </tr>
      <tr>
         <td style="text-align: center">4</td>
         <td style="text-align: center">Severity</td>
         <td>Shows the severity of the accident, a number between 1 and 4, where 1 indicates the least impact on traffic (i.e., short delay as a result of the accident) and 4 indicates a significant impact on traffic (i.e., long delay).</td>
      </tr>
      <tr>
         <td style="text-align: center">5</td>
         <td style="text-align: center">Start_Time</td>
         <td>Shows start time of the accident in local time zone.</td>
      </tr>
      <tr>
         <td style="text-align: center">6</td>
         <td style="text-align: center">End_Time</td>
         <td>Shows end time of the accident in local time zone. End time here refers to when the impact of accident on traffic flow was dismissed.</td>
      </tr>
      <tr>
         <td style="text-align: center">7</td>
         <td style="text-align: center">Start_Lat</td>
         <td>Shows latitude in GPS coordinate of the start point.</td>
      </tr>
      <tr>
         <td style="text-align: center">8</td>
         <td style="text-align: center">Start_Lng</td>
         <td>Shows longitude in GPS coordinate of the start point.</td>
      </tr>
      <tr>
         <td style="text-align: center">9</td>
         <td style="text-align: center">End_Lat</td>
         <td>Shows latitude in GPS coordinate of the end point.</td>
      </tr>
      <tr>
         <td style="text-align: center">10</td>
         <td style="text-align: center">End_Lng</td>
         <td>Shows longitude in GPS coordinate of the end point.</td>
      </tr>
      <tr>
         <td style="text-align: center">11</td>
         <td style="text-align: center">Distance(mi)</td>
         <td>The length of the road extent affected by the accident.</td>
      </tr>
      <tr>
         <td style="text-align: center">12</td>
         <td style="text-align: center">Description</td>
         <td>Shows natural language description of the accident.</td>
      </tr>
      <tr>
         <td style="text-align: center">13</td>
         <td style="text-align: center">Number</td>
         <td>Shows the street number in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">14</td>
         <td style="text-align: center">Street</td>
         <td>Shows the street name in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">15</td>
         <td style="text-align: center">Side</td>
         <td>Shows the relative side of the street (Right/Left) in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">16</td>
         <td style="text-align: center">City</td>
         <td>Shows the city in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">17</td>
         <td style="text-align: center">County</td>
         <td>Shows the county in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">18</td>
         <td style="text-align: center">State</td>
         <td>Shows the state in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">19</td>
         <td style="text-align: center">Zipcode</td>
         <td>Shows the zipcode in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">20</td>
         <td style="text-align: center">Country</td>
         <td>Shows the country in address field.</td>
      </tr>
      <tr>
         <td style="text-align: center">21</td>
         <td style="text-align: center">Timezone</td>
         <td>Shows timezone based on the location of the accident (eastern, central, etc.).</td>
      </tr>
      <tr>
         <td style="text-align: center">22</td>
         <td style="text-align: center">Airport_Code</td>
         <td>Denotes an airport-based weather station which is the closest one to location of the accident.</td>
      </tr>
      <tr>
         <td style="text-align: center">23</td>
         <td style="text-align: center">Weather_Timestamp</td>
         <td>Shows the time-stamp of weather observation record (in local time).</td>
      </tr>
      <tr>
         <td style="text-align: center">24</td>
         <td style="text-align: center">Temperature(F)</td>
         <td>Shows the temperature (in Fahrenheit).</td>
      </tr>
      <tr>
         <td style="text-align: center">25</td>
         <td style="text-align: center">Wind_Chill(F)</td>
         <td>Shows the wind chill (in Fahrenheit).</td>
      </tr>
      <tr>
         <td style="text-align: center">26</td>
         <td style="text-align: center">Humidity(%)</td>
         <td>Shows the humidity (in percentage).</td>
      </tr>
      <tr>
         <td style="text-align: center">27</td>
         <td style="text-align: center">Pressure(in)</td>
         <td>Shows the air pressure (in inches).</td>
      </tr>
      <tr>
         <td style="text-align: center">28</td>
         <td style="text-align: center">Visibility(mi)</td>
         <td>Shows visibility (in miles).</td>
      </tr>
      <tr>
         <td style="text-align: center">29</td>
         <td style="text-align: center">Wind_Direction</td>
         <td>Shows wind direction.</td>
      </tr>
      <tr>
         <td style="text-align: center">30</td>
         <td style="text-align: center">Wind_Speed(mph)</td>
         <td>Shows wind speed (in miles per hour).</td>
      </tr>
      <tr>
         <td style="text-align: center">31</td>
         <td style="text-align: center">Precipitation(in)</td>
         <td>Shows precipitation amount in inches, if there is any.</td>
      </tr>
      <tr>
         <td style="text-align: center">32</td>
         <td style="text-align: center">Weather_Condition</td>
         <td>Shows the weather condition (rain, snow, thunderstorm, fog, etc.)</td>
      </tr>
      <tr>
         <td style="text-align: center">33</td>
         <td style="text-align: center">Amenity</td>
         <td>A <a href="https://wiki.openstreetmap.org/wiki/Points_of_interest">POI</a> annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:amenity">amenity</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">34</td>
         <td style="text-align: center">Bump</td>
         <td>A POI annotation which indicates presence of speed bump or hump in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">35</td>
         <td style="text-align: center">Crossing</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:crossing">crossing</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">36</td>
         <td style="text-align: center">Give_Way</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Tag:highway%3Dgive_way">give_way</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">37</td>
         <td style="text-align: center">Junction</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:junction">junction</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">38</td>
         <td style="text-align: center">No_Exit</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:noexit">no_exit</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">39</td>
         <td style="text-align: center">Railway</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:railway">railway</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">40</td>
         <td style="text-align: center">Roundabout</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Tag:junction%3Droundabout">roundabout</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">41</td>
         <td style="text-align: center">Station</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:station">station</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">42</td>
         <td style="text-align: center">Stop</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:stop">stop</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">43</td>
         <td style="text-align: center">Traffic_Calming</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Key:traffic_calming">traffic_calming</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">44</td>
         <td style="text-align: center">Traffic_Signal</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Tag:highway%3Dtraffic_signals">traffic_signal</a> in a nearby loction.</td>
      </tr>
      <tr>
         <td style="text-align: center">45</td>
         <td style="text-align: center">Turning_Loop</td>
         <td>A POI annotation which indicates presence of <a href="https://wiki.openstreetmap.org/wiki/Tag:highway%3Dturning_loop">turning_loop</a> in a nearby location.</td>
      </tr>
      <tr>
         <td style="text-align: center">46</td>
         <td style="text-align: center">Sunrise_Sunset</td>
         <td>Shows the period of day (i.e. day or night) based on sunrise/sunset.</td>
      </tr>
      <tr>
         <td style="text-align: center">47</td>
         <td style="text-align: center">Civil_Twilight</td>
         <td>Shows the period of day (i.e. day or night) based on <a href="https://en.wikipedia.org/wiki/Twilight#Civil_twilight">civil twilight</a>.</td>
      </tr>
      <tr>
         <td style="text-align: center">48</td>
         <td style="text-align: center">Nautical_Twilight</td>
         <td>Shows the period of day (i.e. day or night) based on <a href="https://en.wikipedia.org/wiki/Twilight#Nautical_twilight">nautical twilight</a>.</td>
      </tr>
      <tr>
         <td style="text-align: center">49</td>
         <td style="text-align: center">Astronomical_Twilight</td>
         <td>Shows the period of day (i.e. day or night) based on <a href="https://en.wikipedia.org/wiki/Twilight#Astronomical_twilight">astronomical twilight</a>.</td>
      </tr>
   </tbody>
</table>