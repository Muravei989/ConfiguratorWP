package de.energie.ritter.configuratorwp.model;

public record FormData(
        int heatLoad,
        String eheater,
        String calcpos,
        String checkplace,
        String newplace,
        String distance,
        String newdistance,
        String VBoption,
        String acoustic,
        String newplaceVA,
        String radtemp,
        String reconstradtemp,
        String surfencradtemp,
        String woodcauldron
){}
