# CodeWars - 5kyu

### Product of consecutive Fib numbers

>The Fibonacci numbers are the numbers in the following integer sequence (Fn):
>
>> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
>
>such as
>
>> F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
>
>Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
>
>> F(n) * F(n+1) = prod.
>
>Your function productFib takes an integer (prod) and returns an array:
>
>```
>[F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
>```
>
>depending on the language if F(n) * F(n+1) = prod.
>
>If you don't find two consecutive F(m) verifying `F(m) * F(m+1) = prod`you will return
>
>```
>[F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
>```
>
>F(m) being the smallest one such as `F(m) * F(m+1) > prod`.
>
># Examples
>
>```java
>productFib(714) # should return {21, 34, 1}, 
>                # since F(8) = 21, F(9) = 34 and 714 = 21 * 34
>
>productFib(800) # should return {34, 55, 0}, 
>                # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
>```
>
>**Notes:** Not useful here but we can tell how to choose the number n up to which to go: we can use the "golden ratio" phi which is `(1 + sqrt(5))/2` knowing that F(n) is asymptotic to: `phi^n / sqrt(5)`. That gives a possible upper bound to n.
>
>You can see examples in "Example test".
>
>### References
>
>http://en.wikipedia.org/wiki/Fibonacci_number
>
>http://oeis.org/A000045

- 解法：

```java
public class Product_of_consecutive_Fib_numbers {
    public static long[] productFib(long prod) {
        long a = 0;
        long b = 1;
        long temp = a * b;
        while(temp < prod) {
            b = a + b;
            a = b - a;
            temp = a * b;
        }
        return new long[]{a, b, prod == temp ? 1 : 0};
    }
}
```

- 思路：

  - ```java
    long a = 0; //f(0)
    long b = 1; //f(1)
    b = a + b; // f(2)
    a = b - a; // f(1)
    ```

    可以使用上述方式交替求出各斐波那契数

  - 注意a 和b的类型设定为long，若设定为Int，有可能在后期数字过大以后超过了int的取值范围，使得`temp < prod`恒定为真，导致进入死循环