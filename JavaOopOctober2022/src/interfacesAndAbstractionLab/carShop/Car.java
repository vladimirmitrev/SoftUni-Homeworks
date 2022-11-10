package interfacesAndAbstractionLab.carShop;

import java.io.Serializable;

public interface Car extends Serializable {

    String getModel();
    String getColor();
    Integer getHorsePower();
    String getCountryProduced();
}
