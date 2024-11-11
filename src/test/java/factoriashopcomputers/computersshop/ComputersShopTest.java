package factoriashopcomputers.computersshop;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import factoriashopcomputers.computersshop.ComputersShop.Computer;


public class ComputersShopTest {

    private Store store;
    private Computer computer1;
    private Computer computer2;
    private Computer computer;
    private Computer computerDifferent;

    

@BeforeEach
public void setUp() {
    computer1 = new Computer("Some Name", "Apple", 16, "Intel i5", "Windows 10", 1000.0);
    computer2 = new Computer("Some Name", "HP", 8, "AMD Ryzen 5", "Windows 10", 600.0);
    computer = new Computer("Some Name", "Dell", 16, "Intel i5", "Windows 10", 800.0);

    store = new Store("Computers Shop", "Estefany Ochoa", "1234567890");
    store.addComputer(computer1);
    store.addComputer(computer2);
}
@Test
public void testAddComputer() {
    Computer computer3 = new Computer("Some Name", "HP", 8, "AMD Ryzen 5", "Windows 10", 600.0);
    store.addComputer(computer3);
    assertTrue(store.listComputers().contains(computer3));
}

@Test
public void testRemoveComputer() {
    boolean removed = store.removeComputer("Dell");
    assertFalse(removed);
    assertNull(store.searchComputer("Dell"));
}

@Test
public void testSearchComputer() {
    Computer result = store.searchComputer("null");
    assertNull(result);
    
}


@BeforeEach
public void shop() {
computer = new Computer("Some Name", "Dell", 16, "Intel i7", "Windows 10", 1000.0);
}

@Test
public void testGetBrand() {
    assertEquals("Dell", computer.getBrand(), "El método getBrand() no devuelve el valor esperado.");
}

@Test
public void testGetMemorySize() {
    assertEquals(16, computer.getMemorySize(), "El método getMemorySize() no devuelve el valor esperado.");
}

@Test
public void testGetProcessor() {
    assertEquals("Intel i7", computer.getProcessor(), "El método getProcessor() no devuelve el valor esperado.");
}

@Test
public void testGetOperatingSystem() {
    assertEquals("Windows 10", computer.getOperatingSystem(), "El método getOperatingSystem() no devuelve el valor esperado.");
}

@Test
public void testGetPrice() {
    assertEquals(1000.0, computer.getPrice(), "El método getPrice() no devuelve el valor esperado.");
}


@BeforeEach
public void compare() {
    computer = new Computer("Some Name", "Dell", 16, "Intel i7", "Windows 10", 1000.0);
    computerDifferent = new Computer("Some Name", "Dell", 16, "Intel i5", "Windows 10", 1000.0);
}

@Test
public void testSameObject() {
    // Línea 1: "if (this == o) return true;"
    assertTrue(computer1.equals(computer1), "equals debería devolver true al comparar el objeto consigo mismo.");
}

@Test
public void testNullObject() {
    // Línea 2: "if (o == null || getClass() != o.getClass()) return false;"
    assertFalse(computer1 == null, "equals debería devolver false al comparar con null.");
}

@Test
public void testDifferentObject() {
    // Línea 2: "if (o == null || getClass()!= o.getClass()) return false;"
    Computer differentClassObject = new Computer("Some Name", "NotAComputer", 16, "Intel i5", "Windows 10", 1000.0);
    assertFalse(computer1.equals(differentClassObject), "equals debería devolver false al comparar con un objeto de una clase diferente.");
}

@Test
public void testDifferentClass() {
    Computer differentClassObject = new Computer("Some Name", "NotAComputer", 16, "Intel i5", "Windows 10", 1000.0);
    assertFalse(computer1.equals(differentClassObject), "equals debería devolver false al comparar con un objeto de una clase diferente.");
}

@Test
public void testEqualMemorySize() {
    // Línea 4: "return memorySize == computer.memorySize && ..."
    assertFalse(computer1.equals(computer2), "equals debería devolver true si todos los atributos son iguales.");
    Computer differentMemorySize = new Computer("Dell", "Some Name", 32, "Intel i7", "Windows 10", 1000.0);
    assertFalse(computer1.equals(differentMemorySize), "equals debería devolver false si el tamaño de memoria es diferente.");
}

@Test
public void testEqualPrice() {
    // Línea 5: "Double.compare(computer.price, price) == 0 && ..."
    Computer differentPrice = new Computer("Some Name", "Dell", 16, "Intel i7", "Windows 10", 1200.0);
    assertFalse(computer1.equals(differentPrice), "equals debería devolver false si el precio es diferente.");
}

@Test
public void testEqualBrand() {
    // Línea 6: "Objects.equals(brand, computer.brand) && ..."
    Computer differentBrand = new Computer("Some Name", "HP", 16, "Intel i7", "Windows 10", 1000.0);
    assertFalse(computer1.equals(differentBrand), "equals debería devolver false si la marca es diferente.");
}

@Test
public void testEqualProcessor() {
    // Línea 7: "Objects.equals(processor, computer.processor) && ..."
    Computer differentProcessor = new Computer("Some Name", "Dell", 16, "Intel i5", "Windows 10", 1000.0);
    assertFalse(computer1.equals(differentProcessor), "equals debería devolver false si el procesador es diferente.");
}

@Test
public void testEqualOperatingSystem() {
    // Línea 8: "Objects.equals(operatingSystem, computer.operatingSystem);"
    Computer differentOperatingSystem = new Computer("Some Name", "Dell", 16, "Intel i7", "Linux", 1000.0);
    assertFalse(computer1.equals(differentOperatingSystem), "equals debería devolver false si el sistema operativo es diferente.");
}

    public Computer getComputerDifferent() {
        return computerDifferent;
    }

    public void setComputerDifferent(Computer computerDifferent) {
        this.computerDifferent = computerDifferent;
    }
    @Test
    void testHashCode() {

        ComputersShop.Computer computer1 = new ComputersShop.Computer("Some Name", "BrandA", 8, "Intel", "Windows", 1000.0);

        ComputersShop.Computer computer2 = new ComputersShop.Computer("Some Name", "BrandA", 8, "Intel", "Windows", 1000.0);


        assertEquals(computer1.hashCode(), computer2.hashCode(), "Los hashCode deben ser iguales");

        
        ComputersShop.Computer computer3 = new ComputersShop.Computer("Some Name", "BrandA", 8, "Intel", "Windows", 1200.0);

        
        assertNotEquals(computer1.hashCode(), computer3.hashCode(), "Los hashCode deben ser diferentes");
    }





    @BeforeEach
    void sett() {
        computer = new Computer("Some Name", "Dell", 16, "Intel", "Windows", 1200.00);
        computer = new Computer("Some Name", "Dell", 16, "Intel", "Windows", 1200.00);
    }

    
    @Test
    void testToString() {
        
        String expectedString = "Computer [brand=Dell, memorySize=16, processor=Intel i7, operatingSystem=Windows 10, price=1000.0]";
        
        
        assertEquals(expectedString, computer.toString(), "El metodo toString() no devuelve el valor esperado.");
    }

    
    @Test
    void testToStringWithNullValues() {
        
        Computer computerWithNulls = new Computer("Some Name", null, 0, null, null, 0.0);
    
        String expectedString = "Computer [brand=null, memorySize=0, processor=null, operatingSystem=null, price=0.0]";
        
    
        assertEquals(expectedString, computerWithNulls.toString(), "El método toString() no maneja correctamente los valores nulos.");
    }

    // Test con valores vacíos
    @Test
    void testToStringWithEmptyValues() {
        
        Computer computerWithEmptyValues = new Computer("Some Name", "", 8, "", "", 1000.0);
        
        
        String expectedString = "Computer [brand=, memorySize=8, processor=, operatingSystem=, price=1000.0]";
        
    
        assertEquals(expectedString, computerWithEmptyValues.toString(), "El método toString() no maneja correctamente los valores vacíos.");
    }

    
    @Test
    void testToStringWithPricePrecision() {
    
        Computer computerWithPrecision = new Computer("Some Name", "Apple", 32, "M1", "macOS", 2399.99);
        
        
        String expectedString = "Computer [brand=Apple, memorySize=32, processor=M1, operatingSystem=macOS, price=2399.99]";
        
        assertEquals(expectedString, computerWithPrecision.toString(), "El método toString() no maneja correctamente la precisión del precio.");
    }


    @BeforeEach
    void sistema() {
        store = new Store("Tech Store", "Estefany Ochoa", "123456789");
        computer1 = new Computer("Some Name", "Dell", 16, "Intel", "Windows", 1200.00);
        computer2 = new Computer("Some Name", "HP", 8, "AMD", "Windows", 800.00);
    }

    @Test
    void testSearchComputerFound() {
        store.addComputer(computer1);
        store.addComputer(computer2);
        
        Computer found = store.searchComputer("Dell");
        assertNotNull(found);
        assertEquals(computer1, found);
    }

    @Test
    void testSearchComputerNotFound() {
        store.addComputer(computer1);
        
        Computer found = store.searchComputer("Apple");
        assertNull(found);
    }

    @Test
    void testListComputers() {
        store.addComputer(computer1);
        store.addComputer(computer2);
        
        List<Computer> computers = store.listComputers();
        assertNotNull(computers);
        assertEquals(2, computers.size());
        assertTrue(computers.contains(computer1));
        assertTrue(computers.contains(computer2));
    }

    @Test
    void testGetNameAndSetName() {
        assertEquals("Tech Store", store.getName());
        
        store.setName("Super Store");
        assertEquals("Super Store", store.getName());
    }


    @BeforeEach
    void store() {
        store = new Store("Tech Store", "Estefany Ochoa", "123456789");
    }

    @Test
    void testGetOwner() {
        assertEquals("Estefany Ochoa", store.getOwner());
    }

    @Test
    void testSetOwner() {
        store.setOwner("Carlos Perez");
        assertEquals("Carlos Perez", store.getOwner());
    }

    @Test
    void testGetTaxId() {
        assertEquals("123456789", store.getTaxId());
    }

    @Test
    void testSetTaxId() {
        store.setTaxId("987654321");
        assertEquals("987654321", store.getTaxId());
    }




    @BeforeEach
    void setComputer() {
        computer = new Computer("Some Name", "Dell", 16, "Intel i7", "Windows 10", 1000.0);
    }

    @Test
    void testSetBrand() {
        computer.setBrand("HP");
        assertEquals("HP", computer.getBrand());
    }

    @Test
    void testSetMemorySize() {
        computer.setMemorySize(32);
        assertEquals(32, computer.getMemorySize());
    }

    @Test
    void testSetProcessor() {
        computer.setProcessor("AMD");
        assertEquals("AMD", computer.getProcessor());
    }

    @Test
    void testSetOperatingSystem() {
        computer.setOperatingSystem("Linux");
        assertEquals("Linux", computer.getOperatingSystem());
    }

    @Test
    void testSetPrice() {
        computer.setPrice(1500.00);
        assertEquals(1500.00, computer.getPrice());
    }
}










