package org.azanar.models;

public class MergeInsuranceDTO {

    public static InsuranceDTO merge(InsuranceDTO base, InsuranceDTO source) {
        if (source.getEmail() != null && !source.getEmail().isEmpty()) {
            base.setEmail(source.getEmail());
        }
        if (source.getInsuranceType() != null && !source.getInsuranceType().isEmpty()) {
            base.setInsuranceType(source.getInsuranceType());
        }
        if (source.getSuma() != null && !source.getSuma().isEmpty()) {
            base.setSuma(source.getSuma());
        }
        if (source.getCreated() != null && !source.getCreated().isEmpty()) {
            base.setCreated(source.getCreated());
        }
        if (source.getExpires() != null && !source.getExpires().isEmpty()) {
            base.setExpires(source.getExpires());
        }
        if (source.getInsuranceDescription() != null && !source.getInsuranceDescription().isEmpty()) {
            base.setInsuranceDescription(source.getInsuranceDescription());
        }
        if (source.getContractId() != 0) { // pokud má contractId smysluplnou hodnotu
            base.setContractId(source.getContractId());
        }

        return base;
    }
}
