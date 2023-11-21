package br.com.marca.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@EnableCaching
public class ApiApplication {

	public static void main(String[] args) throws IOException {
		// ClassLoader classLoader = SpringApplication.class.getClassLoader();

		// File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		InputStream is =  new ClassPathResource("serviceAccountKey.json").getInputStream();

		FirebaseOptions options = new FirebaseOptions.Builder()
		.setCredentials(GoogleCredentials.fromStream(is))
		.build();

		boolean hasBeenInitialized=false;
		List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
		for(FirebaseApp app : firebaseApps){
			if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)){
				hasBeenInitialized=true;
			}
		}

		if(!hasBeenInitialized) {
			FirebaseApp.initializeApp( options);
		}

		SpringApplication.run(ApiApplication.class, args);
	}

}
