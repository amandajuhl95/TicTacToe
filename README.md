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

If the mock takes simple types as argument:

```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.eq;

verify(mock)).someMethod(eq(“first”));
```

or if it takes Objects as argument:

```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.ArgumentCaptor;

ArgumentCaptor<T> captor = ArgumentCaptor.forClass(T.class);
```

We verify that the Mockito.mock has been called a with a method someMethod() with specific arguments.

```
verify(mock)).someMethod(captor.capture());
assertTrue(captor.getAllValues().get(0) == “first”);
assertTrue(captor.getAllValues().get(1) == “second”);
```

##### How do you use a predicate to verify the properties of the arguments given to a call to the mock?

```
Import static org.mockito.Mockito.verify;
Import static org.mockito.Mockito.argThat;

verify(mock)).someMethod(argThat(x -> x.getAttribute() == value));
```

We verify that the Mockito.mock has been called a with a method someMethod() with specific arguments.

#### 2. At Least One

We have decided to make Tic Tac Toe in Java with an AI that uses MiniMax. For this we have used:

- PITest for mutation testing
- Jacoco for coverage report

<img width="739" alt="Skærmbillede 2021-11-28 kl  19 16 14" src="https://user-images.githubusercontent.com/47500265/143780714-844b76b9-d4cb-475b-b927-aef0906f9c17.png">

- FindSpots for static analysis 

<img width="994" alt="Skærmbillede 2021-11-28 kl  19 19 05" src="https://user-images.githubusercontent.com/47500265/143780821-162f7334-3677-41c1-83ec-6857b602b5e0.png">



