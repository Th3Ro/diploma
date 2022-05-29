package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;;

import java.util.*;

public class SelectedItemsByUserHelper {
    private static Model selectedModel = null;
    private static Map<String, List<PartCode>> selectedPartCodesAndRegulations = new HashMap<>();

    public static void changeSelectedModel(Model model) {
        selectedModel = model;
    }

    public static Model getSelectedModel() {
        return selectedModel;
    }

    public static void clearSelectedModel () {
        selectedModel = null;
    }

    public static void addToSelectedVendorCodesAndRegulations(String regulationsId, List<PartCode> partCodes) {
        selectedPartCodesAndRegulations.put(regulationsId, partCodes);
    }

    public static Map<String, List<PartCode>> getSelectedPartCodesAndRegulations() {
        return selectedPartCodesAndRegulations;
    }

    public static void clearSelectedVendorCodesAndRegulations() {
        selectedPartCodesAndRegulations.clear();
    }

    public static void removeFromSelectedVendorCodesAndRegulations(String regulationsId) {
        selectedPartCodesAndRegulations.remove(regulationsId);
    }
}
