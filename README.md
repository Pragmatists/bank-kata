Bank account kata
=================

Think of your personal bank account experience
When in doubt, go for the simplest solution

Requirements
------------

* Deposit and Withdrawal
* Account statement (date, credit, debit, balance)
* Statement printing
* Transfer to another account
* Statement filters (just deposits, withdrawal, date)

Statement should have transactions in the following format:

```
   date        | credit    | debit     | balance
   14/01/2012  |           | 500.00    | 2500.00
   13/01/2012  | 2000.00   |           | 3000.00
   10/01/2012  | 1000.00   |           | 1000.00
```


The Rules
---------

1. One level of indentation per method
2. Don’t use the 'else' keyword
3. Wrap all primitives and Strings
4. First class collections
5. One dot per line
6. Don’t abbreviate
7. Keep all entities small (50 lines)
8. No classes with more than two instance variables
9. No getters/setters/properties


Implementation Guidelines
=========================

**Note:** Start with an acceptance test through the Account class:

    public class Account {
        deposit(amount);
        withdraw(amount);
        printStatement();
    }

You are not allowed to add any other methods to that class

#### For more information:

-  [Object Calisthenics pdf](http://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)
-  Object Calisthenics (full book), Jeff Bay in: The ThoughtWorks Anthology.
   Pragmatic Bookshelf 2008
-  Original idea for the kata: [How Object-Oriented Are You Feeling Today?](https://www.slideshare.net/KrzysztofJelski/how-object-oriented-are-you-feeling-today) - Krzysztof Jelski (Session on the Software Craftsmanship UK 2011 conference)
- sample solution: [https://github.com/sandromancuso/Bank-kata.git](https://github.com/sandromancuso/Bank-kata.git)
