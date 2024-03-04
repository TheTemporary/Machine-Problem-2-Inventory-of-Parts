public class Transaction extends Inventory {
  int CountRecords;
  Inventory[] records;

  public Transaction(long partNumber, String partDiscriptioString, Float price, Boolean isDelete) {
    super(partNumber, partDiscriptioString, price, isDelete);
    createInventoryArray(partNumber, partDiscriptioString, price, isDelete);

  }
 
  public Transaction() {
    records = new Inventory[100000];
    CountRecords = 0;
  }

  // creating a record
  public void createInventoryArray(long partNumber, String partDiscriptioString, Float price, Boolean isDelete) {
    records[CountRecords] = new Inventory(partNumber, partDiscriptioString, price, isDelete);
    CountRecords++;
  }

  // updating the inventory
  public Boolean updateRecordPrice(long partNumber, Float newPrice) {
    Boolean isChange = false;
    try {
      // looping through the records
      for (int i = 0; i < CountRecords; i++) {
        // if the partnumber is found, it will be updated
        if (records[i] != null && records[i].getPartNumber() == partNumber) {
          records[i].setPrice(newPrice);
          isChange = true;
        }
      }
    } catch (Exception e) {
      System.out.println("Wrong input part number, please try again.");
    }
    return isChange;
  }

  public Boolean updateRecordDescription(long partNumber, String NewpartDiscription) {
    Boolean isChange = false;
    try {
      // looping through the records
      for (int i = 0; i < CountRecords; i++) {
        // if the partnumber is found, it will be updated
        if (records[i] != null && records[i].getPartNumber() == partNumber) {
          records[i].setpartDiscription(NewpartDiscription);
          isChange = true;
        }
      }
    } catch (Exception e) {
      System.out.println("Wrong input part number, please try again.");
    }
    return isChange;
  }
  // The method iterates through the `records` array and checks if a record with a matching part number exists and is not marked as deleted.
  public Boolean findPartNum(long PartNum) {
    Boolean isFind = false;
    for (int i = 0; i < CountRecords; i++) {
      if (records[i].partNumber == PartNum && records[i].isDelete ==false) {
        isFind = true;
      }
    }
    return isFind;
  }
  // The method iterates through the `records` array and sets the `isDelete` flag to `true`
  public Boolean Delete(long PartNum) {
    Boolean isFind = false;
    for (int i = 0; i < CountRecords; i++) {
      if (records[i].partNumber == PartNum) {
        records[i].setDelete(true);
        isFind = true;
      }
    }
    return isFind;
  }

  // this prints out inventory records in a tabular format, including part number, description, and price.
  public void displayAllRecords() {
    System.out.println("Inventory Records");
    System.out.println();
    System.out.println("PartNumber     || Description               || Price     ");
    for (int i = 0; i < CountRecords; i++) {
      if (records[i] != null && records[i].isDelete!=true) {
        System.out.println(
            records[i].partNumber + "     || " + records[i].partDiscription + "          || $ " + records[i].price);
      }
    }
  }
}
