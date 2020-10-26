package Contracts;

public class DigitalTelevisionContract extends Contract{
    private CanalPackages canalPackage;

    public CanalPackages getCanalPackage() {
        return canalPackage;
    }

    public void setCanalPackage(CanalPackages canalPackage) {
        this.canalPackage = canalPackage;
    }
}
