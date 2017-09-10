# Fizzbuzz

## Step 1
Write code that prints out the following for a contiguous range of numbers:
* the number
* 'fizz' for numbers divisible by 3
* 'buzz' for numbers divisible by 5
* 'fizzbuzz' for numbers divisible by both 3 and 5

e.g. if I run the program over a range from 1-20 I should get the following output:

`1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz`

## Step 2
Enhance your existing FizzBuzz solution to perform the following:
* If the number contains a three you must output the text 'lucky'. This overrides any existing behaviour

e.g. if I run the program over a range from 1-20 should get the following output:

`1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz`

## Step 3
Enhance your existing FizzBuzz solution to also print statistics about how many times the following were output:
* fizz
* buzz
* fizzbuzz
* luck
* number

e.g. if I run the prograrm over a range from 1-20 I should get the following output:
```
1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz
fizz: 4
buzz: 3
fizzbuzz: 1
luck: 2
number: 10
```