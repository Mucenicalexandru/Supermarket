package com.alex.supermarket;

public class Shovel extends Product {

    protected ShovelMaterial material;
    protected ShovelSize size;

    public enum ShovelMaterial{
        ALUMINIUM,
        STEEL,
        PLASTIC;
    }

    public enum ShovelSize{
        SMALL,
        NORMAL,
        BIG;
    }

    public Shovel(String brandName, int quantity, ShovelMaterial material, ShovelSize size) {
        super(brandName, quantity);
        this.material = material;
        this.size = size;
    }

    public ShovelMaterial getMaterial(){
        return material;
    }

    public ShovelSize getSize(){
        return size;
    }


}
