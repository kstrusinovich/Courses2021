package by.part10;

import by.part10.internal.example3.ConcreteStrategyAdd;
import by.part10.internal.example3.ConcreteStrategyDivide;
import by.part10.internal.example3.ConcreteStrategyMultiply;
import by.part10.internal.example3.ConcreteStrategySubtract;
import by.part10.internal.example3.Context;

public class Example3 {

  public static void main(String[] args) {

    Context context = new Context();

    context.setStrategy(new ConcreteStrategyAdd());
    int resultA = context.executeStrategy(3, 4);

    context.setStrategy(new ConcreteStrategySubtract());
    int resultB = context.executeStrategy(3, 4);

    context.setStrategy(new ConcreteStrategyMultiply());
    int resultC = context.executeStrategy(3, 4);

    context.setStrategy(new ConcreteStrategyDivide());
    int resultD = context.executeStrategy(12, 4);

    System.out.println("Result A : " + resultA);
    System.out.println("Result B : " + resultB);
    System.out.println("Result C : " + resultC);
    System.out.println("Result D : " + resultD);
  }
}
