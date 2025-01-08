package com.altonaut.model;

import lombok.Data;
import java.util.List;

public class AltonautTestDataModels {

    @Data
    public static class RequsitionItem {
        private int price;
        private int requestQuantity;
        private int approveQuantity;
        private String priceUnit;
        private String requestQuantityUnit;
        private String approveQuantityUnit;
        private String manufacturer;
        private String partNumber;
        private String costCode;
        private String remarks;
        private String priority;
        private String category;
        private String deliveryTo;
        private String specialInstruction;
        private String itemName;
        private Boolean isImpaItem;
    }

    @Data
    public static class Role {
        private String[] chiefEngineerRole;
        private String[] chiefOfficerRole;
        private String[] officeStaffRole;
        private String[] officeSpvRole;
    }

    @Data
    public static class ProcurementActor {
        private String vesselRequesterName;
        private String vesselApproverName;
        private String officeOpenReviewdByName;
        private String officePriceAddedByName;
        private String officeApproverName;
        private List<Role> role;
    }

    @Data
    public static class TestData {
        private List<RequsitionItem> requsitionItems; 
        private List<ProcurementActor> procurementActor;
    }

    @Data
    public static class Account {
        private String username;
        private String password;
        private String vesselName;
    }

    @Data
    public static class ExpectedResult {
        private String errorMessage;
        private List<RequsitionItem> requsitionItems; 
        private List<ProcurementActor> procurementActor;
    }
}
