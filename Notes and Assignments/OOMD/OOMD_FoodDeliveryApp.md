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
1. 

### Classes
1. Customer
   - Attribute: id, name, email, password, mobileNumber, address
     - Behavior: get/set(), browsRestaurant(), deleteAddress(), updateAddress(), updateEmail(), updateMobileNumber()
                  addItemToCart(), placeOrder(), trackDelivery().

2. Restaurant:
   - Attribute: id, name, description, email, mobileNumber, mennu : List <Items>
   - Behavior: get/set(), addItemTOMenu(), removeItemFromMenu(), acceptOrder(), rejectOrder()

3. Item
   - Attribute: id, name, description, price, serves : int
   - Behavior:get/set()

4. DeliveryAgent
   - Attribute: id, name, mobileNumber, email
   - Behavior: get/set(), acceptOrder(), updateStatus()

5. Cart
   - Attribute: items : <Item>, totalBill
   - Behavior: get/set(), removeItem()

2. a
   - Attribute:
   - Behavior:
### Enums
1. Status : {ORDER_PLACED, ORDER_PREPARIN, ORDER_PICKED, ORDER_DELIVERED }