package gardenbooking.rkdeveloper.com.webserviceexample.Utils;

/**
 * Created by ROHIT on 7/8/2016.
 */
public class Data {

    private String name,description,country;
    private float temp;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public float getTemp() {
        return temp;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }


}
