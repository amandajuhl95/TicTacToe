## Tic Tac Toe
 
### Test Assignment 4 

Made by Sofie Amalie Landt, Amanda Juhl Hansen & Benjamin Aizen Kongshaug

#### 1. Mockito Powerups

##### How do you verify that a mock was called?
```
Import static org.mockito.Mockito.verify;
verify(mock).someMethod();
```

We verify that the Mockito.mock has been called with a method someMethod().

##### How do you verify that a mock was NOT called?
```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.never;

verify(mock, never()).someMethod();
```
We verify that the Mockito.mock never is called with the method someMethod().

##### How do you specify how many times a mock should have been called?
```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.times;

verify(mock, times(wantedNumberOfInvocations)).someMethod();
```

We verify that the Mockito.mock has been called a specific number of times (wantedNumberOfInvocations) with a method someMethod().

##### How do you verify that a mock was called with specific arguments?
```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.eq;

verify(mock)).someMethod(eq(“first”));
```

or 

For Objects as argument

```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.ArgumentCaptor;

ArgumentCaptor<T> captor = ArgumentCaptor.forClass(T.class);

We verify that the Mockito.mock has been called a with a method someMethod() with specific arguments.


verify(mock)).someMethod(captor.capture());
assertTrue(captor.getAllValues().get(0) == “first”);
assertTrue(captor.getAllValues().get(1) == “second”);
![image](https://user-images.githubusercontent.com/47500265/143779474-b1ae4f60-5497-45cd-b502-82fbee4c110c.png)


##### How do you use a predicate to verify the properties of the arguments given to a call to the mock?

#### 2. At Least One

We have decided to make Tic Tac Toe in Java with an AI that uses MiniMax. For this we have used:

- Jacoco as coverage report
- PITest as mutation testing
- FindSpots as static analysis 



