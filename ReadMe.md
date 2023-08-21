# Chapter 4 - Arrays A
## Part A : Code Commenting Exercise

## Introduction

This exercise is designed to help you understand every line of code by writing comments. Each line of code and annotation has a purpose, and by documenting it, you will deepen your understanding of Java and best coding practices. You will write comments
for all classes and test classes in `parta`

## Instructions

Look in the package `com.codedifferentlt.labs.partA`

1. **Understand Before Commenting**: Before you start, read through the code. If there are lines of code or annotations you don't understand, research or ask questions to clarify. The goal is to genuinely understand the purpose and function of each line.

2. **Comments**: Write a comment for each line of code and annotation in the provided file. Your comments should be succinct but explanatory enough that someone new to Java can understand what's happening.

  - For example, if you see:
    ```java
    import java.util.Scanner;
    ```
    Your comment might be:
    ```java
    // Importing the Scanner class from the Java utility package to take user input.
    ```

3. **Annotations**: If you come across any annotations, ensure you understand their purpose and document it accordingly.

  - For instance:
    ```java
    @Override
    ```
    Your comment can be:
    ```java
    // @Override is an annotation indicating the following method is intended to override a method in a superclass.
    ```

4. **Avoid Stating the Obvious**: While we want you to comment on each line, avoid redundant comments that only state the obvious.

  - Not so good:
    ```java
    int count = 0;  // Declare integer variable count and set it to 0.
    ```

  - Better:
    ```java
    int count = 0;  // Initializing a counter variable.
    ```

5. **Use Multi-Line Comments for Blocks**: If a block of code (like a for-loop or if-statement) is doing one single task, use a multi-line comment to describe the task rather than commenting on each line individually.

  - Example:
    ```java
    /*
     * This loop iterates through the array and prints each element.
     */
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
    ```

6. **Review**: After commenting, read through the code again. Ensure that your comments provide a clear understanding and that there aren't any lines left uncommented.

7. **Discuss**: Pair up with a classmate. Exchange your commented files and discuss the comments. This peer review is a valuable opportunity to learn from different perspectives and interpretations.

## Conclusion

Commenting is not just for documentation but also an invaluable tool for understanding and collaboration. By diving deep into each line of code, you're enhancing your foundational knowledge, ensuring that as you progress, you're building on a solid base.

## Part B Lab: 10 Items or Less


## Objective:
Build a Shopping Cart Simulator using Java with the Maven build tool, an object-oriented approach, and Test-Driven Development (TDD) principles using JUnit 5. In the `partb` package

### 1. Setting Up the Base Classes:
Create two main classes:
- `Product`: This class will represent a product with attributes like `name`, `price`, and `productId`.
- `ShoppingCart`: This class will hold an array of products and will have methods to add a product, remove a product, and calculate the total price.

### 2. TDD Approach:

#### 3.1. Start with the Product class:
Before implementing the class, write your tests first.

Create a new class in the `test` directory: `ProductTest`.

Write tests:
- Test the creation of a product.
- Test retrieving product attributes (getters).

Sample test:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testCreateProduct() {
        Product product = new Product("Book", 10.99, 1);
        assertEquals("Book", product.getName());
        assertEquals(10.99, product.getPrice());
        assertEquals(1, product.getProductId());
    }
}
```

Implement the `Product` class to pass the tests.

```
 +-------------------------------+
 |          <<class>>             |
 |           Product              |
 +-------------------------------+
 | -name : String                 |
 | -price : double                |
 | -productId : int               |
 +-------------------------------+
 | +Product(name: String,         |
 |          price: double,        |
 |          productId: int)       |
 | +getName(): String             |
 | +getPrice(): double            |
 | +getProductId(): int           |
 +-------------------------------+
```

#### 3.2. ShoppingCart class:

Similarly, before implementing the class, write your tests first.

Create a new class in the `test` directory: `ShoppingCartTest`.

Write tests:
- Test adding a product to the cart.
- Test removing a product from the cart.
- Test calculating the total price.

Sample test:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Book", 10.99, 1);
        cart.addProduct(product);
        assertEquals(1, cart.numberOfProducts());
    }
    
    @Test
    void testTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Book", 10.99, 1));
        cart.addProduct(new Product("Pen", 0.99, 2));
        assertEquals(11.98, cart.calculateTotal());
    }
    
    // Continue with other tests like removing a product, etc.
}
```

Now, implement the `ShoppingCart` class to pass the tests.

```
 +------------------------------------------------------+
 |          <<class>>                                   |
 |         ShoppingCart                                 |
 +------------------------------------------------------+
 | -products : Product[]                                |
 +------------------------------------------------------+
 | +ShoppingCart()                                      |
 | +addProduct(product: Product): boolean               |
 | +replaceProduct(index:int, product: Product): boolean|
 | +removeProduct(index:int) : boolean                  |
 | +calculateTotal(): double                            |
 | +numberOfProducts(): int                             |
 +------------------------------------------------------+
```

Here are the detailed instructions for the methods in the `ShoppingCart` class based on your description:

**1. Constructor**
- Purpose: The constructor should initialize the `products` array to have a size of 10.
- Steps:
    - Directly in the constructor, instantiate the `products` array to a new array of `Product` with a size of 10.

**2. addProduct**
- Purpose: To add a product to the next available empty slot in the array.
- Steps:
    - Loop through the `products` array.
    - For each index, check if the element at that index is `null`.
    - If it is, place the product in that slot and return `true`.
    - If you've looped through the entire array and found no empty slot, return `false`.

**3. replaceProduct**
- Purpose: To replace a product at a specified index.
- Steps:
    - Take in the desired index and product as parameters.
    - Check if the index is valid (0 to 9).
    - Set the product at that index to the new product.

**4. calculateTotal**
- Purpose: To calculate and return the total cost of all products in the cart.
- Steps:
    - Initialize a double variable `total` to 0.
    - Loop through the `products` array.
    - For each non-null product, add its price to `total`.
    - Return `total`.

**5. removeProduct**
- Purpose: To remove a product at a specified index.
- Steps:
    - Take in the desired index as a parameter.
    - Check if the index is valid (0 to 9).
    - If the product at that index is not `null`, set it to `null` and return `true`.
    - If the product was already `null`, return `false` (or `true`, depending on your needs – this behavior can vary).

**6. numberOfProducts**
- Purpose: To return the number of non-null products in the array.
- Steps:
    - Initialize an integer variable `count` to 0.
    - Loop through the `products` array.
    - For each non-null product, increment the `count`.
    - Return `count`.


### 4. Implementing the Classes:
Based on the tests you've written, now implement the methods in the `Product` and `ShoppingCart` classes.

### 5. Expand & Refactor:
As you build the system, you may encounter scenarios or edge cases you hadn't thought of initially. Go back, update your tests to cover these cases, and then modify your classes to pass the new tests.

### 7. Main

Certainly! I'll walk the students through creating a menu-driven approach, where users can not only add items to the cart but also view the cart, remove items, replace items, and check out.

---

## Main.java Class Implementation Instructions:

### 1. Setup:

Begin by importing necessary packages and defining the `Main` class:
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Your code goes here
    }
}
```

### 2. Inside the `main` method:

#### 2.1 Initialize the Scanner:
```java
Scanner scanner = new Scanner(System.in);
```

#### 2.2 Create some sample products:
```java
Product[] sampleProducts = {
    new Product("Product 1", 10.99),
    new Product("Product 2", 5.49),
    new Product("Product 3", 7.89),
    // ... add more sample products
};
```

#### 2.3 Instantiate the ShoppingCart:
```java
ShoppingCart cart = new ShoppingCart();
```

#### 2.4 Implement the menu-driven program:

Set up a loop inside the main() , that displays the main menu and prompts the user for their choice.
```java
boolean continueShopping = true;

while (continueShopping) {
    System.out.println("\n--- MENU ---");
    System.out.println("1. List available products");
    System.out.println("2. Add a product to the cart");
    System.out.println("0. Exit");
    
    System.out.print("\nSelect an option: ");
    int menuChoice = scanner.nextInt();
    
    switch (menuChoice) {
        case 1:
            // Display available products
            for (int i = 0; i < sampleProducts.length; i++) {
                System.out.println((i + 1) + ". " + sampleProducts[i].getName() + " - $" + sampleProducts[i].getPrice());
            }
            break;

        case 2:
            System.out.println("Enter product number to add to the cart:");
            int choiceToAdd = scanner.nextInt();
            if (choiceToAdd > 0 && choiceToAdd <= sampleProducts.length) {
                if (cart.addProduct(sampleProducts[choiceToAdd - 1])) {
                    System.out.println(sampleProducts[choiceToAdd - 1].getName() + " added to the cart.");
                } else {
                    System.out.println("Cart is full! Consider removing or replacing items.");
                }
            } else {
                System.out.println("Invalid choice! Please select a valid product number.");
            }
            break;
            
        case 0:
            continueShopping = false;
            break;

        default:
            System.out.println("Invalid choice! Please select a number from the menu.");
    }
}
```

---

This menu-driven program will allow users to interact with their shopping cart in multiple ways, providing them with a comprehensive shopping experience through the terminal.

### 6. Conclusion:
By the end of this lab, you will have a basic Shopping Cart Simulator built using the principles of Object-Oriented Programming and Test-Driven Development.

### Tips:
- Always write tests before implementing your methods.
- Ensure all tests pass after you've written your method implementations.
- If you modify a method, ensure you update and rerun your tests.

Good luck, and happy coding!