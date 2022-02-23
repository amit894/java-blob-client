package example.testclient;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.common.StorageSharedKeyCredential;
//import com.azure.identity.DefaultAzureCredentialBuilder;
//import com.azure.identity.ClientSecretCredentialBuilder;

import java.util.Locale;


public class BlobClient {

    public static void main ( String args[])  {
//        KeysAuthenticate();
//        SASAuthenticate();
          ADAuthenticate();

    }

    private static void listContainers (BlobServiceClient storageClient) {

        for (BlobContainerItem blobItem : storageClient.listBlobContainers()) {
            System.out.println("\t" + blobItem.getName());
        }
    }

    private static void listObjects (BlobContainerClient blobContainerClient) {

        System.out.println(blobContainerClient);

        for (BlobItem blobItem : blobContainerClient.listBlobs()) {
            System.out.println("\t" + blobItem.getName());
        }
    }

    private static BlobServiceClient KeysAuthenticate()  {
        String accountName = "mediumblog";

        String accountKey = "secret";
        String endpoint = String.format(Locale.ROOT, "https://%s.blob.core.windows.net", accountName);
        StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);
        BlobServiceClient storageClient = new BlobServiceClientBuilder().endpoint(endpoint).credential(credential).buildClient();
        listContainers(storageClient);
        return storageClient;

    }


    private static void ADAuthenticate(){
        System.out.println("ADAuthenticate");
//        TokenCredential ServicePrincipal = new ClientSecretCredentialBuilder()
//                .tenantId("8f12c261-6dbf-47c3-918f-1d15198a3b3b")
//                .clientId("254a124e-9cb5-49b2-919d-faf8c141ac0a")
//                .clientSecret("secret")
//                .build();

    }

    private static BlobContainerClient SASAuthenticate(){
        String accountName = "mediumblog";
        String blobName = "testcontainer";
        String sasToken = "secret";
        String endpoint = String.format(Locale.ROOT, "https://%s.blob.core.windows.net", accountName);

        BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
                                              .endpoint(endpoint)
                                              .sasToken(sasToken)
                                              .containerName(blobName)
                                              .buildClient();


        return blobContainerClient;

    }


}
