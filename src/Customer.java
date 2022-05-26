import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental aRental = enum_rentals.nextElement();
            frequentRenterPoints += aRental.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle() + "\t" + "\t" + aRental.getDaysRented() + "\t" + aRental.getCharge(aRental) + "\n";
            totalAmount += aRental.getCharge(aRental);
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
    