package service;

import javax.jws.WebService;

/**
 * Created by Asus on 22.12.2017.
 */

@WebService(endpointInterface = "service.TempConverter")
public class TempConverterImpl implements TempConverter {

    @Override
    public double f2c(double degrees) {
        return degrees * 9 / 5 + 32;
    }

    @Override
    public double c2f(double degrees) {
        return (degrees - 32) * 5 / 9;
    }

}
