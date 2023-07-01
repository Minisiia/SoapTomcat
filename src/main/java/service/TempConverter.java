package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Asus on 22.12.2017.
 */

@WebService
public interface TempConverter {

    @WebMethod
    double c2f(double degrees);

    @WebMethod
    double f2c(double degrees);

}
