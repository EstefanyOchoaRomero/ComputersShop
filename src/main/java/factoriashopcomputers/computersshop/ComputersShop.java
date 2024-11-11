package factoriashopcomputers.computersshop;

import java.util.Objects;

public class ComputersShop {
    public static class Computer {
        private String brand;
        private int memorySize;
        private String processor;
        private String operatingSystem;
        private double price;
        

        public Computer(String name,String brand, int memorySize, String processor, String operatingSystem, double price) {
            this.brand = brand;
            this.memorySize = memorySize;
            this.processor = processor;
            this.operatingSystem = operatingSystem;
            this.price = price;
        }

        public String getBrand() { return brand; }
        public int getMemorySize() { return memorySize; }
        public String getProcessor() { return processor; }
        public String getOperatingSystem() { return operatingSystem; }
        public double getPrice() { return price; }

        @Override
        public String toString() {
            return "Computer [brand=" + brand + ", memorySize=" + memorySize +
                ", processor=" + processor + ", operatingSystem=" + operatingSystem +
                ", price=" + price + "]";
        }

        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Computer computer = (Computer) o;
            return memorySize == computer.memorySize &&
                Double.compare(computer.price, price) == 0 &&
                Objects.equals(brand, computer.brand) &&
                Objects.equals(processor, computer.processor) &&
                Objects.equals(operatingSystem, computer.operatingSystem);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, memorySize, processor, operatingSystem, price);
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setMemorySize(int memorySize) {
            this.memorySize = memorySize;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
}

