# Stream API Example  

***

#### Data Model

````java
@Data
@Entity
@NoArgsConstructor
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private Integer tier;
}

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private LocalDate orderDate;
  private LocalDate deliveryDate;
  private String status;
  
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
  
  @ManyToMany
  @JoinTable(
      name = "order_product_relationship",
      joinColumns = { @JoinColumn(name = "order_id") },
      inverseJoinColumns = { @JoinColumn(name = "product_id") }
  )
  @ToString.Exclude
  Set<Product> products;
    
}


@Data
@NoArgsConstructor
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private String category;
  @With private Double price;
  
  @ManyToMany(mappedBy = "products")
  @ToString.Exclude
  private Set<Order> orders;
}
````

***
#### Exercise 1 - Obtain a list of products belongs to category “Books” with price > 100

````java
List<Product> result = productRepository.findAll()
                                .stream()
                                .filter(p -> p.getCategory().equals("Books"))
                                .filter(p -> p.getPrice() > 100)
                                .collect(Collectors.toList()); 
````


#### Exercise 2 - Obtain a list of order with products belong to category “Baby”

````java
List<Order> result = orderRespository.findAll()
                                .stream()
                                .filter(o -> 
                                    o.getProducts
                                    .stream()
                                    .anyMatch(p -> p.getCategory().equals("Baby")))
                                .collect(Collectors.toList()); 
````

#### Exercise 3 - Obtain a list of product with category = “Toys” and then apply 10% discount

````java
List<Product> result = productRepository.findAll()
                                .stream()
                                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                                .map(p -> p.withPrice(p.getPrice() * 0.9))
                                .collect(Collectors.toList()); 
````

#### Exercise 4 - Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021

````java
List<Product> result = orderRepositry.findAll()
                                .stream()
                                .filter(o -> o.getCustomer().getTier() == 2)
                                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                                .flatMap(o -> getProducts().stream())
                                .distinct()
                                .collect(Collectors.toList()); 
````

#### Exercise 5 - Get the cheapest products of “Books” category

````java
Optional<Product> result = productRepository.findAll()
                                .stream()
                                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                                .sorted(Comparator.comparing(Product::getPrice))
                                .findFirst(); 
````

or

````java
Optional<Product> result = productRepository.findAll()
                                .stream()
                                .filter(p -> p.getCateogry().equalsIgnoreCase("Books"))
                                .min(Comparator.comparing(Product::getPrice))
````

#### Exercise 6 - Get the 3 most recent placed order

````java
List<Order> result = orderRepository.findAll()
                            .stream()
                            .sorted(Comparator.comparing(Order::getOrderDate).reversed()))
                            .limit(3)
                            .collect(Collectors.toList()); 
````

#### Exercise 7 - Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list

````java
List<Product> result = orderRepository.findAll()
                            .stream()
                            .filter(o -> getOrderDate().isEqual(LocalDate.of(2021,3,15)))
                            .peek(o -> System.out.println(o.toString()))
                            .flatMap(o -> o.getProducts.stream())
                            .distinct()
                            .collect(Collectors.toList());
````

#### Exercise 8 - Calculate total lump sum of all orders placed in Feb 2021

````java
Double result = orderRepository.findAll()
                            .stream()
                            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                            .flatMap(o -> o.getProducts().stream())
                            .mapToDouble(p -> p.getPrice())
                            .sum(); 
````

#### Exercise 9 - Calculate order average payment placed on 14-Mar-2021

````java
Double result = orderRepository.findAll()
                            .stream()
                            .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                            .flatMap(o -> o.getProducts().stream())
                            .mapToDouble(p -> p.getPrice())
                            .average()
                            .getAsDouble();
````

#### Exercise 10 - Obtain a collection of statistic figures 

````java
DoubleSummaryStatistics statistics = productRepository.findAll()
                            .stream()
                            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                            .mapToDouble(p -> p.getPrice())
                            .summaryStatistics(); 

  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum())));
````

#### Exercise 11 - Obtain a data map with order id and order’s product count

````java
Map<Long, Integer> result = orderRepository.findAll()
                            .stream()
                            .collect(
                                Collectors.toMap(
                                    order -> order.getId()
                                    order -> order.getProducts().size()
                                )      
                            );   
````

#### Exercise 12 - Produce a data map with order records grouped by customer

````java
Map<Customer, List<Order>> result = orderRepository.findAll()
                            .stream()
                            .collect(
                                Collectors.groupingBy(Order::getCustomer)
                            );      
````

#### Exercise 13 - Produce a data map with order record and product total sum

````java
Map<Order, Double> result = orderRepository.findAll()
                            .stream()
                            .collect(
                                Collectors.toMap(
                                    Function.identity(),
                                    order -> order.getProducts().stream()
                                        .mapToDouble(p -> p.getPrice())
                                        .sum()
                                )                            
                            );                                
````

#### Exercise 14 -  Obtain a data map with list of product name by category

````java
Map<String, List<String>> result = productRepository.findAll()
                            .stream()
                            .collect(
                                Collectors.groupingBy(
                                    Product::getCategory,
                                    Collectors.mapping(product -> product.getName(), Collectors.toList())
                                )  
                            );      
````

#### Exercise 15 - Get the most expensive product by category

````java
Map<String, Optional<Product>> result = productRepository.findAll()
                            .stream()
                            .collect(
                                Collectors.groupingBy(
                                    Product::getCategory,
                                    Collectors.maxBy(Comparator.comparing(Product::getPrice))
                                )  
                            );  
````


