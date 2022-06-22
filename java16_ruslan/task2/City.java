package task2;

public class City {
  public String name;
  public City(String name) {
    this.name = name;
  }
  public City() {}
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  @Override public String toString() {
    return name;
  }
}