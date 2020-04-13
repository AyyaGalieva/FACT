package Entities;

public enum Subject {
    AMOUNT,
    SERVICE;

    private int amount;
    private Service service;

    public int getAmount() {
        if (this == Subject.AMOUNT) {
            return amount;
        }
        else return 0;
    }

    public void setAmount(int amount) {
        if (this == Subject.AMOUNT) {
            this.amount = amount;
        }
    }

    public Service getService() {
        if (this == Subject.SERVICE) {
            return service;
        }
        else return null;
    }

    public String getServiceName() {
        if (service != null) {
            return service.getServiceName();
        } else return "";
    }

    public void setService(String serviceName) {
        if (this == Subject.SERVICE) {
            this.service = new Service(serviceName);
        }
    }
}
