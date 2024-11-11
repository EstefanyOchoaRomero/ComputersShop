package factoriashopcomputers.computersshop;

import java.util.ArrayList;
import java.util.List;

import factoriashopcomputers.computersshop.ComputersShop.Computer;

class Store {
    private String name;
    private String owner= "Estefany Ochoa";
    private String taxId;
    private List<Computer> computers;
    

    public Store(String name, String owner, String taxId) {
        this.name = name;
        this.owner = owner;
        this.taxId = taxId;
        this.computers = new ArrayList<>();
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }


    public boolean removeComputer(String brand) {
        return computers.removeIf(computer -> computer.getBrand().equalsIgnoreCase(brand));
    }

    public Computer searchComputer(String brand) {
        for (Computer computer : computers) {
            if (computer.getBrand().equalsIgnoreCase(brand)) {
                return computer;
            }
        }
        return null;
    }

    public List<Computer> listComputers() {
        return computers;
    }

        public String getName() {
            return name;
        }

        

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getTaxId() {
            return taxId;
        }

        public void setTaxId(String taxId) {
            this.taxId = taxId;
        }

        public List<Computer> getComputers() {
            return computers;
        }

        public void setComputers(List<Computer> computers) {
            this.computers = computers;
        }
}


