package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.Regulations;

import java.util.*;

public class SelectedItemsByUserHelper {
//    private static Set<String> selectedVendorCodes = new HashSet<>();
    private static Map<String, Regulations> selectedVendorCodesAndRegulations = new HashMap<>();


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

    public static void addToSelectedVendorCodesAndRegulations(String vendorCode, Regulations regulations) {
        selectedVendorCodesAndRegulations.put(vendorCode, regulations);
    }

    public static Map<String, Regulations> getSelectedVendorCodesAndRegulations() {
        return selectedVendorCodesAndRegulations;
    }

    public static void clearSelectedVendorCodesAndRegulations() {
        selectedVendorCodesAndRegulations.clear();
    }

    public static void removeFromSelectedVendorCodesAndRegulations(String vendorCode) {
        selectedVendorCodesAndRegulations.remove(vendorCode);
    }
}
