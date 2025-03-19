package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    // Constructor Tests
    @Test
    void shouldCreateEmployeeWithDefaultConstructor(){
        //arrange
        //act
        Employee employee = new Employee();
        //assert
        assertNotNull(employee);
    }

    @Test
    void shouldCreateEmployeeWithValidArguments(){
        //arrange
        //act
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //assert
        assertNotNull(employee);
    }


    // Attribute Validation Tests
    @Test
    void shouldThrowExceptionWhenFirstNameIsNull(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee(null,"Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsEmpty(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("","Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao",null, "Developer", 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsEmpty(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","", "Developer", 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsNull(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", null, 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", "", 5, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void shouldThrowExceptionWhenJobYearsIsNegative(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", "Developer", -1, "joao7pinheiro@hotmail.com"));
    }

    @Test
    void testEmployeeConstructorValidZeroJobYears(){
        //arrange
        //act
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 0, "joao7pinheiro@hotmail.com");
        //assert
        assertNotNull(employee);
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull(){
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", "Developer", 5, null));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsEmpty() {
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", "", 5, ""));
    }

    @Test
    void shouldThrowExceptionWhenEmailDoesNotContainAtSymbol() {
        //arrange
        //act
        //assert
        assertThrows(Exception.class, () -> new Employee("Joao","Pinheiro", "", 5, "joao7pinheirohotmail.com"));
    }


    // equals() Tests
    @Test
    void shouldReturnTrueIfSameEmployeeAttributes(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfSameEmployee(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfDifferentId(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");

        employee.setId(1L);
        employee2.setId(2L);
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDifferentFirstName(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Bernardo", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDifferentLastName(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Ferreira", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDifferentDescription(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Teacher", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDifferentJobYears(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Developer", 3, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfDifferentEmail(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Developer", 5, "joaopinheiro888@hotmail.com");
        //act
        boolean result = employee.equals(employee2);
        //assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfNullEmployeeCompared(){
        //arrange
        Employee employee = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        boolean result = employee.equals(null);
        //assert
        assertFalse(result);
    }


    // hashCode() Tests
    @Test
    void shouldReturnSameHashCodeForEqualEmployees(){
        // arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");

        employee1.setId(1L);
        employee2.setId(1L);

        // act
        int hashCode1 = employee1.hashCode();
        int hashCode2 = employee2.hashCode();

        // assert
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void shouldReturnDifferentHashCodeForDifferentEmployees(){
        // arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Employee employee2 = new Employee("Bernardo", "Ferreira", "Teacher", 3, "bernardo11ferreira@hotmail.com");

        employee1.setId(1L);
        employee2.setId(2L);

        // act
        int hashCode1 = employee1.hashCode();
        int hashCode2 = employee2.hashCode();

        // assert
        assertNotEquals(hashCode1, hashCode2);
    }


    // Getters and Setters Tests
    @Test
    void shouldReturnEmployeeId(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");

        employee1.setId(1L);

        //act
        Long id = employee1.getId();
        //assert
        assertEquals(1L, id);
    }

    @Test
    void shouldSetEmployeeId(){
        // Arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        Long expected = 1L;
        // Act
        employee1.setId(expected);
        // Assert
        assertEquals(expected, employee1.getId());
    }

    @Test
    void shouldReturnEmployeeFirstName(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        String firstName = employee1.getFirstName();
        //assert
        assertEquals(firstName, "Joao");
    }

    @Test
    void shouldSetEmployeeFirstName(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        employee1.setFirstName("Bernardo");
        String result = employee1.getFirstName();
        //assert
        assertEquals("Bernardo", result);
    }

    @Test
    void shouldThrowExceptionWhenSetWithNullFirstName(){
        //arrange
        String firstName = null;
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setFirstName(firstName));
    }

    @Test
    void shouldThrowExceptionWhenSetWithEmptyFirstName(){
        //arrange
        String firstName = "";
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setFirstName(firstName));
    }

    @Test
    void shouldReturnEmployeeLastName(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        String lastName = employee1.getLastName();
        //assert
        assertEquals(lastName, "Pinheiro");
    }

    @Test
    void shouldSetEmployeeLastName(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        employee1.setLastName("Ferreira");
        String result = employee1.getLastName();
        //assert
        assertEquals("Ferreira", result);
    }

    @Test
    void shouldThrowExceptionWhenSetWithNullLastName(){
        //arrange
        String lastName = null;
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setLastName(lastName));
    }

    @Test
    void shouldThrowExceptionWhenSetWithEmptyLastName(){
        //arrange
        String lastName = "";
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setLastName(lastName));
    }

    @Test
    void shouldReturnEmployeeDescription(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        String description = employee1.getDescription();
        //assert
        assertEquals(description, "Developer");
    }

    @Test
    void shouldSetEmployeeDescription(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        employee1.setDescription("Teacher");
        String result = employee1.getDescription();
        //assert
        assertEquals("Teacher", result);
    }

    @Test
    void shouldThrowExceptionWhenSetWithNullDescription(){
        //arrange
        String description = null;
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setDescription(description));
    }

    @Test
    void shouldThrowExceptionWhenSetWithEmptyDescription(){
        //arrange
        String description = "";
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setDescription(description));
    }

    @Test
    void shouldReturnEmployeeJobYears(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        int jobYears = employee1.getJobYears();
        //assert
        assertEquals(jobYears, 5);
    }

    @Test
    void shouldSetEmployeeJobYears(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        employee1.setJobYears(3);
        int result = employee1.getJobYears();
        //assert
        assertEquals(3, result);
    }

    @Test
    void shouldThrowExceptionWhenSetWithNegativeJobYears(){
        //arrange
        int jobYears = -1;
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act and assert
        assertThrows(Exception.class, () -> employee1.setJobYears(jobYears));
    }

    @Test
    void shouldReturnEmployeeEmail(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        String email = employee1.getEmail();
        //assert
        assertEquals(email, "joao7pinheiro@hotmail.com");
    }

    @Test
    void shouldSetEmployeeEmail(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act
        employee1.setEmail("joaopinheiro888@hotmail.com");
        String result = employee1.getEmail();
        //assert
        assertEquals("joaopinheiro888@hotmail.com", result);
    }

    @Test
    void shouldThrowExceptionWhenSetWithNullEmail(){
        //arrange
        String email = null;
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setEmail(email));
    }

    @Test
    void shouldThrowExceptionWhenSetWithEmptyEmail(){
        //arrange
        String email = "";
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        //act + assert
        assertThrows(Exception.class, () -> employee1.setEmail(email));
    }

    @Test
    void shouldThrowExceptionWhenSetWithEmailMissingAtSymbol(){
        // arrange
        String email = "joaopinheiro123hotmail.com";
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        // act + assert
        assertThrows(IllegalArgumentException.class, () -> employee1.setEmail(email));
    }


    // toString() Test
    @Test
    void shouldReturnEmployeeToString(){
        //arrange
        Employee employee1 = new Employee("Joao", "Pinheiro", "Developer", 5, "joao7pinheiro@hotmail.com");
        employee1.setId(1L);
        //act
        String result = employee1.toString();
        // assert
        String expected = "Employee{id=1, firstName='Joao', lastName='Pinheiro', description='Developer', jobYears=5', email='joao7pinheiro@hotmail.com'}";
        assertEquals(expected, result);
    }


}