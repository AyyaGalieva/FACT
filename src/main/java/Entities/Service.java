package Entities;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private String serviceName = "";
    private int term;
    private ArrayList<String> properties = new ArrayList<>();

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public void addProperty(String property) {
        properties.add(property);
    }
}
