package eu.circletouch.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersManagerApplication.class, args);
	}

}

class HelloWorld{

	public static void main(String []args){
		int a[] = new int[100];
		for(int i = 0; i < 100; i++){
			a[i] = 100 - i;
		}
		// undeva aici se initializeaza acest array
		for (int i = 0; i < 99; i++){
			int j = i;
			while(j >= 0 && a[j] > a[j + 1]){
				int aux = a[j];
				a[j] = a[j + 1];
				a[j + 1] = aux;
				j--;
			}
		}

		for(int i = 0; i < 100; i++){
			System.out.println(a[i] + " ");
		}

	}
}
