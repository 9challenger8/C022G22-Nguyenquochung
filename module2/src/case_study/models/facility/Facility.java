package case_study.models.facility;

public abstract class Facility {
    private String codeService;
    private String serviceName;
    private Double usableArea;
    private Integer rentalCosts;
    private Integer amountOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String codeService, String serviceName, Double usableArea, Integer rentalCosts, Integer amountOfPeople, String rentalType) {
        this.codeService = codeService;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.amountOfPeople = amountOfPeople;
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Integer getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Integer rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(Integer amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getInFor() {
        return this.codeService + ", " + this.serviceName + ", " + this.usableArea + ", " + this.rentalCosts + ", " + this.amountOfPeople
                + ", " + rentalType;
    }

    @Override
    public String toString() {
        return this.codeService + ", " + this.serviceName + ", " + this.usableArea + ", " + this.rentalCosts + ", " + this.amountOfPeople
                + ", " + rentalType;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Facility facility = (Facility) o;
//        return Objects.equals(serviceName, facility.serviceName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(serviceName);
//    }
//
//    public static void main(String[] args) {
//        Facility facility = new House();
//        facility.setServiceName("a");
//
//        Facility facility1 = new House();
//        facility1.setServiceName("a");
//
//        Facility facility2 = new House();
//        facility2.setServiceName("b");
//
//        Facility facility3 = new House();
//        facility3.setServiceName("a");
//
//        Facility facility4 = new House();
//        facility4.setServiceName("b");
//
//        Facility facility5 = new House();
//        facility5.setServiceName("c");
//
//        Facility facility6 = new House();
//        facility6.setServiceName("a");
//
//        Map<Facility, Integer> facilityMap = new HashMap<>();
//        abc(facility, facilityMap);
//        abc(facility1, facilityMap);
//        abc(facility2, facilityMap);
//        abc(facility3, facilityMap);
//        abc(facility4, facilityMap);
//        abc(facility5, facilityMap);
//        abc(facility6, facilityMap);
//
//        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey());
//            System.out.println("Value: " + entry.getValue());
//        }
//    }
//    public static void abc(Facility facility, Map<Facility, Integer> facilityIntegerMap) {
//        if (facilityIntegerMap.isEmpty()) {
//            facilityIntegerMap.put(facility, 1);
//        } else {
//            Set<Facility> key = facilityIntegerMap.keySet();
//            boolean flag = true;
//            for (Facility keySet: key) {
//                if (keySet.equals(facility)) {
//                    facilityIntegerMap.put(keySet, facilityIntegerMap.get(keySet) + 1);
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                facilityIntegerMap.put(facility, 1);
//            }
//        }
//    }
}
