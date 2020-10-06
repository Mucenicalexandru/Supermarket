package com.alex.supermarket;

import java.util.LinkedList;

public class Supermarket {
    public LinkedList<Product> products;
    private String supermarketName;

    public Supermarket(String supermarketName){
        this.supermarketName = supermarketName;
        this.products = new LinkedList<>();
    }

    public String getSupermarketName(){
        return supermarketName;
    }

    public void addProducts(Product product){
        products.add(product);
    }

    public LinkedList<Product> showAllProducts(){
        return products;
    }

    public int showNumberOfAllProducts(){
        int result = 0;
        for(Product product : products){
            result = result + product.getQuantity();
        }
        return result;
    }

    public LinkedList<Product> showAllTrucks(){
        LinkedList<Product> trucks = new LinkedList<>();
        for(Product product : products) {
            if (product instanceof Truck){
                trucks.add(product);
            }
        }
        return trucks;
    }

    public int showNumberOfTrucks(){
        int result = 0;
        for(Product product : products){
            if(product instanceof Truck){
                result = result + product.getQuantity();
            }
        }
        return result;
    }

    public LinkedList<Product> showTrucksByNumberOfWheels(int wheelNumber){
        LinkedList<Product> trucks = new LinkedList<>();
        for(Product product : products) {
            if (product instanceof Truck && ((Truck) product).getNumberOfWheels() == wheelNumber){
                trucks.add(product);
            }
        }
        return trucks;
    }

    public LinkedList<Product> showAllShovels(){
        LinkedList<Product> trucks = new LinkedList<>();
        for(Product product : products) {
            if (product instanceof Shovel){
                trucks.add(product);
            }
        }
        return trucks;
    }

    public int showTotalNumberOfShovels(){
        int result = 0;
        for(Product product : products){
            if(product instanceof Shovel){
                result = result + product.getQuantity();
            }
        }
        return result;
    }

    public LinkedList<Product> showShovelsByMaterial(Shovel.ShovelMaterial material){
        LinkedList<Product> shovels = new LinkedList<>();
        for(Product product : products){
            if(product instanceof Shovel && ((Shovel) product).material.equals(material)){
                shovels.add(product);
            }
        }
        return shovels;
    }

    public LinkedList<Product> showShovelsBySize(Shovel.ShovelSize size){
        LinkedList<Product> shovels = new LinkedList<>();
        for(Product product : products){
            if(product instanceof Shovel && ((Shovel) product).size.equals(size)){
                shovels.add(product);
            }
        }
        return shovels;
    }

    public LinkedList<Product> showShovelsByMaterialAndBySize(Shovel.ShovelMaterial material, Shovel.ShovelSize size){
        LinkedList<Product> shovels = new LinkedList<>();
        for(Product product : products){
            if(product instanceof Shovel && ((Shovel) product).material.equals(material) && ((Shovel) product).size.equals(size)){
                shovels.add(product);
            }
        }
        return shovels;
    }

    public LinkedList<Product> showAllDiaryProducts(){
        LinkedList<Product> diaryProducts = new LinkedList<>();
        for(Product product : products) {
            if (product instanceof DairyProduct){
                diaryProducts.add(product);
            }
        }
        return diaryProducts;
    }


    public LinkedList<Product> showLongLastMilk(){
        LinkedList<Product> longLastMilk = new LinkedList<>();
        for(Product product : products){
            if(product instanceof LongLastingMilk){
                longLastMilk.add(product);
            }
        }
        return longLastMilk;
    }

    public LinkedList<Product> showRegularMilk(){
        LinkedList<Product> regularMilk = new LinkedList<>();
        for(Product product : products){
            if(product instanceof RegularDairyMilk){
                regularMilk.add(product);
            }
        }
        return regularMilk;
    }


    public LinkedList<Product> showAllExpiredProducts(){
        LinkedList<Product> expiredProducts = new LinkedList<>();
        for(Product product : products){
            if(product instanceof DairyProduct && ((DairyProduct) product).isMilkSoured()){
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }

    public int showNumberOfExpiredMilk(){
        LinkedList<Product> expiredProducts = new LinkedList<>();
        int result = 0;
        for(Product product : products){
            if(product instanceof DairyProduct && ((DairyProduct) product).isMilkSoured()){
                expiredProducts.add(product);
            }
        }
        for(Product milk : expiredProducts){
            result = result + milk.getQuantity();
        }

        return result;
    }

    public void removeProduct(Product productToBeRemoved){
        for(Product product : products){
            if(product.equals(productToBeRemoved)){
                products.remove(productToBeRemoved);
            }
        }
    }

}