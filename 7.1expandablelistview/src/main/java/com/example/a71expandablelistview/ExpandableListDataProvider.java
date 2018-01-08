package com.example.a71expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ADMIN on 1/3/2018.
 */

public class ExpandableListDataProvider {

    public static HashMap<String, List<String>> getData() {

        HashMap<String, List<String>> expandableListDetails = new HashMap<String, List<String>>();

        List<String> Maharashtra = new ArrayList<>();
        Maharashtra.add("Mumbai");
        Maharashtra.add("Pune");
        Maharashtra.add("Nashik");
        Maharashtra.add("Nagpur");
        Maharashtra.add("Wardha");
        Maharashtra.add("Aurangabad");

        List<String> Gujarat = new ArrayList<>();
        Gujarat.add("Vadodara");
        Gujarat.add("Gandhinagar");
        Gujarat.add("Surat");
        Gujarat.add("Baroda");

        List<String> Kerala = new ArrayList<>();
        Kerala.add("Kochi");
        Kerala.add("Ernakulum");
        Kerala.add("Trivendrum");
        Kerala.add("Palakkad");
        Kerala.add("Kottayam");

        List<String> Karnataka = new ArrayList<>();
        Karnataka.add("Bangaluru");
        Karnataka.add("Mangagaluru");
        Karnataka.add("Kurg");
        Karnataka.add("Mysore");

        expandableListDetails.put("MAHARASHTRA", Maharashtra);
        expandableListDetails.put("GUJARAT", Gujarat);
        expandableListDetails.put("KERALA", Kerala);
        expandableListDetails.put("KARNATAKA", Karnataka);
        return expandableListDetails;
    }
}
