
public class InterfaceHell {

    static interface FirstLevelOfHell{
        void helloBabyDevil();
    }
    
    static class SecondLevelOfHell implements FirstLevelOfHell{
        @Override
        public void helloBabyDevil() {
            System.out.println("Hello Dear");
        }
    }
    
    
    public static void main(String[] args) {
        
        
        new SecondLevelOfHell().helloBabyDevil();
        
//        new FirstLevelOfHell().helloBabyDevil();
        
        new FirstLevelOfHell() {
            @Override
            public void helloBabyDevil() {
                System.out.println("Devil Loves You");
            }
        }.helloBabyDevil();
        
        FirstLevelOfHell hell = () -> System.out.println("Nice To Meet You");
        hell.helloBabyDevil();
        
        
        
        ((FirstLevelOfHell) () -> System.out.println("Nice To Meet You Too")).helloBabyDevil();
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
