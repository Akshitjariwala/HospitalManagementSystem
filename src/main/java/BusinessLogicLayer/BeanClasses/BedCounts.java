package BusinessLogicLayer.BeanClasses;

import BusinessLogicLayer.BeanClasses.Bed;

public class BedCounts extends Bed {
  private int numberOfBeds;

  public BedCounts() {

  }

  public int getNumberOfBeds() {
    return this.numberOfBeds;
  }

  public void setNumberOfBeds(int numberOfBeds) {
    this.numberOfBeds = numberOfBeds;
  }
}
