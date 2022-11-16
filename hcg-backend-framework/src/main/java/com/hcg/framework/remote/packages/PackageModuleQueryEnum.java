package com.hcg.framework.remote.packages;


//TODO a sample - don't use it
public enum PackageModuleQueryEnum {
    packageList,
    packageListEnhanced,
    roomTypeList,
    categoryList,
    packageTimeslotList,
    packageCancellationPolicyList,
    packageWishList,
    createPackageWish,
    updatePackageWish,
    deletePackageWish,
    ;
    public String value(){
        return this.name();
    }
}
