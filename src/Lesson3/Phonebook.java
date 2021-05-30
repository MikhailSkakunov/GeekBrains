package Lesson3;

import java.util.Map;
import java.util.Set;

interface PhoneBook {

    void add (String nameСustomer, String phoneCustomer);

    Set<String> get(String nameСustomer);

    Set<String> getAllPhoneCustomer();

    }
