# Unusual Spends

You work at a credit card company and as a value-add they want to start providing alerts to users when their spending in any particular category is higher than usual.
- Compare the total amount paid for the current month, grouped by category with the previous month
- Filter down to the categories for which the user spent at least 50% more this month than last month
- Compose an e-mail message to the user that lists the categories for which spending was unusually high

Sample Email -

``` 
Unusual spending of ₹1076 detected!

Hello Baburao!

We have detected unusually high spending on your card in these categories:

* You spent ₹148 on groceries
* You spent ₹928 on travel

Thanks,

The Credit Card Company 
```



---

## Analysis:

- You work at a credit card company
- User spend using Credit Card
- Calculate the total spending in each category
- Start providing alerts to customer when their spending in any category is higher than usual
- Group the spends by category
- Compare total amount paid for the current month in a group
- Filter the categories where user has spent at least 50% more than last month
- Compose and send email in the above given format

## Questions:
- can user block the credit card -> No

--- 

## Modelling:

### 1. CreditCard: Entity
#### attributes: number: String, userId: String
#### behaviours: get/set, addTransaction(transactionId: String)

### 2. User: Entity
#### attributes: id: String, name: String, email: String, mobile: String, card: List<CreditCard>
#### behaviours: get/set, spend(amount: double)

### 3. SpendingCategory: Value Object
#### constants: FOOD, GROCERIES, FUEL, ENTERTAINMENT, UTILITY, TRAVEL, ...

### 4. Transaction: Entity
#### attributes: id: String, double amount, merchantId: String, creditCardId: String, timestamp: DateTime
#### behaviours: get/set, getMonth()

### 5. Merchant: Entity
#### attributes: id: String, name: String, category: SpendingCategory 
#### behaviours: get/set

### 6. UnusualSpendsProcessor: Service
#### behaviours: getUnusualSpending(lastMonthSpending: SpendingByCategoryAndAmount, currentMonth: SpendingByCategoryAndAmount)
