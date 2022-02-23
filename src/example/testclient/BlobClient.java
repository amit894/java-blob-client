package example.testclient;

public class BlobClient {

    public static void main ( String args[]){
        SASAuthenticate();
        ADAuthenticate();
        KeysAuthenticate();

    }

    private static void SASAuthenticate(){
        System.out.println("SASAuthenticate");

    }


    private static void ADAuthenticate(){
        System.out.println("ADAuthenticate");

    }

    private static void KeysAuthenticate(){
        System.out.println("KeysAuthenticate");

    }


}
