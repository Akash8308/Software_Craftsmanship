## Design a system for managing a simple online bookstore. Users can browse books, add them to a shopping cart, and place orders. Each book has a title, author, price, and a BookGenre (e.g., FICTION, SCIENCE, HISTORY, PROGRAMMING). The system should allow tracking of order status (e.g., PENDING, SHIPPED, DELIVERED, CANCELED).

## Questions: 
1. User can add multiple books to the kart?
2. User has UI? >  If "YES" can user create account?
3. save user's buyinig history?
4. Do we maintain stock status (inStock/outOfStock)? 
5. do we need to add payment info?
6. Do we need admin who will add books/price/genre etc?

### Classes
- Class Book:
   - Attribute: id, title, author, price, genre (Enum), stockStatus (Enum)
   - Behavior: get/set(),  update()


- Class Order:
  - Attribute: id, orderDetails, orderStatus
  - Behavior: get/set(), viewOrder(), cancelOrder()


- Enum orderStatus:
  - PENDING
  - SHIPPED
  - DELIVERED
  - CANCELED


- Enum BokkStatus:
  - inStock
  - outOfStock


- Enum BookGenre:
  - Fiction
  - Science
  - History
  - Programming


- Class Kart
  - Attribute: item, total
  - behavior: get/set(), clearKart(), addToKart(), showKart()
  

- Class User
  - Attribute: id, name
  - Behavior: get/set(), browsBooks(), addToKart(), placeOrder(), viewKart(), viewOrder(), viewOrderStatus()
