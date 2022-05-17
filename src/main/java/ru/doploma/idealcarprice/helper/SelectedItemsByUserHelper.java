package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.City;
import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.model.PartCode;

import java.util.*;

public class SelectedItemsByUserHelper {
    private static City selectedCity;
//    private static Set<String> selectedVendorCodes = new HashSet<>();
    private static Map<String, Defect> selectedVendorCodesAndDefects = new HashMap<>();

    public static void setSelectedCity(City city) {
        selectedCity = city;
    }

    public City getSelectedCity(City city) {
        return selectedCity;
    }

//    public static void addToSelectedVendorCodes(String vendorCode) {
//        selectedVendorCodes.add(vendorCode);
//    }
//
//    public static Set<String> getSelectedVendorCodes() {
//        return selectedVendorCodes;
//    }
//
//    public static void clearSelectedDetails() {
//        selectedVendorCodes.clear();
//        clearSelectedVendorCodesAndDefects();
//    }

    public static void addToSelectedVendorCodesAndDefects(String vendorCode, Defect defect) {
        selectedVendorCodesAndDefects.put(vendorCode, defect);
    }

    public static Map<String, Defect> getSelectedVendorCodesAndDefects() {
        return selectedVendorCodesAndDefects;
    }

    public static void clearSelectedVendorCodesAndDefects() {
        selectedVendorCodesAndDefects.clear();
    }

    public static void removeFromSelectedVendorCodesAndDefects(String vendorCode) {
        selectedVendorCodesAndDefects.remove(vendorCode);
    }
}
