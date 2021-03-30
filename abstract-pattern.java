// file Shape.java
public interface Shape {
   void draw();
}
// file Rectangle.java
public class Rectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

// file Square.java
public class Square implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

// file Circle.java
public class Circle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}
// file Color.java
public interface Color {
   void fill();
}
// file Red.java
public class Red implements Color {
   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}

// file Green.java
public class Green implements Color {
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}

// file Blue.java
public class Blue implements Color {
   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}
// file AbstractFactory.java
public abstract class AbstractFactory {
   abstract Color getColor(String color);
   abstract Shape getShape(String shape) ;
}
// file ShapeFactory.java
public class ShapeFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }     
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }

      return null;
   }

   @Override
   Color getColor(String color) {
      return null;
   }
}

// file ColorFactory.java
public class ColorFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   @Override
   Color getColor(String color) {
      if(color == null){
         return null;
      }     
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      }else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      }else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }

      return null;
   }
}
// file FactoryProducer.java

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      }else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}
// file AbstractFactoryPatternDemo.java

public class AbstractFactoryPatternDemo {
   public static void main(String[] args) {
      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

      Shape shape1 = shapeFactory.getShape("CIRCLE");
      shape1.draw();

      Shape shape2 = shapeFactory.getShape("RECTANGLE");
      shape2.draw();

      Shape shape3 = shapeFactory.getShape("SQUARE");
      shape3.draw();

      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

      Color color1 = colorFactory.getColor("RED");
      color1.fill();

      Color color2 = colorFactory.getColor("Green");
      color2.fill();

      Color color3 = colorFactory.getColor("BLUE");
      color3.fill();
   }
}