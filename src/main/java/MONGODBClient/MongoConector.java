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
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class MongoConector {
    static String connectionString = "mongodb+srv://pedro:1234567890@pokemon.b7hrwwy.mongodb.net/?retryWrites=true&w=majority&appName=POKEMON";

	public static void main(String[] args) {
		System.out.println("Comprobando conexion...");
		client();
		
		System.out.println("Probando metodos");
		añadirPokemon();
		
		

		
	}


	 static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

	 static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
     
	public static void client() {
		
		try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

		
		
	
	
public static void eliminarPokemon(){
    	
    	
       

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	 MongoDatabase database = mongoClient.getDatabase("POKEMON");
                 MongoCollection<Document> collection = database.getCollection("POKEMON");
                 
                 
                 //DELETE                 
                 //collection.deleteOne(Filters.eq("name", "Golderos"));
                 //System.out.println("Pokemon eliminado");
                 
                 //Para eliminar todos los que se llamen Evee
                 //collection.deleteMany(Filters.eq("name", "Evee"));
                 
                 //Leer despues de eliminar                
                 Document foundPokemon1 = collection.find(Filters.eq("name", "Bulbasur")).first();
                 if (foundPokemon1 != null) {
                 	System.out.println("Pokemon encontrado: " + foundPokemon1.getString("name"));
                 }else {
                 	System.out.println("Pokemon no encontrado");
                 }
                 
             } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
    public static void añadirPokemon(){
    	
    	
               String connectionString = "mongodb+srv://pedro:1234567890@pokemon.b7hrwwy.mongodb.net/?retryWrites=true&w=majority&appName=POKEMON";


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
            	 MongoDatabase database = mongoClient.getDatabase("POKEMON");
                 MongoCollection<Document> collection = database.getCollection("POKEMON");
                 
                 
                 //CREATE insertar pokemons
                 //planta fuego agua electrico
                 
                Document newPokemon = new Document("name", "Bulbasur")
                 					.append("type","planta")
                 					.append("level", "26");
                
                Document newSaldo = new Document("Saldo", 100);

                collection.insertOne(newSaldo);
                System.out.println("Cargando saldo...");
                 							
                 collection.insertOne(newPokemon);
                 System.out.println("Pokemon prueba insertado");

                 collection.deleteOne(Filters.eq("name", "Bulbasur"));
                 System.out.println("Pokemon prueba eliminado");




                 
                 

                 
                
                
                
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

	public static Document mostrarInfo(String nombrePokemon) {
		
		Document foundSaldo = null;
		Document foundPokemon = null;
		 try (MongoClient mongoClient = MongoClients.create(settings)) {
	            try {
	            	 MongoDatabase database = mongoClient.getDatabase("POKEMON");
	                 MongoCollection<Document> collection = database.getCollection("POKEMON");
	           
	                  foundPokemon = collection.find(Filters.eq("name", nombrePokemon)).first();
	                 if (foundPokemon != null) {
	                 	System.out.println("Pokemon encontrado: " + foundPokemon.getString("name"));
	                 	System.out.println("Pokemon encontrado: " + foundPokemon.getString("type"));
	                 	
	                 }else {
	                 	System.out.println("Pokemon no encontrado");
	                 }
	             
	                
	            } catch (MongoException e) {
	                e.printStackTrace();
	            }
	            
	        }
		return foundPokemon;
		
	}
}