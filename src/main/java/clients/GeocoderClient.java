package main.java.clients;

import feign.Param;
import feign.RequestLine;
import main.java.model.GeocodeRequest;

public interface GeocoderClient {
    @RequestLine("GET /geocoding/v5/mapbox.places/{address}?proximity=ip&types=place%2Cpostcode%2Caddress&access_token={access_token}")
    GeocodeRequest getLatLongFromAddress(@Param("address") String address, @Param("access_token") String access_token);
}
