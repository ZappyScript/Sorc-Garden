package gui;

public class Vendor {
String name;
int ID;

@Override
public String toString() {
    return name;
}

public Vendor(String name, int ID) {
    this.name = name;
    this.ID = ID;
}


}