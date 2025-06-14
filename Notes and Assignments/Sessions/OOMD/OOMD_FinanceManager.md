# Problem Statement: Personal Finance Tracker

## You need to design a simple application to help individuals track their personal finances. The system should allow users to record income and expenses, categorize transactions, and manage different accounts.

## Questions: 
1. User can have multiple accounts?
2. Do we want to track expense category? (Rent, Elec Bill, Food, etc)

### Classes

### Class: User

Attributes: userId, name, email, accounts: List<Account>

Behaviors: addAccount, removeAccount, getTotalBalance

### Class: Account

Attributes: accountId, accountName, accountType, balance, transactions: List<Transaction>

Behaviors: addTransaction, getBalance

### Enum: accountType
{
  Savings,
  Credit,
  Wallet
}

### Class: Transaction

Attributes: transactionId, date, amount, description, category, transactionType

Behaviors: isExpense(), isIncome

### Enum : transactionType
{
  INCOME,
  EXPENSE
}

### Class: Category

Attributes: categoryId, name 

Behaviors: rename

### Class: FinanceManager

Attributes: users

Behaviors: addUser, getUser, generateReport

---

### Class: Report

Attributes: user, startDate, endDate, incomeTotal, expenseTota, categoryWiseBreakdown

Behaviors: generateSummary(), getCategoryWiseBreakdown
