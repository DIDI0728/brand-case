package Pojo;

public class Brand {
    private int id;
    private String brand_name;
    private String company_name;
    private  int ordered;
    private String description;
    private  int status;

    private String statusStr;



    public String getStatusStr() {
        if (status == 1)
            return "启用";
        else return "禁用";
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Brand(){}


    public Brand(int id, String brand_name, String company_name, int ordered, String description, int status) {
        this.id = id;
        this.brand_name = brand_name;
        this.company_name = company_name;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand_name='" + brand_name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
