package licenta.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_MEDICAMENT")
public class Medicament implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCTION_DATE")
    private Date productionDate;

    @Column(name = "VALIDITY_DATE")
    private Date valabilityDate;

    @Column(name = "MANUFACTURER_NAME")
    private String manufacturerName;

    @Column(name = "MANUFACTURER_DESCRIPTION")
    private String manufacturerDescription;

    public Medicament() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getValabilityDate() {
        return valabilityDate;
    }

    public void setValabilityDate(Date valabilityDate) {
        this.valabilityDate = valabilityDate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerDescription() {
        return manufacturerDescription;
    }

    public void setManufacturerDescription(String manufacturerDescription) {
        this.manufacturerDescription = manufacturerDescription;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "name='" + name + '\'' +
                ", productionDate=" + productionDate +
                ", valabilityDate=" + valabilityDate +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerDescription='" + manufacturerDescription + '\'' +
                '}';
    }
}
