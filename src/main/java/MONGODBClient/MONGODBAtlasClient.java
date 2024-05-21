package MONGODBClient;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MONGODBAtlasClient {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://pedrogutI:634clp%A@pedroguti.5edptfw.mongodb.net/?retryWrites=true&w=majority&appName=PEDROGUTI";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	//connect
                MongoDatabase database = mongoClient.getDatabase("CLUSTERPokemon");
                MongoCollection<Document>collection= database.getCollection("POKEMON");

            	//create inserte nuevo pokemonn
                Document newPokemon = new Document("Name","Pikachu")
                									.append("Type","Electric")
                									.append("Type","Electric");

                
                // Send a ping to confirm a successful connection
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}


