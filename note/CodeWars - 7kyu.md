# CodeWars - 7kyu

### Exes and Ohs

>##### Description:
>
>Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
>
>Examples input/output:
>
>```
>XO("ooxx") => true
>XO("xooxx") => false
>XO("ooxXm") => true
>XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
>XO("zzoo") => false
>```

- 解法：

```java
public class XO {
  public static boolean getXO (String str) {
      
    if(str.isEmpty()) return true;      
    HashMap<Character, Integer> map = new HashMap<>();
    char temp;
    int count = 0;
      
    for(int i = 0; i < str.length(); ++i) {
    temp = str.toLowerCase().charAt(i);
      if(temp == 'o' || temp == 'x') {
        count = map.get(temp) == null ? 0 : map.get(temp) + 1;
        map.put(temp, count);
      }
    }
      
     if(map.isEmpty()) {
       return true;
     } 
     
      //不写该判断，则最后一句比较返回可能报错，因为若键不存在的话，会返回空指针
     if(map.size() != 2) { 
       return false;
     }
     
     return map.get('x').equals(map.get('o'));
  }
}
```

- 思路：

  - 依次取出字符，转换为小写后判断其是否为`'x'或'o'`，满足条件则存入哈希表中，计数；
  - 注意：
    - 如果最后哈希表中的元素不为2，则返回false；
    - 哈希表中元素值得递增方法；
    - `.toLowerCase()`是string的方法，不是char的方法；

- 其他思路：

  - 解法一：

  ```java
  public class XO {
    
    public static boolean getXO (String str) {
      str = str.toLowerCase();
      return str.replace("o","").length() == str.replace("x","").length();   
    }
  }
  ```

  - 思路：
    - 分别去掉字符中的`'x'和'o'`后比较两个字符串的长度；
  - 解法二：

  ```java
  public class XO {
    public static boolean getXO(String str) {
      int x = 0, o = 0;
      for(int i = 0; i < str.length(); i++){
        if(str.toUpperCase().charAt(i) == 'O') o++;
        if(str.toUpperCase().charAt(i) == 'X') x++;
      }
      return x == o;
    }
  }
  ```

  - 思路：
    - 不用哈希表，直接存储计数；

