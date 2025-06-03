## Problem Statement: Food Delivery App

You are tasked with designing an Object-Oriented system for a Food Delivery Application,
similar to platforms like Swiggy, Zomato, or Uber Eats.

The system should allow customers to browse restaurants, place orders, and track deliveries. 
Restaurants should be able to manage their menu and receive orders.
Delivery agents should be able to accept and deliver orders.

### Analysis
- Design food delivery application
- Customer should be able to brows restaurants
- Customer should be able to place order
- Customer should be able to track deliveries
- Restaurant should be able to manage their menu
- Restaurant should be able to Receive orders
- Delivery agents shhould be able to accept orders
- Delivery agents shhould be able to deliver orders


### Questions
1. Do we need Admin?
2. Do we need Payment method?
3. Maintain Restauran open/closed status?
4. User can cancel order?

### Classes
1. Customer
   - Attribute: id: int, name: String, email : String, password: String, contactNumber: long, address: String
   - Behavior: get/set(), browsRestaurant(), deleteAddress(), updateAddress(), updateEmail(), updateMobileNumber()
               addItemToCart(), placeOrder(), trackDelivery().


2. Restaurant:
   - Attribute: id: int, name: String, description, email : String, contactNumber: long, menu : List <Items>
   - Behavior: get/set(), addItemTOMenu(), removeItemFromMenu(), acceptOrder(), rejectOrder()


3. Item
   - Attribute: id: int, name: String, description: String, price: float, serves : int
   - Behavior:get/set()


4. DeliveryAgent
   - Attribute: id: int, name: String, mobileNumber, email : String
   - Behavior: get/set(), acceptOrder(), updateStatusOnceDelivered()


5. Cart
   - Attribute: items : <Item>, totalBill: float
   - Behavior: get/set(), removeItem()
<<<<<<< HEAD

=======
>>>>>>> 3b5a880367f27e7bc2f59d9a3e369f24648c23ea
   
### Enums
1. Status : { ORDER_PLACED, ORDER_PREPARING, ORDER_PICKED/ORDER_ONTHEWAY, ORDER_DELIVERED }
