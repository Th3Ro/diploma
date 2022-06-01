package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.BodyWork;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;;

import java.util.*;

public class SelectedItemsByUserHelper {
    private static Model selectedModel = null;
    private static Map<Long, List<PartCode>> selectedPartCodesAndRegulations = new HashMap<>();
    private static Map<Long, BodyWork> selectedBodyWorks = new HashMap<>();

    public static void changeSelectedModel(Model model) {
        selectedModel = model;
    }

    public static Model getSelectedModel() {
        return selectedModel;
    }

    public static void clearSelectedModel () {
        selectedModel = null;
    }

    public static void addToSelectedVendorCodesAndRegulations(Long regulationsId, List<PartCode> partCodes) {
        selectedPartCodesAndRegulations.put(regulationsId, partCodes);
    }

    public static Map<Long, List<PartCode>> getSelectedPartCodesAndRegulations() {
        return selectedPartCodesAndRegulations;
    }

    public static void clearSelectedVendorCodesAndRegulations() {
        selectedPartCodesAndRegulations.clear();
    }

    public static void removeFromSelectedVendorCodesAndRegulations(String regulationsId) {
        selectedPartCodesAndRegulations.remove(regulationsId);
    }

    public static void addToSelectedBodyWorks(Long selectedRegulations, BodyWork bodyWork) {
        selectedBodyWorks.put(selectedRegulations, bodyWork);
    }

    public static Map<Long, BodyWork> getSelectedBodyWorks() {
        return selectedBodyWorks;
    }

    public static void clearSelectedBodyWorks() {
        selectedBodyWorks.clear();
    }

    public static void removeFromSelectedBodyWorks(String selectedRegulations) {
        selectedBodyWorks.remove(selectedRegulations);
    }
}
